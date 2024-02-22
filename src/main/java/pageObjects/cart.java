package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractPkg.abstractClass;
import dev.failsafe.internal.util.Assert;

public class cart extends abstractClass {

	WebDriver driver;

	public cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProd;

	By checkout = By.xpath("//button[normalize-space()='Checkout']");

	public void validateZara(String name) throws InterruptedException {
		for (int i = 0; i < cartProd.size(); i++) {
			if (cartProd.get(i).getText().equals(name)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				break;
			}
		}
		waitForElementToBeClickable(checkout);
		driver.findElement(checkout).click();
	}
}
