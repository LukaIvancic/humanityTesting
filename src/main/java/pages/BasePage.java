package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method gets URL of the current page
     *
     * @author Luka.Ivancic
     * */
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }



}
