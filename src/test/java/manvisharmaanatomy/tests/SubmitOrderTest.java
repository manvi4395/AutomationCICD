package manvisharmaanatomy.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import manvisharmaanatomy.pageobjects.CartPage;
import manvisharmaanatomy.pageobjects.LandingPage;
import manvisharmaanatomy.pageobjects.OrderConfirmationPage;
import manvisharmaanatomy.pageobjects.ProductCatalogue;
import manvisharmaanatomy.pageobjects.UserDetailsForm;
import manvisharmanatomy.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(input.get("product"));
		Thread.sleep(2000);
		CartPage cartPage = productCatalogue.goToCart();

		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		UserDetailsForm userDetailsForm = cartPage.goToCheckout();
		OrderConfirmationPage orderConfirmationPage = userDetailsForm.selectCountryAndPlaceOrder("India");
		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}


	/*
	 * @Test(dependsOnMethods= {"submitOrder"}) public void OrderHistoryTest() {
	 * 
	 * //ZARA COAT 3 ProductCatalogue productCatalogue =
	 * landingPage.loginApplication("anshika@gmail.com", "Iamking@000"); OrderPage
	 * ordersPage = productCatalogue.goToOrdersPage();
	 * Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	 * 
	 * }
	 */
	 

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//manvisharmaanatomy//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
