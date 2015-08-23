package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class can add a record to a unit, list an existing unit and its weighting criterion.
 */
public class UnitProxy 
  implements UnitInterface
{
  
  
  
  /** 
   * Declare class variables.
   */
  UnitManager unitManager;
  private String unitCode;
  private String unitName;

  
  
  /**
   * Constructor method for class UnitProxy.  
   * 
   * @param code: The unit code to retrieve.
   * @param name: The unit name to retrieve.
   */  
  public UnitProxy (String code, String name) {
    this.unitCode = code;
    this.unitName = name;
    unitManager = UnitManager.getInstance();
  }

  
  
  /**
   * Retrieve the unit code.
   * 
   * @return unit code.
   */  
  public String getUnitCode() {
    return this.unitCode;
  }

  
  
  /**
   * Retrieve the unit name.
   * 
   * @return unit name.
   */  
  public String getUnitName() {
    return this.unitName;
  }

  
  
  /**
   * Retrieve the pass range of each unit.
   * 
   * @return pass range.
   */
  public float getPassRange() {
    return unitManager.getUnit (unitCode).getPassRange();
  }
  
  
  
  /**
   * Retrieve the credit range of each unit.
   * 
   * @return credit range.
   */
  public float getCreditRange() {
    return unitManager.getUnit (unitCode).getCreditRange();
  }
  
  
  
  /**
   * Retrieve the distinction range of each unit.
   * 
   * @return distinction range.
   */
  public float getDistinctionRange() {
    return unitManager.getUnit (unitCode).getDistinctionRange();
  }

  
  
  /**
   * Retrieve the high distinction range of each unit.
   * 
   * @return high distinction range.
   */
  public float getHighDistinctionRange() {

    return unitManager.getUnit (unitCode).getHighDistinctionRange();
  }
  
  
  
  /**
   * Retrieve the additional exam range of each unit.
   * 
   * @return additional exam range.
   */
  public float getAdditionalExamRange() {
    return unitManager.getUnit (unitCode).getAdditionalExamRange();
  }
  
  
  
  /**
   * Retrieve the unit grade.
   * 
   * @param first: The unit code to retrieve grade
   * @param second: The unit code to retrieve grade
   * @param third: The unit code to retrieve grade
   * @return unit grade.
   */
  public String getGrade (float first, float second, float third) {
    return unitManager.getUnit (unitCode).getGrade (first, second, third);
  }
  
  
  
  /**
   * Retrieve the student record.
   * 
   * @param student: The student to retrieve.
   * @return student information record.
   */
  public IStudentUnitRecord getStudentRecord (int student) {
    return unitManager.getUnit(unitCode).getStudentRecord(student);
  }
  
  
  
  /**
   * Retrieve the weighting value of the first assignment of a unit.
   * 
   * @return the first assignment weight for a specific unit.
   */
  public int getFirstAssignmentWeight() {
    return unitManager.getUnit(unitCode).getFirstAssignmentWeight();
  }
  
  
  
  /**
   * Retrieve the weighting value of the second assignment of a unit.
   * 
   * @return the second assignment weight for a specific unit.
   */ 
  public int getSecondAssignmentWeight() {
    return unitManager.getUnit(unitCode).getSecondAssignmentWeight();
  }
  
  
  
  /**
   * Retrieve the weighting value of the exam of a unit.
   * 
   * @return the exam weight for a specific unit.
   */
  public int getExamWeight() {
    return unitManager.getUnit(unitCode).getExamWeight();
  }
  
  
  
  /**
   * Set pass range for a specific unit.
   * 
   * @param range: The range of a pass mark to set.
   */
  public void setPassRange (float range) {
    unitManager.getUnit(unitCode).setPassRange(range);
  }

  
  
  /**
   * Set credit range for a specific unit.
   * 
   * @param range: The range of a credit mark to set.
   */ 
  public void setCreditRange (float range) {
    unitManager.getUnit(unitCode).setCreditRange(range);
  }
  
  
  
  /**
   * Set distinction range for a specific unit.
   * 
   * @param range: The range of a distinction mark to set.
   */ 
  public void setDistinctionRange (float range) {
    unitManager.getUnit(unitCode).setDistinctionRange(range);
  }
  
  
  
  /**
   * Set high distinction range for a specific unit.
   * 
   * @param range: The range of a high distinction mark to set.
   */
  public void setHighDistinctionRange (float range) {
    unitManager.getUnit(unitCode).setHighDistinctionRange(range);
  }
  
  

  /**
   * Set additional exam range for a specific unit.
   * 
   * @param range: The range for an additional exam to be set.
   */  
  public void setAdditionalExamRange (float range) {
    unitManager.getUnit(unitCode).setAdditionalExamRange(range);
  }  
  
  
   
  /**
   * Set the weight of each assessment item.
   * 
   * @param assessment1: The range of the first assessment item to be set.
   * @param assessment2: The range of the second assessment item to be set.
   * @param exam: The range of the exam item to be set.
   */ 
  public void setAssessmentWeights (int assessment1, 
      int assessment2, int exam) {
    unitManager.getUnit(unitCode).setAssessmentWeights(
        assessment1, assessment2, exam);
  }
  
  
  
  /**
   * Add a mark to student record.
   * 
   * @param mark: The specific mark to be added on the students record.
   */ 
  public void addStudentRecord (IStudentUnitRecord mark) {
    unitManager.getUnit(unitCode).addStudentRecord(mark);
  }
  
  
  
  /**
   * List the student record of a student.
   * 
   * @return A list of the students record.
   */ 
  public StudentUnitRecordList listStudentRecords() {
    return unitManager.getUnit(unitCode).listStudentRecords();
  }
}
