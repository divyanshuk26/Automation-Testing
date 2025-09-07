package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void loadConfig() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found at src/test/resources/", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

