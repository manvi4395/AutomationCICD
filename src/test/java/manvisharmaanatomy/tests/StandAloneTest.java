package manvisharmaanatomy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import manvisharmaanatomy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String product = "ZARA COAT 3";
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("maan@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Framework@0700");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prodFiltered = products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prodFiltered.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 
		List<WebElement> cartProds = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean matchedItem = cartProds.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(product));
		Assert.assertTrue(matchedItem);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h3"))));
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		
		List<WebElement> DropDownItems = driver.findElements(By.cssSelector(".list-group"));
		WebElement country = DropDownItems.stream().filter(di->di.findElement(By.cssSelector(".list-group button")).getText().equals("India")).findAny().orElse(null);
		country.click();
		

	}

}
