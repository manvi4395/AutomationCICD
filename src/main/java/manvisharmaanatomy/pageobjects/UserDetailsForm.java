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

public class UserDetailsForm extends AbstractComponents {

	WebDriver driver;
	String countryName = "India";

	public UserDetailsForm(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements

	@FindBy(css="[placeholder='Select Country']") WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]") WebElement selectCountry;
	@FindBy(css=".action__submit") WebElement PlaceOrderButton;
	
	//Locators
	By dropDownResultLocator = By.cssSelector(".ta-results");

	public OrderConfirmationPage selectCountryAndPlaceOrder(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(dropDownResultLocator);
		selectCountry.click();
		
		PlaceOrderButton.click();
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		return orderConfirmationPage;
		
	}
	
}
		
	

