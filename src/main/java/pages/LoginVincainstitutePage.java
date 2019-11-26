package pages;

import org.openqa.selenium.WebDriver;

public class LoginVincainstitutePage extends BaseLogin {


    public LoginVincainstitutePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Mathod logs in via vincainstitute login Page
     *
     * @param userEmail, userPassword
     *
     * @author Luka.Ivancic
     *
     * */
    public void VincainstitutelogIn(String userEmail, String userPassword){

        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
