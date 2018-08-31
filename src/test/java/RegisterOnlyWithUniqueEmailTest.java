import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.RegisterPage;

public class RegisterOnlyWithUniqueEmailTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithOnlyUniqueEmailAddress() {
        String email = TestUtils.randomEmail();
        doLogin(email);

        registerPage.visit(BasePage.BASE_URL);
        doLogin(email);

        registerPage.isEmailErrorPopUpDisplayed();

        Assert.assertEquals(registerPage.getEmailErrorPopUpText(), "Kunden existerar redan");
    }


    //register a new user, than try to register another with the same Email
    private void doLogin(String email) {
        //Mobile and Code form
        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();


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
    }
}
