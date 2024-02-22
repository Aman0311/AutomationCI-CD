package framework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import initializeDriver.baseTest;
import pageObjects.LoginPage;
import pageObjects.cart;
import pageObjects.checkout;
import pageObjects.productCatlogue;

public class errorValidation extends baseTest{

	@Test
	public  void completeOrder() throws InterruptedException, IOException {
		//WebDriver driver = initiailizeDriver();
		LoginPage lg = new LoginPage(driver);
		lg.goTo();
		lg.loginApplication("snow@gfd", "cvdsdfxc");
		Assert.assertEquals("Incorrect email password.", lg.getError());

		//div[@aria-label='Incorrect email or password.']
	}

}
