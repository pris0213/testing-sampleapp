package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InsurantFormPage;
import pages.PricePage;
import pages.ProductFormPage;
import pages.QuotePage;
import pages.VehicleFormPage;

import static constants.QuoteConstants.INSURANT;
import static constants.QuoteConstants.PRICE;
import static constants.QuoteConstants.PRODUCT;
import static constants.QuoteConstants.QUOTE;
import static constants.QuoteConstants.VEHICLE;


public class QuoteSteps {
    public static WebDriver webDriver;
    public static VehicleFormPage vehicleFormPage;
    public static InsurantFormPage insurantFormPage;
    public static ProductFormPage productFormPage;
    public static PricePage pricePage;
    public static QuotePage quotePage;

    @Before("@FirstScenario")
    public static void setUp() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        vehicleFormPage = new VehicleFormPage(webDriver, "Enter Vehicle Data");
        insurantFormPage = new InsurantFormPage(webDriver, "Enter Insurant Data");
        productFormPage = new ProductFormPage(webDriver, "Enter Product Data");
        pricePage = new PricePage(webDriver, "Select Price Option");
        quotePage = new QuotePage(webDriver, "Send Quote");
    }

    @After("@LastScenario")
    public void tearDown() {
        webDriver.close();
    }

    /* Common Steps */
    @Given("User is at the {string} form")
    public void userIsAtPage(String page) {
        if (page.equals(VEHICLE))
            vehicleFormPage.goToVehiclePage();

        assert isAtPage(page);
    }

    @And("User goes to the {string} form")
    public void userGoesToTheNextForm(String page) {
        switch (page) {
            case INSURANT:
                vehicleFormPage.goToTheNextPage();
                break;
            case PRODUCT:
                insurantFormPage.goToTheNextPage();
                break;
            case PRICE:
                productFormPage.goToTheNextPage();
                break;
            case QUOTE:
                pricePage.goToTheNextPage();
                break;
        }
    }

    @Then("User is redirected to the {string} form")
    public void userIsRedirectedToTheNextForm(String page) {
        assert isAtPage(page);
    }

    /* Vehicle Steps */
    @When("User chooses brand {string}")
    public void userChoosesBrand(String brand) {
        vehicleFormPage.pickBrand(brand);
    }

    @And("User chooses the model {string}")
    public void userChoosesTheModel(String model) {
        vehicleFormPage.pickModel(model);
    }

    @And("User chooses the cylinder capacity {string}")
    public void userChoosesTheCylinderCapacity(String capacity) {
        vehicleFormPage.setCylinderCapacity(capacity);
    }

    @And("User enters the engine performance {string}")
    public void userEntersTheEnginePerformance(String performance) {
        vehicleFormPage.setEnginePerformance(performance);
    }

    @And("User enters the date of manufacture {string}")
    public void userEntersTheDateOfManufacture(String date) {
        vehicleFormPage.setDateOfManufacture(date);
    }

    @And("User picks the number of seats {string}")
    public void userPicksTheNumberOfSeats(String quantity) {
        vehicleFormPage.pickNumberOfSeatsMenu(quantity);
    }

    @And("User picks the number of seats for motorcycle {string}")
    public void userPicksTheNumberOfSeatsForMotorcycle(String quantity) {
        vehicleFormPage.pickNumberOfSeatsForMotorcycleMenu(quantity);
    }

    @And("User chooses the fuel type {string}")
    public void userChoosesTheFuelType(String type) {
        vehicleFormPage.pickFuelType(type);
    }

    @And("User enters the payload {string}")
    public void userEntersThePayload(String payload) {
        vehicleFormPage.setPayload(payload);
    }

    @And("User enters the total weight {string}")
    public void userEntersTheTotalWeight(String weight) {
        vehicleFormPage.setTotalWeight(weight);
    }

    @And("User enters the list price {string}")
    public void userEntersTheListPrice(String price) {
        vehicleFormPage.setListPrice(price);
    }

    @And("User enters the annual mileage {string}")
    public void userEntersTheAnnualMileage(String mileage) {
        vehicleFormPage.setAnnualMileage(mileage);
    }

    /* Insurant Steps */
    @When("User enters their first name {string}")
    public void userEntersTheirFirstName(String name) {
        insurantFormPage.setFirstName(name);
    }

    @When("User enters their last name {string}")
    public void userEntersTheirLastName(String lastName) {
        insurantFormPage.setLastName(lastName);
    }

    @And("User enters their date of birth {string}")
    public void userEntersTheirDateOfBirth(String dob) {
        insurantFormPage.setDateOfBirth(dob);
    }

    @And("User picks their country {string}")
    public void userPicksTheirCountry(String country) {
        insurantFormPage.pickCountry(country);
    }

    @And("User enters their zip code {string}")
    public void userEntersTheirZipcode(String zipCode) {
        insurantFormPage.setZipCode(zipCode);
    }

    @And("User enters their occupation {string}")
    public void userEntersTheirOccupation(String occupation) {
        insurantFormPage.pickOccupation(occupation);
    }

    @And("User enters their hobby {string}")
    public void userEntersTheirHobby(String hobby) {
        insurantFormPage.pickCliffDivingAsAHobby();
    }

    /* Product Steps */
    @When("User enters the start date {string}")
    public void userEntersTheStartDate(String startDate) {
        productFormPage.setStartDateInput(startDate);
    }

    @When("User enters the insurance sum {string}")
    public void userEntersTheInsuranceSum(String sum) {
        productFormPage.pickInsuranceSum(sum);
    }

    @And("User picks the merit rating {string}")
    public void userPicksTheMeritRating(String rate) {
        productFormPage.pickMeritRating(rate);
    }

    @And("User enters the damage insurance {string}")
    public void userEntersTheDamageInsurance(String damageInsurance) {
        productFormPage.pickDamageInsurance(damageInsurance);
    }

    @And("User picks an optional product {string}")
    public void userPicksAnOptionalProduct(String optionalProduct) {
        productFormPage.pickEuroProtectionAsAnOptionalProduct();
    }

    @And("User picks if they want a courtesy car {string}")
    public void userPicksIfTheyWantACourtesyCar(String courtesyCar) {
        productFormPage.pickCourtesyCar(courtesyCar);
    }

    /* Price Steps */
    @When("User picks the price option {string}")
    public void userPicksThePriceOption(String price) {
        pricePage.pickGoldPriceOption();
    }

    /* Send Quote Steps */
    @When("User enters their email address {string}")
    public void userEntersTheirEmailAddress(String email) {
        quotePage.setEmailInput(email);

    }

    @And("User enters their username {string}")
    public void userEntersTheirUsername(String username) {
        quotePage.setUsernameInput(username);
    }

    @And("User enters their password {string}")
    public void userEntersTheirPassword(String password) {
        quotePage.setPasswordInput(password);
    }

    @And("User confirms their password {string}")
    public void userConfirmsTheirPassword(String password) {
        quotePage.setConfirmPasswordInput(password);
    }

    @And("User sends the quote")
    public void userSendsTheQuote() {
        quotePage.sendQuote();
    }

    @Then("The message {string} is displayed")
    public void theMessageIsDisplayed(String message) {
        assert quotePage.isMessageDisplayed(message);

    }

    /* Class methods */
    private boolean isAtPage(String page) {
        switch (page) {
            case VEHICLE:
                return vehicleFormPage.isAtPage();
            case INSURANT:
                return insurantFormPage.isAtPage();
            case PRODUCT:
                return productFormPage.isAtPage();
            case PRICE:
                return pricePage.isAtPage();
            case QUOTE:
                return quotePage.isAtPage();
            default:
                return false;
        }
    }
}
