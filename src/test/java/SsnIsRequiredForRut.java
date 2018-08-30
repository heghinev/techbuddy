import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;
import java.io.IOException;

import static api.HttpClient.login;
import static org.apache.http.client.methods.RequestBuilder.get;
import static org.apache.http.client.methods.RequestBuilder.post;


public class SsnIsRequiredForRut extends BaseTest {
    private RegisterPage registerPage;


    @BeforeMethod
    public void setUp() throws IOException {
        login("46701231231", "100100");
        get();
        registerPage = new RegisterPage();
    }

    @Test
    public void registerWithInvalidCode() {
        /*registerPage.openRequestPage();
        registerPage.checkTerms();
        registerPage.selectRUT();
        registerPage.submitRequest();
        registerPage.isSsnErrorDisplayed();*/

        Assert.assertEquals(registerPage.getSsnErrorText(), "Du måste ange ett personnummer för att utnyttja RUT-avdraget");
    }
}
