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
    
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    
    
    
    public  ProductCatlogue loginApplication(String email,String password)  //pass email click method driver productcatlog la de te
    {
    	userEmail.sendKeys(email);
    	passwordEle.sendKeys(password);
    	submit.click();
		ProductCatlogue  Productcatlogue=new ProductCatlogue(driver);
		 return Productcatlogue;

    }
    public String getErrorMessage() 
	{
		 waifForWebelementToAppear(errorMessage);
	    	return errorMessage.getText();
	}
   
    public void goTo() 
    {
		driver.get("https://rahulshettyacademy.com/client");
    }
}

//<div class="ng-tns-c4-22 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error" toast-component="" style="opacity: 1;"><!----><!----><!----><div role="alert" class="ng-tns-c4-22 toast-message ng-star-inserted" aria-label="Incorrect email or password." style=""> Incorrect email or password. </div><!----><!----></div>