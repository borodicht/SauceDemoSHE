package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
        log.info("Откытие страницы LoginPage");
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Страница LoginPage открыта")
    public LoginPage isPageOpened() {
        log.info("Откытие страницы LoginPage");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        } catch (TimeoutException e) {
            log.error("Страница LoginPage не открылась");
        }
        return this;
    }

    @Step("Вход в систему с данными: '{user}' и '{password}'")
    public void loginNegative(String user, String password) {
        log.info("Вход в систему с данными: '{}' и '{}'", user, password);
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Вход в систему с данными: '{user}' и '{password}'")
    public ProductsPage login(String user, String password) {
        log.info("Вход в систему с данными: '{}' и '{}'", user, password);
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        log.info("Получение сообщения об ошибке");
        return driver.findElement(errorMessage).getText();
    }
}
