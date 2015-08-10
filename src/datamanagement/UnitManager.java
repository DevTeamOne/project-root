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
    IUnit iu = unitManager.get(unitCode);
    return iu != null ? iu : createUnit(unitCode);

  }

  
  
  public UnitMap getUnits() {

    UnitMap unitManger;
    IUnit iu;

    unitManger = new UnitMap();
    for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable").getChildren("Unit")) {
      iu = new UnitProxy(element.getAttribute("Unit ID"),
          element.getAttribute("Name"));
      unitManger.put(iu.getUnitCode(), iu);
    } // unit maps are filled with PROXY units
    return unitManger;
  }

  
  
  private IUnit createUnit(String unitCode) {

    IUnit iu;

    for (Element element : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable").getChildren("unit"))
      if (unitCode.equals(element.getAttribute("uid"))) {
        StudentUnitRecordList studentList;

        studentList = null;
        iu = new Unit(element.getAttribute("uid"),
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
        unitManager.put(iu.getUnitCode(), iu);
        return iu;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }
}
