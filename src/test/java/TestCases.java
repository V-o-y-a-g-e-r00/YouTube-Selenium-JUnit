import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestCases {

    private WebDriver browser;
    private Integer DEFAULT_DELEY = 1000;

    @Before
    public void precondition() {
        Properties prop = new Properties();
        String fileName = "env.config";


        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println(fileName + " not found!" + ex);
    // FileNotFoundException catch is optional and can be collapsed
        } catch (IOException ex) {
            System.out.println(fileName + " IOException");
        }
        System.out.println(prop.getProperty("login"));
        String authorizePageLogin = prop.getProperty("login");
        String authorizePagePassword = prop.getProperty("password");

//        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\fmolo\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");


        browser = new ChromeDriver(options);
//        browser.manage().window().maximize();
        browser.get("https://www.youtube.com/");



        MainPage mainPage = new MainPage(browser);
//        AuthorizePage authorizePage = new AuthorizePage(browser);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        mainPage
//                .clickSignInButton();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        authorizePage
//                .clickUsernameInputArea()
//                .usernameInputArea(authorizePageLogin)
//                .clickPasswordInputButton();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        authorizePage
//                .passwordInputArea(authorizePagePassword)
//                .clickConfirmPasswordButton();

//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
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
        try {
            Thread.sleep(this.DEFAULT_DELEY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mainPage.clickSearchForm("Король и Шут Прыгну со скалы").clickSearchButton();

        try {
            Thread.sleep(this.DEFAULT_DELEY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SearchPage searchPage = new SearchPage(browser);
        try {
            Thread.sleep(this.DEFAULT_DELEY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        String firstVideoTitle = searchPage.getFirstVideoTitle();
//        Assert.assertEquals(expectedSearchText, firstVideoTitle);
    }

    @Test
    //Тест-кейс 3 "Оценка видео, поставить лайк, отображение в понравившемся"
    public void checkLikeButton() {

        MainPage mainPage = new MainPage(browser);

        mainPage
                .clickFirstVideoButton();

        try {
            Thread.sleep(this.DEFAULT_DELEY);
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
            Thread.sleep(this.DEFAULT_DELEY);
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
            Thread.sleep(this.DEFAULT_DELEY);
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
            Thread.sleep(this.DEFAULT_DELEY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        VideoPage videoPage = new VideoPage(browser);

        String expectedChannelName = videoPage.getChannelName();

        videoPage
                .clickSubscribeButton()
                .clickChannelButton();

        try {
            Thread.sleep(this.DEFAULT_DELEY);
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
