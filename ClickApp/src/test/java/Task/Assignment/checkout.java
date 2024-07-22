package Task.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class checkout {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fadeke Adeboye\\Desktop\\quality-assurance\\ClickAppDemo\\ClickApp\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#user-name")).sendKeys("visual_user");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
        Thread.sleep(5000);
        String firstElement = driver.findElement(By.xpath("//a[@id='item_3_title_link']")).getText();
        Assert.assertEquals(firstElement, "Test.allTheThings() T-Shirt (Red)");
        Thread.sleep(2000);
        String secondElement = driver.findElement(By.xpath("//a[@id='item_0_title_link']")).getText();
        Assert.assertEquals(secondElement, "Sauce Labs Bike Light");
        Thread.sleep(2000);
        String thirdElement = driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
        Assert.assertEquals(thirdElement, "Sauce Labs Backpack");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("sally");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("110002");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(2000);
        String ele1 = driver.findElement(By.cssSelector("#item_3_title_link")).getText();
        Assert.assertEquals(firstElement, ele1);
        String ele2 = driver.findElement(By.xpath("//a[(@id='item_0_title_link')]")).getText();
        Assert.assertEquals(secondElement, ele2);
        String ele3 = driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
        Assert.assertEquals(thirdElement, ele3);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        driver.quit();

    }
}