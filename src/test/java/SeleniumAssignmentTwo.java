import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SeleniumAssignmentTwo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Handling Drop down list value by index, value. text
        WebElement fruitsDropDown =driver.findElement(By.id("fruits"));
        Select dropDown = new Select(fruitsDropDown);
        dropDown.selectByIndex(1);
        dropDown.selectByValue("banana");
        dropDown.selectByVisibleText("Orange");
        Thread.sleep(3000);
        dropDown.deselectByValue("banana");
        dropDown.deselectByIndex(1);
        dropDown.deselectByVisibleText("Orange");
        //Handling radio button and checkbox
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement radiobutton = driver.findElement(By.cssSelector("input#vfb-7-1"));
        System.out.println("Option1 is selected:" + radiobutton.isSelected());
        radiobutton.click();
        System.out.println("Option1 is selected:" + radiobutton.isSelected());
        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.xpath("//input[@id = 'vfb-6-1']"));
        System.out.println("Checkbox2 is selected:" + checkbox.isSelected());
        checkbox.click();
        System.out.println("Checkbox2 is selected:" + checkbox.isSelected());
        driver.quit();

    }
}
