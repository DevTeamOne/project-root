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

  
  
  public void setPsCutoff1(float cutoff) {
    unitManager.getUnit(unitCode).setPsCutoff1(cutoff);
  }

  
  
  public float getPsCutoff() {
    return unitManager.getUnit(unitCode).getPsCutoff();
  }

  
  
  public void setCrCutoff(float cutoff) {
    unitManager.getUnit(unitCode).setCrCutoff(cutoff);
  }

  
  
  public float getCrCutoff() {
    return unitManager.getUnit(unitCode).getCrCutoff();
  }

  
  
  public void setDiCutoff(float cutoff) {
    unitManager.getUnit(unitCode).setDiCutoff(cutoff);
  }

  
  
  public float getDiCuttoff() {
    return unitManager.getUnit(unitCode).getDiCuttoff();
  }

  
  
  public void setHdCutoff(float cutoff) {
    unitManager.getUnit(unitCode).setHdCutoff(cutoff);
  }

  
  
  public float getHdCutoff() {

    return unitManager.getUnit(unitCode).getHdCutoff();
  }

  
  
  public void setAeCutoff(float cutoff) {
    unitManager.getUnit(unitCode).setAeCutoff(cutoff);
  }

  
  
  public float getAeCutoff() {
    return unitManager.getUnit(unitCode).getAeCutoff();
  }

  
  
  public String getGrade(float f1, float f2, float f3) {
    return unitManager.getUnit(unitCode).getGrade(f1, f2, f3);
  }

  
  
  public void addStudentRecord(IStudentUnitRecord record) {
    unitManager.getUnit(unitCode).addStudentRecord(record);
  }

  
  
  public IStudentUnitRecord getStudentRecord(int s) {
    return unitManager.getUnit(unitCode).getStudentRecord(s);
  }

  
  
  public StudentUnitRecordList listStudentRecords() {
    return unitManager.getUnit(unitCode).listStudentRecords();
  }

  
  
  public int getAsg1Weight() {
    return unitManager.getUnit(unitCode).getAsg1Weight();
  }

  
  
  public int getAsg2Weight() {
    return unitManager.getUnit(unitCode).getAsg2Weight();
  }

  
  
  public int getExamWeight() {
    return unitManager.getUnit(unitCode).getExamWeight();
  }

  
  
  public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
    unitManager.getUnit(unitCode).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
  }
}
