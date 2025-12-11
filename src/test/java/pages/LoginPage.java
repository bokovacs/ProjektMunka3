package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String LOGIN_URL =
            "https://eng.digitalbank.masterfield.hu/bank/login";

    // Cookie popup "OK" gomb
    @FindBy(css = "button.cc-nb-okagree")
    private WebElement acceptCookiesButton;

    // Mezők és gomb a login oldalon
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);

        // login oldal betöltése
        driver.get(LOGIN_URL);

        // cookie popup kezelése, amint megjelenik
        acceptCookiesIfPresent();

        // login mezők láthatóságának biztosítása
        waitForVisible(usernameField);
        waitForVisible(passwordField);
    }

    // cookie popup elfogadása, ha elérhető
    public void acceptCookiesIfPresent() {
        try {
            waitForClickable(acceptCookiesButton);
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (TimeoutException e) {

        }
    }


    public BannerPage loginAs(String username, String password) {
        waitForClickable(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);

        waitForClickable(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);

        waitForClickable(loginButton);
        loginButton.click();

        return new BannerPage(driver);
    }

    public boolean isOnLoginPage() {
        return getCurrentUrl().contains("/login");
    }

    // Logout sikerüzenet (login oldal)
    @FindBy(css = "div.alert-success")
    private WebElement logoutSuccessMessage;

    public boolean isLogoutSuccessMessageDisplayed(String expectedText) {
        waitForVisible(logoutSuccessMessage);
        return logoutSuccessMessage.getText().contains(expectedText);
    }

}
