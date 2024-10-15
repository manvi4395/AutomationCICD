package manvisharmaanatomy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import manvisharmaanatomy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3") List<WebElement> itemsInCart;
	@FindBy(css=".totalRow button") WebElement checkoutButton;
	
	public Boolean verifyProductDisplay(String productName) {
		
		
		Boolean matchedItem = itemsInCart.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
		return matchedItem;
	
	}
	
	public UserDetailsForm goToCheckout() {
		
		checkoutButton.click();
		UserDetailsForm userDetailsForm = new UserDetailsForm(driver);	
		return userDetailsForm;
	}

}
