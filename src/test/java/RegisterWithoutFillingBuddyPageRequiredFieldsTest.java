import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.RegisterPage;

public class RegisterWithoutFillingBuddyPageRequiredFieldsTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithoutFillingBuddyRequiredFields() {
        String email = TestUtils.randomEmail();

        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

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

        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isCategoryErrorDisplayed();
        registerPage.isWhatForErrorDisplayed();
        registerPage.isPriceErrorDisplayed();



        Assert.assertEquals(registerPage.getCategoryErrorText(), "Du måste välja en kategori");
        Assert.assertEquals(registerPage.getWhatForErrorText(), "Beskriv kortfattat vad du behöver hjälp med");
        Assert.assertEquals(registerPage.getPriceErrorpText(), "Välj pris alternativ med eller utan RUT");
    }




}
