package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import base.ProjectSpecifiMethods;
import utils.GeneralReUsableMethods;
import utils.VerifyElements;

public class DesktopPage extends ProjectSpecifiMethods {

	public DesktopPage(ChromeDriver driver){
		this.driver=driver;}
	
	GeneralReUsableMethods objToAccessGeneralReUsableMethods = new GeneralReUsableMethods();
	VerifyElements objToAccessVerifyElementsMethods = new VerifyElements();
	
	
	public DesktopPage enterFirstComputer() throws IOException 
	/*This method is used to First Computer in the List of Multiple Computers*/
	{
		try {
			
			List<WebElement> ListofComputers = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
			
			driver.findElement(By.xpath("//a[contains(text(),'"+ListofComputers.get(0).getText()+"')]")).click();
			
			String PriceofComputer = driver.findElement(By.xpath(prop.getProperty("DesktopPage.FirstComputerPrice.Xpath"))).getText();
			
			test.log(Status.INFO, "The price of computer is : " +PriceofComputer);
			
			reportStep("Successfully clicked First computer", "pass");

		} catch (Exception e) {
			reportStep("Not able to Click First computer", "fail");
		}
		return this;
	}
	
	
	public DesktopPage enterQuantity() throws IOException 
	/*This method is used to Pass the Input for Quantity section of selected Cart item*/
	{
		try {
			WebElement ScrolltoQuantity = driver.findElement(By.xpath(prop.getProperty("DesktopPage.Quantity.Xpath")));
			
			objToAccessGeneralReUsableMethods.scrollToSpecificElement(driver, ScrolltoQuantity);
			
			driver.findElement(By.xpath(prop.getProperty("DesktopPage.Quantity.Xpath"))).clear();
			
			driver.findElement(By.xpath(prop.getProperty("DesktopPage.Quantity.Xpath"))).sendKeys("5");
			
			reportStep("Successfully passed input to Quantity", "pass");

		} catch (Exception e) {
			reportStep("Not able to pass input to Quantity", "fail");
		}
		return this;
	}
	
	public DesktopPage clickAddToCart() throws IOException 
	/*This method is used to Add To Cart icon*/
	{
		try {
			
			driver.findElement(By.xpath(prop.getProperty("DesktopPage.AddtoCart.Xpath"))).click();
			
			reportStep("Add to Cart is clicked Successfully", "pass");

		} catch (Exception e) {
			reportStep("Add to Cart is not clicked Successfully", "fail");
		}
		return this;
	}
	
	
	public DesktopPage validateCartAddedOrNot() throws IOException 
	/*This method is used to validate whether cart is added successfully or not*/
	{
			WebElement ShoppingCartMessage = driver.findElement(By.xpath(prop.getProperty("DesktopPage.ShoppingCartMessage.Xpath")));
			
			boolean value = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(ShoppingCartMessage);
			if(value) 
			{
				driver.findElement(By.xpath(prop.getProperty("DesktopPage.ShoppingCartClose.Xpath"))).click();
				
				reportStep("ShoppingCartMessage is Displayed successfully", "pass");
			} 
			else {
				reportStep("ShoppingCartMessage is not Displayed successfully", "fail");}
		return this;
	}
	
	public DesktopPage clickShoppingCart() throws IOException
	/*This method is used to click the Shopping Cart available at the top of page and print the Sub total price*/
	{	
		try {
			
		WebElement ScrolltoShoppingCart = driver.findElement(By.xpath(prop.getProperty("DesktopPage.ShoppingCart.Xpath")));
		
		objToAccessGeneralReUsableMethods.scrollToSpecificElement(driver, ScrolltoShoppingCart);
		
		objToAccessGeneralReUsableMethods.javaScriptClick(driver, ScrolltoShoppingCart);
		
		String subtotalprice = driver.findElement(By.xpath(prop.getProperty("DesktopPage.ShoppingCartSubPrice.Xpath"))).getText();
		
		test.log(Status.INFO, "The Sub-Price is : " +subtotalprice);
		
		reportStep("ShoppingCart is clicked successfully", "pass");
			
		} catch (Exception e) {
				reportStep("ShoppingCart is not clicked successfully", "fail");}
		return this;
	}
	
	public DesktopPage clickTermsOfService() throws IOException
	/*This method is used to enable the terms of service checkbox*/
	{
		try {
		
		driver.findElement(By.xpath(prop.getProperty("DesktopPage.TermsOfService.Xpath"))).click();
		
		reportStep("Terms of Service is Enabled Successfully", "pass");
			
		} catch (Exception e) {
				reportStep("Terms of Service is not Enabled Successfully", "fail");}
		return this;
	}

	public CheckoutPage clickCheckout() throws IOException 
	/*This method is used to Click the Check Out Icon*/
	{
		try {
		
		driver.findElement(By.xpath(prop.getProperty("DesktopPage.CheckOut.Xpath"))).click();
		
		reportStep("Checkout is clicked Successfully", "pass");
			
		} catch (Exception e) {
				reportStep("Checkout is not clicked Successfully", "fail");}
		return new CheckoutPage(driver);
	}

	
}
