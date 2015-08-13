package datamanagement;

import java.util.List;

import org.jdom.Element;

public class StudentUnitRecordAdapter {
  private static final String ASSIGNMENT1_ATTRIBUTE = "asg1";
  private static final String ASSIGNMENT2_ATTRIBUTE = "asg2";
  private static final String EXAM_ATTRIBUTE = "exam";
  private static final String SID_ATTRIBUTE = "sid";
  private static final String UID_ATTRIBUTE = "uid";
  private static final String STUDENT_UNIT_RECORD_NODE = "studentUnitRecordTable";
  private static final String RECORD_NODE = "studentUnitRecordTable";

  private static StudentUnitRecordAdapter studentUnitRecordManager_ = null;
  private StudentUnitRecordMap studentRecordMap_;
  private java.util.HashMap<String, StudentUnitRecordList> studentUnitRecordsByName;
  private java.util.HashMap<Integer, StudentUnitRecordList> studentUnitRecordsById;

  public static StudentUnitRecordAdapter instance() {
    if (studentUnitRecordManager_ == null)
      studentUnitRecordManager_ = new StudentUnitRecordAdapter();
    return studentUnitRecordManager_;
  }

  private StudentUnitRecordAdapter() {
    studentRecordMap_ = new StudentUnitRecordMap();
    studentUnitRecordsByName = new java.util.HashMap<>();
    studentUnitRecordsById = new java.util.HashMap<>();
  }

  /**
   * Retrieve a student unit record, based on a key of both student id and unit code.
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
      if (recordMatch(element, studentId, unitCodeId)) {
        
        studentUnitRecord = mapStudentUnitRecordFromElement(element);
        studentRecordMap_.put(buildCompositeKey(studentUnitRecord), studentUnitRecord);
        
        return studentUnitRecord;
      }
    }
    throw new RuntimeException(
        "DBMD: createStudent : student unit record not in file");
  }
  
  /**
   * Returns a composite key built from the Student Id and Unit Code.
   * This can be used to uniquely identify a record.
   * @param studentUnitRecord: The record from which to construct a
   *  composite key.
   * @return : String - The composite key.
   */
  private String buildCompositeKey (IStudentUnitRecord studentUnitRecord) {
      return studentUnitRecord.getStudentID().toString()
          + studentUnitRecord.getUnitCode();
  }

  /**
   * Loads the student unit record element from the XML file.
   * @return: List of XML Elements.
   */
  private List<Element> loadStudentUnitRecordElementsFromFile() {
    return (List<Element>) XMLManager
        .getXML()
        .getDocument()
        .getRootElement()
        .getChild(STUDENT_UNIT_RECORD_NODE)
        .getChildren(RECORD_NODE);
  }

  /**
   * Checks if the given element matches the Student ID and Unit Code
   * @param element: The element under test.
   * @param studentId: The student ID to compare.
   * @param unitCodeId: The Unit Code to compare.
   * @return: Boolean, True if the element matches the given code.
   */
  private boolean recordMatch(Element element, Integer studentId,
      String unitCodeId) {
    return unitCodeId.equals(getAttributeAsString(element, UID_ATTRIBUTE))
        && studentId.equals(getAttributeAsInteger(element, SID_ATTRIBUTE));
  }

  private Float getAttributeAsFloat(Element element, String attributeName) {
    return new Float(element.getAttributeValue(attributeName));
  }

  private Integer getAttributeAsInteger(Element element, String attributeName) {
    return new Integer(element.getAttributeValue(attributeName));
  }

  private String getAttributeAsString(Element element, String attributeName) {
    return new String(element.getAttributeValue(attributeName));
  }

  /**
   * Hydrates a student record element node from the CML document to a
   * StudentUnitRecord
   * 
   * @param element
   *          : Student recode element node
   * @return StudentUnitRecord: record mapped from an element.
   */
  private StudentUnitRecord mapStudentUnitRecordFromElement(Element element) {
    return new StudentUnitRecord(getAttributeAsInteger(element, SID_ATTRIBUTE),
        getAttributeAsString(element, UID_ATTRIBUTE), getAttributeAsFloat(
            element, ASSIGNMENT1_ATTRIBUTE), getAttributeAsFloat(element,
            ASSIGNMENT2_ATTRIBUTE),
        getAttributeAsFloat(element, EXAM_ATTRIBUTE));
  }

