package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(id = "txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginbtn;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    public void login(String usernameText, String passwordText){
        username.sendKeys(usernameText);
        password.sendKeys(passwordText);
        loginbtn.click();
    }



}
