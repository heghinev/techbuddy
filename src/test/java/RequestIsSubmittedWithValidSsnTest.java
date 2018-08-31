import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RequestIsSubmittedWithValidSsnTest extends BaseTest {
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
        registerPage.typeSsn(TestUtils.DEFAULT_SSN);
        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isRegisterSuccessDisplayed();


        Assert.assertEquals(registerPage.getRegisterSuccessText(), "En TechBuddy kommer kontakta dig för att boka dag och tid för besöket");
    }

}
