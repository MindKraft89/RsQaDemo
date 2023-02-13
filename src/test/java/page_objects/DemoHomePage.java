package page_objects;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverBase;

public class DemoHomePage extends WebDriverBase {

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[6]")
    private static WebElement bookStoreApplicationLink;

    public DemoHomePage(WebDriver driver) {
        super(driver);
    }

    public static void goToBookStoreApplication() {
        Helper.assertElementPresent(bookStoreApplicationLink);
        Helper.click(bookStoreApplicationLink);
    }

}
