package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver= driver;
    }

    public void launchPage() throws IOException, InterruptedException {
        String root= System.getProperty("user.dir");
        Properties props= new Properties();
        props.load(new FileInputStream(root+"//src//test//resources//data.properties"));
        driver.get(props.getProperty("loginUrl"));
        Thread.sleep(3000);
        String expectedTitle=props.getProperty("title");
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String username= props.getProperty("username");
        String password= props.getProperty("password");
        driver.findElement(By.id("mobileNumberPass")).sendKeys(username);
        driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(password);
        driver.findElement(By.className("submitButton")).click();
        Thread.sleep(34000);
        driver.findElement(By.className("submitButton")).click();
        Thread.sleep(4000);
    }

    public void verifyUsername() throws IOException, InterruptedException {
        String root= System.getProperty("user.dir");
        Properties props= new Properties();
        props.load(new FileInputStream(root+"//src//test//resources//data.properties"));
        String editUrl= props.getProperty("editUrl");
        driver.get(editUrl);
        Thread.sleep(2000);
        String expectedUser= props.getProperty("user");
        String actualUser=driver.findElement(By.xpath("//div[contains(text(),'AKASH MONDAL')]")).getText();
        Assert.assertEquals(expectedUser,actualUser);
    }
}
