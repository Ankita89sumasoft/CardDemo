package Ankitapatil.pageobjects;

import java.util.List;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Ankitapatil.AbstractComponets.AbstractComponents;

public class ProductCatlogue extends AbstractComponents 
{
	WebDriver driver;
	public  ProductCatlogue(WebDriver driver) 
	{
		//intialization
		
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
     @FindBy(css=".mb-3")
     List<WebElement>products1;
     
     @FindBy(css=".ng-animating")
     WebElement spinner;
     
     By productsBy=By.cssSelector(".mb-3");
     By  addToCart=By.cssSelector(".card-body button:last-of-type");
     By tostMessage= By.cssSelector("#toast-container");
     
     
    //----------------------------------------------------------------------------------------
     
     
    public List<WebElement> getproductList() // we are getting product list are sending it back
    {
    	 waifForElementToAppear(productsBy);
    	 return products1;
    	
    }
   
    public WebElement getProductByName(String productName)   //selecting product in webside
    {
    	WebElement prod=getproductList().stream().filter(product
    		         -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	return prod;
    			
    	
    }
    public void addProductToCart(String product) //we are adding this element
    {
    	
    	WebElement prod=getProductByName(product);
    	prod.findElement(addToCart).click();
    	waifForElementToAppear(tostMessage);
    	waitForElementDisappear(spinner);
   }

	
  }
