package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class VideoPage {

    private WebDriver browser;

    public VideoPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getVideoTitle() {
        WebElement videoTitle = browser.findElement(Locators.VideoPage.videoTitle);
        return videoTitle.getText();
    }

    public VideoPage clickLikeVideoButton() {
        WebElement likeVideoButton = browser.findElement(Locators.VideoPage.likeVideoButton);
        likeVideoButton.click();
        return new VideoPage(browser);
    }

    public VideoPage clickGuideButton() {
        WebElement guideButton = browser.findElement(Locators.VideoPage.guideButton);
        guideButton.click();
        return new VideoPage(browser);
    }

    public LikedVideosPage clickLikedVideosButton() {
        WebElement likedVideosButton = browser.findElement(Locators.VideoPage.likedVideosButton);
        likedVideosButton.click();
        return new LikedVideosPage(browser);
    }

    public VideosHistoryPage clickVideosHistoryButton() {
        WebElement videosHistoryButton = browser.findElement(Locators.VideoPage.videosHistoryButton);
        videosHistoryButton.click();
        return new VideosHistoryPage(browser);
    }

    public VideoPage clickSubscribeButton() {
        WebElement subscribeButton = browser.findElement(Locators.VideoPage.subscribeButton);
        subscribeButton.click();
        return new VideoPage(browser);
    }

    public ChannelPage clickChannelButton() {
        WebElement channelButton = browser.findElement(Locators.VideoPage.channelButton);
        channelButton.click();
        return new ChannelPage(browser);
    }

    public String getChannelName() {
        WebElement channelName = browser.findElement(Locators.VideoPage.channelButton);
        return channelName.getText();
    }
}
