package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class VideosHistoryPage {

    private WebDriver browser;

    public VideosHistoryPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getFirstVideoTitle() {
        WebElement firstVideoButton = browser.findElement(Locators.VideosHistoryPage.firstVideoTitle);
        return firstVideoButton.getText();
    }
}
