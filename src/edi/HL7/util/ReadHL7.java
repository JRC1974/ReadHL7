package edi.HL7.util;

import edi.Quadax.util.ProcessProperties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import static java.util.logging.Level.ALL;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

/**
 * Created by JasonCrane on 8/14/2017.
 * Project ReadHL7
 */
public class ReadHL7 {
  private final static Logger logger = Logger.getLogger(ReadHL7.class.getName());

  public static void main(String[] args) throws IOException {
    loggerSetup();
    String propertyFile = args[0];
    Properties props = new Properties();

    ProcessProperties newProps = new ProcessProperties();
    try {
      newProps.loadProps(props,propertyFile);
      logger.log(INFO,props.getProperty("displayName"));

    } catch (IOException e) {
      System.out.println("Exception <" + e.getClass().getSimpleName() + "> " +e.getMessage());
      String errorMessage = "Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage();
      logger.log(SEVERE, errorMessage);
    }
  }
  private static void loggerSetup() throws IOException {
    Handler handler = new FileHandler("ReadHL7Logger.log",2000,5);
    handler.setLevel(ALL);
    handler.setFormatter(new XMLFormatter());
    //handler.setFormatter(new SimpleFormatter());
    logger.setUseParentHandlers(false); //Doesn't print to console
    logger.addHandler(handler);
    logger.setLevel(ALL);
  }
}
