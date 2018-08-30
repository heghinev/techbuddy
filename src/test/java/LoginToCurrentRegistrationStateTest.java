import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.RegisterPage;

public class LoginToCurrentRegistrationStateTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void loginWithValidMobileCode() {
        String login = TestUtils.randomMobile();
        doBasicLogin(login);

        Assert.assertTrue(registerPage.isAddressSubmitDisplayed(), "Address Submit button is not displayed!");

        registerPage.visit(BasePage.BASE_URL);
        doBasicLogin(login);

        Assert.assertTrue(registerPage.isAddressSubmitDisplayed(), "Address Submit button is not displayed!");
    }

    private void doBasicLogin(String login) {
        registerPage.validMobile(login);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();
    }
}
