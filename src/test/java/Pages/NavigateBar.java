package Pages;

import Test.TestBase;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NavigateBar extends TestBase {

    public NavigateBar(){

        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToMenu(String menuName){
       WebElement menuBar = Driver.get().findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(), '"+menuName+"')]"));
    menuBar.click();

    }


}
