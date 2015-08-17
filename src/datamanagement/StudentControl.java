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
    
    studentManagementUserInterface_.setState1(false);
    studentManagementUserInterface_.setState2(false);
    studentManagementUserInterface_.setState3(false);
    studentManagementUserInterface_.setState4(false);
    studentManagementUserInterface_.setState5(false);
    studentManagementUserInterface_.setState6(false);
    
    studentManagementUserInterface_.Refresh3();

    ListUnitsControl units = new ListUnitsControl();
    units.listUnits(studentManagementUserInterface_);
    studentManagementUserInterface_.setVisible(true);
    studentManagementUserInterface_.setState1(true);
  }

  
  
  public void selectUnit(String code) {

    if (code.equals("NONE"))
      studentManagementUserInterface_.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(studentManagementUserInterface_, code);
      unitCode_ = code;
      studentManagementUserInterface_.setState2(true);
    }
    studentManagementUserInterface_.setState3(false);
  }

  
  
  public void selectStudent(Integer studentIdentifier) {
    currentStudentIdentifier_ = studentIdentifier;
    if (currentStudentIdentifier_.intValue() == 0) {
      studentManagementUserInterface_.Refresh3();
      studentManagementUserInterface_.setState3(false);
      studentManagementUserInterface_.setState4(false);
      studentManagementUserInterface_.setState5(false);
      studentManagementUserInterface_.setState6(false);
    }

    else {
      IStudent student = StudentManager.get().getStudent(studentIdentifier);

      IStudentUnitRecord studentUnitRecord = student.getUnitRecord(unitCode_);

      studentManagementUserInterface_.setRecord(studentUnitRecord);
      studentManagementUserInterface_.setState3(true);
      studentManagementUserInterface_.setState4(true);
      studentManagementUserInterface_.setState5(false);
      studentManagementUserInterface_.setState6(false);
      isChanged_ = false;

    }
  }

  
  
  public String checkGrade(float f, float g, float h) {
    IUnit unit = UnitManager.UM().getUnit(unitCode_);
    String grade = unit.getGrade(f, g, h);
    studentManagementUserInterface_.setState4(true);
    studentManagementUserInterface_.setState5(false);
    if (isChanged_) {
      studentManagementUserInterface_.setState6(true);
    }
    return grade;
  }

  
  
  public void enableChangeMarks() {
    studentManagementUserInterface_.setState4(false);
    studentManagementUserInterface_.setState6(false);
    studentManagementUserInterface_.setState5(true);
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
    studentManagementUserInterface_.setState4(true);
    studentManagementUserInterface_.setState5(false);
    studentManagementUserInterface_.setState6(false);
  }
}
