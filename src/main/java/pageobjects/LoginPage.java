package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;



public class LoginPage extends BasePage {
    @FindBy(xpath = "")
    private WebElement loginLocator;
    @FindBy(xpath = "//*")
    private WebElement emailLocator;
    @FindBy(xpath = "")
    private WebElement passwordLocator;
    @FindBy(xpath = "//*")
    private WebElement submitLocator;
    @FindBy(id  = "email")
    private WebElement profileMailLocator;



    public LoginPage() {
        visit(getUrl());
    }

    public String getUrl(){
        return BASE_URL;
    }

    public void openLoginPopup(){
        click(loginLocator);
    }

    public boolean isPopupDisplayed(){
        try {
            WaitHelper.getWait().waitForElementToBeClickable(emailLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void loginWith(String email, String password) {
        type(emailLocator, email);
        type(passwordLocator, password);
        click(submitLocator);
    }

    public boolean isProfileDisplayed(){
        try {
            WaitHelper.getWait().waitForElementToBeVisible(profileMailLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getProfileMail(){
        return profileMailLocator.getAttribute("value");
    }
}
