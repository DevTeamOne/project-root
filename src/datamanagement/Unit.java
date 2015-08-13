/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class
 */
package datamanagement;

public class Unit implements IUnit {
  private String unitCode;
  private String unitNumber;
  private float co2;
  private float co1;
  private float co4;
  private float co3;
  private float co5;
  private int a1, a2, ex;

  private StudentUnitRecordList recordStudent;

  public Unit(String UC, String un, float f1, float f2, float f3, float f4,
      float f5, int i1, int i2, int i3, StudentUnitRecordList rl) {

    unitCode = UC;
    unitNumber = un;
    co2 = f1;
    co1 = f2;
    this.co4 = f3;
    co3 = f4;
    this.co5 = f5;
    this.setAssessmentWeights(i1, i2, i3);
    recordStudent = rl == null ? new StudentUnitRecordList() : rl;
  }

  public String getUnitCode() {
    return this.unitCode;
  }

  public String getUnitName() {

    return this.unitNumber;
  }
  
  public float getPassRange() {
    return this.co2;
  }

  public float getCreditRange() {
    return this.co1;
  }
  
  public float getDistinctionRange() {
    return this.co4;
  }
  
  public void getHighDistinctionRange(float range) {
    this.co3 = range;
  }
  
  public float getHighDistinctionRange() {
    return this.co3;
  }
  
  public float getAlternativeExitRange() {
    return this.co5;
  }
  
  public IStudentUnitRecord getStudentRecord(int studentID) {
    for (IStudentUnitRecord r : recordStudent) {
      if (r.getStudentID() == studentID)
        return r;
    }
    return null;
  }
  
  @Override
  public int getFirstAssignmentWeight() {
    return a1;
  }

  @Override
  public int getSecondAssignmentWeight() {
    return a2;
  }

  @Override
  public int getExamWeight() {
    return ex;
  }
  
  public String getGrade(float f1, float f2, float f3) {
    float t = f1 + f2 + f3;

    if (f1 < 0 || f1 > a1 || f2 < 0 || f2 > a2 || f3 < 0 || f3 > ex) {
      throw new RuntimeException(
          "marks cannot be less than zero or greater than assessment weights");
    }

    if (t < co5) {
      return "FL";
    } else if (t < co2)
      return "AE";
    else if (t < co1)
      return "PS";
    else if (t < co4)
      return "CR";
    else if (t < co3)
      return "DI";
    else
      return "HD";
  }
  
  public void setPassRange(float range) {
    this.co2 = range;
  }

  public void setCreditRange(float range) {
    this.co1 = range;
  }


  public void setDistinctionRange(float range) {
    this.co4 = range;
  }

  public void setHighDistinctionRange(float range) {
    this.co3 = range;
  }

  public void setAlternativeExitRange(float range) {
    this.co5 = range;
  }

  @Override
  public void setAssessmentWeights(int assessment1, int assessment2, int assessmentExam) {
    if (assessment1 < 0 || assessment1 > 100 || assessment2 < 0 || assessment2 > 100 || assessmentExam < 0 || assessmentExam > 100) {
      throw new RuntimeException(
          "Assessment weights cant be less than zero or greater than 100");
    }
    if (assessment1 + assessment2 + assessmentExam != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.a1 = assessment1;
    this.a2 = assessment2;
    this.ex = assessmentExam;
  }

  private void setAssignmentRange(float pass, float credit, float distinction, float highDistinction, float alternativeExit) {
    if (pass < 0 || pass > 100 || credit < 0 || credit > 100 || distinction < 0 || distinction > 100
        || highDistinction <= 0 || highDistinction > 100 || alternativeExit < 0 || alternativeExit > 100) {
      throw new RuntimeException(
          "Assessment range cant be less than zero or greater than 100");
    }
    if (alternativeExit >= pass) {
      throw new RuntimeException("Alternative Exit range must be less than Pass range");
    }
    if (pass >= credit) {
      throw new RuntimeException("Pass range must be less than Credit range");
    }
    if (credit >= distinction) {
      throw new RuntimeException("Credit range must be less than Distinction range");
    }
    if (distinction >= highDistinction) {
      throw new RuntimeException("Distinction range must be less than HighDistinction range");
    }
  }

  public void addStudentRecord(IStudentUnitRecord record) {
    recordStudent.add(record);
  }

  public StudentUnitRecordList listStudentRecords() {
    return recordStudent;
  }

}