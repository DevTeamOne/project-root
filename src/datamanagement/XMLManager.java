package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

public class XMLManager {
	private static XMLManager self = null;
	private Document document;

	public static XMLManager getXML() {
		if (self == null)
			self = new XMLManager();
		return self;
	}

	private XMLManager() {
		init();
	}

	public void init() {
		String fileName = AppProperties.getInstance().getProperties()
				.getProperty("XMLFILE");
		try {
			SAXBuilder builder = new SAXBuilder();
			builder.setExpandEntities(true);
			document = builder.build(fileName);
		}

		catch (JDOMException exception) {
			System.err.printf("%s",
					"DBMD: XMLManager : init : caught JDOMException\n");
			throw new RuntimeException(
					"DBMD: XMLManager : init : JDOMException");
		} catch (IOException e) {
			System.err.printf("%s",
					"DBMD: XMLManager : init : caught IOException\n");

			throw new RuntimeException("DBMD: XMLManager : init : IOException");
		}
	}

	public Document getDocument() {
		return document;
	}

	public void saveDocument() {
		String xmlFile = AppProperties.getInstance().getProperties()
				.getProperty("XMLFILE");
		try (FileWriter outputFile = new FileWriter(xmlFile)) {
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(document, outputFile);
			outputFile.close();
		} catch (IOException ioException) {
			System.err.printf("%s\n",
					"DBMD : XMLManager : saveDocument : Error saving XML to "
							+ xmlFile);
			throw new RuntimeException(
					"DBMD: XMLManager : saveDocument : error writing to file");
		}
	}
}
