package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BaseLogin extends BasePage{

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[(@name='login') and contains(@class,'btn-blue')]")
    WebElement loginButton;

    @FindBy(id = "response-message")
    WebElement responseMessage;

    @FindBy(linkText = "Forgot Password?")
    WebElement forgotPasswordButton;

    @FindBy(linkText = "Homepage")
    WebElement homepageButton;

    @FindBy(linkText = "Lost password?")
    WebElement lostPasswordButton;

    @FindBy(xpath = "//button[(@name = 'loginSSO') and contains(@class, 'btn-blue-bordered')]")
    WebElement singleSignOnButton;

    @FindBy(id = "SSOLogin")
    WebElement singleSignOnForm;

    @FindBy(partialLinkText = "Log in with Facebook")
    WebElement loginWithFacebookButton;

    public BaseLogin(WebDriver driver) {
        super(driver);
    }


    /**
     * Method enters email and password
     *
     * @param userEmail, userPassword
     * @author Luka.Ivancic
     *
     * */
    public void enterData(String userEmail, String userPassword){
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
    }

    /**
     * The method check if the response message is displayed
     *
     * @return true if displayed, false if otherwise
     * @author Luka.Ivancic
     *
     * */
    public boolean isIResponseMessageDisplayed(){ //BASE
        if(responseMessage.isDisplayed()){
            return true;
        }
        return false;


    }

    /**
     * The method check if the Single Sign On form is displayed
     *
     * @return true if displayed, false if otherwise
     * @author Luka.Ivancic
     *
     * */
    public boolean isSingleSignOnDisplayed(){
        String style = singleSignOnForm.getAttribute("style");
        if(style.equalsIgnoreCase("display: block;")){
            return true;
        }
        return false;

    }

    /**
     * The method clicks on the Forgot Password button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickForgotPasswordButton(){

        forgotPasswordButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method clicks on the Homepage button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickHomepageButton(){

        homepageButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method clicks on the Lost Password button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickLostPasswordButton(){

        lostPasswordButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method clicks on the Single Sign On button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickSingleSignOnButton(){

        singleSignOnButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method presses Enter
     *
     * @author Luka.Ivancic
     *
     * */
    public void pressEnterOnLoginButton(){

        loginButton.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
