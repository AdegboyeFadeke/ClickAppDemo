package Task.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


 public class TheTest {
     WebDriver driver;

     @BeforeTest
     public void Tests() throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fadeke Adeboye\\Desktop\\quality-assurance\\ClickAppDemo\\ClickApp\\src\\main\\resources\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.saucedemo.com/");
         Thread.sleep(5000);
         String elementPage2 = driver.getCurrentUrl();
         System.out.println(elementPage2);
         Assert.assertEquals(elementPage2, "https://www.saucedemo.com/");
     }


     @Test
     public void TaskTest() throws InterruptedException {
         TaskLogin login = new TaskLogin(driver);
         login.getUsername().sendKeys("visual_user");
         login.getPassword().sendKeys("secret_sauce");
         login.getLogin().click();
         Thread.sleep(5000);
         TaskCart cart = new TaskCart(driver);
         cart.getBackpack().click();
         Thread.sleep(2000);
         cart.getTshirt().click();
         Thread.sleep(2000);
         cart.getBike().click();
         Thread.sleep(2000);
         cart.getCart().click();
         Thread.sleep(2000);
         String tshirt1 = cart.getCheckTshirt().getText();
         String backpack1 = cart.getCheckBackpack().getText();
         String bike1 = cart.getCheckBike().getText();
         Thread.sleep(5000);
         TaskCheckout checkout = new TaskCheckout(driver);
         String tshirt = checkout.getCheckTshirt().getText();
         String backpack = checkout.getCheckBackpack().getText();
         String bike = checkout.getCheckBike().getText();
         Assert.assertEquals(tshirt1, tshirt);
         Assert.assertEquals(backpack1, backpack);
         Assert.assertEquals(bike1, bike);
         Thread.sleep(2000);
         checkout.getCheckout().click();
         checkout.getCheckoutFirstName().sendKeys("sauce");
         checkout.getCheckoutLastName().sendKeys("secret");
         checkout.getCheckoutPostal().sendKeys("1100005");
         checkout.getCheckoutCont().click();
         Thread.sleep(5000);
         TaskFinalCheckout finalCheckout = new TaskFinalCheckout(driver);
         String tshirt2 = finalCheckout.getCheckoutele1().getText();
         String bike2 = finalCheckout.getCheckoutele2().getText();
         String backpack2 = finalCheckout.getCheckoutele3().getText();
         Assert.assertEquals(tshirt2, tshirt);
         Assert.assertEquals(backpack2, backpack);
         Assert.assertEquals(bike2, bike);
         Thread.sleep(5000);
         finalCheckout.getCheckoutfinish().click();
         driver.quit();
     }
 }