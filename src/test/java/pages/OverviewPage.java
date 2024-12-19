package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на финальную страницу")
    public CompletePage clickFinish() {
        driver.findElement(finishButton).click();
        return new CompletePage(driver);
    }
}
