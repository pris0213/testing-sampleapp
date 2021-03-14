package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InsurantFormPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "birthdate")
    private WebElement dobInput;
    @FindBy(id = "country")
    private WebElement countryMenu;
    @FindBy(id = "zipcode")
    private WebElement zipCodeInput;
    @FindBy(id = "occupation")
    private WebElement occupationMenu;
    @FindBy(css = ".idealforms-field-checkbox > p > label:nth-child(3)")
    private WebElement cliffDivingCheckBox;
    @FindBy(id = "nextenterproductdata")
    private WebElement nextBtn;

    public InsurantFormPage(WebDriver webDriver, String title) {
        super(webDriver, title);
        PageFactory.initElements(webDriver, this);
    }

    public void setFirstName(String name) {
        firstNameInput.sendKeys(name);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setDateOfBirth(String dob) {
        dobInput.sendKeys(dob);
    }

    public void pickCountry(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryMenu));
        Select countrySelect = new Select(countryMenu);
        countrySelect.selectByValue(country);
    }

    public void setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void pickOccupation(String occupation) {
        wait.until(ExpectedConditions.visibilityOf(occupationMenu));
        Select occupationSelect = new Select(occupationMenu);
        occupationSelect.selectByValue(occupation);
    }

    public void pickCliffDivingAsAHobby() {
        cliffDivingCheckBox.click();
    }

    public void goToTheNextPage() {
        nextBtn.click();
    }
}
