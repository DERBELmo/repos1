package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class connexion {

	WebDriver driver;
	
	
	@BeforeMethod
	public void open2  () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	 driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get("https://askomdch.com/");
			 driver.manage().window().maximize();
					Thread.sleep(50);
					
	}

	
@Test(priority =1)
public void connexion1 () {
	
	driver.findElement(By.xpath("//li[@id='menu-item-1237']//a[@class='menu-link'][normalize-space()='Account']")).click();
	driver.findElement(By.id("username")).sendKeys("drbl.med@gmail.com");
	driver.findElement(By.id("password")).sendKeys("test1234");
	driver.findElement(By.xpath("//button[@name='login']")).click();
}
	@Test(priority =3)
	void lien () {
	driver.getCurrentUrl();
	Assert.assertEquals("https://askomdch.com", "https://askomdch.com");
	}
	
	@Test(priority =2)
	void achatproduit() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
		
		driver.findElement(By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart']")).click();
	     driver.findElement(By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']")).click();
	     Thread.sleep(2000);
        driver.findElement(By.className("cart-container")).click();
			
				driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
				Thread.sleep(1000);
	     driver.findElement(By.id("billing_first_name")).sendKeys("derbel");
	     driver.findElement(By.id("billing_last_name")).sendKeys("Mohamed");
	     
	     
	     driver.findElement(By.className("select2-selection__arrow")).click();
	     WebElement el =  driver.findElement(By.id("select2-billing_country-container"));
	    	     System.out.println(el);

	     Select drpCountry = new Select(el);
	     System.out.println(drpCountry);
	     drpCountry.selectByVisibleText("Tunisia");
	     System.out.println("okkk");
	     //driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).click();
	     
	   
	     
	     //Select drpCountry = new Select(driver.findElement(By.name("woocommerce_checkout_update_totals" )));
	    // drpCountry.selectByVisibleText("Tunisa");
	     
	    // driver.findElement(By.xpath("//input[@role='combobox']")).click();
  	     
  	     driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("38 rue cheverus");
	     driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("France");
	     driver.findElement(By.xpath("//input[@id='billing_state']")).sendKeys("bordeaux");
	     driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys ("3300");
	     driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("drbl.med@gmail.com");
	     
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//button[@id='place_order']")).click();
	     
	   
	}
	   			
	
	
	//@Test(priority =4)
	//void page() {
	
//}

@AfterClass
	
	void clo() {
	
	driver.quit();
}
}