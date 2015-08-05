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

  public IStudent getStudent(Integer id) {
    IStudent is = studentManager.get(id);
    
    return is != null ? is : createStudent(id);
  }
  
  private Element getStudentElement(Integer id) {
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("studentTable").getChildren("student"))
      
      if (id.toString().equals(el.getAttribute("sid"))) {
        return el;
      }
    return null;
  }
  
  public StudentMap getStudentsByUnit(String unitCode) {
    StudentMap student = unitManager.get(unitCode);
    
    if (student != null) {
      return student;
    }

    student = new StudentMap();
    
    IStudent is;
    
    StudentUnitRecordList unitRecord = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
    
    for (IStudentUnitRecord S : unitRecord) {
      is = createStudentProxy(new Integer(S.getStudentID()));
      student.put(is.getStudentNumber(), is);
    }

    unitManager.put(unitCode, student);
    return student;
  }

  private IStudent createStudent(Integer studentNumber) {
    IStudent is;
    Element element = getStudentElement(studentNumber);
    
    if (element != null) {
      StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(studentNumber);
      
      is = new Student(new Integer(element.getAttribute("sid")),
          element.getAttribute("fname"), element.getAttribute("lname"), rlist);

      studentManager.put(is.getStudentNumber(), is);
      
      return is;
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  private IStudent createStudentProxy(Integer studentNumber) {
    Element element = getStudentElement(studentNumber);

    if (element != null) {
      return new StudentProxy(studentNumber, element.getAttribute("fname"), element.getAttribute("lname"));
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }
}
