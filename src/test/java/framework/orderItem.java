package framework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractPkg.abstractClass;
import initializeDriver.baseTest;
import pageObjects.LoginPage;
import pageObjects.cart;
import pageObjects.checkout;
import pageObjects.orders;
import pageObjects.productCatlogue;

public class orderItem extends baseTest {

	@Test(dataProvider= "dataP",retryAnalyzer = initializeDriver.retryMech.class)
	public void completeOrder(HashMap<String, String> input)  throws InterruptedException, IOException {
		String prodName = "ZARA COAT 3";
		// WebDriver driver = initiailizeDriver();
		LoginPage lg = new LoginPage(driver);
		lg.goTo();
		lg.loginApplication(input.get("email"), input.get("password"));

		productCatlogue pr = new productCatlogue(driver);
		pr.getProducts();
		pr.addZaraProduct(prodName);

		cart tr = new cart(driver);
		tr.validateZara(prodName);

		checkout ch = new checkout(driver);
		ch.enterText();
		ch.selectIndia();
		ch.clickPlaceOrder();
		ch.validateThanks();
	}

	@Test(dependsOnMethods = { "completeOrder" })
	public void validateZaraInOrders() {
		LoginPage lg = new LoginPage(driver);
		lg.goTo();
		lg.loginApplication("snow@gmail.com", "Aman@0311");

		productCatlogue pr = new productCatlogue(driver);
		pr.moveToOrders();

		orders or = new orders(driver);
		or.validateZaraInOrders();
	}
	
	@DataProvider
	public Object[][] dataP() throws IOException
	{
		/*HashMap<String, String> map= new HashMap<String, String>();
		map.put("email", "snow@gmail.com");
		map.put("password", "Aman@0311");
		
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("email", "jamie@gmail.com");
		map1.put("password", "Qwertykey@123");*/
		
		
		/*Object[][] obj = new Object[2][2];
		obj[0][0]="snow@gmail.com";
		obj[0][1]="Aman@0311";
		obj[1][0]="jamie@gmail.com";
		obj[1][1]="Qwertykey@123";*/
		
		List<HashMap<String,String>>data =readJsonData("C:\\Users\\kumar.b.aman\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\DataPkg\\purchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
