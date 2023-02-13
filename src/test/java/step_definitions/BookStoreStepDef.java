package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.BookStorePage;
import page_objects.DemoHomePage;
import page_objects.LoginPage;
import page_objects.ProfilePage;

public class BookStoreStepDef {

    public BookStoreStepDef() {
        WebDriver driver = CucumberHooks.driver;
        PageFactory.initElements(driver, DemoHomePage.class);
        PageFactory.initElements(driver, BookStorePage.class);
        PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^a user has no login yet$")
    public void userHasNoLogin() {
        DemoHomePage.goToBookStoreApplication();
        BookStorePage.goToLoginPageByBtn();
    }

    @Given("user is logged in")
    public void UserIsLoggedIn() {
        DemoHomePage.goToBookStoreApplication();
        BookStorePage.goToLoginPageByBtn();
        LoginPage.loginFlow("RSQA", "RSQADemo1!");
    }

    @When("user searches for book {string}")
    public void UserSearchesForBook(String bookToSearch) {
        ProfilePage.goBackToBookStore();
        BookStorePage.fillInSearchBox(bookToSearch);
        BookStorePage.clickGitPocketGuideBook();
    }

    @Then("he can add this to his record")
    public void addBookToRecord() {
        BookStorePage.addNewBook();
        //User not authorized yet..
    }

}
