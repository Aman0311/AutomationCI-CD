package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import abstractPkg.abstractClass;

public class checkout extends abstractClass {
	WebDriver driver;

	public checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountryDrpDwn;

	@FindBy(xpath = "(//span[contains(text(),'India')])[2]")
	WebElement selectCountry;

	By placeOrder = By.xpath("//a[normalize-space()='Place Order']");

	@FindBy(xpath = "//h1[normalize-space()='Thankyou for the order.']")
	WebElement thanksText;

	public void enterText() {
		selectCountryDrpDwn.sendKeys("Ind");
	}

	public void selectIndia() {
		selectCountry.click();
	}

	public void clickPlaceOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		waitForElementToBeClickable(placeOrder);
		driver.findElement(placeOrder).click();
	}

	public void validateThanks() {
		Assert.assertEquals(thanksText.getText(), "THANKYOU FOR THE ORDER.");
	}
}
