import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginWithValidMobileCodeTest extends BaseTest {
    private RegisterPage registerPage;
    private TestUtils testUtils;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
        testUtils = new TestUtils();
    }

    @Test
    public void loginWithValidMobileCode() {
        registerPage.validMobile(testUtils.randomMobile(7));
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(testUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        Assert.assertTrue(registerPage.isAddressSubmitDisplayed(), "Address Submit button is not displayed!");
    }
}
