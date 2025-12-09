package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private WebDriver driver;


    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");

        private String loginUrl = "https://hun.digitalbank.masterfield.hu/bank/login?";

    // Konstruktor – létrehozza a drivert
    public LoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Login oldal megnyitása
    public void openLoginPage() {
        driver.get(loginUrl);
    }


    }
}
