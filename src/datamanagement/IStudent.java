package datamanagement;

public interface IStudent {

  public Integer getStudentNumber();

  
  public String getFirstName();

  
  public String getLastName();

  
  public StudentUnitRecordList getUnitRecords();
  
  
  public IStudentUnitRecord getUnitRecord(String unitCode);
  
  
  public void setFirstName(String firstName);

  
  public void setLastName(String lastName);

  
  public void addUnitRecord(IStudentUnitRecord record);
}
