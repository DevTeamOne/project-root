/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class manages and creates new element of a student.
 */
package datamanagement;

import java.util.List;

import org.w3c.dom.Element;

public class StudentManager {
  
  
  
  /** 
   * Declare class variables.
   */
  private static StudentManager self = null;
  private StudentMap studentManager_;
  private java.util.HashMap<String, StudentMap> unitManager_;

  
  
  /**
   * Constructor for class StudentManager.
   */ 
  private StudentManager() {
    studentManager_ = new StudentMap();
    unitManager_ = new java.util.HashMap<>();
  }
  
  
  
  /**
   * Retrieve student unit record.   
   * 
   * @return create new self.
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
   * 
   * @param studentNumber: The student number to retrieve.
   * @return individual student or create new student if null.
   */   
  public StudentInterface getStudent(Integer studentNumber) {
    StudentInterface individualStudent = studentManager_.get(studentNumber);
    
    return individualStudent != null ? individualStudent : createStudent(studentNumber);
  }
  
  
  
  /**
   * Retrieve student element using student number.   
   * 
   * @param studentNumber: The student number to retrieve.
   * @return element.
   * @return null.
   */
  private Element getStudentElement(Integer studentNumber) {
    for (Element element : (List<Element>) XMLManager.getXML().
        getDocument().
        getRootElement().
        getChild("studentTable").
        getChildren("student"))
      
      if (studentNumber.toString().equals(element.getAttribute("studentNumber"))) {
        return element;
      }
    return null;
  }
  
  
  
  /**
   * Retrieve individual student using a unit code. 
   *   
   * @param code: The code number to lookup student.
   * @return student record attached to unit code.
   */ 
  public StudentMap getStudentsByUnit(String code) {
    StudentMap student = unitManager_.get(code);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    StudentInterface individualStudent;
    StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(code);
    
    for (IStudentUnitRecord s : unitRecord) {
      individualStudent = createStudentProxy(new Integer(s.getStudentNumber()));
      student.put(individualStudent.getStudentNumber(), individualStudent);
    }

    unitManager_.put(code, student);
    
    return student;
  }
  
  
  
  /**
   * Create a new student element.   
   * 
   * @param studentNumber: The student number assigned to a new student element.
   * @return individual student created.
   * @throws runtime exception if student is not in file.
   */ 
  private StudentInterface createStudent(Integer studentNumber) {
    StudentInterface individualStudent_;
    Element element_ = getStudentElement(studentNumber);
    
    if (element_ != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().
          getRecordsByStudent(studentNumber);
      
      individualStudent_ = new Student(new Integer(element_.getAttribute("Student Number")),
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"), recordList);

      studentManager_.put(individualStudent_.
          getStudentNumber(), 
          individualStudent_);
      
      return individualStudent_;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  /**
   * Create a new student proxy.   
   * 
   * @param studentNumber: The studentNumber to be retrieved.
   * @return student element using student number..
   * @throws runtime exception if student is not in file.
   */ 
  private StudentInterface createStudentProxy(Integer studentNumber) {
    Element element_ = getStudentElement(studentNumber);

    if (element_ != null) {
      return new StudentProxy(studentNumber, 
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
