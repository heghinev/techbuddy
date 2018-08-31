import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterWithoutEmailAddressTest extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithoutEmailAddress() {
        //Mobile and Code forms
        registerPage.validMobile(TestUtils.randomMobile());
        registerPage.submitMobile();
        registerPage.isCodeSubmitDisplayed();
        registerPage.validCodeText(TestUtils.DEFAULT_PASSWORD);
        registerPage.submitCode();

        //Customer info form
        registerPage.isEmailDisplayed();
        registerPage.scrollToAddressSubmit();
        registerPage.isAddressSubmitDisplayed();
        registerPage.submitAddress();
        registerPage.isAddressErrorDisplayed();

        Assert.assertEquals(registerPage.getAddressErrorText(), "Vi kunde inte hitta adressen på kartan, använd kartan nedan för att peka ut din address");
    }
}
