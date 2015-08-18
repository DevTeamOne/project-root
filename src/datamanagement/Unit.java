package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: Unit class object containing details of a unit such as unit code and unit name as implemented from the IUnit class.
 */
public class Unit implements UnitInterface {
  
  
  
  /** 
   * Declare class variables.
   */
  private String unitCode_;
  private String unitName_;
  private float passRange;
  private float creditRange;
  private float distinctionRange;
  private float highDistinctionRange;
  private float additionalExamRange;
  private int assignment1, assignment2, exam;
  private StudentUnitRecordList recordStudent;

  
  
  /**
   * Retrieve a unit or create new unit if no existing match.
   * 
   * @param code: The unit code to retrieve.
   * @param name: The unit name to retrieve.
   * @param range1: The range of a pass mark for this unit to retrieve.
   * @param range2: The range of a credit mark for this unit to retrieve.
   * @param range3: The range of a distinction mark for this unit to retrieve.
   * @param range4: The range of a high distinction mark for this unit to retrieve.
   * @param range5: The range of an additional exam for this unit to retrieve.
   * @param weight1: The weight of assessments for this unit to set.
   * @param weight2: The weight of assessments for this unit to set.
   * @param weight3: The weight of assessments for this unit to set.
   * @param recordList: If the unit is not currently in the unit list then create new unit to record. 
   */
  public Unit (String code, String name, float range1, float range2, float range3, float range4,
      float range5, int weight1, int weight2, int weight3, StudentUnitRecordList recordList) {

    this.unitCode_ = code;
    this.unitName_ = name;
    this.passRange = range1;
    this.creditRange = range2;
    this.distinctionRange = range3;
    this.highDistinctionRange = range4;
    this.additionalExamRange = range5;
    this.setAssessmentWeights(weight1, weight2, weight3);
    recordStudent = recordList == null ? new StudentUnitRecordList() : recordList;
  }

  
  
  /**
   * Retrieve unit code.
   * 
   * @return The unit code.
   */ 
  public String getUnitCode() {
    return this.unitCode_;
  }

 
  
  /**
   * Retrieve unit name.
   * 
   * @return The unit name.
   */
  public String getUnitName() {
    return this.unitName_;
  }
   
  
  
  /**
   * Retrieve pass range.
   * 
   * @return The pass range.
   */
  public float getPassRange() {
    return this.passRange;
  }
  
  
  
  /**
   * Retrieve credit range.
   * 
   * @return The credit range.
   */
  public float getCreditRange() {
    return this.creditRange;
  }

  
  
  /**
   * Retrieve distinction range.
   * 
   * @return The distinction range.
   */
  public float getDistinctionRange() {
    return this.distinctionRange;
  }
  
  
  
  /**
   * Retrieve high distinction range.
   * 
   * @return The high distinction range.
   */
  public float getHighDistinctionRange() {
    return this.highDistinctionRange;
  }
  
  
  
  /**
   * Retrieve additional exam range.
   * 
   * @return The additional exam range.
   */
  public float getAdditionalExamRange() {
    return this.additionalExamRange;
  }
      
  
  
  /**
   * Retrieve high distinction range.
   * 
   * @param studentNumber: The student number to retrieve.
   * @return If the student number exists lookup and return record.
   * @return null.
   */
  public IStudentUnitRecord getStudentRecord (int studentNumber) {
    for (IStudentUnitRecord record : recordStudent) {
      if (record.getStudentNumber() == studentNumber)
        return record;
    }
    return null;
  }
  
  
  
  /**
   * Retrieve first assignment weight.
   * 
   * @return The first assignment weight.
   */
  public int getFirstAssignmentWeight() {
    return assignment1;
  }
  
  

  /**
   * Retrieve second assignment weight.
   * 
   * @return The second assignment weight.
   */
  public int getSecondAssignmentWeight() {
    return assignment2;
  }
  
  

  /**
   * Retrieve exam weight.
   * 
   * @return The exam weight.
   */
  public int getExamWeight() {
    return exam;
  }
  
  
  
