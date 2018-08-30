package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.TestNGUtils;
import setup.WaitHelper;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[2]/div/div/input")
    private WebElement mobileLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[3]/div/button/span")
    private WebElement mobileSubmitLocator;
    @FindBy (xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[2]/div/p")
    private WebElement mobileErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[1]/div/input")
    private WebElement codeLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[2]/div/button/span")
    private WebElement codeSubmitLocator;
    @FindBy(xpath = "/html/body/div[4]/div/div[1]/p")
    private WebElement codeErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/form/div[1]/p")
    private WebElement codeErrorMessageLocator;
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

    public void submitMobile(){
        click(mobileSubmitLocator);
    }

    public boolean isMobileErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(mobileErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getMobileErrorText(){
       return mobileErrorLocator.getText();
    }

    public void invalidMobileText(String s){
      type(mobileLocator, s);
    }

    public void validMobile(String s){
        type(mobileLocator, s);
    }

    public boolean isCodeSubmitDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(codeSubmitLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void submitCode(){
        click(codeSubmitLocator);
    }

    public boolean isCodeErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(codeErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public boolean isCodeErrorMessageDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(codeErrorMessageLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void invalidCodeText(String s){
        type(codeLocator, s);
    }

    public String getCodeErrorText(){
        return codeErrorMessageLocator.getText();
    }

    public void validCodeText(String s){
        type(codeLocator, s);
    }

    public boolean isAddressSubmitDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(addressSubmitLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }











    /*public void registerWith(String fName, String lName, String email, String password){
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
    }*/







}
