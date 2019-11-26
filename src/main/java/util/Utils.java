package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Utils {



    /**
     * The method starts the application
     *
     * @param driver, browser, URL
     * @author Luka.Ivancic
     *
     * */
    public static WebDriver startApplication(WebDriver driver, String browser, String URL){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        else{
            System.out.println("Browser not supported");
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }

    /**
     * The method sets up the browser
     *
     * @author Luka.Ivancic
     *
     * */
    public static LoginPage setUpBrowser(){
        LoginPage loginPage;
        WebDriverManager.chromedriver().setup();
        return loginPage = new LoginPage(new ChromeDriver());

    }

    /**
     * The method quits the browser
     *
     * @param driver
     * @author Luka.Ivancic
     *
     * */
    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }


}
