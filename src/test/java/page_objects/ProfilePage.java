package page_objects;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverBase;

public class ProfilePage extends WebDriverBase {

    @FindBy(id = "searchBox")
    private static WebElement searchBox;
    @FindBy(id = "userName-value")
    private static WebElement userNameValue;
    @FindBy(id = "gotoStore")
    private static WebElement gotoStoreBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/button")
    private static WebElement deleteAccountBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button")
    private static WebElement deleteAllBooksBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/button")
    private static WebElement logoutBtn;

    public ProfilePage (WebDriver driver) {
        super(driver);
    }

    public static void goBackToBookStore() {
        Helper.click(gotoStoreBtn);
    }

    public static void deleteAccount() {
        Helper.click(deleteAccountBtn);
    }

    public static void deleteAllBooks() {
        Helper.click(deleteAllBooksBtn);
    }

    public static void fillInSearchBox(String title) {
        Helper.type(searchBox, title);
    }

    public static void assertUserName(String userName) {
        Helper.assertElementPresent(userNameValue);
        Helper.assertElementText(userNameValue, userName);
    }


}
