package Ankitapatil.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Ankitapatil.AbstractComponets.AbstractComponents;

public class CartPage extends AbstractComponents 
{
	WebDriver driver;
	
	 @FindBy(css=".totalRow button")
     WebElement checkoutEle;
	 
	 @FindBy(css=".cartSection h3")
     private List<WebElement>cartproducts;
	 
	 @FindBy(css=".product-name-class") // Replace with actual class
	 private List<WebElement> cartproductss;

	 
	public  CartPage(WebDriver driver) 
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	public Boolean VerifyProductDisplay(String productName) 
	{
		Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		   return match;

	}
	
	
   public   CheckoutPage goToCheckout() //returns a new instance of the CheckoutPage class.
   {
	   checkoutEle.click();
	  return new CheckoutPage(driver);
	   
   }


  }
