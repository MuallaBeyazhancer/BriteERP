package Test.briteERP_1;

import Utilities.BriteERPUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ExpensesManager {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

//          TEST CASE 14
//            1) Navigate to the Application URL
//            2) Click on ""My Expenses"" link
//            3) Click on Expense Reports to Approve link
//            4) Create a Report and send it for approval
//
    @Test (priority = 1)
    public void expensesTC14() throws InterruptedException {
//        1) Navigate to the Application URL

        BriteERPUtils.login(driver, "in_ex_manager5@info.com", "LLighg92");
//        2) Click on ""My Expenses"" link
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expenses')])[1]")).click();
//        3) Click on Expense Reports to Approve link
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expense Reports')])[1]")).click();
        Thread.sleep(2000);
//        4) Create a Report, fill out the form and send it for approval
        driver.findElement(By.cssSelector("button[class='btn btn-primary btn-sm o_list_button_add']")).click();
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //write down "trip to Istanbul" into Title
        driver.findElement(By.cssSelector("input[id='o_field_input_19']")).sendKeys("Trip to Istanbul");
        //select employee
        Thread.sleep(2000);
        driver.findElement(By.id("o_field_input_20")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Ashley Presley']")).click();

//        5) Send it for approval
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class='fa fa-external-link btn btn-default o_external_button'])[1]")).click();



        //    "http://54.148.96.210/web#view_type=list&model=hr.expense.sheet&menu_id=394&action=547

//    username: in_ex_manager5@info.com
//    password: LLighg92"

    }




//          TEST CASE 11
//            1) Navigate to the Application URL
//            2) Navigate to ""My Expenses"" link
//            3) Click on Expense Reports
//            4) Verify My Expense Reports's  title is "My Reports - Odoo" on the page

    @Test (priority =  0)
    public void expenseTC11() throws InterruptedException {
//        1) Navigate to the Application URL

        BriteERPUtils.login(driver, "in_ex_manager5@info.com", "LLighg92");
//        2) Click on ""My Expenses"" link
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expenses')])[1]")).click();
//        3) Click on Expense Reports
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expense Reports')])[1]")).click();
//        4) Verify that page title is My Reports - Odoo
        Thread.sleep(3000);

        String expectedTitle = "My Reports - Odoo";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


    }

}
