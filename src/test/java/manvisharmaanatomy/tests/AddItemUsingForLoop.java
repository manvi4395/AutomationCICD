package manvisharmaanatomy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddItemUsingForLoop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("maan@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Framework@0700");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		
		for(int i=0; i<products.size();i++) {
		
			WebElement item = products.get(i);
			List<WebElement> finalItem = item.findElements(By.cssSelector("b"));
			
			if(finalItem.equals("ZARA COAT 3")) {
				
				
				
				
			}
		}

	}

}
