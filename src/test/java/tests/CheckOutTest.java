package tests;

import dto.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        Customer customer = new Customer("Ivan", "Petrov", "123456");

        loginPage.open()
                .login("standard_user", "secret_sauce")
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
