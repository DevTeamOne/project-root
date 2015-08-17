package datamanagement;
public class ListUnitsControl {
    private UnitManager um;
public ListUnitsControl() {
        um = UnitManager.UM();
}
            public void listUnits( IUnitLister lister ) {
lister.clearUnits();UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
