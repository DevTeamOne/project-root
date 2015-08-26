package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class manages and creates new element of a student.
 */
import org.w3c.dom.Element;

import java.util.List;

public class StudentManager {
  
  
  
  /** 
   * Declare class variables.
   */
  private static StudentManager self_ = null;
  private StudentMap studentManager;
  private java.util.HashMap<String, StudentMap> unitManager;

  
  
  private StudentManager() {
    studentManager = new StudentMap();
    unitManager = new java.util.HashMap<>();
  }
  
  
  
  /**
   * Retrieve student unit record.   
   * 
   * @return create new self.
   * @return self.
   */ 
  public static StudentManager getInstance() {
    if (self_ == null)
      self_ = new StudentManager();
    
    return self_;
  }

  
  
  /**
   * Retrieve individual student using their student number.   
   * 
   * @param studentNumber: The student number to retrieve.
   * @return individual student or create new student if null.
   */   
  public StudentInterface findStudent (Integer studentNo) {
    StudentInterface individualStudent = studentManager.get(studentNo);
    
    return individualStudent != null ? 
      individualStudent : createStudent(studentNo);
  }
  
  
  
  private Element findStudentElement (Integer studentNumber) {
    for (Element element : (List<Element>) XMLManager.getXML().
      getDocument().
      getRootElement().
      getChild("studentTable").
      getChildren("student")) {
      
      boolean string = studentNumber.toString().equals(
          element.getAttribute("studentNumber"));
      
      if (string)
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
  public StudentMap findStudentsByUnit(String code) {
    StudentMap student = unitManager.get(code);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    StudentInterface individualStudent;
    StudentUnitRecordList unitRecords = StudentUnitRecordManager.instance().
      getRecordsByUnit(code);
    
    for (IStudentUnitRecord unitRecord : unitRecords) {
      individualStudent = createStudentProxy(new Integer(unitRecord.
        getStudentNumber()));
      student.put(individualStudent.getStudentNumber(), individualStudent);
    }

    unitManager.put(code, student);
    
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
    Element element_ = findStudentElement(studentNumber);
    
    if (element_ != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().
          getRecordsByStudent(studentNumber);
      
      individualStudent_ = new Student(new Integer(
          element_.getAttribute("Student Number")),
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"), recordList);

      studentManager.put(individualStudent_.
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
    Element element_ = findStudentElement(studentNumber);

    if (element_ != null) {
      return new StudentProxy(studentNumber, 
          element_.getAttribute("First Name"), 
          element_.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
