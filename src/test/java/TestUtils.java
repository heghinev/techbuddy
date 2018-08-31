import net.bytebuddy.utility.RandomString;
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
    public static final String DEFAULT_MOBILE = "46701231231";
    public static final String DEFAULT_ADDRESS = "Stjärntorget";
    public static final String DEFAULT_SSN = "19890703-1234";


    public static String randomEmail(){
        return UUID.randomUUID().toString() + "@test.com";
    }

}
