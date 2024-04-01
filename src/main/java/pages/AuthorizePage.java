package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class AuthorizePage {

    private WebDriver browser;

    public AuthorizePage(WebDriver browser) {
        this.browser = browser;
    }

    public AuthorizePage clickUsernameInputArea() {
        WebElement usernameInputArea = browser.findElement(Locators.AuthorizePage.usernameInputArea);
        usernameInputArea.click();
        return new AuthorizePage(browser);
    }

    public AuthorizePage usernameInputArea(String username) {
        WebElement usernameInputArea = browser.findElement(Locators.AuthorizePage.usernameInputArea);
        usernameInputArea.sendKeys(username);
        return new AuthorizePage(browser);
    }

    public AuthorizePage clickPasswordInputButton() {
        WebElement passwordInputButton = browser.findElement(Locators.AuthorizePage.usernameConfirmButton);
        passwordInputButton.click();
        return new AuthorizePage(browser);
    }

    public AuthorizePage passwordInputArea(String password) {
        WebElement passwordInputArea = browser.findElement(Locators.AuthorizePage.passwordInputArea);
        passwordInputArea.sendKeys(password);
        return new AuthorizePage(browser);
    }

    public MainPage clickConfirmPasswordButton() {
        WebElement confirmPasswordButton = browser.findElement(Locators.AuthorizePage.passwordConfirmButton);
        confirmPasswordButton.click();
        return new MainPage(browser);
    }
}
