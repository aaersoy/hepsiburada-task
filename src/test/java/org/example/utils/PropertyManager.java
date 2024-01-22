package org.example.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;

    private String baseUrl;
    private String defaultTimeout;
    private String browser;

    public static PropertyManager getInstance() {
        if(instance == null) {
            instance = new PropertyManager();
            instance.loadProperties();
        }
        return instance;
    }

    private void loadProperties() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("env/default/default.properties"));
        }catch (Exception e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }

        this.baseUrl = properties.getProperty("baseUrl");
        this.defaultTimeout = properties.getProperty("defaultTimeout");
        this.browser = properties.getProperty("browser");
    }

    public String getBaseUrl() {
         return baseUrl;
    }

    public String getDefaultTimeout() {
        return defaultTimeout;
    }

    public String getBrowser() {
        return browser;
    }
}
