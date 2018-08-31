import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void login() {
        //basic login with already existing user
        registerPage.validMobile(TestUtils.DEFAULT_MOBILE);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        Assert.assertTrue(registerPage.isBuddyListDisplayed(), "Buddy List is not displayed!");
    }
}
