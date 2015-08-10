package datamanagement;

public class StudentControl {

  CheckGradeUserInterface studentManagementUserInterface;
  String unitCode = null;
  Integer currentStudentID = null;
  boolean changed = false;

  public StudentControl() {
  }

  public void execute() {
    studentManagementUserInterface = new CheckGradeUserInterface(this);
    studentManagementUserInterface.setState1(false);

    studentManagementUserInterface.setState2(false);
    studentManagementUserInterface.setState3(false);
    studentManagementUserInterface.setState4(false);
    studentManagementUserInterface.setState5(false);
    studentManagementUserInterface.setState6(false);
    studentManagementUserInterface.Refresh3();

    ListUnitsCTL units = new ListUnitsCTL();
    units.listUnits(studentManagementUserInterface);
    studentManagementUserInterface.setVisible(true);
    studentManagementUserInterface.setState1(true);
  }

  public void unitSelected(String code) {

    if (code.equals("NONE"))
      studentManagementUserInterface.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(studentManagementUserInterface, code);
      unitCode = code;
      studentManagementUserInterface.setState2(true);
    }
    studentManagementUserInterface.setState3(false);
  }

  public void studentSelected(Integer studentIdentifier) {
    currentStudentID = studentIdentifier;
    if (currentStudentID.intValue() == 0) {
      studentManagementUserInterface.Refresh3();
      studentManagementUserInterface.setState3(false);
      studentManagementUserInterface.setState4(false);
      studentManagementUserInterface.setState5(false);
      studentManagementUserInterface.setState6(false);
    }

    else {
      IStudent student = StudentManager.get().getStudent(studentIdentifier);

      IStudentUnitRecord studentUnitRecord = student.getUnitRecord(unitCode);

      studentManagementUserInterface.setRecord(studentUnitRecord);
      studentManagementUserInterface.setState3(true);
      studentManagementUserInterface.setState4(true);
      studentManagementUserInterface.setState5(false);
      studentManagementUserInterface.setState6(false);
      changed = false;

    }
  }

  public String checkGrade(float f, float g, float h) {
    IUnit unit = UnitManager.UM().getUnit(unitCode);
    String grade = unit.getGrade(f, g, h);
    studentManagementUserInterface.setState4(true);
    studentManagementUserInterface.setState5(false);
    if (changed) {
      studentManagementUserInterface.setState6(true);
    }
    return grade;
  }

  public void enableChangeMarks() {
    studentManagementUserInterface.setState4(false);
    studentManagementUserInterface.setState6(false);
    studentManagementUserInterface.setState5(true);
    changed = true;
  }

  public void saveGrade(float asg1, float asg2, float exam) {

    IUnit u = UnitManager.UM().getUnit(unitCode);
    IStudent s = StudentManager.get().getStudent(currentStudentID);

    IStudentUnitRecord r = s.getUnitRecord(unitCode);
    r.setAssignment1Result(asg1);
    r.setAssignment2Result(asg2);
    r.setExamResult(exam);
    StudentUnitRecordManager.instance().saveRecord(r);
    studentManagementUserInterface.setState4(true);
    studentManagementUserInterface.setState5(false);
    studentManagementUserInterface.setState6(false);
  }
}
