package webdriver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import logger.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriverManager instance = new WebDriverManager();
    private static WebDriver driver = null;
    private static String link = WebDriverLink.getLink();

    public static WebDriverManager getInstance() {
        return instance;
    }

    public static String getBrowser() {
        Log.info("Retrieving browser properties");
        String browser = System.getProperty("browser");

        if (browser == null)
            browser = "chrome";
        return browser;
    }

    public static WebDriver getWebDriver(String browser) throws MalformedURLException {
        switch (browser.toLowerCase()) {
            case "ff":
            case "firefox":
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                Log.info("Starting WebDriver with Firefox ");
                driver = new FirefoxDriver();
                break;

            case "ch":
            case "chrome":
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                //ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless=new");
                Log.info("Starting WebDriver with Chrome");
                driver = new ChromeDriver(options);
                break;

            default:
                Assert.fail("Unknown WebDriver for browser '" + browser.toLowerCase() + "'");
                break;
        }

        Log.info("Deleting cookies");
        driver.manage().deleteAllCookies();

        Log.info("Maximizing instance window");
        driver.manage().window().maximize();

        Log.info("Setting page load timeout");
        driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);

        Log.info("Setting script timeout");
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        Log.info("Setting implicit wait");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Log.info("Navigating to: '" + link + "'");
        driver.get(link);

        return driver;
    }

    public void removeDriver() {
        Log.info("Closing WebDriver");
        driver.close();

        Log.info("Quitting WebDriver Background Processes");
        driver.quit();
    }

}