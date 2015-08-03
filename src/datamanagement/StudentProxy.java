package datamanagement;

public class StudentProxy implements IStudent {
  private Integer studentNumber;
  private String firstName;
  private String lastName;
  private StudentManager student;

  public StudentProxy(Integer number, String first, String last) {
    this.studentNumber = number;
    this.firstName = first;
    this.lastName = last;
    this.student = StudentManager.get();
  }

  
  public Integer getStudentNumber() {
    return studentNumber;
  }

  
  public String getFirstName() {
    return firstName;
  }

  
  public String getLastName() {
    return lastName;
  }
  
  
  public StudentUnitRecordList getUnitRecords() {
    return student.getStudent(studentNumber).getUnitRecords();
  }

  
  public void setFirstName(String firstName) {
    student.getStudent(studentNumber).setFirstName(firstName);
  }

  
  public void setLastName(String lastName) {
    student.getStudent(studentNumber).setLastName(lastName);
  }
  
  
  public IStudentUnitRecord getUnitRecord(String unitCode) {
    return student.getStudent(studentNumber).getUnitRecord(unitCode);
  }
  
  
  public void addUnitRecord(IStudentUnitRecord record) {
    student.getStudent(studentNumber).addUnitRecord(record);
  }
}
