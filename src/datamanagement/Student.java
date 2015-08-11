/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: Student class object containing details of a student such as their first name, last name, student number and the unit records as implemented from the IStudent class.
 */
package datamanagement;

public class Student implements IStudent {
  // Private variables for class Student
  private Integer studentNumber;
  private String firstName;
  private String lastName;
  private StudentUnitRecordList studentUnit;

  
  // Constructor for class Student
  public Student(Integer number, String first, String last, StudentUnitRecordList record) {
    this.studentNumber = number;
    this.firstName = first;
    this.lastName = last;
    this.studentUnit = record == null ? new StudentUnitRecordList() : record;
  }

  
  // Getter method returning the student number  
  public Integer getStudentNumber() {
    return this.studentNumber;
  }

  
  // Getter method returning the first name of the Student
  public String getFirstName() {
    return firstName;
  }

  
  // Getter method returning the last name of the Student
  public String getLastName() {
    return lastName;
  }

    
  // Getter method returning student units
  public StudentUnitRecordList getUnitRecords() {
    return studentUnit;
  }
  
  
  // Getter method returning unit record of student
  public IStudentUnitRecord getUnitRecord(String code) {
    for (IStudentUnitRecord record : studentUnit) {
      if (record.getUnitCode().equals(code))
        return record;
    }
    return null;
  }
  
  
  // Setter method to store the first name of the Student
  public void setFirstName(String first) {
    this.firstName = first;
  }
  
  
  // Setter method to store the last name of the student
  public void setLastName(String last) {
    this.lastName = last;
  }

  
  // This method adds a new unit to the student record
  public void addUnitRecord(IStudentUnitRecord record) {
    studentUnit.add(record);
  }
}
