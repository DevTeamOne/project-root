package datamanagement;

public class cgCTL {

	cgUI CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL() {
	}

	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);

		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();

		ListUnitsControl luCTL = new ListUnitsControl();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			CGUI.setState2(false);
		else {
		  ListUnitsControl lsCTL = new ListUnitsControl();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}

		else {
			StudentInterface s = StudentManager.getInstance().findStudent(id);

			IStudentUnitRecord r = s.findUnitRecord(cuc);

			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;

		}
	}

	public String checkGrade(float f, float g, float h) {
		UnitInterface u = UnitManager.getInstance().findUnit(cuc);
		String s = u.getGrade(f, g, h, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) {
			CGUI.setState6(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {

		UnitInterface u = UnitManager.getInstance().findUnit(cuc);
		StudentInterface s = StudentManager.getInstance().findStudent(currentStudentID);

		IStudentUnitRecord r = s.findUnitRecord(cuc);
		r.setAsg1(asg1);
		r.setAsg2(asg2);
		r.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	}
}
