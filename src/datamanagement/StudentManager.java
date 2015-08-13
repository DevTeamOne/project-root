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
  /** 
   * Private variables for class StudentManager
   */
  private static StudentManager self = null;
  private StudentMap studentManager_;
  private java.util.HashMap<String, StudentMap> unitManager_;

  /**
   * Constructor for class StudentManager
   */ 
  private StudentManager() {
    studentManager_ = new StudentMap();
    unitManager_ = new java.util.HashMap<>();
  }
  
  /**
   * Retrieve student unit record.   
   * If self is null
   * @return create new self.
   * else
   * @return self.
   */ 
  public static StudentManager get() {
    if (self == null) {
      self = new StudentManager();
    }
    return self;
  }

  /**
   * Retrieve individual student using their student number.   
   * @param number: The student number to retrieve.
   * @return individual student or create new student if null.
   */   
  public IStudent getStudent(Integer number) {
    IStudent individualStudent = studentManager_.get(number);
    
    return individualStudent != null ? individualStudent : createStudent(number);
  }
  
  /**
   * Retrieve individual student using their student number.   
   * @param number: The student number to retrieve.
   * @return individual student or create new student if null.
   */   
  @SuppressWarnings("unchecked")
  private Element getStudentElement(Integer studentNumber) {
    for (Element element : (List<Element>) XMLManager.getXML().
        getDocument().
        getRootElement().
        getChild("studentTable").
        getChildren("student"))
      
      if (studentNumber.toString().equals(element.getAttribute("Student Number"))) {
        return element;
      }
    return null;
  }
  
  
  
  public StudentMap getStudentsByUnit(String code) {
    StudentMap student = unitManager_.get(code);
    
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

    unitManager_.put(code, student);
    
    return student;
  }

  
  
  private IStudent createStudent(Integer number) {
    IStudent individualStudent_;
    Element element_ = getStudentElement(number);
    
    if (element_ != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().getRecordsByStudent(number);
      
      individualStudent_ = new Student(new Integer(element_.getAttribute("Student Number")),
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"), recordList);

      studentManager_.put(individualStudent_.getStudentNumber(), individualStudent_);
      
      return individualStudent_;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  private IStudent createStudentProxy(Integer number) {
    Element element_ = getStudentElement(number);

    if (element_ != null) {
      return new StudentProxy(number, 
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
