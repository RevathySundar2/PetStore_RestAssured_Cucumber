package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    public static Properties FrameworkProperties() {

    Properties properties = new Properties();

            
                String environment = System.getProperty("env");
                String propsPath = "src/test/resources/properties/" + environment + ".properties";

                System.out.println("Is my line executing????????? ------------ ");
    if (System.getProperty("env").equals("qa")) {
        System.out.println(System.getProperty("env") + " this is QA environment???????????");
        System.out.println(System.getProperty("base.url") + " QA base url ???????????");
    }

    else if (System.getProperty("env").equals("prod")) {
        System.out.println("Now have to setup prod url here");

    }
                try(
    InputStream input = new FileInputStream(propsPath))

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
