package datamanagement;

public class StudentControl {

  private CheckGradeUserInterface studentManagementUserInterface_;
  private String unitCode_ = null;
  private Integer currentStudentIdentifier_ = null;
  private boolean isChanged_ = false;

  public StudentControl() {
  }
  

  public void execute() {
    studentManagementUserInterface_ = new CheckGradeUserInterface(this);
    
    studentManagementUserInterface_.enableUnitComboBox(false);
    studentManagementUserInterface_.enableStudentCombo(false);
    studentManagementUserInterface_.enableCheckGradeButton(false);
    studentManagementUserInterface_.enableChangeButton(false);
    studentManagementUserInterface_.enableValueFields(false);
    studentManagementUserInterface_.enableSave(false);
    
    studentManagementUserInterface_.clearAndDisableValueFields();

    ListUnitsControl units = new ListUnitsControl();
    units.listUnits(studentManagementUserInterface_);
    studentManagementUserInterface_.setVisible(true);
    studentManagementUserInterface_.enableUnitComboBox(true);
  }

  
  
  public void selectUnit(String code) {

    if (code.equals("NONE"))
      studentManagementUserInterface_.enableStudentCombo(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(studentManagementUserInterface_, code);
      unitCode_ = code;
      studentManagementUserInterface_.enableStudentCombo(true);
    }
    studentManagementUserInterface_.enableCheckGradeButton(false);
  }

  
  
  public void selectStudent(Integer studentIdentifier) {
    currentStudentIdentifier_ = studentIdentifier;
    if (currentStudentIdentifier_.intValue() == 0) {
      studentManagementUserInterface_.clearAndDisableValueFields();
      studentManagementUserInterface_.enableCheckGradeButton(false);
      studentManagementUserInterface_.enableChangeButton(false);
      studentManagementUserInterface_.enableValueFields(false);
      studentManagementUserInterface_.enableSave(false);
    }

    else {
      IStudent student = StudentManager.get().getStudent(studentIdentifier);

      IStudentUnitRecord studentUnitRecord = student.getUnitRecord(unitCode_);

      studentManagementUserInterface_.addStudentRecord(studentUnitRecord);
      studentManagementUserInterface_.enableCheckGradeButton(true);
      studentManagementUserInterface_.enableChangeButton(true);
      studentManagementUserInterface_.enableValueFields(false);
      studentManagementUserInterface_.enableSave(false);
      isChanged_ = false;

    }
  }

  
  
  public String checkGrade(float f, float g, float h) {
    IUnit unit = UnitManager.UM().getUnit(unitCode_);
    String grade = unit.getGrade(f, g, h);
    studentManagementUserInterface_.enableChangeButton(true);
    studentManagementUserInterface_.enableValueFields(false);
    if (isChanged_) {
      studentManagementUserInterface_.enableSave(true);
    }
    return grade;
  }

  
  
  public void enableChangeMarks() {
    studentManagementUserInterface_.enableChangeButton(false);
    studentManagementUserInterface_.enableSave(false);
    studentManagementUserInterface_.enableValueFields(true);
    isChanged_ = true;
  }

  
  
  public void saveGrade(float asg1, float asg2, float exam) {

    IUnit u = UnitManager.UM().getUnit(unitCode_);
    IStudent s = StudentManager.get().getStudent(currentStudentIdentifier_);

    IStudentUnitRecord r = s.getUnitRecord(unitCode_);
    r.setAssignment1Result(asg1);
    r.setAssignment2Result(asg2);
    r.setExamResult(exam);
    StudentUnitRecordAdapter.getInstance().saveRecord(r);
    studentManagementUserInterface_.enableChangeButton(true);
    studentManagementUserInterface_.enableValueFields(false);
    studentManagementUserInterface_.enableSave(false);
  }
}
