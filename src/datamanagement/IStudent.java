/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This is an interface class that allows the user to add or retrieve information of a Student
 */
package datamanagement;

public interface IStudent {
  //Getter method returning the student number
  public Integer getStudentNumber();

  
  // Getter method returning the first name of the Student
  public String getFirstName();

  
  // Getter method returning the last name of the Student
  public String getLastName();

  
  // Getter method returning student units
  public StudentUnitRecordList getUnitRecords();
  
  
  // Getter method returning unit record of student
  public IStudentUnitRecord getUnitRecord(String code);
  
  
  // Setter method to store the first name of the Student
  public void setFirstName(String first);

  
  // Setter method to store the last name of the student
  public void setLastName(String last);

  
  // This method adds a new unit to the student
  public void addUnitRecord(IStudentUnitRecord record);
}
