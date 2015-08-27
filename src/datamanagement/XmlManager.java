package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.JDOMException;

import java.io.FileWriter;

import java.io.IOException;
 


/**
 * XMLManager is a singleton class for managing an xml data store.
 */
public class XmlManager {
  private static XmlManager self_ = new XmlManager();
  private Document document;
  

  
  private XmlManager() {
    initialize();
  }

  
  
  /**
   * Retrieves the singleton instance of the xmlManager.
   * 
   * @return The singleton instance of the xmlManager
   */
  static XmlManager getInstance() {
    return self_;
  }
  
  
  
  /**
   * Initializes the XmlManager by loading the 
   * xml File identified by the XMLFILE application
   * property.
   */
  public void initialize() {
    String fileName = ApplicationProperties.
        getInstance().
        getProperties().
        getProperty("XMLFILE");
    
    try {
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities(true);
      document = builder.build(fileName);
    }

    catch (JDOMException exception) {
      System.err.printf("%s",
          "DBMD: XMLManager : initialize : caught JDOMException\n");
      throw new RuntimeException(
          "DBMD: XMLManager : initialize : JDOMException");
    } catch (IOException e) {
      System.err.printf("%s",
          "DBMD: XMLManager : initialize : caught IOException\n");

      throw new RuntimeException("DBMD: XMLManager : init : IOException");
    }
  }

  
  
  /**
   * Retrieves the xml document root.
   * 
   * @return Document: The xml document root.
   */
  public Document getDocument() {
    return document;
  }
  
  
  
  /**
   * Save the Xml Document to disk, as identified
   * by the XMLFILE application property.
   */
  public void saveDocument() {
    String xmlFile = ApplicationProperties.
        getInstance().
        getProperties().
        getProperty("XMLFILE");
    
    try (FileWriter outputFile = new FileWriter(xmlFile)) {
      
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document, outputFile);
      
    } catch (IOException ioException) {
      System.err.printf("%s\n",
          "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlFile);
      throw new RuntimeException(
          "DBMD: XMLManager : saveDocument : error writing to file");
    }
  }
}