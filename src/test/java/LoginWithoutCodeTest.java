import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginWithoutCodeTest extends BaseTest {
    private RegisterPage registerPage;
    private TestUtils testUtils;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
        testUtils = new TestUtils();
    }

    @Test
    public void loginWithoutCode() {
        registerPage.validMobile(testUtils.randomMobile(7));
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.submitCode();

        Assert.assertTrue(registerPage.isCodeErrorDisplayed(), "Code error pop up is not displayed!");
    }
}
