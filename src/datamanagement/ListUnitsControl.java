package datamanagement;

public class ListUnitsControl {
  private UnitManager unitManager;

  public ListUnitsControl() {
    unitManager = UnitManager.UNIT_MANAGER();
  }

  public void listUnits(IUnitLister lister) {
    lister.clearUnits();
    UnitMap units = unitManager.getUnits();
    for (String student : units.keySet())
      lister.addUnit(units.get(student));
  }
}
