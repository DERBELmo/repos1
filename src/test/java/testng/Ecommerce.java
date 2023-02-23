package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce  {
	WebDriver driver ;
	
	
	@BeforeClass
	public void openApp () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
			driver = (WebDriver) new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 driver.get("https://askomdch.com/");
					Thread.sleep(50);
	}


	@Test (dataProvider="dp")
	public void account(String username , String email, String password) throws InterruptedException {
		
		driver.findElement(By.xpath("//li[@id='menu-item-1237']//a[@class='menu-link'][normalize-space()='Account']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='reg_username']")).sendKeys(username);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		 
		// scroll 
		  js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		driver.findElement(By.name("register")).click();
		
	}

	@DataProvider(name="dp" )  //, indices = {0,2})

	String [][] loginData()
	{
		  
	String data [][] = {
				  
			  {  "mohamed" , "mohamed.derbel@scub.net" , "test123"},
				 {" derbel ","drbl.med@gmail.com" , "test1234"}
			
		  
		 };
		  
		  return data;
	}
	
	
@AfterClass
public void close() {
	driver.quit();
}
	
	


	  
}
