package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    By title = By.cssSelector("[data-test=title]");
    By cartLink = By.id("shopping_cart_container");
    String addToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Страница ProductsPage открыта")
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(title).isDisplayed();
        return this;
    }

    @Step("Переход в корзину")
    public CartPage clickToCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    @Step("Добавление товара {product} в корзину")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCart, product))).click();
        return this;
    }
}
