import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp(){
        registerPage = new RegisterPage();
    }

    @Test
    public void register(){
        registerPage.openRegisterPopup();

        TestUtils.fillUserData(registerPage, TestUtils.randomEmail());

        Assert.assertTrue(registerPage.isCheckmailDisplayed(), "Registration was not succeed!");
    }

}
