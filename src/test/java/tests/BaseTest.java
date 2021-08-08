package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import shared.enums.Browser;
import shared.enums.TestEnvironment;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
    private static final String projectRoot = System.getProperty("user.dir");
    private static ChromeDriverService service;
    protected static Browser browser;
    protected static TestEnvironment testEnvironment;
    protected WebDriver driver;

    public BaseTest() {}

    @BeforeClass
    public static void beforeAllSetup() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(projectRoot + "/src/main/resources/config.properties"));
        browser = Browser.valueOf(prop.getProperty("browser"));
        testEnvironment = TestEnvironment.valueOf(prop.getProperty("environment"));

        switch (browser) {
            case CHROME:
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(projectRoot + "/chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
                break;
            case EDGE:
                //todo
                break;
            case FIREFOX:
                //todo
                break;
            default:
                throw new Exception("invalid browser value in config.properties file");
        }
    }

    @AfterClass
    public static void afterAllTeardown() {
        service.stop();
    }

    @Before
    public void beforeTestSetup() throws Exception {
        new Robot().mouseMove(0, 0); // move mouse to corner of the screen so that it doesn't interfere with tests
        switch (browser) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new RemoteWebDriver(service.getUrl(), chromeOptions);
            case EDGE:
                //todo
                break;
            case FIREFOX:
                //todo
                break;
        }
    }

    @After
    public void afterTestTeardown() {
        driver.quit();
    }
}
