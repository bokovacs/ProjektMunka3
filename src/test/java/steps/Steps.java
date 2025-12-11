package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.BannerPage;
import pages.HeaderPage;

import java.time.Duration;

public class Steps {

    private static WebDriver driver;

    private LoginPage loginPage;
    private BannerPage bannerPage;
    private HeaderPage headerPage;

    @Before
    public void setup() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void teardown(Scenario scenario) {
        // A böngésző bezárása a logout scenarió után
        if (scenario.getName().contains("Sikeres kijelentkezés")) {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

    // ----------------------------------------------------
    // US01 – Bejelentkezés érvényes adatokkal
    // ----------------------------------------------------

    @Given("the login page is displayed")
    public void the_login_page_is_displayed() {
        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                "A login oldal URL-je tartalmazza a /login részt.",
                loginPage.isOnLoginPage()
        );
    }

    @When("I sign in using {string} and {string}")
    public void i_sign_in_using_and(String username, String password) {
        bannerPage = loginPage.loginAs(username, password);
    }

    @Then("I am redirected to the home page")
    public void i_am_redirected_to_the_home_page() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Dashboard title megjelenése
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("page-title"))
        );

        String text = title.getText().trim();

        Assert.assertEquals(
                "Sikeres bejelentkezés után a főoldal címe 'Dashboard'.",
                "Dashboard",
                text
        );
    }

    // ----------------------------------------------------
    // US05 – Biztonságos kijelentkezés
    // ----------------------------------------------------

    @Given("the profile avatar is visible in the header")
    public void the_profile_avatar_is_visible_in_the_header() {
        headerPage = new HeaderPage(driver);

        Assert.assertTrue(
                "Az avatar ikon elérhető a fejlécben.",
                headerPage.isAvatarVisible()
        );
    }

    @When("I open the profile menu from the avatar")
    public void i_open_the_profile_menu_from_the_avatar() {
        headerPage.openUserMenu();
    }

    @When("I click the logout option")
    public void i_click_the_logout_option() {
        headerPage.clickLogout();
    }

    @Then("a success message is displayed with {string}")
    public void a_success_message_is_displayed_with(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        var alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.sufee-alert.alert-success")
                )
        );

        String text = alert.getText().trim();
        Assert.assertTrue(
                "A logout sikerüzenet a várt szöveget hordozza. Várt: " + expectedMessage + ", kapott: " + text,
                text.contains(expectedMessage)
        );
    }

    @Then("I am redirected to the login page")
    public void i_am_redirected_to_the_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(
                "A kijelentkezés után a login oldal URL-je aktív.",
                driver.getCurrentUrl().contains("/login")
        );
    }

}
