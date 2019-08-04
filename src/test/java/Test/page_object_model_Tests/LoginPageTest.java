package Test.page_object_model_Tests;

import Pages.LoginPage;
import Test.TestBase;
import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @BeforeMethod
    public void setUp() {

        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();

    }

    @Test
    public void LoginTest() {

        String username = ConfigurationReader.get("CRM_user_username");
        System.out.println("username = " + username);
        String password = ConfigurationReader.get("CRM_user_password");
        System.out.println("password = " + password);

//        driver.findElement(By.xpath("//b[.='Sign in']")).click();

       LoginPage loginPage = new LoginPage();
//
//        loginPage.login(username, password);


        loginPage.loginBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginButton.click();

        System.out.println(driver.getTitle());

        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.getTitle().contains("Odoo"));


    }

}
