package test;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import pages.LoginPage;

public class TestLoginPage extends TestBase{


    private FacebookPage facebookPage;



    /**
     * The test validates login with correct data
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 0)
    public void testLoginWithCorrectData(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(Constants.EMAIL, Constants.PASSWORD);
        String expectedURL = loginPage.getCurrentURL();

        Assert.assertEquals(Constants.ACTUAL_DASBOARD_URL, expectedURL);

    }


    /**
     * The test validates login by pressing Enter key
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 1)
    public void testLoginByPressingEnter(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(Constants.EMAIL, Constants.PASSWORD);
        loginPage.pressEnterOnLoginButton();
        String expectedURL = loginPage.getCurrentURL();
        Assert.assertEquals(Constants.ACTUAL_DASBOARD_URL, expectedURL);

    }

    /**
     * The test validates login with empty data fields
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 2)
    public void testLoginWithEmptyEmailAndPassword(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(Constants.EMPTY_EMAIL, Constants.EMPTY_PASSWORD);
        Assert.assertTrue(loginPage.isIResponseMessageDisplayed(), "Response message not displayed");

    }

    /**
     * The test validates login with incorrect email and password
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 3)
    public void testLoginWithIncorrectData(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(Constants.INCORRECT_EMAIL, Constants.INCORRECT_PASSWORD);
        Assert.assertTrue(loginPage.isIResponseMessageDisplayed(), "Response message not displayed");

    }



    /**
     * The test validates the Forgot Password button function
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 4)
    public void testForgotPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordButton();
        String expectedURL = loginPage.getCurrentURL();
        Assert.assertEquals(Constants.ACTUAL_FORGOT_PASSWORD_URL, expectedURL);

    }

    /**
     * The test validates the Homepage button function
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 5)
    public void testHomepageButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickHomepageButton();
        String expectedURL = loginPage.getCurrentURL();
        Assert.assertEquals(Constants.ACTUAL_HOMEPAGE_URL, expectedURL);

    }

    /**
     * The test validates the Lost Password button function
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 6)
    public void testLostPasswordButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLostPasswordButton();
        String expectedURL = loginPage.getCurrentURL();
        Assert.assertEquals(Constants.ACTUAL_LOST_PASSWORD_URL, expectedURL);

    }

    /**
     * The test validates Single Sign On button function
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 7)
    public void testSingleSignOn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSingleSignOnButton();
        Assert.assertTrue(loginPage.isSingleSignOnDisplayed(), "Single Sign On form not displayed");

    }

    /**
     * The test validates Login with Facebook button function
     *
     * @author Luka.Ivancic
     *
     * */
    @Test(priority = 8)
    public void testLoginWithFacebook(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginWithFacebookButton();
        facebookPage = new FacebookPage(driver);
        Assert.assertTrue(facebookPage.checkFacebookLink(), "Facebook page didn't open!");

    }

}
