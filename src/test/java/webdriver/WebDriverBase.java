package webdriver;

import org.openqa.selenium.WebDriver;

@SuppressWarnings("ALL")
public abstract class WebDriverBase {
    private static WebDriver driver;

    public WebDriverBase(WebDriver driver) {
        WebDriverBase.driver = driver;
    }

}
