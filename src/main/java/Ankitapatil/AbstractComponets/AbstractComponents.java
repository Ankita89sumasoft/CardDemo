package Ankitapatil.AbstractComponets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ankitapatil.pageobjects.CartPage;

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

	  public void waifForElementToAppear(By findBy) 
	  {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	  }
	public CartPage goToCartPage() 
	{
		cartHeader.click();
		 CartPage cartpage=new CartPage(driver);
		 return cartpage;

	}

	public void waitForElementDisappear(WebElement ele) 
	{
		//Thread.sleep(1000);
       WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(500));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
}
