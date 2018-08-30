import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginWithValidMobileTest extends BaseTest {
    private RegisterPage registerPage;
    private TestUtils testUtils;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
        testUtils = new TestUtils();
    }

    @Test
    public void loginWithValidMobile() {
        registerPage.validMobile(testUtils.randomMobile(7));
        registerPage.submitMobile();

        Assert.assertTrue(registerPage.isCodeSubmitDisplayed(), "Code Submit is not displayed!");
    }
}
