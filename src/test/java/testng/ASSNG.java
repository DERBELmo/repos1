package testng;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class ASSNG{

WebDriver driver ;

  @BeforeClass 
  public void openbrowser() throws InterruptedException {
	  
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(10);
  }
  @Test(priority=1)
   void logo()  
  {
   WebElement logo=driver.findElement(By.xpath("img[alt='company-branding']"));
    Assert.assertTrue(logo.isDisplayed());	
  Assert.fail();
  }
  

  @Test(priority=2)
  public void testhomepagetite()
  {
	String title= driver.getTitle();
	
	Assert.assertEquals( "OrangeHRM", title);
  }
  	
@AfterClass
  public void closeapp() {
	  driver.quit();
	  
  }
  
}


