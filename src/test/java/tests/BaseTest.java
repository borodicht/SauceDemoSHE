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
    String user = System.getProperty("user", utils.PropertyReader.getProperty("user"));
    String password = System.getProperty("password", utils.PropertyReader.getProperty("password"));

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutInfo = new CheckoutInfo(driver);
        completePage = new CompletePage(driver);
        overviewPage = new OverviewPage(driver);
        cartPage = new CartPage(driver);

        System.out.println(System.getProperty("user"));
        System.out.println(System.getProperty("password"));

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
