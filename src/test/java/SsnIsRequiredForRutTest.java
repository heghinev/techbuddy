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
        //Mobile and Code forms
        registerPage.validMobile(TestUtils.DEFAULT_MOBILE);
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        //Buddy Request list
        registerPage.isBuddyListDisplayed();
        registerPage.openRequestPage();

        //Mobile and Code form
        registerPage.isCategoryDisplayed();
        registerPage.selectRUT();
        registerPage.isTermsDisplayed();
        registerPage.checkTerms();
        registerPage.submitRequest();

        registerPage.isSsnErrorDisplayed();


        Assert.assertEquals(registerPage.getSsnErrorText(), "Du måste ange ett personnummer för att utnyttja RUT-avdraget");
    }

}
