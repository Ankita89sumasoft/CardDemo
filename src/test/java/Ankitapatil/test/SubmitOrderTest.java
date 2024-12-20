package Ankitapatil.test;

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
		String productName="ZARA COAT 3";  // Product to be added to the cart
		WebDriverManager.chromedriver().setup(); // Setup ChromeDriver using WebDriverManager
		WebDriver driver=new ChromeDriver();  // Initialize ChromeDriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
		//driver.get("https://rahulshettyacademy.com/client");
		 driver.manage().window().maximize();  // Maximize the browser window
		 
		 
			 
	/*-------------------------------------Landing_page ---------------------------------------------------------*/
		 LandingPage  landingpage=new LandingPage(driver);   // Create LandingPage object to interact with login page
		 landingpage.goTo(); // Open the login page
	        

		 
		 
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ productcatlogue_part ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		 
		 
		 ProductCatlogue  Productcatlogue=landingpage.loginApplication("ankita378patil@gmail.com", "ankita378"); // Login to the application
		 
		 List<WebElement>products=Productcatlogue.getproductList(); // Retrieve list of products
		 
		 Productcatlogue.addProductToCart(productName); // Add product to the cart
		 
		 
		 
/*-------------------------------------------------card_page----------------------------------------------------------------------*/
		 
		 CartPage cartpage= Productcatlogue.goToCartPage(); // Navigate to the cart page
		
		 
		 Boolean match=cartpage.VerifyProductDisplay(productName); // Verify product is displayed in the cart
		 
		 Assert.assertTrue( match); // Assert that the product is present in the cart
		 
		 
/*----------------------------------------------------------checkoutpage---------------------------------------------------*/
		
		 CheckoutPage checkoutPage=cartpage.goToCheckout();  // Proceed to the checkout page  first CheckoutPage specifies the type second checkoutPage is the variable name.
		 //(The navigation logic and interactions are encapsulated within the respective page classes, adhering to the POM design pattern.)
		 
		 
		 checkoutPage.selectCountry("india"); // Select "India" as the country
		 ConfirmationPage confirmationPage=checkoutPage.submitOrder(); // Submit the order
		 String confirmesssage=confirmationPage.getconfirmationmessage(); // Get confirmation message
	     Assert.assertTrue(confirmesssage.equalsIgnoreCase("Thankyou for the order.")); // Verify confirmation message

		// JavascriptExecutor js = (JavascriptExecutor) driver;
	     //   js.executeScript("window.scrollBy(0,500);");
    }

}
