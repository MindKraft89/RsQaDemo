package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.*;

import static step_definitions.CucumberHooks.driver;

public class RegisterStepDef {

    public RegisterStepDef() {
        WebDriver driver = CucumberHooks.driver;
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, RegisterPage.class);
        PageFactory.initElements(driver, ProfilePage.class);
    }

    @When("^user registers himself$")
    public void userRegisters() throws InterruptedException {
        LoginPage.registerAsNewUser();
        RegisterPage.fillInFirstName("RS");
        RegisterPage.fillInLastName("QADemo");
        RegisterPage.fillInUserName("RSQA");
        RegisterPage.fillInPassword("RSQADemo1!");
        RegisterPage.checkCaptcha();
        Thread.sleep(15000);
        RegisterPage.register();
        acceptAlert();
    }

    @Then("^he is able to access his profile$")
    public void userIsAbleToAccessHisProfile() {
        ProfilePage.assertUserName("AndyDoe");
    }

    public void acceptAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
    }

}
