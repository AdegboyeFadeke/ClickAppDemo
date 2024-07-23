package Task.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


 public class TheTest {
     WebDriver driver = null;

     @Test
     public void Tests() throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fadeke Adeboye\\Desktop\\quality-assurance\\ClickAppDemo\\ClickApp\\src\\main\\resources\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.saucedemo.com/");
         Thread.sleep(5000);
         String elementPage2 = driver.getCurrentUrl();
         System.out.println(elementPage2);
         Assert.assertEquals(elementPage2, "https://www.saucedemo.com/");
     }


     @Test
     public void TaskTest() {
         TaskLogin login = new TaskLogin(driver);
         login.getUsername().sendKeys("visual_user");
         login.getPassword().sendKeys("secret_sauce");
         login.getLogin().click();

         TaskCart cart = new TaskCart(driver);
         cart.getBackpack().click();
         cart.getTshirt().click();
         cart.getBike().click();
         cart.getCart().click();
         String tshirt1 = cart.getCheckTshirt().getText();
         String backpack1 = cart.getCheckBackpack().getText();
         String bike1 = cart.getCheckBike().getText();

         TaskCheckout checkout = new TaskCheckout(driver);
         String tshirt = checkout.getCheckTshirt().getText();
         String backpack = checkout.getCheckBackpack().getText();
         String bike = checkout.getCheckBike().getText();
         Assert.assertEquals(tshirt1, tshirt);
         Assert.assertEquals(backpack1, backpack);
         Assert.assertEquals(bike1, bike);
         checkout.getCheckout().click();
         checkout.getCheckoutFirstName().sendKeys("sauce");
         checkout.getCheckoutLastName().sendKeys("secret");
         checkout.getCheckoutPostal().sendKeys("1100005");
         checkout.getCheckoutCont().click();

         TaskFinalCheckout finalCheckout = new TaskFinalCheckout(driver);
         String tshirt2 = finalCheckout.getCheckoutele1().getText();
         String bike2 = finalCheckout.getCheckoutele2().getText();
         String backpack2 = finalCheckout.getCheckoutele3().getText();
         Assert.assertEquals(tshirt2, tshirt);
         Assert.assertEquals(backpack2, backpack);
         Assert.assertEquals(bike2, bike);
         finalCheckout.getCheckoutfinish().click();
         driver.quit();
     }
 }