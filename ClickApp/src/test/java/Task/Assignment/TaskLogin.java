package Task.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskLogin {
    WebDriver Pdriver;

    public TaskLogin(WebDriver driver){
        Pdriver = driver;
        PageFactory.initElements(Pdriver, this);

    }
    @FindBy(css = "#user-name")
    private WebElement username;
    public WebElement  getUsername(){
        return username;

    }
    @FindBy(css = "#password")
    private WebElement password;
    public WebElement  getPassword(){
        return password;

    }

    @FindBy(css = "#login-button")
    private WebElement login;
    public WebElement  getLogin(){
        return login;

    }
}
