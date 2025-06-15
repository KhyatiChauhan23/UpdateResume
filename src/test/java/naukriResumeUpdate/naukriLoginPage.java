package naukriResumeUpdate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class naukriLoginPage {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.naukri.com/");
		System.out.println("Title: " + driver.getTitle());
		
		try {
		driver.findElement(By.xpath("//*[text()='Got it']")).click();
		}
		catch(Exception e)
		{
		}
		
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		
		String username = System.getenv("naukri_username");
		String password = System.getenv("naukri_password");
		System.out.println("Username is: "+ username);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'Email ID / Username')]")));	
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID / Username')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@placeholder,'password')]")).sendKeys(password);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("Logged In Successfully");
	}

}
