/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class
 */
package datamanagement;

import java.util.List;

import org.w3c.dom.Element;

public class UnitManager {
  private static UnitManager self = null;
  private UnitMap unitManager_;

  public static UnitManager UNIT_MANAGER() {
    if (self == null)
      self = new UnitManager();
    return self;
  }

  
  
  private UnitManager() {
    unitManager_ = new UnitMap();
  }
  
  

  public IUnit getUnit(String unitCode) {
    IUnit unit = unitManager_.get(unitCode);
    return unit != null ? unit : createUnit(unitCode);

  }

  
  
  public UnitMap getUnits() {

    UnitMap unitManger;
    IUnit unit;

    unitManger = new UnitMap();
    for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable").getChildren("Unit")) {
      unit = new UnitProxy(element.getAttribute("Unit ID"),
          element.getAttribute("Name"));
      unitManger.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units
    return unitManger;
  }

  
  
  @SuppressWarnings("unchecked")
  private IUnit createUnit(String unitCode) {

    IUnit unit_;

    for (Element element : (List<Element>) XMLManager.getXML().
        getDocument().
        getRootElement().
        getChild("Unit Table").
        getChildren("Unit"))
      if (unitCode.equals(element.getAttribute("Unit ID"))) {
        StudentUnitRecordList studentList;

        studentList = null;
        unit_ = new Unit(element.getAttribute("Unit ID"),
            element.getAttribute("Name"), Float.valueOf(
                element.getAttribute("Pass")).floatValue(), Float.valueOf(
                element.getAttribute("Credit")).floatValue(), Float.valueOf(
                element.getAttribute("Distinction")).floatValue(), Float.valueOf(
                element.getAttribute("High Distinction")).floatValue(), Float.valueOf(
                element.getAttribute("Alternative Exit")).floatValue(), Integer.valueOf(
                element.getAttribute("Assignment 1 weight")).intValue(), Integer.valueOf(
                element.getAttribute("Assignment 2 weight")).intValue(), Integer.valueOf(
                element.getAttribute("Exam weight")).intValue(), StudentUnitRecordManager.instance().
                getRecordsByUnit(unitCode));
        unitManager_.put(unit_.getUnitCode(), unit_);
        return unit_;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
