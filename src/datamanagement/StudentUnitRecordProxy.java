package datamanagement;

/**
 * Student unit record proxy is used as a proxy record
 * for use in querying the XML file via
 * the Student Unit Record File Adapter. 
 */
public class StudentUnitRecordProxy
  implements IStudentUnitRecord {
  
	private Integer studentID;
	private String unitCode;
	private StudentUnitRecordAdapter studentUnitRecordFileAdapter;

	
	
	/**
	 * Constructor for studentUnitRecordProxy.
	 * 
	 * @param studentId
	 * @param unitCode
	 */
	public StudentUnitRecordProxy(Integer studentId, String unitCode) {
		this.studentID = studentId;
		this.unitCode = unitCode;
		this.studentUnitRecordFileAdapter = StudentUnitRecordAdapter.getInstance();
	}
	
	

	/**
	 * The studentID for this proxy.
	 * 
	 * @return the studentID.
	 */
	public Integer getStudentId() {
		return studentID;
	}
	
	
	
	/**
	 * The Unit Code for this proxy.
	 * 
	 * @return the unit code.
	 */
	public String getUnitCode() {
		return unitCode;
	}

	
	
	/**
	 * set the Assignment 1 result mark.
	 * 
	 * @param float, The mark for assignment 1.
	 */
	public void setAssignment1Result(float mark) {
		studentUnitRecordFileAdapter.getStudentUnitRecord(studentID, unitCode).
		  setAssignment1Result(mark);
	}

	
	
	/**
	 * Get the assignment 1 result.
	 * 
	 * @param float, the assignment 1 result.
	 */
	public float getAssignment1Result() {
		return studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).getAssignment1Result();
	}

	
	
	/**
	 * Set the assignment 2 result.
	 * 
	 * @param float, the assignment 2 result.
	 */
	public void setAssignment2Result(float mark) {
		studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).setAssignment2Result(mark);
	}

	
	
	/**
	 * Get assignment 2 results,
	 * 
	 * @param float, The assignment 2 result.
	 */
	public float getAssignment2Result() {
		return studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).getAssignment2Result();
	}

	
	
	/**
	 * set the exam results.
	 * 
	 * @param The mark for the exam.
	 */
	public void setExamResult(float mark) {
		studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).setExamResult(mark);
	}

	
	
	/**
	 * Get the exam result.
	 * 
	 * @param float, The exam result.
	 */
	public float getExamResult() {
		return studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).getExamResult();
	}
	
	
	
	/**
	 * Get total of the marks.
	 * 
	 * @param float, The total of the marks.
	 */
	public float getTotal() {
		return studentUnitRecordFileAdapter.getStudentUnitRecord(studentID,
		    unitCode).getTotal();
	}
}
