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
  private UnitMap unitManager;

  public static UnitManager UNIT_MANAGER() {
    if (self == null)
      self = new UnitManager();
    return self;
  }

  
  
  private UnitManager() {
    unitManager = new UnitMap();
  }
  
  

  public IUnit getUnit(String unitCode) {
    IUnit unit = unitManager.get(unitCode);
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

  
  
  private IUnit createUnit(String unitCode) {

    IUnit unit;

    for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable").getChildren("unit"))
      if (unitCode.equals(element.getAttribute("uid"))) {
        StudentUnitRecordList studentList;

        studentList = null;
        unit = new Unit(element.getAttribute("uid"),
            element.getAttribute("name"), Float.valueOf(
                element.getAttribute("ps")).floatValue(), Float.valueOf(
                element.getAttribute("cr")).floatValue(), Float.valueOf(
                element.getAttribute("di")).floatValue(), Float.valueOf(
                element.getAttribute("hd")).floatValue(), Float.valueOf(
                element.getAttribute("ae")).floatValue(), Integer.valueOf(
                element.getAttribute("asg1wgt")).intValue(), Integer
                .valueOf(element.getAttribute("asg2wgt")).intValue(),
            Integer.valueOf(element.getAttribute("examwgt")).intValue(),
            StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
        unitManager.put(unit.getUnitCode(), unit);
        return unit;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
