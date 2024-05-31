package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-agent=Mozilla   Chrome/125.0.6422.113");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--guest");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-infobars");

            driver = new ChromeDriver(options);
        }
    }
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            for (int i = 0; i < Math.min(tabs.size(), 10); i++) {
                driver.switchTo().window(tabs.get(i));
                driver.close();
            }
            driver.quit();
        }
    }
}

