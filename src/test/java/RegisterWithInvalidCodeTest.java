import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithInvalidCodeTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithInvalidCode() {
        //Mobile and Code forms
        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.invalidCodeText(TestUtils.randomText());
        registerPage.submitCode();
        registerPage.isCodeErrorMessageDisplayed();

        Assert.assertEquals(registerPage.getCodeErrorText(), "Koden du angivit är inte korrekt");
    }
}
