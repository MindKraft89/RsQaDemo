package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.*;

public class LoginStepDef {

    public LoginStepDef() {
        WebDriver driver = CucumberHooks.driver;
        PageFactory.initElements(driver, DemoHomePage.class);
        PageFactory.initElements(driver, BookStorePage.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, RegisterPage.class);
        PageFactory.initElements(driver, ProfilePage.class);
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        DemoHomePage.goToBookStoreApplication();
        BookStorePage.goToLoginPageByBtn();
    }

    @When("he enters his credentials")
    public void userEntersHisCredentials() {
        LoginPage.fillInUserName("RSQA");
        LoginPage.fillInPassword("RSQADemo1!");
        LoginPage.login();
    }

    @Then("he should be logged in")
    public void userIsLoggedIn() throws InterruptedException {
        ProfilePage.assertUserName("RSQA");
    }

}
