import net.bytebuddy.utility.RandomString;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {

    public static String randomText(){
        return RandomString.make(11);
    }

    public static String randomMobile(){
        return "4670" + String.valueOf(ThreadLocalRandom.current().nextInt(1000000,9999999));
    }

    public static final String DEFAULT_PASSWORD = "100100";
    public static final String DEFAULT_LOGIN = "46701231231";

   /* public static void fillUserData(RegisterPage registerPage, String email){
        registerPage.registerWith("TestName", "TestSurname", email, DEFAULT_PASSWORD);
    }*/

    public static String randomEmail(){
        return UUID.randomUUID().toString() + "@test.com";
    }

}
