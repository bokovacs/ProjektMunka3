package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    // Avatar ikon (jobb felső sarok)
    @FindBy(css = "img.user-avatar")
    private WebElement avatarIcon;

    // Profil menü dropdown (logout ebben jelenik meg)
    @FindBy(css = "div.user-menu.dropdown-menu")
    private WebElement userMenuDropdown;

    // Logout link
    @FindBy(css = "a[href='/bank/logout']")
    private WebElement logoutLink;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAvatarVisible() {
        waitForVisible(avatarIcon);
        return avatarIcon.isDisplayed();
    }

    public void openUserMenu() {
        waitForClickable(avatarIcon);
        avatarIcon.click();
        waitForVisible(userMenuDropdown);
    }

    public void clickLogout() {
        waitForClickable(logoutLink);
        logoutLink.click();
    }
}
