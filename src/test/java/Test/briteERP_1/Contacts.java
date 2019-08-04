package Test.briteERP_1;

import Utilities.BriteERPUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Contacts {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }

    @Test(priority = 0)
    public void contactTC43() throws InterruptedException {
//1) Navigate to the Application URL
//2)Enter username
//3) Enter password
//4) Click sign in button
        BriteERPUtils.login(driver, "in_manuf_manager5@info.com", "kop98tfgQ72");

//5) Click on ""Contacts"" link
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(), 'Contacts')])[1]")).click();
//6) Select contact name ""RACHEL"
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='oe_kanban_details']/strong[@class='o_kanban_record_title oe_partner_heading']/span[.='&*&*)_( (copy)']")).click();
        Thread.sleep(3000);
//7) Click actions
//        driver.findElement(By.xpath("(//button[@aria-expanded='false'][@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")).click();

        driver.findElement(By.xpath("//div/button[@aria-expanded='false'][@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'][contains(text(), 'Action')]")).click();
        Thread.sleep(2000);
//8) Select delete and click ok botton to delete selected contact"
        //DELETE
        driver.findElement(By.cssSelector("a[data-index='0'][data-section='other']")).click();
        Thread.sleep(2000);

        //OK-1
        driver.findElement(By.xpath(("//button[@class='btn btn-sm btn-primary']/span[text()='Ok']"))).click();      //button[class='btn btn-sm btn-primary']
        Thread.sleep(2000);

        //OK-2
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //pageTitle
        String expectedPAgeTitle = "&*&*)_( (copy) - Odoo";
        String actualPageTitle = driver.getTitle();
       // System.out.println("pageTitle = " + actualPageTitle);

        Assert.assertEquals(expectedPAgeTitle, actualPageTitle);

//        """54.148.96.210
//        username: in_manuf_manager5@info.com
//        password: kop98tfgQ72""
//        Contact name: Aiman"

//

    }
    @Test (priority = 1)
    public void contactTC39() throws InterruptedException {
//            1) Navigate to the Application URL
//            2)Enter username
//            3) Enter password
//            4) Click sign in button
//            5) Click on ""Contacts"" link
        BriteERPUtils.login(driver, "in_manuf_manager5@info.com", "kop98tfgQ72");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(), 'Contacts')])[1]")).click();

//            6) Click ""<"" (back) and  "">"" (forth) arrows
//            located at right top hand corner."
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='fa fa-chevron-left btn btn-icon o_pager_previous']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='fa fa-chevron-right btn btn-icon o_pager_next']")).click();
    }
}
