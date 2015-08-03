package datamanagement;

public class ListStudentsCTL {
  private StudentManager studentManager;

  public ListStudentsCTL() {
    studentManager = StudentManager.get();
  }

  
  public void listStudents(IStudentLister lister, String unitCode) {
    lister.clearStudents();
    
    StudentMap students = studentManager.getStudentsByUnit(unitCode);
    
    for (Integer studentNumber : students.keySet())
      lister.addStudent(students.get(studentNumber));
  }
}
