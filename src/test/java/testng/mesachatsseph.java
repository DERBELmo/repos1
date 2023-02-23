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


public class mesachatsseph {

WebDriver driver;

	
	@BeforeClass
	public void opensephora  () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get("https://www.sephora.fr/");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//*[@id=\"footer_tc_privacy_button_3\"]")).click();
		Thread.sleep(50);


	}

	@Test (priority =1)
	void achat() throws InterruptedException {

		WebElement ele = driver.findElement(By.cssSelector("#customerAuthenticated > span.header-link-text"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(100);
		driver.findElement(By.xpath("/html/body/div[3]/header/div[6]/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/div[2]/a/span[2]")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#primary>div.non-connected-page>div.non-connected-page-btn>a")).click();
		Thread.sleep(50);
		driver.findElement(By.cssSelector("#dwfrm_crmsephoracard_email")).sendKeys("drbl.med@gmail.com");
		
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("Ibrahim2014!");
		driver.findElement(By.cssSelector("#loginSubmit")).click();		
		Thread.sleep(50);
		driver.findElement(By.cssSelector("#primary > div > div.small-12.all-order-details > div.order-history-footer> div.column.text-right.return-process > div. > a:nth-child(1)")).click();	
		
		
	}
	}
	

	
			

