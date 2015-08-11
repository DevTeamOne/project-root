/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class 
 */
package datamanagement;

import java.util.List;

import org.w3c.dom.Element;

public class StudentManager {
  private static StudentManager self = null;
  private StudentMap studentManager;
  private java.util.HashMap<String, StudentMap> unitManager;

  private StudentManager() {
    studentManager = new StudentMap();
    unitManager = new java.util.HashMap<>();
  }
  
  
  
  public static StudentManager get() {
    if (self == null) {
      self = new StudentManager();
    }
    return self;
  }

  
  
  public IStudent getStudent(Integer number) {
    IStudent individualStudent = studentManager.get(number);
    
    return individualStudent != null ? individualStudent : createStudent(number);
  }
  
  
  
  private Element getStudentElement(Integer sn) {
    for (Element e : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student"))
      if (sn.toString().equals(e.getAttribute("Student Number"))) {
        return e;
      }
    return null;
  }
  
  
  
  public StudentMap getStudentsByUnit(String code) {
    StudentMap student = unitManager.get(code);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    
    IStudent individualStudent;
    
    StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(code);
    
    for (IStudentUnitRecord s : unitRecord) {
      individualStudent = createStudentProxy(new Integer(s.getStudentID()));
      student.put(individualStudent.getStudentNumber(), individualStudent);
    }

    unitManager.put(code, student);
    
    return student;
  }

  
  
  private IStudent createStudent(Integer number) {
    IStudent individualStudent;
    Element element = getStudentElement(number);
    
    if (element != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().getRecordsByStudent(number);
      
      individualStudent = new Student(new Integer(element.getAttribute("Student Number")),
          element.getAttribute("First Name"), element.getAttribute("Last Name"), recordList);

      studentManager.put(individualStudent.getStudentNumber(), individualStudent);
      
      return individualStudent;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  private IStudent createStudentProxy(Integer number) {
    Element element = getStudentElement(number);

    if (element != null) {
      return new StudentProxy(number, element.getAttribute("First Name"), element.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
