package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class AddCart {
    WebDriver driver;

    public AddCart(WebDriver driver) {
        this.driver= driver;
    }

    public void addItem() throws InterruptedException, IOException {
        String root= System.getProperty("user.dir");
        Properties props = new Properties();
        FileInputStream fs = new FileInputStream("src//test//resources//data.properties");
        props.load(fs);
        driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys(props.getProperty("search1"));
        driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> I1= allWindows.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!mainWindow.equals(child_window))
            {
                driver.switchTo().window(child_window);
            }}

//        driver.findElement(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]/div[1]/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]")).click();
        String str1=driver.findElement(By.xpath("//*[@id=\"appContent\"]/div/div/div/div/div[1]/div[5]/div[2]")).getText();
        Assert.assertEquals(str1,props.getProperty("check"));


    }

//    public void verifyCart() {
//    }
}
