/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: Student class object containing details of a student such as their first name, last name, student number and the unit records as implemented from the IStudent class.
 */
package datamanagement;

public class Student implements IStudent {
  /** Private variables for class Student
   * 
   */
  private Integer studentNumber;
  private String firstName;
  private String lastName;
  private StudentUnitRecordList studentUnit;
  
  /**
   * Retrieve a student unit record, based on a key of both student id and unit code.
   * @param number: The student number to retrieve.
   * @param first: The first name to retrieve.
   * @param last: The last name to retrieve.
   * @param record: The unit record to retrieve.
   * @return A matching or empty student unit record.
   */
  public Student(Integer number, String first, String last, StudentUnitRecordList record) {
    this.studentNumber = number;
    this.firstName = first;
    this.lastName = last;
    this.studentUnit = record == null ? new StudentUnitRecordList() : record;
  }
  
  /**
   * Retrieve a student number.
   * @return The student number.
   */ 
  public Integer getStudentNumber() {
    return this.studentNumber;
  }
  
  /**
   * Retrieve student first name.
   * @return The student first name.
   */ 
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Retrieve student last name.
   * @return The student last name.
   */ 
  public String getLastName() {
    return lastName;
  }
    
  /**
   * Retrieve student unit record.
   * @return The student unit record.
   */ 
  public StudentUnitRecordList getUnitRecords() {
    return studentUnit;
  }
  
  /**
   * Retrieve student last name.
   * @param code: The unit code to be retrieved.
   * If unit code is found in studentUnit then
   * @return Retrieve unit record.
   * Else
   * @return Null.
   */ 
  public IStudentUnitRecord getUnitRecord(String code) {
    for (IStudentUnitRecord record : studentUnit) {
      if (record.getUnitCode().equals(code))
        return record;
    }
    return null;
  }
  
  /**
   * Set student first name.
   * @param first: The first name of the student to set.
   */
  public void setFirstName(String first) {
    this.firstName = first;
  }
  
  /**
   * Set student last name.
   * @param last: The last name of the student to set.
   */
  public void setLastName(String last) {
    this.lastName = last;
  }
  
  /**
   * Add a unit to the student record.
   * @param record: The unit is added to the student record.
   */
  public void addUnitRecord(IStudentUnitRecord record) {
    studentUnit.add(record);
  }
}
