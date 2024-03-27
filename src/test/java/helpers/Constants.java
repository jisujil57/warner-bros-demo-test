package helpers;

import org.apache.xmlbeans.SystemProperties;

public class Constants {
    public final static String BROWSER_NAME = SystemProperties.getProperty("browser", "chrome");

}
