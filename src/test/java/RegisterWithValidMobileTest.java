import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithValidMobileTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithValidMobile() {
        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();

        Assert.assertTrue(registerPage.isCodeSubmitDisplayed(), "Code Submit is not displayed!");
    }
}
