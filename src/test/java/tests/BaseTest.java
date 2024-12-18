package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutInfo checkoutInfo;
    CompletePage completePage;
    OverviewPage overviewPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutInfo = new CheckoutInfo(driver);
        completePage = new CompletePage(driver);
        overviewPage = new OverviewPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
