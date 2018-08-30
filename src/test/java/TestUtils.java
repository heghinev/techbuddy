import net.bytebuddy.utility.RandomString;
import java.security.SecureRandom;
import java.util.UUID;

public class TestUtils {

    public static String randomText(){
        return RandomString.make(11);
    }

    public static String randomMobile(int length){
        String numbers = "0123456789";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i <length; i++ )
        sb.append(numbers.charAt(rnd.nextInt(numbers.length())));

        String randomMobile = sb.toString();
        String validMobile = "4670" + randomMobile;
        return validMobile;
    }


    public static final String DEFAULT_PASSWORD = "100100";

   /* public static void fillUserData(RegisterPage registerPage, String email){
        registerPage.registerWith("TestName", "TestSurname", email, DEFAULT_PASSWORD);
    }*/

    public static String randomEmail(){
        return UUID.randomUUID().toString() + "@test.com";
    }

}
