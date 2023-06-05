package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import webdriver.WebDriverManager;

import java.net.MalformedURLException;


public class CucumberHooks {
    static WebDriver driver = null;

    @Before
    public void openBrowser() throws MalformedURLException {
        driver = WebDriverManager.getWebDriver(WebDriverManager.getBrowser());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}