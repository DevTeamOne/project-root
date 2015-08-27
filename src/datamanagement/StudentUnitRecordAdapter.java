package datamanagement;

import org.jdom.Element;

import java.util.List;


/**
 * StudentUnitRecordAdapter performs the function of an Adapter 
 * (persistance and hydration) between an XML file and
 * a StudentUnitRecord.
 */
public class StudentUnitRecordAdapter {
  private static final String ASSIGNMENT1_ATTRIBUTE = "asg1";
  private static final String ASSIGNMENT2_ATTRIBUTE = "asg2";
  private static final String EXAM_ATTRIBUTE = "exam";
  private static final String STUDENT_ID_ATTRIBUTE = "sid";
  private static final String UNIT_CODE_ATTRIBUTE = "uid";
  private static final String STUDENT_UNIT_RECORD_NODE = "studentUnitRecordTable";
  private static final String RECORD_NODE = "studentUnitRecordTable";

  private static StudentUnitRecordAdapter studentUnitRecordManager_ = null;

  private StudentUnitRecordMap studentRecordMap_;
  private java.util.HashMap<String, StudentUnitRecordList> studentUnitRecordsByName_;
  private java.util.HashMap<Integer, StudentUnitRecordList> studentUnitRecordsById_;

    
  private StudentUnitRecordAdapter() {
    studentRecordMap_ = new StudentUnitRecordMap();
    studentUnitRecordsByName_ = new java.util.HashMap<>();
    studentUnitRecordsById_ = new java.util.HashMap<>();
  }
  
  

  public static StudentUnitRecordAdapter getInstance() {
    if (studentUnitRecordManager_ == null)
      studentUnitRecordManager_ = new StudentUnitRecordAdapter();
    return studentUnitRecordManager_;
  }
  
  
  
  /**
   * Retrieve a student unit record, based on a key of both student id and unit code.
   * 
   * @param studentID: The student Id to retrieve.
   * @param unitCode: The unit code to retrieve
   * @return A matching or empty student unit record.
   */
  public IStudentUnitRecord getStudentUnitRecord(Integer studentID,
      String unitCode) {
    
    // Retrieve the Student unit record, based on a key of student Id and unit code. 
    IStudentUnitRecord studentUnitRecord = studentRecordMap_.get(studentID
        .toString() + unitCode);
    
    if (studentUnitRecord == null)
      studentUnitRecord = findStudentUnitRecord(studentID, unitCode);

    return studentUnitRecord;
  }
  
  
  
  /**
   * Return a student unit record based on the given composite key of 
   * Student Id and Unit Code Id.
   * 
   * @param studentId: The student Id to find.
   * @param unitCodeId: Then unit code id to find.
   * @return: ISTudentRecord - the record represented by
   * @throws: RuntimeException if the record can't be found - this seems dirty, 
   * the program can and should recover from no record found,
   * at worst case here there should be a checked exception, 
   * at best an empty object... even returning null would be better.
   */
  private IStudentUnitRecord findStudentUnitRecord(Integer studentId,
      String unitCodeId) {

    IStudentUnitRecord studentUnitRecord;

    // Get the list of record element nodes from the StudentUnitRecordTable
    // node.
    List<Element> studentUnitRecords = loadStudentUnitRecordElementsFromFile();

    // For each element where the given UID and SID matches the XML node.
    for (Element element : studentUnitRecords) {
      if (isMatch(element, studentId, unitCodeId)) {
        
        studentUnitRecord = mapStudentUnitRecordFromElement(element);
        studentRecordMap_.put(buildCompositeKeyAsString(studentUnitRecord), 
            studentUnitRecord);
        
        return studentUnitRecord;
      }
    }
    throw new RuntimeException(
        "DBMD: createStudent : student unit record not in file");
  }
  
  
  
  /**
   * Returns a composite key built from the Student Id and Unit Code.
   * This can be used to uniquely identify a record.
   * 
   * @param studentUnitRecord: The record from which to construct a
   *  composite key.
   * @return : String - The composite key.
   */
  private String buildCompositeKeyAsString (
      IStudentUnitRecord studentUnitRecord) {
    
      return studentUnitRecord.getStudentId().toString() +
           studentUnitRecord.getUnitCode();
  }

  
  
  /**
   * Loads the student unit record element from the XML file.
   * 
   * @return: List of XML Elements.
   */
  @SuppressWarnings("unchecked")
private List<Element> loadStudentUnitRecordElementsFromFile() {
    return (List<Element>) XmlManager.
        getInstance().
        getDocument().
        getRootElement().
        getChild(STUDENT_UNIT_RECORD_NODE).
        getChildren(RECORD_NODE);
  }
  

  
  /**
   * Checks if the given element matches the Student ID and Unit Code.
   * 
   * @param element: The element under test.
   * @param studentId: The student ID to compare.
   * @param unitCodeId: The Unit Code to compare.
   * @return: Boolean, True if the element matches the given code.
   */
  private boolean isMatch(Element element, Integer studentId,
      String unitCodeId) {
    return 
        unitCodeId.equals(getAttributeAsString(element, UNIT_CODE_ATTRIBUTE)) &&
        studentId.equals(getAttributeAsInteger(element, STUDENT_ID_ATTRIBUTE));
  }
  

  
  /**
   * Returns the value of the requested attribute, from the given element 
   * as a float.
   * 
   * @param element: An element node, containing the given attributeName.
   * @param attributeName: The name of the attribute value
   * @return: The value of of the requested attribute as a Float. 
   */
  private Float getAttributeAsFloat(Element element, String attributeName) {
    return new Float(element.getAttributeValue(attributeName));
  }

  