  /**
   * Retrieve grades.
   * 
   * @param assessment1: The first assessment value to retrieve.
   * @param assessment2: The second assessment value to retrieve.
   * @param assessment3: The third assessment value to retrieve.
   * @throw exception on the marking criterion.
   * @return string.
   * @return string.
   * @return string.
   * @return string.
   * @return string.
   * @return string.
   */
  public String getGrade (float assessment1, float assessment2, float assessment3) {
    float totalMarks = assessment1 + assessment2 + assessment3;

    if (assessment1 < 0 || assessment1 > assignment1 || 
        assessment2 < 0 || assessment2 > assignment2 || 
        assessment3 < 0 || assessment3 > exam) {
      throw new RuntimeException(
          "marks cannot be less than zero or greater than assessment weights");
    }

    if (totalMarks < additionalExamRange) {
      return "Fail";
    } 
    else if (totalMarks < passRange)
      return "Additional Exam";
    else if (totalMarks < creditRange)
      return "Pass";
    else if (totalMarks < distinctionRange)
      return "Credit";
    else if (totalMarks < highDistinctionRange)
      return "Distinction";
    else
      return "High Distinction";
  }
  
  
  
  /**
   * Set unit pass range.
   * 
   * @param range: The range of a pass mark to set.
   */
  public void setPassRange (float range) {
    this.passRange = range;
  }
  
  

  /**
   * Set unit credit range.
   * 
   * @param range: The range of a credit mark to set.
   */
  public void setCreditRange (float range) {
    this.creditRange = range;
  }
  
  

  /**
   * Set unit distinction range.
   * 
   * @param range: The range of a distinction mark to set.
   */
  public void setDistinctionRange (float range) {
    this.distinctionRange = range;
  }

  
  
  /**
   * Set unit high distinction range.
   * 
   * @param range: The range of a high distinction mark to set.
   */
  public void setHighDistinctionRange (float range) {
    this.highDistinctionRange = range;
  }
  
  

  /**
   * Set unit additional exam range.
   * 
   * @param range: The range of an additional exam to set.
   */
  public void setAdditionalExamRange (float range) {
    this.additionalExamRange = range;
  }

  
  
  /**
   * Set the weighting criterion for each assessment.
   * 
   * @param assessment1: The weight of assessment 1 to set.
   * @param assessment2: The weight of assessment 2 to set.
   * @param assessmentExam: The weight of exam to set.
   * @throw exception on weight range.
   * @throw exception on weight total.
   */
  public void setAssessmentWeights (int assessment1, int assessment2, int assessment3) {
    if (assessment1 < 0 || assessment1 > 100 || 
        assessment2 < 0 || assessment2 > 100 || 
        assessment3 < 0 || assessment3 > 100) {
      throw new RuntimeException(
          "Assessment weights cant be less than zero or greater than 100");
    }
    if (assessment1 + assessment2 + assessment3 != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.assignment1 = assessment1;
    this.assignment2 = assessment2;
    this.exam = assessment3;
  }
  
  

  /**
   * Set the weighting criterion for each assessment.
   * 
   * @param pass: The pass range to set.
   * @param credit: The credit range to set.
   * @param distinction: The distinction range to set.
   * @param highDistinction: The high distinction range to set.
   * @param additionalExam: The additional exam range to set.
   */
  private void setAssignmentRange (float pass, float credit, float distinction, float highDistinction, float additionalExam) {
    if (pass < 0 || pass > 100 || 
        credit < 0 || credit > 100 || 
        distinction < 0 || distinction > 100 || 
        highDistinction <= 0 || highDistinction > 100 || 
        additionalExam < 0 || additionalExam > 100) {
      throw new RuntimeException(
          "Assessment range cant be less than zero or greater than 100");
    }
    if (additionalExam >= pass) {
      throw new RuntimeException("Alternative Exit range must be less than Pass range");
    }
    if (pass >= credit) {
      throw new RuntimeException("Pass range must be less than Credit range");
    }
    if (credit >= distinction) {
      throw new RuntimeException("Credit range must be less than Distinction range");
    }
    if (distinction >= highDistinction) {
      throw new RuntimeException("Distinction range must be less than High Distinction range");
    }
  }

  
  
  /**
   * Add a record of a unit to the student record.
   * 
   * @param record: The unit record of a student to add the to student record.
   */
  public void addStudentRecord (IStudentUnitRecord record) {
    recordStudent.add(record);
  }

  
  
  /**
   * Access the student unit record list.
   * 
   * @return The list of the student record.
   */
  public StudentUnitRecordList listStudentRecords() {
    return recordStudent;
  }

}