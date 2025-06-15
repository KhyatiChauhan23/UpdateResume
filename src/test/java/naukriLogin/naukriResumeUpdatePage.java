package naukriLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;
import java.net.URISyntaxException;
import java.time.Duration;

public class naukriResumeUpdatePage {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = webDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Test
    public void uploadResumeTest() throws URISyntaxException, InterruptedException {
        // Navigate to profile page
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/mnjuser/profile']")));
        element.click();

        // Click on Resume tab
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Resume']")));
        element.click();

        // Load resume file
        ClassLoader classLoader = naukriResumeUpdatePage.class.getClassLoader();
        URL resource = classLoader.getResource("resources/Khyati_Chauhan_Resume.pdf");

        if (resource == null) {
            throw new IllegalArgumentException("Resume file not found in resources!");
        }

        File file = new File(resource.toURI());
        String absolutePath = file.getAbsolutePath();

        // Upload the resume
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        fileInput.sendKeys(absolutePath);

        // Wait briefly to observe the result
        Thread.sleep(1000);

        System.out.println("Resume uploaded successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
