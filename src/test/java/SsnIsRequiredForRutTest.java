import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class SsnIsRequiredForRutTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void ssnIsRequieredForRut() {
        registerPage.validMobile(TestUtils.DEFAULT_MOBILE);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        registerPage.isBuddyListDisplayed();
        registerPage.openRequestPage();

        registerPage.isCategoryDisplayed();
        registerPage.selectRUT();
        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isSsnErrorDisplayed();


        Assert.assertEquals(registerPage.getSsnErrorText(), "Du måste ange ett personnummer för att utnyttja RUT-avdraget");
    }

}
