package core;

import org.junit.After;
import org.junit.Before;

public class hooks {

@Before
    public void initialsetup() {

    System.out.println("Is my line executing????????? ------------ ");
    if (System.getProperty("env").equals("qa")) {
        System.out.println(System.getProperty("base.url"));
    }
}
}
