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

  
  
  public IStudent getStudent(Integer sn) {
    IStudent individualStudent = studentManager.get(sn);
    
    return individualStudent != null ? individualStudent : createStudent(sn);
  }
  
  
  
  private Element getStudentElement(Integer sn) {
    for (Element e : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student"))
      if (sn.toString().equals(e.getAttribute("Student Number"))) {
        return e;
      }
    return null;
  }
  
  
  
  public StudentMap getStudentsByUnit(String uc) {
    StudentMap student = unitManager.get(uc);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    
    IStudent individualStudent;
    
    StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
    
    for (IStudentUnitRecord s : unitRecord) {
      individualStudent = createStudentProxy(new Integer(s.getStudentID()));
      student.put(individualStudent.getStudentNumber(), individualStudent);
    }

    unitManager.put(uc, student);
    
    return student;
  }

  
  
  private IStudent createStudent(Integer sn) {
    IStudent individualStudent;
    Element element = getStudentElement(sn);
    
    if (element != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance().getRecordsByStudent(sn);
      
      individualStudent = new Student(new Integer(element.getAttribute("Student Number")),
          element.getAttribute("First Name"), element.getAttribute("Last Name"), recordList);

      studentManager.put(individualStudent.getStudentNumber(), individualStudent);
      
      return individualStudent;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  private IStudent createStudentProxy(Integer sn) {
    Element element = getStudentElement(sn);

    if (element != null) {
      return new StudentProxy(sn, element.getAttribute("First Name"), element.getAttribute("Last Name"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
