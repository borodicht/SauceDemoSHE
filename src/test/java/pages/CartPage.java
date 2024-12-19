package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Переход на страницу CheckoutInfo")
    public CheckoutInfo clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutInfo(driver);
    }
}
