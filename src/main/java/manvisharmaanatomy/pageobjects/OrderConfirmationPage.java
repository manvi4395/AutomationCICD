package manvisharmaanatomy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import manvisharmaanatomy.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents {
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement
	@FindBy(css=".hero-primary") WebElement orderConfirmation;
	
	
	public String getConfirmationMessage() {
		
		return orderConfirmation.getText();
		
	}
	

}
