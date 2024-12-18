package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    WebDriver driver;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFinishMessage() {
        return driver.findElement(By.xpath("//*[@class = 'complete-header']")).getText();
    }
}
