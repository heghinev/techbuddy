import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithoutEmailAddressIfMissingCheckedTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithoutEmailAddressIfMissingChecked() {
        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        registerPage.isEmailDisplayed();
        registerPage.scrollToAddressSubmit();
        registerPage.typeAddress(TestUtils.DEFAULT_ADDRESS);
        registerPage.isPostCodeDisplayed();
        registerPage.clickPostCode();
        registerPage.isMapDisplayed();
        registerPage.clickMap();
        registerPage.isAddressSubmitDisplayed();
        registerPage.submitAddress();

        registerPage.isMissingEmailCheckboxDisplayed();
        registerPage.checkMissingEmail();
        registerPage.submitAddress();
        registerPage.isCategoryDisplayed();

        Assert.assertTrue(registerPage.isCategoryDisplayed(), "Category field is not displayed!");
    }
}
