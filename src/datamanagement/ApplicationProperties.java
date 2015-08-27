package datamanagement;
 
import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Concrete class for the application properties.
 */
public class ApplicationProperties {
  private static ApplicationProperties self_ = new ApplicationProperties();
  private Properties properties;
  
  

  private ApplicationProperties() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("Properties.prop"));
    } catch (IOException ioException) {
      throw new RuntimeException("Could not read property file");
    }
  }
  
  

  /**
   * Returns the single instance of the application
   * properties object.
   * 
   * @return The instance of the application properties
   * object.
   */
  public static ApplicationProperties getInstance() {
    return self_;
  }

  
  
  /**
   * The application properties collection.
   * 
   * @return the application properties collection.
   */
  public Properties getProperties() {
    return properties;
  }
}
