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

  public IStudent getStudent(Integer studentNumber) {
    IStudent individualStudent = studentManager.get(studentNumber);
    
    return individualStudent != null ? individualStudent : createStudent(studentNumber);
  }
  
  private Element getStudentElement(Integer studentNumber) {
    for (Element element : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("studentTable").getChildren("student"))
      
      if (studentNumber.toString().equals(element.getAttribute("Student Number"))) {
        return element;
      }
    return null;
  }
  
  public StudentMap getStudentsByUnit(String unitCode) {
    StudentMap student = unitManager.get(unitCode);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    
    IStudent individualStudent;
    
    StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
    
    for (IStudentUnitRecord S : unitRecord) {
      individualStudent = createStudentProxy(new Integer(S.getStudentID()));
      student.put(individualStudent.getStudentNumber(), individualStudent);
    }

    unitManager.put(unitCode, student);
    
    return student;
  }

  private IStudent createStudent(Integer studentNumber) {
    IStudent individualStudent;
    Element element = getStudentElement(studentNumber);
    
    if (element != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().getRecordsByStudent(studentNumber);
      
      individualStudent = new Student(new Integer(element.getAttribute("Student Number")),
          element.getAttribute("First Name"), element.getAttribute("Last Name"), recordList);

      studentManager.put(individualStudent.getStudentNumber(), individualStudent);
      
      return individualStudent;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  private IStudent createStudentProxy(Integer studentNumber) {
    Element element = getStudentElement(studentNumber);

    if (element != null) {
      return new StudentProxy(studentNumber, element.getAttribute("First Name"), element.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
