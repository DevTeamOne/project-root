package datamanagement;

public interface IStudent {

  public Integer getStudentNumber();

  
  
  public String getFirstName();

  
  
  public String getLastName();

  
  
  public StudentUnitRecordList getUnitRecords();
  
  
  
  public IStudentUnitRecord getUnitRecord(String uc);
  
  
  
  public void setFirstName(String fn);

  
  
  public void setLastName(String ln);

  
  
  public void addUnitRecord(IStudentUnitRecord r);
}
