package au.demo.utilities;

import java.io.*;
import java.util.Properties;

public class TestSettings {
    public static Properties constantsProp = new Properties();
    public static TestSettings _instance;

    public static TestSettings getInstance() {
        if (_instance == null) {
            _instance = new TestSettings();
        }
        return _instance;
    }

    public void loadConstantsProperties() {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("au/demo/properties/constants.properties");
            if (in != null) {
                constantsProp.load(in);
            }
            System.out.println(constantsProp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestSettings() {
        loadConstantsProperties();
        System.out.println("LOADED CONSTANTS PROPERTIES");
    }

    public Properties getConstantsProp() {
        return constantsProp;
    }

    public static void main(String[] args) throws IOException {
        TestSettings ts = TestSettings.getInstance();
    }
}
