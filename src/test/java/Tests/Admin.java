package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Config;
import Utilities.Driver;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class Admin extends TestBase {

    @Ignore
    @Test
    public void login() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement admin = driver.findElement(By.id("welcome"));
        Assert.assertTrue(admin.isDisplayed());

    }
    @Ignore
    @Test
         public void loginVerification(){
            driver.get("https://opensource-demo.orangehrmlive.com/");

            LoginPage lgn = new LoginPage();
            lgn.login("Admin", "admin123");

            HomePage hmp = new HomePage(driver);
            Assert.assertTrue(hmp.welcome.isDisplayed());

            hmp.welcome.click();
            hmp.aboutLink.click();
            Assert.assertTrue(hmp.companyInfo.getText().contains("OrangeHRM"));

        }

        @Ignore
        @Test
            public void jobTitleVerification(){
            driver.get("https://opensource-demo.orangehrmlive.com/");

            LoginPage lgn = new LoginPage();
            lgn.login("Admin", "admin123");

            HomePage hmp = new HomePage(driver);
            Actions actions = new Actions(driver);
            actions.moveToElement(hmp.performance).perform();
            actions.moveToElement(hmp.configure).perform();
            hmp.kpis.click();
            Select jobTitle = new Select(hmp.jobTitleDropdown);
            List<WebElement> options = jobTitle.getOptions();
            boolean found = false;
            for (WebElement option: options){
                System.out.println(option.getText());
                if (option.getText().contains("CEO")){

                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);
        }
        @Test
            public void negativeLogin(){
            Driver.getDriver().get(Config.getProperty("url"));
            LoginPage lgn = new LoginPage();
            lgn.login(Config.getProperty("username"), "whatever");
            String message = lgn.errorMessage.getText();
            Assert.assertEquals(message, Config.getProperty("message"));


        }

}
