import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class LoginWithInvalidMobileTest extends BaseTest {
    private RegisterPage registerPage;
    private TestUtils testUtils;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
        testUtils = new TestUtils();
    }

    @Test
    public void loginWithInvalidMobile() {
        registerPage.invalidMobileText(testUtils.randomText());
        registerPage.submitMobile();
        registerPage.isMobileErrorDisplayed();

        Assert.assertEquals(registerPage.getMobileErrorText(), "Telefonnumret du angivit är inte korrekt");
    }
}
