/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: Student class object containing details of a student such as their first name, last name, student number and the unit records as implemented from the IStudent class.
 */
package datamanagement;

public class Student implements StudentInterface {
  
  
  
  /** 
   * Private variables for class Student.
   */
  private Integer studentNumber_;
  private String firstName_;
  private String lastName_;
  private StudentUnitRecordList studentUnit_;
  
  
  
  /**
   * Retrieve a student unit record, based on a key of both student id and unit code.
   * 
   * @param number: The student number to retrieve.
   * @param first: The first name to retrieve.
   * @param last: The last name to retrieve.
   * @param record: The unit record to retrieve.
   * @return A matching or empty student unit record.
   */
  public Student (Integer number, String first, String last, StudentUnitRecordList record) {
    this.studentNumber_ = number;
    this.firstName_ = first;
    this.lastName_ = last;
    this.studentUnit_ = record == null ? new StudentUnitRecordList() : record;
  }
  
  
  
  /**
   * Retrieve a student number.
   * 
   * @return The student number.
   */ 
  public Integer getStudentNumber() {
    return this.studentNumber_;
  }
  
  
  
  /**
   * Retrieve student first name.
   * 
   * @return The student first name.
   */ 
  public String getFirstName() {
    return firstName_;
  }
  
  
  
  /**
   * Retrieve student last name.
   * 
   * @return The student last name.
   */ 
  public String getLastName() {
    return lastName_;
  }
    
  
  
  /**
   * Retrieve student unit record.
   * 
   * @return The student unit record.
   */ 
  public StudentUnitRecordList getUnitRecords() {
    return studentUnit_;
  }
  
  
  
  /**
   * Retrieve student record using unit code.
   * 
   * @param code: The unit code to be retrieved.
   * @return Retrieve unit record.
   * @return Null.
   */ 
  public IStudentUnitRecord getUnitRecord (String code) {
    for (IStudentUnitRecord record : studentUnit_) {
      if (record.getUnitCode().equals(code))
        return record;
    }
    return null;
  }
  
  
  
  /**
   * Set student first name.
   * 
   * @param first: The first name of the student to set.
   */
  public void setFirstName (String first) {
    this.firstName_ = first;
  }
  
  
  
  /**
   * Set student last name. 
   * 
   * @param last: The last name of the student to set.
   */
  public void setLastName (String last) {
    this.lastName_ = last;
  }
  
  
  
  /**
   * Add a unit to the student record.
   * 
   * @param record: The unit is added to the student record.
   */
  public void addUnitRecord (IStudentUnitRecord record) {
    studentUnit_.add(record);
  } 
}
