package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
  private Integer studentId_;
  private String unitCode_;
  private float assignment1Result_, assignment2Result_, examResult_;

  /**
   * Constructor for the Student Unit Record
   * @param studentId
   * @param unitCode
   * @param assignment1Result
   * @param assignment2Result
   * @param examResult
   */
  public StudentUnitRecord(Integer studentId, String unitCode, float assignment1Result, float assignment2Result,
      float examResult) {
    this.studentId_ = studentId;
    this.unitCode_ = unitCode;
    this.setAssignment1Result(assignment1Result);
    this.setAssignment2Result(assignment2Result);
    this.setExamResult(examResult);
  }

  
  
  public Integer getStudentID() {
    return studentId_;
  }

  
  
  public String getUnitCode() {
    return unitCode_;
  }

  
  
  public float getAssignment1Result() {

    return assignment1Result_;
  }

  
  
  public void setAssignment1Result(float assignment1Result) {
    if (assignment1Result < 0 || assignment1Result > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignment1Result_ = assignment1Result;
  }


  
  public void setAssignment2Result(float assignment2Result) {
    if (assignment2Result < 0 || assignment2Result > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignment2Result_ = assignment2Result;
  }

  
  
  public float getAssignment2Result() {
    return assignment2Result_;
  }

  
  
  public void setExamResult(float ex) {
    if (ex < 0 || ex > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.examResult_ = ex;
  }

  
  
  public float getExamResult() {
    return examResult_;
  }

  
  
  public float getTotal() {
    return assignment1Result_ + assignment2Result_ + examResult_;
  }
}
