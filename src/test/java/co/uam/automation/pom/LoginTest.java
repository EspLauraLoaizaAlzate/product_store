package co.uam.automation.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.testng.Assert.*;
public class LoginTest {


    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://www.demoblaze.com/");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);
        assertEquals(loginPage.loginSuccessfulText(),

                "Welcome username");
        loginPage.addProduct("Iphone 6 32gb");
        Thread.sleep(2000);
        loginPage.addToCart();
        Thread.sleep(1000);
        loginPage.cartPage();
        Thread.sleep(500);
        loginPage.placeOrder();
        Thread.sleep(500);
        loginPage.form("Laura", "Colombia", "Manizales", "42424242424242", "Abril", "2024");
        Thread.sleep(500);
        assertEquals(loginPage.popUp(), true);
        Thread.sleep(500);
        loginPage.closedPopUp();
        Thread.sleep(2000);


    }
}
