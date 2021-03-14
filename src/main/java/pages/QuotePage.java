package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuotePage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(id = "sendemail")
    private WebElement sendBtn;
    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > h2")
    private WebElement messageText;

    public QuotePage(WebDriver webDriver, String title) {
        super(webDriver, title);
        PageFactory.initElements(webDriver, this);
    }

    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void setUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(String password) {
        confirmPasswordInput.sendKeys(password);
    }

    public void sendQuote() {
        sendBtn.click();
    }

    public boolean isMessageDisplayed(String message) {
        wait.until(ExpectedConditions.visibilityOf(messageText));
        return messageText.getText().equals(message);
    }

}
