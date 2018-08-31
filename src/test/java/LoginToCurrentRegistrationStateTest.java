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
        String email = TestUtils.randomEmail();
        doBasicLogin(login);

        //Customer info form
        registerPage.isEmailDisplayed();
        registerPage.typeEmail(email);
        registerPage.typeAddress(TestUtils.DEFAULT_ADDRESS);
        registerPage.isPostCodeDisplayed();
        registerPage.clickPostCode();

        registerPage.isEmailDisplayed();
        registerPage.scrollToAddressSubmit();
        registerPage.isMapDisplayed();
        registerPage.clickMap();

        registerPage.isAddressSubmitDisplayed();
        registerPage.submitAddress();

        Assert.assertTrue(registerPage.isCategoryDisplayed(), "Category field is not displayed!");

        //verify that after page reload and login the previous state page will be opened
        registerPage.visit(BasePage.BASE_URL);
        doBasicLogin(login);

        Assert.assertTrue(registerPage.isCategoryDisplayed(), "Category field is not displayed!");
    }

    private void doBasicLogin(String login) {
        registerPage.validMobile(login);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();
    }
}
