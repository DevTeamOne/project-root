package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class manages and creates new element of a unit.
 */
import java.util.List;

import org.w3c.dom.Element;

public class UnitManager {
  
  
  
  /** 
   * Declare class variables.
   */
  private static UnitManager self = null;
  private UnitMap unitManager_;

  
  
  /**
   * Retrieve unit record. 
   *   
   * @return self.
   */ 
  public static UnitManager UNIT_MANAGER() {
    if (self == null)
      self = new UnitManager();
    return self;
  }
  
  

  /**
   * Constructor of class UnitManager.
   */ 
  private UnitManager() {
    unitManager_ = new UnitMap();
  }
  
  
  
  /**
   * Retrieve a unit or create new unit if no existing match.
   * 
   * @param unitCode: The unit code to retrieve
   * @return unit or create new unit if null.
   */
  public UnitInterface getUnit (String unitCode) {
    UnitInterface unit = unitManager_.get(unitCode);
    return unit != null ? unit : createUnit(unitCode);

  }

  
  
  /**
   * Retrieve proxy unit element from the UnitMap.
   * 
   * @return unit manager.
   */ 
  public UnitMap getUnits() {
    UnitMap unitManager;
    UnitInterface unit;

    unitManager = new UnitMap();
    for (Element e : (List<Element>) XMLManager.getXML().
        getDocument().
        getRootElement().
        getChild("unitTable").
        getChildren("Unit")) {
      
      unit = new UnitProxy(e.getAttribute("Unit ID"),
          e.getAttribute("Name"));
      
      unitManager.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units
    return unitManager;
  }
  
  

  /**
   * Create a new unit element using unit code.   
   * 
   * @param unitCode: The unit code assigned to a new unit element.
   * @return the unit created.
   * @throws runtime exception if unit is not in file.
   */
  private UnitInterface createUnit (String unitCode) {
    UnitInterface unit_;

    for (Element e : (List<Element>) XMLManager.getXML().
        getDocument().
        getRootElement().
        getChild("Unit Table").
        getChildren("Unit"))
      if (unitCode.equals(e.getAttribute("Unit ID"))) {
        StudentUnitRecordList studentList;

        studentList = null;
        unit_ = new Unit(e.getAttribute("Unit ID"),
            e.getAttribute("Name"), Float.valueOf(
                e.getAttribute("Pass")).floatValue(), Float.valueOf(
                e.getAttribute("Credit")).floatValue(), Float.valueOf(
                e.getAttribute("Distinction")).floatValue(), Float.valueOf(
                e.getAttribute("High Distinction")).floatValue(), Float.valueOf(
                e.getAttribute("Additional Exam")).floatValue(), Integer.valueOf(
                e.getAttribute("Assignment 1 weight")).intValue(), Integer.valueOf(
                e.getAttribute("Assignment 2 weight")).intValue(), Integer.valueOf(
                e.getAttribute("Exam weight")).intValue(), StudentUnitRecordManager.instance().
                getRecordsByUnit(unitCode));
        unitManager_.put(unit_.getUnitCode(), unit_);
        return unit_;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
