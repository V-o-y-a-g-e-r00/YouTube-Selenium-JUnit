package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class ChannelPage {

    private WebDriver browser;

    public ChannelPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getChannelName() {
        WebElement channelName = browser.findElement(Locators.ChannelPage.channelName);
        return channelName.getText();
    }

    public ChannelPage clickNotificationButton() {
        WebElement notificationButton = browser.findElement(Locators.ChannelPage.notificationButton);
        notificationButton.click();
        return new ChannelPage(browser);
    }

    public ChannelPage clickUnsubscribeButton() {
        WebElement unsubscribeButton = browser.findElement(Locators.ChannelPage.unsubscribeButton);
        unsubscribeButton.click();
        return new ChannelPage(browser);
    }

    public ChannelPage clickConfirmUnsubscribeButton() {
        WebElement confirmUnsubscribeButton = browser.findElement(Locators.ChannelPage.confirmUnsubscribeButton);
        confirmUnsubscribeButton.click();
        return new ChannelPage(browser);
    }
}
