/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class 
 */
package datamanagement;

public interface IUnit {

  public String getUnitCode();

  public String getUnitName();

  public float getPassRange();
  
  public float getCreditRange();  
  
  public float getDistinctionRange(); 
  
  public float getHighDistinctionRange(); 
  
  public float getAlternativeExitRange();
  
  public int getFirstAssignmentWeight();

  public int getSecondAssignmentWeight();

  public int getExamWeight();
  
  public String getGrade(float assignment1, float assignment2, float exam);
  
  public IStudentUnitRecord getStudentRecord(int studentNumber);
  
  public void setPassRange(float range);

  public void setCreditRange(float range);

  public void setDistinctionRange(float range);

  public void setHighDistinctionRange(float range);

  public void setAlternativeExitRange(float range);

  public void setAssessmentWeights(int assessment1, int assessment2, int assessmentExam);

  public void addStudentRecord(IStudentUnitRecord record);

  public StudentUnitRecordList listStudentRecords();
}
