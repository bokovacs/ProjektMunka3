package steps;

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

    private void openBrowserIfNeeded() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    // ----------------------------------------------------
    // LOGIN + COOKIES + REDIRECT ellenőrzés
    // ----------------------------------------------------

    @Given("the login page is displayed")
    public void the_login_page_is_displayed() {
        openBrowserIfNeeded();

        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                "A login oldal URL-je tartalmazza a /login részt.",
                loginPage.isOnLoginPage()
        );
    }

    // --- OKTATÓ ÁLTAL KÉRT SZÖVEGEK A LOGOUT BACKGROUNDHOZ ---

    @Given("I opened the DBank")
    public void i_opened_the_dbank() {
        openBrowserIfNeeded();
        // LoginPage konstruktora megnyitja a /login oldalt és kezeli a cookie popupot
        loginPage = new LoginPage(driver);
    }

    @Given("I accepted the cookies")
    public void i_accepted_the_cookies() {
        loginPage.acceptCookiesIfPresent();
    }

    // (ez a kettő maradhat, ha más feature-ben használod – nem zavarja a logoutot)
    @Given("the user opens the DigitalBank web")
    public void the_user_opens_the_digitalbank_web() {
        openBrowserIfNeeded();
        loginPage = new LoginPage(driver);
    }

    @Given("accepts cookies")
    public void accepts_cookies() {
        loginPage.acceptCookiesIfPresent();
    }

    @When("logs in with valid username and password")
    public void logs_in_with_valid_username_and_password() {
        bannerPage = loginPage.loginAs("jsmith2", "Demo123!");
    }

    @When("I sign in using {string} and {string}")
    public void i_sign_in_using_and(String username, String password) {
        bannerPage = loginPage.loginAs(username, password);
    }

    @Then("the user is logged in successfully")
    public void the_user_is_logged_in_successfully() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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

    @Then("I am redirected to the home page")
    public void i_am_redirected_to_the_home_page() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
    // LOGOUT
    // ----------------------------------------------------

    @When("I log out")
    public void i_log_out() {
        headerPage = new HeaderPage(driver);
        headerPage.openUserMenu();
        headerPage.clickLogout();
    }

    @Then("a success message is displayed with {string}")
    public void a_success_message_is_displayed_with(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.sufee-alert.alert-success")
                )
        );

        String text = alert.getText().trim();
        Assert.assertTrue(
                "A logout sikerüzenet a várt szöveget hordozza. Várt: "
                        + expectedMessage + ", kapott: " + text,
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

    // ----------------------------------------------------
    // BÖNGÉSZŐ BEZÁRÁSA
    // ----------------------------------------------------

    @Then("the browser is closed")
    public void the_browser_is_closed() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
