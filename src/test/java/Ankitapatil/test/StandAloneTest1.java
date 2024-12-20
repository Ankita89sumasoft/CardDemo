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

import io.github.bonigarcia.wdm.WebDriverManager;



public class StandAloneTest1 
{

    public static void main(String[] args) throws InterruptedException 
    {
        String productName="ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        
        //Landingpage  landingpage=new Landingpage(driver);
         //landingpage.goTo();
         //landingpage.loginApplication("ankita378patil@gmail.com", "ankita378");
         //ProductCatalogue productCatalogue= new ProductCatalogue(driver);
         //List<WebElement>products=productCatalogue.getProductList();
        
        driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("ankita378patil@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("ankita378");
        driver.findElement(By.id("login")).click();
        
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

         List<WebElement> products1 = driver.findElements(By.cssSelector(".mb-3"));

         // Find the desired product
        WebElement Prod = products1.stream().filter(product
         -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")) .findFirst().orElse(null);
        Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match= cartproducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase( productName));
        Assert.assertTrue( match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".action__submit")).click();
    
        String confirmesssage= driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmesssage.equalsIgnoreCase("Thankyou for the order."));
       
 }

}
