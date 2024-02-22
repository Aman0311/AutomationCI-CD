package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractPkg.abstractClass;

public class LoginPage extends abstractClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement submit;
	
	By errorMessage=By.xpath("//div[@aria-label='Incorrect email or password.']");

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public void loginApplication(String email, String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
	}
	
	public String getError()
	{
		waitForElementToAppear(errorMessage);
		return driver.findElement(errorMessage).getText();
	}
}
