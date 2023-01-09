package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AddCart;
import pageObjects.LoginPage;

import java.io.IOException;

public class AppTest {
    WebDriver driver;
    LoginPage logIn;
    AddCart cart;
    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        String root= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",root+"//src//test//resources//chromedriver.exe");
        driver= new ChromeDriver();
        logIn= new LoginPage(driver);
        cart= new AddCart(driver);
        driver.manage().window().maximize();
        logIn.launchPage();
    }
    @Test
    public void verifyLoginPage() throws IOException, InterruptedException {
//        logIn.launchPage();
        logIn.verifyUsername();
        tearDown();
    }
    @Test
    public void verifyCart() throws IOException, InterruptedException {
//        logIn.launchPage();
        cart.addItem();
//        cart.verifyCart();
//        tearDown();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
