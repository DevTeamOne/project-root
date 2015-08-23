package datamanagement;

/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class controls the list of units for a student.
 */
public class ListUnitsControl {
  
  
  
  private UnitManager unitManager;
  
  
  
  /**
   * Class ListUnitsControl constructor.
   */ 
  public ListUnitsControl() {
    unitManager = UnitManager.getInstance();
  }

  
  
  /**
   * Retrieve student record from class student.
   * 
   * @param cgUI: The user interface of the lister retrieved.
   * @param code: The unit code to be retrieved.
   */ 
  public void listStudents (cgUI cgUI, String code) {
    unitManager = UnitManager.getInstance();    
  }
  
  
  
  /**
   * List the units from the unitManger.
   * 
   * @param lister: The unit list to be retrieved.
   */ 
  public void listUnits (IUnitLister lister) {
    lister.clearUnits();
    UnitMap units = unitManager.getUnitMap();
    for (String student : units.keySet())
      lister.addUnit(units.get(student));
  }  
}
