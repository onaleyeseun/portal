package psb.paymentgateway.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {

    private Properties pro; // For config.properties
    private Properties testDataPro; // For testData.properties

    public configDataProvider() {
        pro = loadPropertiesFile("./Configuration/config.properties");
        testDataPro = loadPropertiesFile("./Configuration/testData.properties");
    }

    private Properties loadPropertiesFile(String filePath) {
        Properties properties = new Properties();
        try {
            File src = new File(filePath);
            FileInputStream fis = new FileInputStream(src);
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load properties file: " + e.getMessage());
        }
        return properties;
    }

    public String getConfigProperty(String key) {

        return pro.getProperty(key);
    }

    public String getTestDataProperty(String key) {
        return testDataPro.getProperty(key);
    }


    public String getBrowser() {
        // TODO Auto-generated method stub
        return pro.getProperty("browser");
    }

    // Method to get property values


    public String getStagingUrl() {
        // TODO Auto-generated method stub
        return pro.getProperty("testurl");
    }



}
