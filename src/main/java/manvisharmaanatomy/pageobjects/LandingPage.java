package manvisharmaanatomy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manvisharmaanatomy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	//Page Factory design 
	//driver.findElement(By.id("userEmail"))
	
	@FindBy(id="userEmail") WebElement userName;
	
	@FindBy(id="userPassword") WebElement password;
	
	@FindBy(id="login") WebElement submitButton;
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApplication(String userEmail, String userPaswd) {
		
		userName.sendKeys(userEmail);
		password.sendKeys(userPaswd);
		submitButton.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	
	

}
