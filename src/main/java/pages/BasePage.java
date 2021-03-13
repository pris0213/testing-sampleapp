package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver webDriver;
    public WebDriverWait wait;
    public String title;

    public BasePage(WebDriver webDriver, String title) {
        this.webDriver = webDriver;
        this.title = title;
        wait = new WebDriverWait(webDriver, 10);
    }

    public boolean isAtPage() {
        return webDriver.getTitle().equals(title);
    }
}
