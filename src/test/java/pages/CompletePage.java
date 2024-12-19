package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public String getFinishMessage() {
        return driver.findElement(By.xpath("//*[@class = 'complete-header']")).getText();
    }
}
