package Demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		String homepage = "https://www.bobbibrown.co.uk/";
		String spp1 = "https://www.bobbibrown.co.uk/product/14358/7485/best-sellers/vitamin-enriched-face-base";
		String cart= "https://www.bobbibrown.co.uk/checkout/viewcart.tmpl";
	
	
		driver.get(homepage);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(spp1);
		
		
//		driver.findElement(By.linkText("BESTSELLERS")).click();
		
//		driver.findElement(By.linkText("Vitamin Enriched Face Base")).click();
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test-id=\"add-to-cart\" and @data-sku-base-id=\"17621\" ]")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
			

		//driver.findElement(By.xpath("//a[@data-test-id=\"add-to-cart\" and @data-sku-base-id=\"17621\" ]")).click();
		Thread.sleep(1000);
		driver.get(cart);
		
		driver.findElement(By.xpath("//a[@data-test-id=\"cart_primarycheckout\"]")).click();
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_checkout_samples_continue_no_samples\"]")).click();
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_signin_new_user_email\"]")).sendKeys("cssqa1229+gst@gmail.com");
		/*
		 * WebDriverWait wait1 = new WebDriverWait(driver,30); WebElement element1 =
		 * wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@data-test-id=\\\"form_checkout_signin_new_user_submit\\")));
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].click()", element1)
		 ;*/
			
		
		//driver.findElement(By.xpath("//input[@data-test-id=\"form_checkout_signin_new_user_submit\"]")).click();
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_address_search_zipcode\"]")).sendKeys("po144fl");
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_address_search_submit\"]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_address_firstname\" and @placeholder = \"*First Name\"]")).sendKeys("Tester");
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_address_lastname\" and @placeholder = \"*Last Name\"]")).sendKeys("QAAA");
		
		driver.findElement(By.xpath("//input[@data-test-id=\"form_checkout_shipping_panel_continue\"]")).click();
		
		System.out.println("Test case passed till payment page");
		
				

	}

}
