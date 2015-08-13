package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {
	private Integer studentID;
	private String unitCode;
	private StudentUnitRecordAdapter mngr;

	public StudentUnitRecordProxy(Integer id, String code) {
		this.studentID = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordAdapter.getInstance();
	}

	public Integer getStudentID() {
		return studentID;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setAssignment1Result(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAssignment1Result(mark);
	}

	public float getAssignment1Result() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAssignment1Result();
	}

	public void setAssignment2Result(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setAssignment2Result(mark);
	}

	public float getAssignment2Result() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getAssignment2Result();
	}

	public void setExamResult(float mark) {
		mngr.getStudentUnitRecord(studentID, unitCode).setExamResult(mark);
	}

	public float getExamResult() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getExamResult();
	}

	public float getTotal() {
		return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
	}
}
