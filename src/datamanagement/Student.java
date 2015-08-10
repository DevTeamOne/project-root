package datamanagement;

public class Student implements IStudent {
  private Integer studentNumber;
  private String firstName;
  private String lastName;
  private StudentUnitRecordList studentUnit;

  public Student(Integer id, String fn, String ln, StudentUnitRecordList su) {
    this.studentNumber = id;
    this.firstName = fn;
    this.lastName = ln;
    this.studentUnit = su == null ? new StudentUnitRecordList() : su;
  }

  
  
  public Integer getStudentNumber() {
    return this.studentNumber;
  }

  
  
  public String getFirstName() {
    return firstName;
  }

  
  
  public String getLastName() {
    return lastName;
  }

    

  public StudentUnitRecordList getUnitRecords() {
    return studentUnit;
  }
  
  
  
  public IStudentUnitRecord getUnitRecord(String uc) {
    for (IStudentUnitRecord record : studentUnit) {
      if (record.getUnitCode().equals(uc))
        return record;
    }
    return null;
  }
  
  
  
  public void setFirstName(String fn) {
    this.firstName = fn;
  }
  
  

  public void setLastName(String ln) {
    this.lastName = ln;
  }

  
  
  public void addUnitRecord(IStudentUnitRecord r) {
    studentUnit.add(r);
  }
}
