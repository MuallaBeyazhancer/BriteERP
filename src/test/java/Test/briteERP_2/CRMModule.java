package Test.briteERP_2;

import Test.TestBase;
import Utilities.BriteERPUtils;
import Utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRMModule extends TestBase {

    /*
    As a user, when I already created an opportunity in CRM module of Bribe ERP application,
    I want to be able to delete it.

    //ACCAPTANCE CRITERIA 1 :   Verify that user should be able to see the list view.
    //ACCAPTANCE CRITERIA 2 : Verify that user should be able to delete the opportunity from action drop down list .
     */
    @Test
    public void createOpportunities() throws InterruptedException {
        //ACCAPTANCE CRITERIA 1 :   Verify that user should be able to see the list view.
        //Step 1 navigate to BriteERP web page;
//              WebDriverManager.chromedriver().setup();   // I extended the TestBase class
//              driver = new ChromeDriver();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        String username = ConfigurationReader.get("CRM_user_username");         //eventscrmmanager52@info.com
        String password = ConfigurationReader.get("CRM_user_password");         //eventscrmmanager

        BriteERPUtils.login(driver,username, password);

        //Step 2 navigate to CRM page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        BriteERPUtils.selectMenuOption(driver, "CRM");

       // driver.findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(), 'CRM')]")).click();   //span[contains(text(), 'Discuss')]

       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active'][contains(text(), 'Pipeline')]")));   //   //title[text()='Pipeline - Odoo']
        String expPageTitle = "Pipeline - Odoo";
        String actualPageTitle = driver.getTitle();
        System.out.println("expPageTitle = " + expPageTitle);
        System.out.println("actualPageTitle = " + actualPageTitle);

        Assert.assertEquals(expPageTitle, actualPageTitle);

        //Step 3 Verify that you see the LIST VIEW
        //click to list button
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[type=button][aria-label=list]")).click();


        //ACCAPTANCE CRITERIA 2 : Verify that user should be able to delete the opportunity from action drop down list .
        //Step 4 Verify that user Delete

//        Step 4.1 Select the element which will be deleted
        WebElement printerSales = driver.findElement(By.xpath("(//div[@class='o_checkbox']//input[@type='checkbox'])[4]"));
        printerSales.click();
        Thread.sleep(2000);

        //count the counter before delete
        String counterBeforeDelete = driver.findElement(By.cssSelector("span[class=o_pager_limit]")).getText();

        int intcCounterBeforeDelete = Integer.parseInt(counterBeforeDelete);
        System.out.println("intcCounterBeforeDelete = " + intcCounterBeforeDelete);

        //Step 4.2 navigate to Action and click
        driver.findElement(By.xpath("//button[contains(text(), 'Action')]")).click();

        //Step 4.3 navigate to Delete and click
        driver.findElement(By.xpath("//a[@data-index='3']")).click();

//        Step 4.4 click to Ok button
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary'][@type='button']")).click();

//        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        //Step 4.5 count the counter after delete
        Thread.sleep(4000);
        String counterAfterDelete = driver.findElement(By.cssSelector("span[class=o_pager_limit]")).getText();//span[class=o_pager_limit]

        int intCounterAfterDelete = Integer.parseInt(counterAfterDelete);

        System.out.println("intCounterAfterDelete = " + intCounterAfterDelete);
//        Boolean b =false;
//        if (intCounterAfterDelete>intcCounterBeforeDelete){
//            b=true;
//        }else if(intCounterAfterDelete==0){
//            b=true;
//        }

        Assert.assertTrue(intcCounterBeforeDelete > intCounterAfterDelete);
      //  Assert.assertTrue(printerSales.isDisplayed());


    }


}
