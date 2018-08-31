import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithFillingBuddyPageRequiredFieldsTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithoutFillingBuddyRequiredFields() {
        String email = TestUtils.randomEmail();
        String text = TestUtils.randomText();

        //Mobile and Code forms
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

        //Buddy Request form
        registerPage.isCategoryDisplayed();
        registerPage.clickCategory();
        registerPage.typeWhatFor(text);
        registerPage.selectPrice();
        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isRegisterSuccessDisplayed();


        Assert.assertEquals(registerPage.getRegisterSuccessText(), "En TechBuddy kommer kontakta dig för att boka dag och tid för besöket");
    }

}
