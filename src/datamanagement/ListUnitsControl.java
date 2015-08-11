/**
 * Author: Evan Watkins
 * Student Number: 11537439
 * Class: ITC515
 * Assessment: Assignment 2
 * Description: This class 
 */
package datamanagement;

public class ListUnitsControl {
  private UnitManager unitManager;

  public ListUnitsControl() {
    unitManager = UnitManager.UNIT_MANAGER();
  }

  
  
  public void listStudents(cgUI cGUI, String code) {
    unitManager = UnitManager.UNIT_MANAGER();    
  }
  
  
  
  public void listUnits(IUnitLister lister) {
    lister.clearUnits();
    UnitMap units = unitManager.getUnits();
    for (String student : units.keySet())
      lister.addUnit(units.get(student));
  }  
}
