package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class manages and creates new element of a unit.
 */
import java.util.List;

import org.jdom.Element;

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
        getChildren("unit")) {
      
      unit = new UnitProxy(element.getAttributeValue("uid"),
          element.getAttributeValue("name"));
      
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
        getChild("unitTable").
        getChildren("unit"))
      if (unitCode.equals(element.getAttributeValue("uid"))) {

        unit_ = new Unit(element.getAttributeValue("uid"),
          element.getAttributeValue("name"), Float.valueOf(
            element.getAttributeValue("ps")).floatValue(), Float.valueOf(
            element.getAttributeValue("cr")).floatValue(), Float.valueOf(
            element.getAttributeValue("di")).floatValue(), Float.valueOf(
            element.getAttributeValue("hd")).floatValue(), Float.valueOf(
            element.getAttributeValue("ae")).floatValue(), Integer.valueOf(
            element.getAttributeValue("asg1wgt")).intValue(), Integer.valueOf(
            element.getAttributeValue("asg2wgt")).intValue(), Integer.valueOf(
            element.getAttributeValue("examwgt")).intValue(),
            StudentUnitRecordAdapter.getInstance().getRecordsByUnit (unitCode));
        unitManager.put(unit_.getUnitCode(), unit_);
        return unit_;
      }

  
    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
