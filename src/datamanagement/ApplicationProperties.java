package datamanagement;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

public class ApplicationProperties {
  private static ApplicationProperties self_ = new ApplicationProperties();
  private Properties properties_;
  
  
  private ApplicationProperties() {
    properties_ = new Properties();
    try {
      properties_.load(new FileInputStream("Properties.prop"));
    } catch (IOException ioException) {
      throw new RuntimeException("Could not read property file");
    }
  }
  
  
  public static ApplicationProperties getInstance() {
    return self_;
  }

  
  public Properties getProperties() {
    return properties_;
  }
}
