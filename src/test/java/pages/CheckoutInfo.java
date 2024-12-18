package pages;

import dto.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfo {

    WebDriver driver;
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");


    public CheckoutInfo(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInfo writeInfo(Customer customer) {
        driver.findElement(firstNameField).sendKeys(customer.getFirstName());
        driver.findElement(lastNameField).sendKeys(customer.getLastName());
        driver.findElement(zipCodeField).sendKeys(customer.getZipCode());
        return this;
    }

    public OverviewPage clickContinue() {
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }
}
