package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
  private Integer studentId;
  private String unitCode;
  private float assignment1Result, assignment2Result, examResult;
  

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
    this.studentId = studentId;
    this.unitCode = unitCode;
    this.setAssignment1Result(assignment1Result);
    this.setAssignment2Result(assignment2Result);
    this.setExamResult(examResult);
  }

  
  
  /**
   * Student ID Accessor.
   * 
   * @return Integer, The student ID.
   */
  public Integer getStudentID() {
    return studentId;
  }

  
  
  /**
   * Unit Code Accessor.
   * 
   * @return String, The unit code.
   */
  public String getUnitCode() {
    return unitCode;
  }

  
  
  /**
   * Assignment 1 result Accessor,
   * 
   * @return float, Assignment 1 result.
   */
  public float getAssignment1Result() {
    return assignment1Result;
  }

  
  
  public void setAssignment1Result(float assignment1Result) {
    if (assignment1Result < 0 || assignment1Result > UnitManager.UM().
        getUnit(unitCode).getAsg1Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignment1Result = assignment1Result;
  }


  
  public void setAssignment2Result(float assignment2Result) {
    if (assignment2Result < 0 || assignment2Result > UnitManager.UM().getUnit(unitCode).getAsg2Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignment2Result = assignment2Result;
  }

  
  
  public float getAssignment2Result() {
    return assignment2Result;
  }

  
  
  public void setExamResult(float ex) {
    if (ex < 0 || ex > UnitManager.UM().getUnit(unitCode).getExamWeight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.examResult = ex;
  }

  
  
  public float getExamResult() {
    return examResult;
  }

  
  
  public float getTotal() {
    return assignment1Result + assignment2Result + examResult;
  }
}
