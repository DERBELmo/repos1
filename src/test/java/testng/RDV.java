package testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class RDV {

WebDriver driver;


	@BeforeClass
	public void opensephora  () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get("https://www.sephora.fr/");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//*[@id=\"footer_tc_privacy_button_3\"]")).click();
		Thread.sleep(1000);

	}
	@Test
void Rendezvous() throws InterruptedException  {
	 // mouse hover
	Thread.sleep (1000); 
	WebElement ele = driver.findElement(By.cssSelector("#header-item-storelocator>div.header-link-wrapper>a"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).perform();
	
	
    driver.findElement(By.cssSelector("#header-item-storelocator>div>div>div>div>a.button.button-secondary"));

// scroll 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
	
	driver.findElement(By.cssSelector("button[class='mybutton']")).click();
	
	
	
}
}