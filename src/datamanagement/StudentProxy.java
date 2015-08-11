/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class retrieves information on a student based on their individual student number
 */
package datamanagement;

public class StudentProxy implements IStudent {
  // Private variables for class StudentProxy
  private Integer studentNumber;
  private String firstName;
  private String lastName;
  private StudentManager student;

  
  // Constructor for class StudentProxy
  public StudentProxy(Integer number, String first, String last) {
    this.studentNumber = number;
    this.firstName = first;
    this.lastName = last;
    this.student = StudentManager.get();
  }

  
  //Getter method returning the student number
  public Integer getStudentNumber() {
    return studentNumber;
  }

  
  // Getter method returning the first name of the Student  
  public String getFirstName() {
    return firstName;
  }

  
  // Getter method returning the last name of the Student  
  public String getLastName() {
    return lastName;
  }
  
  
  // Getter method returning a student and list of unit records
  public StudentUnitRecordList getUnitRecords() {
    return student.getStudent(studentNumber).getUnitRecords();
  }

  
  // Getter method returning student and unit record based on specified unit code
  public IStudentUnitRecord getUnitRecord(String code) {
    return student.getStudent(studentNumber).getUnitRecord(code);
  }
  
  
  // Setter method to store the first name of the student 
  public void setFirstName(String first) {
    student.getStudent(studentNumber).setFirstName(first);
  }

  
  // Setter method to store the last name of the student
  public void setLastName(String last) {
    student.getStudent(studentNumber).setLastName(last);
  }
    
  
  // This method adds a new unit to the student record
  public void addUnitRecord(IStudentUnitRecord record) {
    student.getStudent(studentNumber).addUnitRecord(record);
  }
}
