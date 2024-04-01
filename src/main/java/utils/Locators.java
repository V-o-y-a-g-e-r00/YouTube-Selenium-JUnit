package utils;

import org.openqa.selenium.By;

public interface Locators {

    interface MainPage {

        By signInButton = By.xpath("//*[@id='sign-in-button']");

        By firstVideoButton = By.xpath("//*[@id='video-title']");

        By searchForm = By.xpath("//*[@id='search-form']/div[@id='container']/div[@id='search-input']/input[@id='search']");

        By searchButton = By.xpath("//*[@id='search-icon-legacy']");
    }

    interface AuthorizePage {

        By usernameInputArea = By.xpath("//*[@id=\"identifierId\"]");

        By usernameConfirmButton = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");

        By passwordInputArea = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");

        By passwordConfirmButton = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");
    }

    interface VideoPage {

        By videoTitle = By.xpath("//*[@id=\"title\"]/h1/yt-formatted-string");

        By likeVideoButton = By.xpath("//*[@id='top-level-buttons-computed']/segmented-like-dislike-button-view-model[@class='YtSegmentedLikeDislikeButtonViewModelHost style-scope ytd-menu-renderer']/yt-smartimation[@class='smartimation smartimation--enable-masking']/div[@class='smartimation__content']/div[@class='YtSegmentedLikeDislikeButtonViewModelSegmentedButtonsWrapper']/like-button-view-model[@class='YtLikeButtonViewModelHost']/toggle-button-view-model/button-view-model[@class='yt-spec-button-view-model']/button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--tonal yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m yt-spec-button-shape-next--icon-leading yt-spec-button-shape-next--segmented-start']");

        By guideButton = By.xpath("//*[@id='guide-button']");

        By likedVideosButton = By.xpath("//*[@id='sections']/ytd-guide-section-renderer[@class='style-scope ytd-guide-renderer'][1]/div[@id='items']/ytd-guide-collapsible-section-entry-renderer[@class='style-scope ytd-guide-section-renderer']/div[@id='section-items']/ytd-guide-entry-renderer[@class='style-scope ytd-guide-collapsible-section-entry-renderer'][6]/a[@id='endpoint']/tp-yt-paper-item[@class='style-scope ytd-guide-entry-renderer']");

        By videosHistoryButton = By.xpath("//*[@id='sections']/ytd-guide-section-renderer[@class='style-scope ytd-guide-renderer'][1]/div[@id='items']/ytd-guide-collapsible-section-entry-renderer[@class='style-scope ytd-guide-section-renderer']/div[@id='section-items']/ytd-guide-entry-renderer[@class='style-scope ytd-guide-collapsible-section-entry-renderer'][2]/a[@id='endpoint']/tp-yt-paper-item[@class='style-scope ytd-guide-entry-renderer']");

        By subscribeButton = By.xpath("//*[@id='subscribe-button-shape']");

        By channelButton = By.xpath("//*[@id='owner']/ytd-video-owner-renderer[@class='style-scope ytd-watch-metadata']/div[@id='upload-info']/ytd-channel-name[@id='channel-name']/div[@id='container']/div[@id='text-container']");
    }

    interface SearchPage {

        By firstVideoTitle = By.xpath("//*[1]/div[@id='dismissible']/div[@class='text-wrapper style-scope ytd-video-renderer']/div[@id='meta']/div[@id='title-wrapper']/h3[@class='title-and-badge style-scope ytd-video-renderer']/a[@id='video-title']/yt-formatted-string[@class='style-scope ytd-video-renderer']");
    }

    interface LikedVideosPage {

        By firstVideoTitle = By.xpath("//*[1]/div[@id='content']/div[@id='container']/div[@id='meta']/h3[@class='style-scope ytd-playlist-video-renderer']/a[@id='video-title']");
    }

    interface VideosHistoryPage {

        By firstVideoTitle = By.xpath("//*[1]/div[@id='dismissible']/div[@class='text-wrapper style-scope ytd-video-renderer']/div[@id='meta']/div[@id='title-wrapper']/h3[@class='title-and-badge style-scope ytd-video-renderer']/a[@id='video-title']/yt-formatted-string[@class='style-scope ytd-video-renderer']");
    }

    interface ChannelPage {

        By channelName = By.xpath("//*[@id='meta']/ytd-channel-name[@id='channel-name']/div[@id='container']/div[@id='text-container']/yt-formatted-string[@id='text']");

        By notificationButton = By.xpath("//*[@id='channel-header']/div[@id='channel-header-container']/div[@id='inner-header-container']/div[@id='buttons']");

        By unsubscribeButton = By.xpath("//*[@id='items']/ytd-menu-service-item-renderer[@class='style-scope ytd-menu-popup-renderer'][3]/tp-yt-paper-item[@class='style-scope ytd-menu-service-item-renderer']");

        By confirmUnsubscribeButton = By.xpath("//*[@id='confirm-button']/yt-button-shape[@class='style-scope ytd-popup-container']");
    }
}
