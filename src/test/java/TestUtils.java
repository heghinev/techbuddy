import pageobjects.RegisterPage;

import java.util.UUID;

public class TestUtils {
    public static final String DEFAULT_PASSWORD = "blabla123";

    public static void fillUserData(RegisterPage registerPage, String email){
        registerPage.registerWith("TestName", "TestSurname", email, DEFAULT_PASSWORD);
    }

    public static String randomEmail(){
        return UUID.randomUUID().toString() + "@test.com";
    }

}
