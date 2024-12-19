package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginField = By.name("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test=error]");

    @Step("Откытие страницы LoginPage")
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Страница LoginPage открыта")
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return this;
    }

    @Step("Вход в систему с данными: '{user}' и '{password}'")
    public void loginNegative(String user, String password) {
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Вход в систему с данными: '{user}' и '{password}'")
    public ProductsPage login(String user, String password) {
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
