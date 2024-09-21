package co.uam.automation.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By loginOption = By.linkText("Log in");
    private final By nameofuser = By.id("nameofuser");
    private final By username = By.id("loginusername");
    private final By password = By.id("loginpassword");
    private final By loginButton =
            By.xpath("//button[text()='Log in']");
    private final By addToCartButton =
            By.xpath("//a[text()='Add to cart']");
    private final By cartPage = By.linkText("Cart");
    private final By placeOrderButton =
            By.xpath("//button[text()='Place Order']");
    private final By nameForm = By.id("name");
    private final By countryForm = By.id("country");
    private final By cityForm = By.id("city");
    private final By cardForm = By.id("card");
    private final By monthForm = By.id("month");
    private final By yearForm = By.id("year");
    private final By purchaseButton =
            By.xpath("//button[text()='Purchase']");
    private final By finallyAlert = By.xpath("//h2[text()='Thank you for your purchase!']");
    private final By okButton =
            By.xpath("//button[text()='OK']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password)
            throws InterruptedException {
        click(loginOption);
        Thread.sleep(2000);
        type(username, this.username);
        type(password, this.password);
        click(loginButton);
    }
    public String loginSuccessfulText() {
        return getText(nameofuser);
    }

    private By getProduct(String name){
        return By.xpath("//a[text()='"+name+"']");

    }

    public void addProduct(String name){
        click(getProduct(name));
    }

    public void addToCart() throws InterruptedException {
        click(addToCartButton);
        Thread.sleep(2000);
        clickAlert();
    }

    public void cartPage(){
        click(cartPage);
    }

    public void placeOrder() throws InterruptedException {
        click(placeOrderButton);

    }

    public void form(String nameForm, String countryForm, String cityForm, String cardForm,
                     String monthForm, String yearForm) throws InterruptedException {
        Thread.sleep(1000);
        type(nameForm, this.nameForm);
        type(countryForm, this.countryForm);
        type(cityForm, this.cityForm);
        type(cardForm, this.cardForm);
        type(monthForm, this.monthForm);
        type(yearForm, this.yearForm);
        click(purchaseButton);

    }

    public Boolean popUp(){
        return isDisplayed(finallyAlert);

    }

    public void closedPopUp(){
        click(okButton);
    }

}