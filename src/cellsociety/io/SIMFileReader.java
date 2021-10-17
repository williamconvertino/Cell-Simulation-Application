package cellsociety.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SIMFileReader {

  public static HashMap<String,String> getMetadataFromFile(String file) throws IOException {

    HashMap metadata = new HashMap();

    Properties prop = readPropertiesFile(file);
    for (final String name : prop.stringPropertyNames()) {
      metadata.put(name, prop.getProperty(name));
    }

    return metadata;
  }

  /**
   * reads in a Sim file as a properties file since they follow the same structure
   *
   * @param fileName the string of the Sim file to be used
   * @return a Properties class containing the data held in the Sim file
   */
  public static Properties readPropertiesFile(String fileName) throws IOException {
    FileInputStream fis;
    Properties prop = null;
    try {
      fis = new FileInputStream(fileName);
      prop = new Properties();
      prop.load(fis);
      fis.close();
    } catch(IOException ioe) {
      throw new IOException();
    }
    return prop;
  }

}
