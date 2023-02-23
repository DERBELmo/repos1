package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SecondNG{

WebDriver driver ;

  @BeforeClass 
  public void Openweb() {
	  
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://demo.nopcommerce.com/login");
  }
  @Test(dataProvider="dp")
  public void login(String email , String password)  {
	  
      
		driver.manage().window().maximize();
      driver.findElement(By.id("Email")).sendKeys("email");
       driver.findElement(By.id("Password")).sendKeys("password");
       driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
      
       String exp_title = "nopCommerce demo store";
       String actual_title = driver.getTitle();
    		
       Assert.assertEquals(exp_title, actual_title);
  }
  
  @AfterClass
  public void closeapp() {
	  driver.quit();
	  
  }
  
  @DataProvider(name="dp" )  //, indices = {0,2})
 
  String [][] loginData()
  {
	  
  String data [][] = {
			  
			  {"mohamed.derbel@scub.net" , "test123"},
			  {"drbl.medgmail.com" , "test1234"},
			  {"drbl.medgmail.com" , "tes123"},
			  {"drbl.medgmail.com" , "test1234"}
			  
	  };
	  
	  return data;
	  }
  }


