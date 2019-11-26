package test;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.Utils;

public class TestBase {

    public WebDriver driver;


    /**
     * Method starts the application and goes to Humanity app
     *
     * @author Luka.Ivancic
     *
     * */
    @BeforeMethod
    public void setUp(){
        driver = Utils.startApplication(driver, Constants.CHROME_BROWSER, Constants.HUMANITY_URL);

    }

    /**
     * Method exits the browser
     *
     * @author Luka.Ivancic
     *
     * */
    @AfterMethod
    public void tearDown(){

        Utils.quitBrowser(driver);

    }

}
