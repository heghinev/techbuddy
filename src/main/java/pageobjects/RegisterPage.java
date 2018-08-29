package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[2]/div/div/input")
    private WebElement mobileLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[3]/div/button/span")
    private WebElement mobileSubmitLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[1]/div/input")
    private WebElement codeLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[2]/div/button/span")
    private WebElement codeSubmitLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[1]/div/div[1]/div/input")
    private WebElement firstNameLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[1]/div/div[2]/div/input")
    private WebElement lastNameLocator;
    @FindBy(id = "street-name")
    private WebElement addressLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[4]/input")
    private WebElement addressSubmitLocator;


    public RegisterPage(){
        visit(getUrl());
    }

    public String getUrl(){
        return BASE_URL;
    }

    public void openRegisterPopup(){
        click(registerLocator);
    }

    public void registerWith(String fName, String lName, String email, String password){
        WaitHelper.getWait().waitForElementToBeClickable(firstNameLocator);
        type(firstNameLocator, fName);
        type(lastNameLocator, lName);
        type(emailLocator, email);
        type(passwordLocator, password);
        click(checkboxLocator);
        click(submitLocator);
    }

    public boolean isCheckmailDisplayed(){
        try {
            WaitHelper.getWait().waitForElementToBeClickable(checkMailLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }







}
