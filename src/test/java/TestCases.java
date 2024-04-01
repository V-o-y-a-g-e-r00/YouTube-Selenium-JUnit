import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.Locators;

public class TestCases {

    private WebDriver browser;

    @Before
    public void precondition() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.youtube.com/");

        MainPage mainPage = new MainPage(browser);
        AuthorizePage authorizePage = new AuthorizePage(browser);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mainPage
                .clickSignInButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        authorizePage
                .clickUsernameInputArea()
                .usernameInputArea("mmailfortest05")
                .clickPasswordInputButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        authorizePage
                .passwordInputArea("zqxwcevr111")
                .clickConfirmPasswordButton();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    //Тест-кейс 1 "Открытие видео из ленты, открылось ли выбранное видео"
    public void checkVideoOpening() {

        MainPage mainPage = new MainPage(browser);

        String currentFirstVideoTitle = mainPage.getFirstVideoTitle();

        mainPage
                .clickFirstVideoButton();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideoPage videoPage = new VideoPage(browser);

        String videoTitle = videoPage.getVideoTitle();
        Assert.assertEquals(currentFirstVideoTitle, videoTitle);
    }

    @Test
    //Тест-кейс 2 "Поиск видео, проверка поля ввода текста"
    public void checkSearchForm() {

        MainPage mainPage = new MainPage(browser);

        String expectedSearchText = "Король и Шут Прыгну со скалы";

        mainPage
                .clickSearchForm()
                .searchFormInputText("Король и Шут Прыгну со скалы")
                .clickSearchButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SearchPage searchPage = new SearchPage(browser);

        String firstVideoTitle = searchPage.getFirstVideoTitle();
        Assert.assertEquals(expectedSearchText, firstVideoTitle);
    }

    @Test
    //Тест-кейс 3 "Оценка видео, поставить лайк, отображение в понравившемся"
    public void checkLikeButton() {

        MainPage mainPage = new MainPage(browser);

        mainPage
                .clickFirstVideoButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideoPage videoPage = new VideoPage(browser);

        String expectedVideoTitle = videoPage.getVideoTitle();

        videoPage
                .clickLikeVideoButton()
                .clickGuideButton()
                .clickLikedVideosButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LikedVideosPage likedVideosPage = new LikedVideosPage(browser);

        String firstVideoTitle = likedVideosPage.getFirstVideoTitle();

        Assert.assertEquals(expectedVideoTitle, firstVideoTitle);

    }

    @Test
    //Тест-кейс 4 "История видео, добавление просмотренного видео в историю"
    public void checkVideoHistory() {

        MainPage mainPage = new MainPage(browser);

        mainPage
                .clickFirstVideoButton();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideoPage videoPage = new VideoPage(browser);

        String expectedVideoTitle = videoPage.getVideoTitle();

        videoPage
                .clickGuideButton()
                .clickVideosHistoryButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideosHistoryPage videosHistoryPage = new VideosHistoryPage(browser);

        String firstVideoTitle = videosHistoryPage.getFirstVideoTitle();

        Assert.assertEquals(expectedVideoTitle, firstVideoTitle);
    }

    @Test
    //Тест-кейс 5 "Подписка на канал, отображение новой подписки в разделе"
    public void checkSubscribeButton() {

        MainPage mainPage = new MainPage(browser);

        mainPage
                .clickFirstVideoButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideoPage videoPage = new VideoPage(browser);

        String expectedChannelName = videoPage.getChannelName();

        videoPage
                .clickSubscribeButton()
                .clickChannelButton();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ChannelPage channelPage = new ChannelPage(browser);

        String channelName = channelPage.getChannelName();
        Assert.assertEquals(expectedChannelName, channelName);

        channelPage
                .clickNotificationButton()
                .clickUnsubscribeButton()
                .clickConfirmUnsubscribeButton();
    }

    @After
    public void closeBrowser() {
        browser.quit();
    }
}
