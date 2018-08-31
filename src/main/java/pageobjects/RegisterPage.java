package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

public class RegisterPage extends BasePage {
    //Mobile and Code page Locators
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

    //Customer info page Locators
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[1]/div/div[1]/div/input")
    private WebElement firstNameLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[1]/div/div[2]/div/input")
    private WebElement lastNameLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[2]/div/div/div/input")
    private WebElement emailLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[3]/div/div/label")
    private WebElement checkMissingEmailLocator;
    @FindBy(id = "street-name")
    private WebElement addressLocator;
    @FindBy(xpath = "//*[@id=\"map\"]/div/div/div[1]/div[3]")
    private WebElement mapLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[3]/div[2]/div/div[1]/div/input")
    private WebElement postCodeLocator;
    @FindBy(xpath = "//*[@id=\"UpdateInfoForm\"]/div[4]/input")
    private WebElement addressSubmitLocator;
    @FindBy(xpath = "//*[@id=\"location-message\"]")
    private WebElement addressErrorLocator;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/p")
    private WebElement emailErrorPopUpLocator;


    //Request page Locators
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/input")
    private WebElement categoryLocator;
    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/ul/li[2]/span")
    private WebElement categoryValueLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[3]/div/div/div/textarea")
    private WebElement whatForTextLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[1]/div[1]")
    private WebElement priceLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[3]/div")
    private WebElement termsLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/div[1]/div[1]/p")
    private WebElement categoryErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[3]/div/div/p")
    private WebElement whatForErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[2]/p")
    private WebElement priceErrorLocator;
    @FindBy (xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[3]/button/span")
    private WebElement bokaLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[1]/div[2]/a[1]")
    private WebElement rutLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[3]/div/div[2]/div/input")
    private WebElement ssnLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[3]/div/div/p")
    private WebElement ssnErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div/div/form/div[1]/div[6]/div[3]/div/div[2]/p")
    private WebElement wrongSsnErrorLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/h4[1]")
    private WebElement registerSuccessLocator;



    //Buddy page Locators
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div[1]/div[1]")
    private WebElement buddyListLocator;
    @FindBy(xpath = "//*[@id=\"customer\"]/div/div/div/div/div/div[2]/div[1]/div[2]/input")
    private WebElement newRequestLocator;



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
            WaitHelper.getWait().waitForElementToBeClickable(addressSubmitLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public boolean isBuddyListDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(buddyListLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public boolean isEmailDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(buddyListLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void scrollToAddressSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,2000)");
        WebElement Element = driver.findElement(By.xpath("//*[@id=\"UpdateInfoForm\"]/div[2]/div/div/div/input"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void submitAddress(){
        click(addressSubmitLocator);
    }

    public boolean isAddressErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(buddyListLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getAddressErrorText(){
       return addressErrorLocator.getText();
    }

    public void typeEmail(String email){
        type(emailLocator,email);
    }

    public boolean isMissingEmailCheckboxDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(checkMissingEmailLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void checkMissingEmail(){
        click(checkMissingEmailLocator);
    }

    public void typeAddress(String address){
        type(addressLocator, address);
    }

    public boolean isMapDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(mapLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void clickMap(){
        click(mapLocator);
    }

    public boolean isPostCodeDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(postCodeLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void clickPostCode(){
        click(postCodeLocator);
    }

    public boolean isEmailErrorPopUpDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(emailErrorPopUpLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getEmailErrorPopUpText(){
        return emailErrorPopUpLocator.getText();
    }

    public boolean isCategoryDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(categoryLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public boolean isTermsDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(termsLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public void checkTerms(){
        click(termsLocator);
    }

    public void submitRequest(){
        click(bokaLocator);
    }

    public boolean isCategoryErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(categoryErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getCategoryErrorText(){
        return categoryErrorLocator.getText();
    }

    public boolean isWhatForErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(whatForErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getWhatForErrorText(){
        return whatForErrorLocator.getText();
    }

    public boolean isPriceErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(priceErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getPriceErrorpText(){
        return priceErrorLocator.getText();
    }

    public void clickCategory(){
        click(categoryLocator);
        click(categoryValueLocator);
    }

    public void typeWhatFor(String text){
        type(whatForTextLocator,text);
    }

    public void selectPrice(){
        click(priceLocator);
    }

    public boolean isRegisterSuccessDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(registerSuccessLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getRegisterSuccessText(){
        return registerSuccessLocator.getText();
    }

    public void openRequestPage(){
        click(newRequestLocator);
    }

    public void selectRUT(){
        click(rutLocator);
    }

    public boolean isSsnErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(ssnErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getSsnErrorText(){
        return ssnErrorLocator.getText();
    }

    public void typeSsn(String text){
        type(ssnLocator, text);
    }

    public boolean isWrongSsnErrorDisplayed(){
        try{
            WaitHelper.getWait().waitForElementToBeVisible(wrongSsnErrorLocator);
            return true;
        }catch (Error e){
            return false;
        }
    }

    public String getWrongSsnErrorText(){
        return wrongSsnErrorLocator.getText();
    }
















}
