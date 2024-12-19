package pages;

import dto.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfo extends BasePage {

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    public CheckoutInfo(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение информации о покупателе")
    public CheckoutInfo writeInfo(Customer customer) {
        driver.findElement(firstNameField).sendKeys(customer.getFirstName());
        driver.findElement(lastNameField).sendKeys(customer.getLastName());
        driver.findElement(zipCodeField).sendKeys(customer.getZipCode());
        return this;
    }

    @Step ("Переход на страницу OverviewPage")
    public OverviewPage clickContinue() {
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }
}
