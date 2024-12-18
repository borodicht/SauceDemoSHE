package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;
    By title = By.cssSelector("[data-test=title]");
    By cartLink = By.id("shopping_cart_container");
    String addToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public CartPage clickToCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCart, product))).click();
        return this;
    }
}
