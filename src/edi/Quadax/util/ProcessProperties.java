package edi.Quadax.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by JasonCrane on 8/14/2017.
 * Project ReadHL7
 */
public class ProcessProperties {
  public Properties loadProps(Properties processProps, String inputFile) throws IOException {
    Path propertyXMLFile = Paths.get(inputFile);
    if(Files.exists(propertyXMLFile)) {
      try(InputStream inputStream = Files.newInputStream(propertyXMLFile)) {
        processProps.loadFromXML(inputStream);
      }
    }
    return processProps;
  }
}
