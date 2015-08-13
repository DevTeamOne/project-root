/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class 
 */
package datamanagement;

public class UnitProxy implements IUnit {
  private String unitCode;
  private String unitName;

  UnitManager unitManager;

  
  
  public UnitProxy(String code, String name) {
    this.unitCode = code;
    this.unitName = name;
    unitManager = UnitManager.UNIT_MANAGER();
  }

  
  
  public String getUnitCode() {
    return this.unitCode;
  }

  
  
  public String getUnitName() {
    return this.unitName;
  }

  
  
  public float getPassRange() {
    return unitManager.getUnit(unitCode).getPassRange();
  }
  
  
  public float getCreditRange() {
    return unitManager.getUnit(unitCode).getCreditRange();
  }
  
  
  public float getDistinctionRange() {
    return unitManager.getUnit(unitCode).getDistinctionRange();
  }

  
  public float getHighDistinctionRange() {

    return unitManager.getUnit(unitCode).getHighDistinctionRange();
  }
  
  
  public float getAlternativeExitRange() {
    return unitManager.getUnit(unitCode).getAlternativeExitRange();
  }
  
  
  public String getGrade(float f1, float f2, float f3) {
    return unitManager.getUnit(unitCode).getGrade(f1, f2, f3);
  }
  
  
  public IStudentUnitRecord getStudentRecord(int s) {
    return unitManager.getUnit(unitCode).getStudentRecord(s);
  }
  
  
  public int getFirstAssignmentWeight() {
    return unitManager.getUnit(unitCode).getFirstAssignmentWeight();
  }

  
  
  public int getSecondAssignmentWeight() {
    return unitManager.getUnit(unitCode).getSecondAssignmentWeight();
  }

  
  
  public int getExamWeight() {
    return unitManager.getUnit(unitCode).getExamWeight();
  }
  
  
  
  public void setPassRange(float range) {
    unitManager.getUnit(unitCode).setPassRange(range);
  }

    
  public void setCreditRange(float range) {
    unitManager.getUnit(unitCode).setCreditRange(range);
  }
  
  public void setDistinctionRange(float range) {
    unitManager.getUnit(unitCode).setDistinctionRange(range);
  }
  
  public void setHighDistinctionRange(float range) {
    unitManager.getUnit(unitCode).setHighDistinctionRange(range);
  }

    
  public void setAlternativeExitRange(float range) {
    unitManager.getUnit(unitCode).setAlternativeExitRange(range);
  }  
   
  
  public void setAssessmentWeights(int assessment1, int assessment2, int assessmentExam) {
    unitManager.getUnit(unitCode).setAssessmentWeights(assessment1, assessment2, assessmentExam);
  }
  
  
  public void addStudentRecord(IStudentUnitRecord record) {
    unitManager.getUnit(unitCode).addStudentRecord(record);
  }
  
  
  public StudentUnitRecordList listStudentRecords() {
    return unitManager.getUnit(unitCode).listStudentRecords();
  }
}
