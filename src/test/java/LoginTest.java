import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;


public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void login() {
        loginPage.openLoginPopup();
        loginPage.isPopupDisplayed();
        loginPage.loginWith("jammusara-3705@yopmail.com", "blabla123");
        loginPage.isProfileDisplayed();

        Assert.assertEquals(loginPage.getProfileMail(), "jammusara-3705@yopmail.com");
    }

}
