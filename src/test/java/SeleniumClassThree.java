import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.lang.Thread;
import java.lang.InterruptedException;
public class SeleniumClassThree {
        public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
       // driver.get("https://demoqa.com/alerts");
        driver.get("https://demoqa.com/links");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement alert = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        alert.click();
        Thread.sleep(100);
        driver.switchTo().alert().dismiss();
        Thread.sleep(100);
        System.out.println("Alert cancelled successfully");
        driver.findElement(By.partialLinkText("Ho")).click();

    }
}