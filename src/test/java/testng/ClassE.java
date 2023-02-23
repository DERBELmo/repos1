package testng;
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

public class ClassE {
	

WebDriver driver;

	
	@BeforeMethod
	public void opensephora  () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get("https://www.sephora.fr/");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//*[@id=\"footer_tc_privacy_button_3\"]")).click();
		Thread.sleep(50);

	}
		
	@Test 
	void comptesephora () throws InterruptedException {
		// click compte
		driver.findElement(By.xpath("//a[@id='customerAuthenticated']//span[@class='header-link-icon']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//a[@id='customerAuthenticated']//span[@class='header-link-icon']//*[name()='svg']")).click();
		// saisir email
		driver.findElement(By.xpath("//input[@id='dwfrm_crmsephoracard_email']")).sendKeys("mohamed.derbel@scub.net");
		
		driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div/div/div[1]/div/form/div/button")).click();
		Thread.sleep(50);
		WebElement r1 = driver.findElement(By.xpath("//*[@id=\"LoyaltyForm\"]/fieldset/div/div/div[2]/label/span"));
		r1.click();
		Thread.sleep(50);
		//confirmer 
		//driver.findElement(By.className("button button-secondary button-confirm-email js-button-confirm-email")).click();
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_lastname\"]")).sendKeys("DERBEL");
		driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_firstname\"]")).sendKeys("mohamed");
		driver.findElement(By.id("dwfrm_profile_login_password")).sendKeys("ABCDe123!");
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset/div[1]/div/div[2]/label/span")).click();
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset/div[6]/div[2]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset/div[9]/div[1]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset/div[9]/div[2]/div/label")).click();
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_customer_subscribePhone']")).sendKeys("0681428761");
		driver.findElement(By.xpath("//input[@name= 'dwfrm_profile_customer_birthdate']")).sendKeys("24/08/1992");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"RegistrationForm\"]/fieldset/div[12]/div/label")).click();
		driver.findElement(By.c("form-row form-row-button js-sticky-block")).click();
		
	}
	
		@Test
		void Assert1 () {
		  
			String title = driver.getTitle();
			
			Assert.assertEquals("-25% SUR UNE SÉLECTION DE PARFUMS DÈS 49€ D'ACHATS", title );
			
			String verifyAssertNull = null;
			assertNull(verifyAssertNull);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertAll();
		
	}
}


