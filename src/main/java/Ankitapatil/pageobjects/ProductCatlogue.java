package Ankitapatil.pageobjects;

import java.util.List;

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
    
    public List<WebElement> getproductList() 
    {
    	 waifForElementToAppear(productsBy);
    	return products1;
    	
    }
   
    public WebElement getProductByName(String productName) 
    {
    	WebElement prod=getproductList().stream().filter(product
    		         -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")) .findFirst().orElse(null);
    	return prod;
    			
    	
    }
    public void addProductToCart(String productName) 
    {
    	
    	WebElement prod=getProductByName(productName);
    	prod.findElement(addToCart).click();
    	waifForElementToAppear(tostMessage);
    	waitForElementDisappear(spinner);

    	
    }
  }
