package framework;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class StandAlone {
	public static void main(String[] args) throws InterruptedException 
	{
		String productName = "ZARA COAT 3";
	    System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://rahulshettyacademy.com/client");
	    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("snow@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Aman@0311");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card']")));
		
				List<WebElement> products = driver.findElements(By.xpath("//div[@class='card']"));
				for(int i=0;i<products.size();i++)
				{
					try {
						if(products.get(i).findElement(By.xpath("//h5/b")).getText().equals(productName))
						{
							products.get(i).findElement(By.xpath("//button[contains(text(),' Add To Cart')]")).click();
							break;
						}
					}
					catch(StaleElementReferenceException e)
					{
						products = driver.findElements(By.xpath("//div[@class='card']"));
					}
					
				}
				System.out.println("Pass");
				/*WebElement prod =	products.stream().filter(product->
				product.findElement(By.xpath("//h5/b")).getText().equals(productName)).findFirst().orElse(null);
				prod.findElement(By.xpath("//button[contains(text(),' Add To Cart')]")).click();*/
	        
	}
}
