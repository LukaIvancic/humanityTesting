package pages;

import org.openqa.selenium.WebDriver;


public class FacebookPage extends BasePage {

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method checks if the current link contains facebook link
     *
     * @return true if it contains, false if otherwise
     * @author Luka.Ivancic
     * */
    public Boolean checkFacebookLink(){
        String link = getCurrentURL();
        if(link.contains("www.facebook.com")){
            return true;
        }
        return false;

    }
}
