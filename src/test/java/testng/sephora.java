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


public class sephora   {

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


@Test (priority =2)
void co () throws InterruptedException {

	//driver.get("https://www.sephora.fr/idees-cadeaux.html");
	 driver.findElement(By.cssSelector("a[style='--top-category-link-color : #d92282']")).click();
	driver.findElement(By.cssSelector("a[title='Voir tous les produits'] ")).click();
	WebElement element =  driver.findElement(By.cssSelector("label[class='refinement-title'] "));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	driver.findElement(By.cssSelector("label[class='refinement-title'] ")).click();
	
	driver.findElement(By.cssSelector("#secondary > div > div.refinement.category-refinement > ul > li > ul > li:nth-child(8) > a > span ")).click();
	driver.findElement(By.cssSelector("a[class='gtmrefinement empty refinement-item']")).click();
}

@Test (priority =1)
void achat() {

	WebElement ele = driver.findElement(By.cssSelector("#customerAuthenticated >a "));
	Actions action = new Actions(driver);
	action.moveToElement(ele).perform();
}
}
