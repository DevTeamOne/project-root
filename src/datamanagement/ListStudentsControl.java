/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class 
 */
package datamanagement;

public class ListStudentsControl {
  private StudentManager studentManager;

  
  
  public ListStudentsControl() {
    studentManager = StudentManager.get();
  }

  
  
  public void listStudents(IStudentLister lister, String code) {
    lister.clearStudents();
    
    StudentMap student = studentManager.getStudentsByUnit(code);
    
    for (Integer studentNumber : student.keySet())
      lister.addStudent(student.get(studentNumber));
  }
}
