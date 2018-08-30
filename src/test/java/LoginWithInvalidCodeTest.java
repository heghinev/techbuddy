import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginWithInvalidCodeTest extends BaseTest {
    private RegisterPage registerPage;
    private TestUtils testUtils;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
        testUtils = new TestUtils();
    }

    @Test
    public void loginWithInvalidCode() {
        registerPage.validMobile(testUtils.randomMobile(7));
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.invalidCodeText(testUtils.randomText());
        registerPage.submitCode();
        registerPage.isCodeErrorMessageDisplayed();

        Assert.assertEquals(registerPage.getCodeErrorText(), "Koden du angivit är inte korrekt");
    }
}
