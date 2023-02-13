package page_objects;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverBase;

public class BookStorePage extends WebDriverBase {

    @FindBy(xpath = "//*[@id=\"item-0\"]")
    private static WebElement loginPageLink;

    @FindBy(xpath = "//*[@id=\"item-3\"]")
    private static WebElement profilePageLink;

    @FindBy(id = "searchBox")
    private static WebElement searchBox;

    @FindBy(id = "login")
    private static WebElement loginBtn;
    @FindBy(id = "addNewRecordButton")
    private static WebElement addNewBookBtn;

    @FindBy(id = "see-book-Git Pocket Guide")
    private static WebElement bookGitPocketGuide;

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public static void goTologinPageByLink() {
        Helper.click(loginPageLink);
    }

    public static void goToProfilePage() {
        Helper.click(profilePageLink);
    }

    public static void login() {
        Helper.click(loginBtn);
    }

    public static void fillInSearchBox(String text) {
        Helper.type(searchBox, text);
    }

    public static void goToLoginPageByBtn() {
        Helper.click(loginBtn);
    }

    public static void checkIfLoginButtonIsVisible() {
        Helper.assertElementValue(loginBtn, "Login");
    }

    public static void addNewBook() {
        Helper.click(addNewBookBtn);
    }
    public static void clickGitPocketGuideBook() {
        Helper.click(bookGitPocketGuide);
    }

}
