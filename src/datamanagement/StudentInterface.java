/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This is an interface class that allows the user to add or retrieve information of a Student.
 */
package datamanagement;

public interface StudentInterface {
  
  
  
  /**
   * Retrieve student record using unit code.
   * 
   * @param code: The unit code to be retrieved.
   */ 
  public IStudentUnitRecord getUnitRecord(String code);
  
  
  
  /**
   * Set student first name.
   * 
   * @param The student first name.
   */ 
  public void setFirstName(String first);
  
  
  
  /**
   * Set student last name.
   * 
   * @param The student last name.
   */ 
  public void setLastName(String last);
  
  
  
  /**
   * Add a unit to the student record.
   * 
   * @param record: The unit is added to the student record.
   */ 
  public void addUnitRecord(IStudentUnitRecord record);
  
  
  
  /**
   * Retrieve student number.
   */ 
  public Integer getStudentNumber();
  
  
  
  /**
   * Retrieve student first name.
   */ 
  public String getFirstName();
  
  
  
  /**
   * Retrieve student last name.
   */ 
  public String getLastName();

  
  
  /**
   * Retrieve student unit records.
   */ 
  public StudentUnitRecordList getUnitRecords();
}
