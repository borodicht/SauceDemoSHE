package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInfo clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutInfo(driver);
    }
}