  /**
   * Returns the value of the requested attribute, from the given element 
   * as a Integer.
   * 
   * @param element: An element node, containing the given attributeName.
   * @param attributeName: The name of the attribute value
   * @return: The value of of the requested attribute as a Integer. 
   */
  private Integer getAttributeAsInteger(Element element, String attributeName) {
    return new Integer(element.getAttributeValue(attributeName));
  }


  
  /**
   * Returns the value of the requested attribute, from the given element 
   * as a String.
   * 
   * @param element: An element node, containing the given attributeName.
   * @param attributeName: The name of the attribute value
   * @return: The value of of the requested attribute as a String. 
   */
  private String getAttributeAsString(Element element, String attributeName) {
    return new String(element.getAttributeValue(attributeName));
  }
  

  
  /**
   * Hydrates a student record element node from the CML document to a
   * StudentUnitRecord.
   * 
   * @param element: Student element node
   * @return StudentUnitRecord: record mapped from an element.
   */
  private StudentUnitRecord mapStudentUnitRecordFromElement(Element element) {
    return new StudentUnitRecord(
        getAttributeAsInteger(element, STUDENT_ID_ATTRIBUTE),
        getAttributeAsString(element, UNIT_CODE_ATTRIBUTE), 
        getAttributeAsFloat(element, ASSIGNMENT1_ATTRIBUTE), 
        getAttributeAsFloat(element, ASSIGNMENT2_ATTRIBUTE),
        getAttributeAsFloat(element, EXAM_ATTRIBUTE));
  }
  
  

  /**
   * Retrieves a list of StudentUnitRecords with the given unit code.
   * 
   * @param unitCode: The unit code for the student records to find.
   * @return: StudentRecordList - List of records for students enrolled the
   *          given unit code.
   */
  public StudentUnitRecordList getRecordsByUnit(String unitCode) {

    // Return any existing student records having the given unit code.
    StudentUnitRecordList studentUnitRecords = 
        studentUnitRecordsByName_.get(unitCode);
    
    if (studentUnitRecords != null)
      return studentUnitRecords;

    studentUnitRecords = new StudentUnitRecordList();

    // Iterate through all of the student records from the XML file.
    List<Element> studentUnitElements = loadStudentUnitRecordElementsFromFile();
    for (Element element : studentUnitElements) {

      String unitCodeId = getAttributeAsString(element, UNIT_CODE_ATTRIBUTE);
      Integer studentId = getAttributeAsInteger(element, STUDENT_ID_ATTRIBUTE);

      // Add proxy records for students having a matching unit code.
      if (unitCode.equals(unitCodeId)) {
        StudentUnitRecordProxy studentUnitRecordProxy = new StudentUnitRecordProxy(
            studentId, unitCodeId);
        studentUnitRecords.add(studentUnitRecordProxy);
      }
    }

    // Add the list of proxy objects to the studentUnitRecordsByName hashmap.
    if (studentUnitRecords.size() > 0)
      studentUnitRecordsByName_.put(unitCode, studentUnitRecords);
    
    return studentUnitRecords;
  }


  
  /**
   * Retrieves a list of StudentRecords by Student Id.
   * 
   * @param studentID: The student Id indicating records to be returned.
   * @return: StudentUnitRecords list of records for the given student Id.
   */
  public StudentUnitRecordList findStudentUnitRecordsById(Integer studentIDToFind) {

    // Return any existing studentUnitRecords for the given student ID.
    StudentUnitRecordList studentUnitRecords = 
        studentUnitRecordsById_.get(studentIDToFind);
    if (studentUnitRecords != null)
      return studentUnitRecords;

    studentUnitRecords = new StudentUnitRecordList();

    // Otherwise iterate through all of the student records from the XML file.
    for (Element element : loadStudentUnitRecordElementsFromFile()) {

      String unitCode = getAttributeAsString(element, UNIT_CODE_ATTRIBUTE);
      Integer studentId = getAttributeAsInteger(element, STUDENT_ID_ATTRIBUTE);

      if (studentIDToFind.toString().equals(studentId)) {

        StudentUnitRecordProxy studentUnitRecordProxy = 
            new StudentUnitRecordProxy(studentId, unitCode);
        studentUnitRecords.add(studentUnitRecordProxy);
      }
    }

    // Add the list of proxy objects to the studentUnitRecordsById hashmap.
    if (studentUnitRecords.size() > 0)
      studentUnitRecordsById_.put(studentIDToFind, studentUnitRecords); 
    return studentUnitRecords;
  }
  
  

  /**
   * Save a record to the XML file.
   * 
   * @param studentUnitRecord: Record to be saved.
   * @throws: RuntimeException - If the xml document could not be saved.
   */
  public void saveRecord(IStudentUnitRecord studentUnitRecord) {
    for (Element element : loadStudentUnitRecordElementsFromFile()) {

      if (isMatch(element, studentUnitRecord.getStudentId(),
          studentUnitRecord.getUnitCode())) {

        element.setAttribute(ASSIGNMENT1_ATTRIBUTE,
            new Float(studentUnitRecord.getAssignment1Result()).toString());
        element.setAttribute(ASSIGNMENT2_ATTRIBUTE,
            new Float(studentUnitRecord.getAssignment2Result()).toString());
        element.setAttribute(EXAM_ATTRIBUTE,
            new Float(studentUnitRecord.getExamResult()).toString());

        // write out the XML file
        XmlManager.getInstance().saveDocument();

        // for continuous save
        return;
      }
    }

    throw new RuntimeException(
        "DBMD: saveRecord : no such student record in data");
  }
}
