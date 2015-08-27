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
  private static UnitManager self_ = null;
  private UnitMap unitManager;

  
  
  /**
   * Retrieve unit record. 
   *   
   * @return self.
   */ 
  public static UnitManager getInstance() {
    if (self_ == null)
      self_ = new UnitManager();
    return self_;
  }
  
  

  private UnitManager() {
    unitManager = new UnitMap();
  }
  
  
  
  /**
   * Retrieve a unit or create new unit if no existing match.
   * 
   * @param unitCode: The unit code to retrieve
   * @return unit or create new unit if null.
   */
  public UnitInterface findUnit (String unitCode) {
    UnitInterface unit = unitManager.get(unitCode);
    return unit != null ? unit : createUnit(unitCode);

  }

  
  
  /**
   * Retrieve proxy unit element from the UnitMap.
   * 
   * @return unit manager.
   */ 
  @SuppressWarnings("unchecked")
public UnitMap getUnitMap() {
    UnitMap unitManager;
    UnitInterface unit;

    unitManager = new UnitMap();
    for (Element element : (List<Element>) XmlManager.getInstance().
        getDocument().
        getRootElement().
        getChild("unitTable").
        getChildren("Unit")) {
      
      unit = new UnitProxy(element.getAttribute("Unit ID"),
          element.getAttribute("Name"));
      
      unitManager.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units
    return unitManager;
  }
  
  

  @SuppressWarnings("unchecked")
private UnitInterface createUnit (String unitCode) {
    UnitInterface unit_;

    for (Element element : (List<Element>) XmlManager.getInstance().
        getDocument().
        getRootElement().
        getChild("Unit Table").
        getChildren("Unit"))
      if (unitCode.equals(element.getAttribute("Unit ID"))) {

        unit_ = new Unit(element.getAttribute("Unit ID"),
          element.getAttribute("Name"), Float.valueOf(
            element.getAttribute("Pass")).floatValue(), Float.valueOf(
            element.getAttribute("Credit")).floatValue(), Float.valueOf(
            element.getAttribute("Distinction")).floatValue(), Float.valueOf(
            element.getAttribute("High Distinction")).floatValue(), Float.valueOf(
            element.getAttribute("Additional Exam")).floatValue(), Integer.valueOf(
            element.getAttribute("Assignment 1 weight")).intValue(), Integer.valueOf(
            element.getAttribute("Assignment 2 weight")).intValue(), Integer.valueOf(
            element.getAttribute("Assignment 3 weight")).intValue(), Integer.valueOf(
            element.getAttribute("Exam weight")).intValue(),
            StudentUnitRecordAdapter.getInstance().getRecordsByUnit (unitCode));
        unitManager.put(unit_.getUnitCode(), unit_);
        return unit_;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
