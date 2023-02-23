package testng;
import java.time.Duration;

import org.openqa.selenium.By;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SCUB {
	

WebDriver driver;
	
	
	@BeforeMethod
	public void op  () throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
	driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get("https://www.scub.net/");
			 driver.manage().window().maximize();
		Thread.sleep(50);

	}	
			 
  
		@Test
		   public void title () throws InterruptedException {
			  	  			       
    	Assert.assertEquals("La performance nous guide dans l'excellence de nos résultats"  ,"La performance nous guide dans l'excellence de nos résultats");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	Thread.sleep(1000);
			}
			
		@Test(priority =3)
		public void move() throws InterruptedException {
			
			driver.findElement(By.xpath("//a[@class='text-white underline-scub font-medium text-base'][normalize-space()='Découvrir SCUB']")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[@class='text-white astro-DUZZ7GSX text-center bg-scub-default border border-transparent font-medium hover:bg-scub-darker inline-block mt-6 px-8 py-3 rounded-md sm:w-auto w-full']")).click();
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@id=\"cconsent-bar\"]/div/div[2]/div/button[2]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[8]/a")).click();
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,1000)");
		
			driver.findElement(By.xpath("//p[normalize-space()='Testing']")).click();
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,1000)");
			
								driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/a")).click();
								js.executeScript("window.scrollBy(0,1000)");
								Thread.sleep(5000);
								
								 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/a")).click();
						
								 js.executeScript("window.scrollBy(0,1000)");
								Thread.sleep(5000);
								
								driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/a")).click();
								Thread.sleep(5000);
								
								  //Find element by link text and store in variable "Element"        		
						       // WebElement Element = driver.findElement(By.linkText("Linux"));

						        //This will scroll the page till the element is found		
						       // js.executeScript("arguments[0].scrollIntoView();", Element);
		}
		
		@Test(priority=2)
		void inscri () throws InterruptedException {
			
			//click boutton by javadcript
			WebElement element = driver.findElement(By.xpath("/html/body/header/nav/ul/li[6]/a/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
				Thread.sleep(5000);
			driver.findElement(By.name("nom")).sendKeys("DERBEL");
			driver.findElement(By.name("prenom")).sendKeys("Mohamed");
			driver.findElement(By.name("email")).sendKeys("mohamed.derbel@scub.net");
			driver.findElement(By.name("entreprise")).sendKeys("SCUB");
			
			//liste deroulante 
			WebElement elem = driver.findElement(By.name("motif[]"));
			new Select(elem).selectByVisibleText("Pôle Testing");
			
			driver.findElement(By.name("message")).sendKeys("hELLO Scub");
			Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@id=\"cconsent-bar\"]/div/div[2]/div/button[2]")).click();
			 
			driver.findElement(By.xpath("//button[@id='send']")).click();
			// scroll 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(4000);	
	
			Assert.assertEquals("Message envoyée", "Message envoyé");
			}
		


		@Test (dataProvider="dp")
		void JOB  (String Nom  , String email, String linkedin)  throws InterruptedException {
			
			driver.findElement(By.xpath("//a[@class='text-white underline-scub font-medium text-base'][normalize-space()='Jobs']")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			  WebElement Element = driver.findElement(By.xpath("//p[normalize-space()='Ingénieur QA H/F']"));
			  js.executeScript("arguments[0].scrollIntoView();", Element);
			  Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//p[normalize-space()='Ingénieur QA H/F']")).click(); 
			  WebElement Element1 = driver.findElement(By.xpath("//input[@placeholder='Nom complet']"));
			  js.executeScript("arguments[0].scrollIntoView();", Element1);
			  
			  Thread.sleep(4000);
			  
			  driver.findElement(By.name("fullName")).sendKeys("Nom");
			  driver.findElement(By.name("email")).sendKeys("email");
			  driver.findElement(By.xpath("//*[@id=\"company-website\"]")).sendKeys("Linkedin");
			  
			 // zoom
			//  executor.executeScript("document.body.style.zoom = '1.5'");
		}
		
		  @DataProvider(name="dp" )  //, indices = {0,2})
		  
		  String [][] JOBData()
		  {
			  
		  String data [][] = {
					  
					  {"mohamed derbel " , "drbl.med@gmail.com", "www.linkedin.com"},
				
		 
			  };
			  
			  return data;
			  }



@Test(priority=4)
 public void veriftitle () {
	String title = driver.getTitle();
	
Assert.assertEquals("Testing", title );
}
		
   @AfterClass
	   public void closeapp() {
	   driver.quit();
			    	  
			      }
}