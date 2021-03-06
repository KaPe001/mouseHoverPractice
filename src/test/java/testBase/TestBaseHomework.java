package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WebListener;

public class TestBaseHomework {

    public static Logger logger = LoggerFactory.getLogger(TestBase.class);
    public WebDriver webDriver;
    private EventFiringWebDriver driver;
    private WebListener webListener;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(webDriver);
        webListener = new WebListener();
        driver.register(webListener);
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        logger.info("Browser opened correctly");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("Driver teared down correctly");
    }
}
