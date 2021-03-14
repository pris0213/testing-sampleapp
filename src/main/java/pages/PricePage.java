package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricePage extends BasePage {
    @FindBy(css = "th.group > label:nth-child(2)")
    private WebElement goldRadioBtn;
    @FindBy(id = "nextsendquote")
    private WebElement nextBtn;

    public PricePage(WebDriver webDriver, String title) {
        super(webDriver, title);
        PageFactory.initElements(webDriver, this);
    }

    public void pickGoldPriceOption() {
        goldRadioBtn.click();
    }

    public void goToTheNextPage() {
        nextBtn.click();
    }
}
