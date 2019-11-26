package test;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginVincainstitutePage;
import util.Utils;

public class TestLoginVincainstitutePage extends TestBase{

    public WebDriver driver;


    /**
     * Method starts the application and goes to vincainstitute.humanity.com app
     *
     * @author Luka.Ivancic
     *
     * */
    @Override
    @BeforeMethod
    public void setUp(){
        driver = Utils.startApplication(driver, "chrome", Constants.VINCAINSTITUTE_HUMANITY_URL);

    }


    /**
     * Test verifies if vincainstitute Login page works correctly
     *
     * @author Luka.Ivancic
     *
     * */
    @Test
    public void testLoginVincainstitutePageWithCorrectData() {

        LoginVincainstitutePage loginVincainstitutePage = new LoginVincainstitutePage(driver);
        loginVincainstitutePage.VincainstitutelogIn(Constants.EMAIL, Constants.PASSWORD);
        String expectedURL = loginVincainstitutePage.getCurrentURL();
        Assert.assertEquals(Constants.ACTUAL_DASBOARD_URL, expectedURL);

    }

    /**
     * Method exits the browser
     *
     * @author Luka.Ivancic
     *
     * */
    @Override
    @AfterMethod
    public void tearDown(){

        Utils.quitBrowser(driver);

    }



}
