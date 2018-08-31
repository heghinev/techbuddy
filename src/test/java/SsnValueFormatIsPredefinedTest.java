import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class SsnValueFormatIsPredefinedTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void ssnValueFormatIsPredefined() {
        String text = TestUtils.randomText();
        //Mobile and Code forms
        registerPage.validMobile(TestUtils.DEFAULT_MOBILE);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        //Buddy Request list
        registerPage.isBuddyListDisplayed();
        registerPage.openRequestPage();

        //Buddy Request form
        registerPage.isCategoryDisplayed();
        registerPage.clickCategory();
        registerPage.typeWhatFor(text);
        registerPage.selectRUT();
        registerPage.typeSsn(text);
        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isWrongSsnErrorDisplayed();


        Assert.assertEquals(registerPage.getWrongSsnErrorText(), "Du har angivit ett felaktigt personnummer");
    }

}
