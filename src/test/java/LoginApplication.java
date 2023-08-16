import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class LoginApplication {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.name("username")).clear();
        WebElement usernameInput = driver.findElement(By.name("username"));
        //System.out.println("username is available:" + usernameInput.isDisplayed());
        usernameInput.sendKeys("Admin");
        driver.findElement(By.name("password")).clear();
        WebElement passwordInput = driver.findElement(By.name("password"));
        //System.out.println("password is available:" + passwordInput.isDisplayed());
        passwordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
        System.out.println("Login Button is selected:" + loginButton.isSelected());
        loginButton.click();
        String expectedPageTitle = "OrangeHRM";
        String actualPageTitle = driver.getTitle();
        if (actualPageTitle.equals(expectedPageTitle)){
            System.out.println("Page title is correct:" + " " + actualPageTitle);
        }
         else {
            System.out.println("Page title is incorrect. Actual page title:" + " " + actualPageTitle);
        }
        driver.quit();

    }
}
