package datamanagement;

public class ListStudentsControl {
  private StudentManager studentManager;

  public ListStudentsControl() {
    studentManager = StudentManager.get();
  }

  
  public void listStudents(IStudentLister lister, String unitCode) {
    lister.clearStudents();
    
    StudentMap student = studentManager.getStudentsByUnit(unitCode);
    
    for (Integer studentNumber : student.keySet())
      lister.addStudent(student.get(studentNumber));
  }
}
