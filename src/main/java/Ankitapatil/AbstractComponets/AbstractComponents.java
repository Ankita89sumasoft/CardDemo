package Ankitapatil.AbstractComponets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ankitapatil.pageobjects.CartPage;
import Ankitapatil.pageobjects.OrderPage;

public class AbstractComponents 
{

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	  @FindBy(css="[routerlink*='cart']")
	    WebElement cartHeader;

	  @FindBy(css="[routerlink*='myorders']")
	    WebElement orderHeader;
	  public void waifForElementToAppear(By findBy) 
	  {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	  }
	  
	  public void waifForWebelementToAppear(WebElement findBy) 
	  {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(findBy));
	  }
	  
	  
	public CartPage goToCartPage() // common method card page 
	{
		cartHeader.click();
		 CartPage cartpage=new CartPage(driver);
		 return cartpage;

	}
	  
		public OrderPage goToorderPage() 
		{
			orderHeader.click();
			OrderPage orderPage=new OrderPage(driver);
			 return orderPage;

		}

	
	public void waitForElementDisappear(WebElement spinner) 
	{
		//Thread.sleep(1000);
       WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(500));
		wait.until(ExpectedConditions.invisibilityOf((WebElement) spinner));

	}
}
