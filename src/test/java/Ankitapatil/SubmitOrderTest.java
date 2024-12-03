package Ankitapatil;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Ankitapatil.pageobjects.CartPage;
import Ankitapatil.pageobjects.CheckoutPage;
import Ankitapatil.pageobjects.ConfirmationPage;
import Ankitapatil.pageobjects.LandingPage;
import Ankitapatil.pageobjects.ProductCatlogue;
import io.github.bonigarcia.wdm.WebDriverManager;



public class SubmitOrderTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		 LandingPage  landingpage=new LandingPage(driver);
		 landingpage.goTo();
		 ProductCatlogue  Productcatlogue=landingpage.loginApplication("ankita378patil@gmail.com", "ankita378");
		 
		 List<WebElement>products=Productcatlogue.getproductList();
		 Productcatlogue.addProductToCart(productName);
		 CartPage cartpage= Productcatlogue.goToCartPage();
		 Boolean match=cartpage.VerifyProductDisplay(productName);
		 Assert.assertTrue( match);
		 
		 CheckoutPage checkoutPage=cartpage.goToCheckout();
		 checkoutPage.selectCountry("india");
		
		 ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		 String confirmesssage=confirmationPage.getconfirmationmessage();
	        Assert.assertTrue(confirmesssage.equalsIgnoreCase("Thankyou for the order."));

		// JavascriptExecutor js = (JavascriptExecutor) driver;
	     //   js.executeScript("window.scrollBy(0,500);");
    }

}
