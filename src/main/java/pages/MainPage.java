package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Locators;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver browser;

    public MainPage(WebDriver browser) {
        this.browser = browser;
    }

    public AuthorizePage clickSignInButton() {
        WebElement signInButton = browser.findElement(Locators.MainPage.signInButton);
        signInButton.click();
        return new AuthorizePage(browser);
    }

    public String getFirstVideoTitle() {
        WebElement firstVideoTitle = browser.findElement(Locators.MainPage.firstVideoButton);
        return firstVideoTitle.getText();
    }

    public VideoPage clickFirstVideoButton() {
        WebElement firstVideoButton = browser.findElement(Locators.MainPage.firstVideoButton);
        firstVideoButton.click();
        return new VideoPage(browser);
    }

    public MainPage clickSearchForm(String text) {
        WebElement searchForm = browser.findElement(Locators.MainPage.searchForm);
        browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        searchForm.click();
        new Actions(browser).sendKeys(text);
        return new MainPage(browser);
    }

//    public MainPage searchFormInputText(String text) {
//        WebElement searchFormInputText = browser.findElement(Locators.MainPage.searchInput);
////        searchFormInputText.sendKeys(text);
//        new Actions(browser).sendKeys(text);
//
//        return new MainPage(browser);
//    }

    public SearchPage clickSearchButton() {
        WebElement searchButton = browser.findElement(Locators.MainPage.searchButton);
        searchButton.click();
        return new SearchPage(browser);
    }
}
