package manvisharmaanatomy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import manvisharmaanatomy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3") List<WebElement> products;
	@FindBy(css="[routerlink*='cart']") WebElement cartButton;
	
	
	By productsByLocator = By.cssSelector(".mb-3");
	By addToCartLocator = By.cssSelector(".card-body button:last-of-type");
	By toastMessageLocator = By.cssSelector("#toast-container");

	
	//getting list of all  & storing WE of all of them into 'products' list
	public List<WebElement> getProductsList() {
		
		waitForElementToAppear(productsByLocator);
		return products;	
	}
	
	//getting desired product from the list by filtering & storing the WE of product into prodFiltered
	public WebElement getProductByName(String productName) {
		
		WebElement itemToBeAdded = getProductsList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return itemToBeAdded;
		
	}
	
	//adding the selected item into cart
	public void addProductToCart(String productName) {
		
		WebElement itemToBeAdded = getProductByName(productName);
		itemToBeAdded.findElement(addToCartLocator).click();
		waitForElementToAppear(toastMessageLocator);
	}
	
	public CartPage goToCart() {
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	
	
	
}
