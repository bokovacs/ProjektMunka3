package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String LOGIN_URL =
            "https://eng.digitalbank.masterfield.hu/bank/login";

    // Mezők és gomb a login oldalon
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    // Lokátorok a főoldali ellenőrzéshez
    @FindBy(xpath = "//span[contains(text(),'Üdvözöljük')]")
    private WebElement welcomeMessage;

    @FindBy(css = "ul.sidebar-menu")
    private WebElement sideMenu;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(LOGIN_URL);
    }

    public void login(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
