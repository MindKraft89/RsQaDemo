package page_objects;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverBase;

public class LoginPage extends WebDriverBase {

    @FindBy(id = "userName")
    private static WebElement userNameField;

    @FindBy(id = "password")
    private static WebElement passwordField;

    @FindBy(id = "newUser")
    private static WebElement newUserBtn;

    @FindBy(id = "login")
    private static WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void registerAsNewUser() {
        Helper.click(newUserBtn);
    }

    public static void fillInUserName(String userName) {
        Helper.assertElementPresent(userNameField);
        Helper.type(userNameField, userName);
    }

    public static void fillInPassword(String password) {
        Helper.assertElementPresent(passwordField);
        Helper.type(passwordField, password);
    }

    public static void login() {
        Helper.click(loginBtn);
    }

    public static void loginFlow(String userName, String password) {
        fillInPassword(userName);
        fillInPassword(password);
        login();
    }

}
