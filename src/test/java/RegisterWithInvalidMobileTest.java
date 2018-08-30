import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithInvalidMobileTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithInvalidMobile() {
        registerPage.invalidMobileText(TestUtils.randomText());
        registerPage.submitMobile();
        registerPage.isMobileErrorDisplayed();

        Assert.assertEquals(registerPage.getMobileErrorText(), "Telefonnumret du angivit är inte korrekt");
    }
}
