package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.JDOMException;

import java.io.FileWriter;

import java.io.IOException;


public class XMLManager {
  private static XMLManager self_ = new XMLManager();
  private Document document_;
  

  public XMLManager() {
    initialize();
  }
    

  static XMLManager getXML() {
    return self_;
  }
  
    
  public void initialize() {
    String fileName = ApplicationProperties.getInstance().getProperties()
        .getProperty("XMLFILE");
    
    try {
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities(true);
      document_ = builder.build(fileName);
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

  
  public Document getDocument() {
    return document_;
  }
  
  
  public void saveDocument() {
    String xmlFile = ApplicationProperties.getInstance().getProperties()
        .getProperty("XMLFILE");
    
    try (FileWriter outputFile = new FileWriter(xmlFile)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document_, outputFile);
      outputFile.close();
    } catch (IOException ioException) {
      System.err.printf("%s\n",
          "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlFile);
      throw new RuntimeException(
          "DBMD: XMLManager : saveDocument : error writing to file");
    }
  }
}