  /**
   * Retrieves a list of StudentUnitRecords ith the given unit code.
   * 
   * @param unitCode
   *          : The unit code for the student records to find.
   * @return: StudentRecordList - List of records for students enrolled the
   *          given unit code.
   */
  public StudentUnitRecordList getRecordsByUnit(String unitCode) {

    // Return any existing student records having the given unit code.
    StudentUnitRecordList studentUnitRecords = studentUnitRecordsByName
        .get(unitCode);
    if (studentUnitRecords != null)
      return studentUnitRecords;

    studentUnitRecords = new StudentUnitRecordList();

    // Iterate through all of the student records from the XML file.
    List<Element> studentUnitElements = loadStudentUnitRecordElementsFromFile();
    for (Element element : studentUnitElements) {

      String unitCodeId = getAttributeAsString(element, UID_ATTRIBUTE);
      Integer studentId = getAttributeAsInteger(element, SID_ATTRIBUTE);

      // Add proxy records for students having a matching unit code.
      if (unitCode.equals(unitCodeId)) {
        StudentUnitRecordProxy studentUnitRecordProxy = new StudentUnitRecordProxy(
            studentId, unitCodeId);
        studentUnitRecords.add(studentUnitRecordProxy);
      }
    }

    // Add the list of proxy objects to the studentUnitRecordsByName hashmap.
    if (studentUnitRecords.size() > 0)
      studentUnitRecordsByName.put(unitCode, studentUnitRecords); // be careful
                                                                  // - this
                                                                  // could be
                                                                  // empty
    return studentUnitRecords;
  }

  /**
   * Retrieves a list of StudentRecords by Student Id.
   * 
   * @param studentID
   *          : The student Id indicating records to be returned.
   * @return: StudentUnitRecords list of records for the given student Id.
   */
  public StudentUnitRecordList getRecordsByStudent(Integer student) {

    // Return any existing studentUnitRecords for the given student ID.
    StudentUnitRecordList studentUnitRecords = studentUnitRecordsById
        .get(student);
    if (studentUnitRecords != null)
      return studentUnitRecords;

    studentUnitRecords = new StudentUnitRecordList();

    // Otherwise iterate through all of the student records from the XML file.
    for (Element element : loadStudentUnitRecordElementsFromFile()) {

      String unitCodeId = getAttributeAsString(element, UID_ATTRIBUTE);
      Integer studentId = getAttributeAsInteger(element, SID_ATTRIBUTE);

      if (student.toString().equals(studentId)) {

        StudentUnitRecordProxy studentUnitRecordProxy = new StudentUnitRecordProxy(
            studentId, unitCodeId);
        studentUnitRecords.add(studentUnitRecordProxy);
      }
    }

    // Add the list of proxy objects to the studentUnitRecordsById hashmap.
    if (studentUnitRecords.size() > 0)
      studentUnitRecordsById.put(student, studentUnitRecords); // be careful -
                                                               // this could be
                                                               // empty
    return studentUnitRecords;
  }

  /**
   * Save a record to the XML file.
   * 
   * @param studentUnitRecord
   *          : Record to be saved.
   */
  public void saveRecord(IStudentUnitRecord studentUnitRecord) {
    for (Element element : loadStudentUnitRecordElementsFromFile()) {

      if (recordMatch(element, studentUnitRecord.getStudentID(),
          studentUnitRecord.getUnitCode())) {

        element.setAttribute(ASSIGNMENT1_ATTRIBUTE,
            new Float(studentUnitRecord.getAssignment1Result()).toString());
        element.setAttribute(ASSIGNMENT2_ATTRIBUTE,
            new Float(studentUnitRecord.getAssignment2Result()).toString());
        element.setAttribute(EXAM_ATTRIBUTE,
            new Float(studentUnitRecord.getExamResult()).toString());

        // write out the XML file
        XMLManager.getXML().saveDocument();

        // for continuous save
        return;
      }
    }

    throw new RuntimeException(
        "DBMD: saveRecord : no such student record in data");
  }
}
