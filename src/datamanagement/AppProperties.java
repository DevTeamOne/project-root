package datamanagement;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AppProperties {
  private static AppProperties self = new AppProperties();
  private Properties properties;

  
  public static AppProperties getInstance() {
    return self;
  }

  
  private AppProperties() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("Properties.prop"));
    } catch (IOException exception) {
      throw new RuntimeException("Could not read property file");
    }
  }

  
  public Properties getProperties() {
    return properties;
  }
}
