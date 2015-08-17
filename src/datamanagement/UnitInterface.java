/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This is an interface class that allows the user to add or retrieve information of a unit.
 */
package datamanagement;

public interface UnitInterface {

  /**
   * Retrieve unit code.
   */ 
  public String getUnitCode();
  
  /**
   * Retrieve unit name.
   */ 
  public String getUnitName();
  
  /**
   * Retrieve unit pass range.
   */ 
  public float getPassRange();
  
  /**
   * Retrieve unit credit range.
   */ 
  public float getCreditRange();  
  
  /**
   * Retrieve unit distinction range.
   */ 
  public float getDistinctionRange(); 
  
  /**
   * Retrieve unit high distinction range.
   */ 
  public float getHighDistinctionRange(); 
  
  /**
   * Retrieve unit additional exam range.
   */ 
  public float getAdditionalExamRange();
  
  /**
   * Retrieve first assignment weighting.
   */ 
  public int getFirstAssignmentWeight();

  /**
   * Retrieve second assignment weighting.
   */ 
  public int getSecondAssignmentWeight();

  /**
   * Retrieve exam weighting.
   */ 
  public int getExamWeight();

  /**
   * Retrieve student grade of unit.
   * @param assignment1: The assignment 1 grade to be retrieved.
   * @param assignment2: The assignment 2 grade to be retrieved.
   * @param exam: The exam grade to be retrieved.
   */ 
  public String getGrade(float assignment1, float assignment2, float exam);
  
  /**
   * Retrieve student unit record using student number.
   * @param studentNumber: The student number be retrieved.
   */ 
  public IStudentUnitRecord getStudentRecord(int studentNumber);
  
  /**
   * Set unit pass range.
   * @param range: The range of a pass mark to set.
   */
  public void setPassRange(float range);

  /**
   * Set unit credit range.
   * @param range: The range of a credit mark to set.
   */
  public void setCreditRange(float range);

  /**
   * Set unit distinction range.
   * @param range: The range of a distinction mark to set.
   */
  public void setDistinctionRange(float range);

  /**
   * Set unit high distinction range.
   * @param range: The range of a high distinction mark to set.
   */
  public void setHighDistinctionRange(float range);

  /**
   * Set unit additional exam range.
   * @param range: The range of mark for an additional exam to set.
   */
  public void setAdditionalExamRange(float range);

  /**
   * Set unit assessment weight range.
   * @param assessment1: The first assessment weight to set.
   * @param assessment2: The second assessment weight to set.
   * @param exam: The exam weight to set.
   */
  public void setAssessmentWeights(int assessment1, int assessment2, int exam);

  /**
   * Set unit assessment weight range.
   * @param range: The unit assessment weight to set.
   */
  public void addStudentRecord(IStudentUnitRecord record);

  /**
   * Call method to list student records.
   */ 
  public StudentUnitRecordList listStudentRecords();
}
