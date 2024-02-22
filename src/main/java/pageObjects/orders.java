package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractPkg.abstractClass;

public class orders extends abstractClass{
	WebDriver driver;
	public orders(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> zaraInOrders;
	
	public void validateZaraInOrders()
	{
		for(int i=0;i<zaraInOrders.size();i++)
		{
			try
			{
				if(zaraInOrders.get(i).getText().contains("ZARA"))
				{
					Assert.assertTrue(true);
					break;
				}
			}
			catch(StaleElementReferenceException e)
			{
				zaraInOrders=driver.findElements(By.xpath("//tbody/tr/td[2]"));
			}
		}
	}

}
