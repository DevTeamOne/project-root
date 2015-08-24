package datamanagement;


/**
 * Represents the per subject results for a student.
 */
public class StudentUnitRecord implements IStudentUnitRecord {
  private static final String ERROR_MESSAGE = "Mark cannot be less than zero or greater than assessment weight";
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
  public StudentUnitRecord(Integer studentId, String unitCode, 
      float assignment1Result, float assignment2Result, float examResult) {
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
  
  
  
  private boolean isAssignment1ResultWithinBounds(float assignment1Result) {
    return
      WeightRange.
        getInstance().
          withUpperBoundExpression(x -> 
            UnitManager.UM().getUnit(unitCode).getAsg1Weight()).
          testValue(assignment1Result).
          isWithinBounds(ERROR_MESSAGE);
  }
  
  
  
  private boolean isAssignment2ResultWithinBounds(float assignment2Result) {
    return
      WeightRange.
        getInstance().
          withUpperBoundExpression(x -> 
            UnitManager.UM().getUnit(unitCode).getAsg2Weight()).
          testValue(assignment2Result).
          isWithinBounds(ERROR_MESSAGE);
  }
  
  
  
  private boolean isExamResultWithinBounds(float examResult) {
    return
      WeightRange.
        getInstance().
          withUpperBoundExpression(x -> 
            UnitManager.UM().getUnit(unitCode).getExamWeight()).
          testValue(examResult).
          isWithinBounds(ERROR_MESSAGE);
  }
  
  
  
  /**
   * Mutator, setting the assignment 1 results,
   * checking if it is within range
   * 
   * @param assignemnt1Result, the result to set.
   * @throws runtimeException if outside range.
   */
  public void setAssignment1Result(float assignment1Result) {
    if (isAssignment1ResultWithinBounds(assignment1Result))
      this.assignment1Result = assignment1Result;
  }


  
  /**
   * Mutator, setting the assignment 2 results,
   * checking if it is within range
   * 
   * @param assignemnt2Result, the result to set.
   * @throws runtimeException if outside range.
   */
  public void setAssignment2Result(float assignment2Result) {
    if (isAssignment2ResultWithinBounds(assignment2Result))
      this.assignment2Result = assignment2Result;
  }

  
  
  /**
   * Mutator, setting the exam result,
   * checking if it is within range
   * 
   * @param exam, the result to set.
   * @throws runtimeException if outside range.
   */
  public void setExamResult(float examResult) {
    if(isExamResultWithinBounds(examResult))
      this.examResult = examResult;
  }
  
  
  /**
   * Accessor, gets the assignment 2 results.
   */
  public float getAssignment2Result() {
    return assignment2Result;
  }

  
  
  /**
   * Accessor, gets the exam result.
   */
  public float getExamResult() {
    return examResult;
  }

  
  
  public float getTotal() {
    return assignment1Result + assignment2Result + examResult;
  }
}

