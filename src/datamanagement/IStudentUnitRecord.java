package datamanagement;

public interface IStudentUnitRecord {

  
  
	public Integer getStudentID();

	
	
	public String getUnitCode();

	
	
	public void setAssignment1Result(float mark);

	
	
	public float getAssignment1Result();

	
	
	public void setAssignment2Result(float mark);

	
	
	public float getAssignment2Result();

	
	
	public void setExamResult(float mark);

	
	
	public float getExamResult();

	
	
	public float getTotal(); 
}
