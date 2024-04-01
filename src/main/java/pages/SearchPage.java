package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class SearchPage {

    private WebDriver browser;

    public SearchPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getFirstVideoTitle() {
        WebElement firstVideoTitle = browser.findElement(Locators.SearchPage.firstVideoTitle);
        return firstVideoTitle.getText();
    }
}
