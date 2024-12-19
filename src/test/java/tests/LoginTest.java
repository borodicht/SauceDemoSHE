package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkNegativeLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.loginNegative("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.loginNegative("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkNegativeLogin() {
        loginPage.open();
        loginPage.loginNegative("standard_user", "12345678");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }
}
