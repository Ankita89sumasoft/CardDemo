package Ankitapatil.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ankitapatil.AbstractComponets.AbstractComponents;

public class CheckoutPage extends  AbstractComponents 
{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(xpath="//footer")
	WebElement element;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	
	
	public void selectCountry(String countryName) throws InterruptedException 
	{
		   Actions a=new Actions(driver);
           a.sendKeys(country,countryName).build().perform();
           waifForElementToAppear(By.cssSelector(".ta-results"));
	       selectCountry.click();
	       Thread.sleep(1000);
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	      //js.executeScript("arguments[0].scrollIntoView(true);", element);
	      
	 }
	public ConfirmationPage submitOrder() 
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
}
