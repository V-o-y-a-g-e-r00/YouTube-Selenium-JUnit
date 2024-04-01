package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class LikedVideosPage {

    private WebDriver browser;

    public LikedVideosPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getFirstVideoTitle() {
        WebElement firstVideoTitle = browser.findElement(Locators.LikedVideosPage.firstVideoTitle);
        return firstVideoTitle.getText();
    }
}
