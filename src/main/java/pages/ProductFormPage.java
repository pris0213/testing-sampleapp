package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductFormPage extends BasePage {
    @FindBy(id = "startdate")
    private WebElement startDateInput;
    @FindBy(id = "insurancesum")
    private WebElement insuranceSumMenu;
    @FindBy(id = "damageinsurance")
    private WebElement damageInsuranceMenu;
    @FindBy(id = "meritrating")
    private WebElement meritRatingMenu;
    @FindBy(css = ".idealsteps-wrap > section:nth-child(3) > div:nth-child(5) > p > label:nth-child(1)")
    private WebElement euroProtectionCheckBox;
    @FindBy(id = "courtesycar")
    private WebElement courtesyCarMenu;
    @FindBy(id = "nextselectpriceoption")
    private WebElement nextBtn;

    public ProductFormPage(WebDriver webDriver, String title) {
        super(webDriver, title);
        PageFactory.initElements(webDriver, this);
    }

    public void setStartDateInput(String date) {
        startDateInput.sendKeys(date);
    }

    public void pickInsuranceSum(String sum) {
        wait.until(ExpectedConditions.visibilityOf(insuranceSumMenu));
        Select insuranceSumSelect = new Select(insuranceSumMenu);
        insuranceSumSelect.selectByValue(sum);
    }

    public void pickDamageInsurance(String damageInsurance) {
        wait.until(ExpectedConditions.visibilityOf(damageInsuranceMenu));
        Select damageInsuranceSelect = new Select(damageInsuranceMenu);
        damageInsuranceSelect.selectByValue(damageInsurance);
    }

    public void pickMeritRating(String rate) {
        wait.until(ExpectedConditions.visibilityOf(meritRatingMenu));
        Select meritRatingSelect = new Select(meritRatingMenu);
        meritRatingSelect.selectByValue(rate);
    }

    public void pickEuroProtectionAsAnOptionalProduct() {
        euroProtectionCheckBox.click();
    }

    public void pickCourtesyCar(String choice) {
        wait.until(ExpectedConditions.visibilityOf(courtesyCarMenu));
        Select courtesyCarSelect = new Select(courtesyCarMenu);
        courtesyCarSelect.selectByValue(choice);
    }

    public void goToTheNextPage() {
        nextBtn.click();
    }
}
