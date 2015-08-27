package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class can create or return a student object based on the individual student details.
 */
public class StudentProxy 
  implements StudentInterface 
{
  
  
  
  /**
   * Private variables for class StudentProxy.
   */ 
  private Integer studentNo;
  private String firstName;
  private String lastName;
  private StudentManager student;

  
  
  /**
   * Constructor for class StudentProxy.
   */ 
  public StudentProxy (Integer number, String first, String last) {
    this.studentNo = number;
    this.firstName = first;
    this.lastName = last;
    this.student = StudentManager.getInstance();
  }
  
  
  
  /**
   * Retrieve a student number.
   * 
   * @return The student number.
   */ 
  public Integer getStudentNumber() {
    return studentNo;
  }
  
  
  
  /**
   * Retrieve student first name.
   * 
   * @return The student first name.
   */ 
  public String getFirstName() {
    return firstName;
  }
  
  
  
  /**
   * Retrieve student last name.
   * 
   * @return The student last name.
   */
  public String getLastName() {
    return lastName;
  }
    
  
  
  /**
   * Retrieve student unit record.
   * 
   * @return The student unit record.
   */ 
  public StudentUnitRecordList getUnitRecords() {
    return student.findStudent(studentNo).getUnitRecords();
  }

  
  
  /**
   * Retrieve student record from class student.
   * 
   * @param code: The unit code to be retrieved.
   * @return Retrieve unit record based on value of student number.
   */ 
  public IStudentUnitRecord findUnitRecord (String code) {
    return student.findStudent(studentNo).findUnitRecord(code);
  }
 
  
  
  /**
   * Set student first name.
   * 
   * @param first: The first name of the student to set.
   */
  public void setFirstName (String first) {
    student.findStudent(studentNo).setFirstName(first);
  }
  
  
  
  /**
   * Set student last name.
   * 
   * @param last: The last name of the student to set.
   */
  public void setLastName (String last) {
    student.findStudent(studentNo).setLastName(last);
  }
  
  
  
  /**
   * Add a unit to the student record.
   * 
   * @param record: The unit is added to the student record.
   */
  public void addUnitRecord (IStudentUnitRecord record) {
    student.findStudent(studentNo).addUnitRecord(record);
  }
}
