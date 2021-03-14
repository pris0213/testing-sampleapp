package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQuotePage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(id = "nextselectpriceoption")
    private WebElement nextBtn;


    public SendQuotePage(WebDriver webDriver, String title) {
        super(webDriver, title);
        PageFactory.initElements(webDriver, this);
    }

}
