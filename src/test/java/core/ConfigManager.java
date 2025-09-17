package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    public static Properties FrameworkProperties() {

    Properties properties = new Properties();

            try(
    InputStream input = new FileInputStream("src/test/resources/properties/qa.properties"))

    {
        properties.load(input);
    } catch(
    IOException e)

    {
        throw new RuntimeException(e);
    }
            return properties;
}
}
