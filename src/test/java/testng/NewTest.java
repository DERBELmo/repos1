package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class NewTest{

WebDriver driver ;

  @BeforeClass 
  public void Openweb() throws InterruptedException {
	  
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
  }
  @Test
  public void login() {
	
      driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
       driver.findElement(By.name("password")).sendKeys("admin123");
       driver.findElement(By.xpath("//button[@type='submit']")).click();
      
  }
  
  @AfterClass
  public void closeapp() {
	  driver.quit();
	  
  }
}