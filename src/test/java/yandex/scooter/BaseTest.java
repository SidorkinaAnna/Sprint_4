package yandex.scooter;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");
    }

    @Before
    public void beforeEach(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void after(){
        getDriver().quit();
    }

    public abstract WebDriver getDriver();
}
