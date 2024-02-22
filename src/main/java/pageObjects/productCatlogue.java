package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import abstractPkg.abstractClass;

public class productCatlogue extends abstractClass {
	WebDriver driver;

	public productCatlogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card']")
	List<WebElement> products;
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> zaraInOrders;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orders;

	By prodName = By.xpath("//h5/b");
	By addTocart = By.xpath("//button[contains(text(),' Add To Cart')]");
	By confirmation = By.xpath("//div[@id='toast-container']");

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;

	public List<WebElement> getProducts() {
		return products;
	}

	public void addZaraProduct(String name) {
		for (int k = 0; k < products.size(); k++) {
			try {
				if (products.get(k).findElement(prodName).getText().equals(name)) {
					products.get(k).findElement(addTocart).click();
				}
				break;
			} catch (StaleElementReferenceException e) {
				products = driver.findElements(By.xpath("//div[@class='card']"));
			}
		}
		waitForElementToAppear(confirmation);
		waitForElementToDisappear(confirmation);
		cart.click();
	}
	
	public void moveToOrders()
	{
		orders.click();
	}
	
}
