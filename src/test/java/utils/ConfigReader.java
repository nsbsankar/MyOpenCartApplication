package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {
    public static Properties intializeProperties() {

        Properties prop = new Properties();
        String filepath = System.getProperty("user.dir") + "/src/test/resources/config/config1.properties";
        File file = new File(filepath);

        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return prop;
    }
}
