package util;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader bufferedReader = null;
        String propertyFilePath = "src/test/resources/configs/config.properties";
        try{
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(bufferedReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try { if(bufferedReader != null) bufferedReader.close(); }
            catch (IOException ignore) {}
        }
    }


    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getTestDataResourcePath(){
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getErrorMessagesResourcePath() {
        String errorMessagesResourcePath = properties.getProperty("errorMessagesResourcePath");
        if(errorMessagesResourcePath!= null) return errorMessagesResourcePath;
        else throw new RuntimeException("Error Messages Resource Path not specified in the Configuration.properties file for the Key:errorMessagesResourcePath");
    }
}
