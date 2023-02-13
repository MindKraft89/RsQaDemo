package page_objects;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.WebDriverBase;

public class RegisterPage extends WebDriverBase {

    @FindBy(id = "firstname")
    private static WebElement firstNameField;

    @FindBy(id = "lastname")
    private static WebElement lastNameField;

    @FindBy(id = "userName")
    private static WebElement userNameField;

    @FindBy(id = "password")
    private static WebElement passwordField;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[1]/button")
    private static WebElement registerBtn;
    @FindBy(id = "gotologin")
    private static WebElement backToLoginBtn;
    @FindBy(id = "g-recaptcha")
    private static WebElement captchaCheckBox;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static void fillInFirstName(String firstName) {
        Helper.type(firstNameField, firstName);
    }

    public static void fillInLastName(String lastName) {
        Helper.type(lastNameField, lastName);
    }

    public static void fillInUserName(String userName) {
        Helper.type(userNameField, userName);
    }

    public static void fillInPassword(String password) {
        Helper.type(passwordField, password);
    }

    public static void checkCaptcha() {
        Helper.assertElementPresent(captchaCheckBox);
        Helper.click(captchaCheckBox);
    }

    public static void goBackToLoginPage() {
        Helper.click(backToLoginBtn);
    }
    public static void register() {
        Helper.assertElementPresent(registerBtn);
        Helper.click(registerBtn);
    }

}
