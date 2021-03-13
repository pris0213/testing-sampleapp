package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.QuoteConstants.QUOTE_URL;

public class VehicleFormPage extends BasePage {
    @FindBy(id = "make")
    private WebElement makeMenu;
    @FindBy(id = "engineperformance")
    private WebElement enginePerformanceInput;
    @FindBy(id = "dateofmanufacture")
    private WebElement dateOfManufactureInput;
    @FindBy(id = "numberofseats")
    private WebElement numberOfSeatsMenu;
    @FindBy(id = "righthanddriveyes")
    private WebElement rightHandDriverYesRadioBtn;
    @FindBy(id = "righthanddriveno")
    private WebElement rightHandDriverNoRadioBtn;
    @FindBy(id = "fuel")
    private WebElement fuelMenu;
    @FindBy(id = "payload")
    private WebElement payloadInput;
    @FindBy(id = "totalweight")
    private WebElement totalWeightInput;
    @FindBy(id = "listprice")
    private WebElement listPriceInput;
    @FindBy(id = "licenseplatenumber")
    private WebElement licensePlateNumberInput;
    @FindBy(id = "annualmileage")
    private WebElement annualMileageInput;
    @FindBy(id = "nextenterinsurantdata")
    private WebElement nextBtn;

    public VehicleFormPage(WebDriver webDriver, String title) {
        super(webDriver, title);
        wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public void goToVehiclePage() {
        webDriver.get(QUOTE_URL);
    }

    public void pickBrand(String brand) {
        wait.until(ExpectedConditions.visibilityOf(makeMenu));
        Select makeSelect = new Select(makeMenu);
        makeSelect.selectByValue(brand);
    }

    public void goToTheNextPage() {
        nextBtn.click();
    }
}
