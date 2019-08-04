package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BriteERPUtils {

    public static void login(WebDriver driver, String username, String password){
        driver.get("http://54.148.96.210/");
        driver.findElement(By.xpath("//b[contains(text(), 'Sign in')]")).click();

        driver.findElement(By.cssSelector("input[id='login']")).sendKeys(username);

        driver.findElement(By.cssSelector("input[id='password']")).
                sendKeys(password+ Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectMenuOption(WebDriver driver, String tab, String module) throws InterruptedException {
        // click on tab
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '"+tab+"')]";
        driver.findElement(By.xpath(tabXpath)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // click on module
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '"+module+"')]";
        driver.findElement(By.xpath(moduleXpath)).click();
        Thread.sleep(2000);
    }



    public static void selectMenuOption(WebDriver driver, String tab) throws InterruptedException {
        // click on tab
        String tabXpath = "//span[@class='oe_menu_text' and contains(text(), '"+tab+"')]";
        //span[@class='oe_menu_text' and contains(text(), 'CRM')]
        driver.findElement(By.xpath(tabXpath)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void waitForUIOverlay(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-mask.shown")));
    }
}
