package pages;

import org.openqa.selenium.WebDriver;


public class LoginPage extends BaseLogin{


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    /**
     * The method enters the correct data and logs in
     *
     * @param userPassword, userPassword
     * @author Luka.Ivancic
     */
    public void logIn(String userEmail, String userPassword){

        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method clicks on the Login with Facebook button
     *
     * @author Luka.Ivancic
     *
     * */
    public void clickLoginWithFacebookButton(){

        loginWithFacebookButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
