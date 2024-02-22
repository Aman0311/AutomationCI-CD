package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import initializeDriver.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.cart;
import pageObjects.checkout;
import pageObjects.productCatlogue;

public class stepDefImplementation extends baseTest {
	WebDriver driver;
	LoginPage lg;
	checkout ch;
	cart tr;
	@Given("I land on ecommerce website")
	public void i_land_on_ecommerce_website() throws IOException {
		driver = initiailizeDriver();
		lg = new LoginPage(driver);
		lg = new LoginPage(driver);
		lg.goTo();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_usPass(String usName, String password) {
		lg.loginApplication(usName, password);
	}

	@When("^Add product (.+) to cart$")
	public void add_product_to_cart(String prodName) {
		productCatlogue pr = new productCatlogue(driver);
		pr.getProducts();
		pr.addZaraProduct(prodName);
	}
	
	@When("^check product(.+) in cart and checkout$")
	public void check_product_and_checkout(String prodName) throws InterruptedException
	{
		tr = new cart(driver);
		tr.validateZara(prodName);
		ch = new checkout(driver);
		ch.enterText();
		ch.selectIndia();
		ch.clickPlaceOrder();
	}
	
	@Then("Verify the success message appears or not")
	public void message_displayed() throws Exception
	{
		Thread.sleep(10000);
		ch.validateThanks();
		driver.close();;
	}
	@Then("^(.+) message is displayed$")
	public void incorrect_message_displayed(String str)
	{
		Assert.assertEquals(str, lg.getError());
		driver.close();
	}
}
