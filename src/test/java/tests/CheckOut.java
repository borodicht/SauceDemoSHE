package tests;

import dto.Customer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOut extends BaseTest {

    @Test (description = "E2E тест", testName = "Проверка сквозного тестирования")
    @Epic("SD-1")
    @Feature("SD-1.1")
    @Story(("SD-1.1.1"))
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка сквозного тестирования")
    @Link("https://www.saucedemo.com/")
    @Issue("BUG-1")
    @TmsLink("TMS-1")
    @Flaky
    public void checkoutTest() {
        Customer customer = new Customer("Ivan", "Petrov", "123456");
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Onesie")
                .clickToCart()
                .clickCheckoutButton()
                .writeInfo(customer)
                .clickContinue()
                .clickFinish();
        assertEquals(completePage.getFinishMessage(), "Thank you for your order!");
    }
}
