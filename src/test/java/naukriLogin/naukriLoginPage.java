package naukriLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class naukriLoginPage extends webDriverManager{

    @Test
    public void uploadResumeTest() throws InterruptedException {

    	WebDriver driver = webDriverManager.getDriver();
        driver.get("https://www.naukri.com/");
        System.out.println("Title: " + driver.getTitle());

        try {
            driver.findElement(By.xpath("//*[text()='Got it']")).click();
        } catch (Exception e) {
        }

        driver.findElement(By.xpath("//a[@id='login_Layer']")).click();

        String username = System.getenv("naukri_username");
        String password = System.getenv("naukri_password");
        System.out.println("Username is: " + username);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'Email ID / Username')]")));

        element.sendKeys(username);
        driver.findElement(By.xpath("//input[contains(@placeholder,'password')]")).sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Logged In Successfully");

    }
}
