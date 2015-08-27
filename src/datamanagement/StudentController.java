package datamanagement;


/**
 * Acts as a controller for the user interface events.
 */
public class StudentController {

  private CheckGradeUserInterface studentManagementUserInterface;
  private String unitCode = null;
  private Integer currentStudentIdentifier = null;
  private boolean isChanged = false;

  
  /**
   * Null Constructor, creates empty student controller.
   */
  public StudentController() {
  }
  
  

  /**
   * Executes the user interface for the application.
   */
  public void execute() {
    studentManagementUserInterface = new CheckGradeUserInterface(this);
    
    studentManagementUserInterface.enableUnitComboBox(false);
    studentManagementUserInterface.enableStudentCombo(false);
    studentManagementUserInterface.enableCheckGradeButton(false);
    studentManagementUserInterface.enableChangeButton(false);
    studentManagementUserInterface.enableValueFields(false);
    studentManagementUserInterface.enableSave(false);
    
    studentManagementUserInterface.clearAndDisableValueFields();

    ListUnitsControl units = new ListUnitsControl();
    units.listUnits(studentManagementUserInterface);
    studentManagementUserInterface.setVisible(true);
    studentManagementUserInterface.enableUnitComboBox(true);
  }

  
  
  /**
   * When a unit is selected, respond by enabling and
   * populating the unit code combobox.
   * 
   * @param unitCode, 
   */
  public void selectUnit(String unitCode) {

    if (unitCode.equals("NONE"))
      studentManagementUserInterface.enableStudentCombo(false);
    else {
      ListStudentsControl listStudentsController = 
          new ListStudentsControl();
      listStudentsController.listStudents (studentManagementUserInterface,
          unitCode);
      this.unitCode = unitCode;
      studentManagementUserInterface.enableStudentCombo(true);
    }
    studentManagementUserInterface.enableCheckGradeButton(false);
  }

  
  
  /**
   * When a student is selected respond by enabling
   * action buttons associated with a valid student.
   * 
   * @param studentIdentifier, the Student ID.
   */
  public void selectStudent(Integer studentIdentifier) {
    currentStudentIdentifier = studentIdentifier;
    if (currentStudentIdentifier.intValue() == 0) {
      studentManagementUserInterface.clearAndDisableValueFields();
      studentManagementUserInterface.enableCheckGradeButton(false);
      studentManagementUserInterface.enableChangeButton(false);
      studentManagementUserInterface.enableValueFields(false);
      studentManagementUserInterface.enableSave(false);
    }

    else {
      StudentInterface student = StudentManager.getInstance().findStudent (studentIdentifier);

      IStudentUnitRecord studentUnitRecord = student.findUnitRecord(unitCode);

      studentManagementUserInterface.addStudentRecord (studentUnitRecord);
      studentManagementUserInterface.enableCheckGradeButton(true);
      studentManagementUserInterface.enableChangeButton(true);
      studentManagementUserInterface.enableValueFields(false);
      studentManagementUserInterface.enableSave(false);
      isChanged = false;

    }
  }

  
  
  /**
   * Populates the grade based on the supplied results, and
   *  enables / disables fields accordingly.
   * @param assignment1Result
   * @param assignment2Result
   * @param examResult
   * @return
   */
  public String checkGrade(float assignment1Result, float assignment2Result,
      float examResult) {
    UnitInterface unit = UnitManager.getInstance().findUnit(unitCode);
    String grade = unit.getGrade (assignment1Result, assignment2Result,
        examResult);
    studentManagementUserInterface.enableChangeButton(true);
    studentManagementUserInterface.enableValueFields(false);
    
    if (isChanged) 
      studentManagementUserInterface.enableSave(true);

    return grade;
  }

  
  
  /** 
   * Enables the value fields and disables
   * the save and change buttons.
   */
  public void enableChangeMarks() {
    studentManagementUserInterface.enableChangeButton(false);
    studentManagementUserInterface.enableSave(false);
    studentManagementUserInterface.enableValueFields(true);
    isChanged = true;
  }

  
  
  /**
   * Save grade creates a unit record based on results supplied,
   * then saves it, then enables/disables buttons on the UI as
   * appropriate.
   * 
   * @param assignment1Result, The result of assignment 1
   * @param assignment2Result, The result of assignment 2
   * @param examResult, The result of the assignment.
   */
  public void saveGrade(float assignment1Result, float assignment2Result,
      float examResult) {

    StudentInterface student = StudentManager.getInstance().
        findStudent (currentStudentIdentifier);

    
    IStudentUnitRecord unitRecord = student.findUnitRecord (unitCode);
    unitRecord.setAssignment1Result (assignment1Result);
    unitRecord.setAssignment2Result (assignment2Result);
    unitRecord.setExamResult (examResult);
    
    StudentUnitRecordAdapter.getInstance().saveRecord (unitRecord);
    
    studentManagementUserInterface.enableChangeButton(true);
    studentManagementUserInterface.enableValueFields(false);
    studentManagementUserInterface.enableSave(false);
  }
}
