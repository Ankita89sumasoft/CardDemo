package Ankitapatil.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ankitapatil.AbstractComponets.AbstractComponents;

public class LandingPage extends AbstractComponents 
{
	WebDriver driver;
	public  LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    //WebElement userEmail=driver.findElement(By.id("userEmail"));
	
    //pageFactory
    @FindBy(id="userEmail")
    WebElement userEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("ankita378");
    @FindBy(id="userPassword")
    WebElement passwordEle;
    //driver.findElement(By.id("login")).click();
    @FindBy(id="login")
    WebElement submit;
    
    public  ProductCatlogue loginApplication(String email,String password)
    {
    	userEmail.sendKeys(email);
    	passwordEle.sendKeys(password);
    	submit.click();
		 ProductCatlogue  Productcatlogue=new ProductCatlogue(driver);
		 return Productcatlogue;

    }
    
    public void goTo()
    {
		driver.get("https://rahulshettyacademy.com/client");
    }
    
    
}
