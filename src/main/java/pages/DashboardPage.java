package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sn_staff")
    WebElement staffButton;

    @FindBy(id = "wrap_us_menu")
    WebElement userMenuButton;

    private By userMenu = By.id("userm");

    @FindBy(partialLinkText = "Sign Out")
    WebElement signOutButton;

    /**
     * Method clicks on the staff button
     *
     * @author Luka.Ivancic
     * */
    public void clickStaffButton(){

        staffButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
