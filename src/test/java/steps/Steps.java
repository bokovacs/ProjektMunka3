package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class Steps {

    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the login page is displayed")
    public void the_login_page_is_displayed() {

        loginPage = new LoginPage(driver);

    }

    @When("I sign in using {string} and {string}")
    public void i_sign_in_using_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I am redirected to the home page")
    public void i_am_redirected_to_the_home_page() {
    }

    @Then("the welcome message is displayed")
    public void the_welcome_message_is_displayed() {
    }

    @Then("the menu items are available")
    public void the_menu_items_are_available() {
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
    }
}
