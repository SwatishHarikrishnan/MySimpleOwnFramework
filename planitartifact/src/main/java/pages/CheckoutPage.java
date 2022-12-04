package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.ProjectSpecifiMethods;
import utils.GeneralReUsableMethods;
import utils.VerifyElements;

public class CheckoutPage extends ProjectSpecifiMethods {

	public CheckoutPage(ChromeDriver driver){
		this.driver=driver;}
	

	VerifyElements objToAccessVerifyElementsMethods = new VerifyElements();

	public CheckoutPage fillBillingAddress() throws IOException 
	/*This method is used to Fill the Billing address*/
	{
		
			WebElement billingAddressMessage = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.BillingAddressMessage.Xpath")));
			
			boolean billingOrNewAddressExists = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(billingAddressMessage);
			
			if(billingOrNewAddressExists)
			{
				WebElement selectBillingAddressDropdown = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.BillingAddressId.Xpath")));
				
				Select select = new Select(selectBillingAddressDropdown);
				
				select.selectByValue("2804131");
				
				driver.findElement(By.xpath(prop.getProperty("CheckoutPage.BillingAddressContinue.Xpath"))).click();
				
				reportStep("Billing Address is filled Successfully", "pass");
			}
			
			else
			{
				reportStep("Billing Address is not filled Successfully", "fail");
			}
			
		return this;
	}
	
	public CheckoutPage fillShippingAddress() throws IOException 
	/*This method is used to Fill the Shipping address*/
	{
		
		try {
			WebElement selectShippingAddressDropdown = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.ShippingAddressId.Xpath")));
			
			Select select = new Select(selectShippingAddressDropdown);
			
			select.selectByValue("2804131");
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.ShippingAddressContinue.Xpath"))).click();
			
			reportStep("Shipping Address is filled Successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Shipping Address is not filled Successfully", "fail");
		}
		
		return this;
	}
	
	public CheckoutPage updateShippingMethod() throws IOException 
	/*This method is used to update the shipping method*/
	{
		try {
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.NextDayAirValue.Xpath")));
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.ShippingMethodContinue.Xpath"))).click();
			
			reportStep("Shipping method is updated Successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Shipping method is not updated Successfully", "fail");
		}
		
		return this;
	}
	
	public CheckoutPage updatePaymentMethod() throws IOException 
	/*This method is used to update the payment method*/
	{
		
		try {
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.PaymentMethod.Xpath"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.PaymentMethodContinue.Xpath"))).click();
			
			reportStep("Payment method is updated Successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Payment method is not updated Successfully", "fail");
		}
		
		return this;
	}
	
	public CheckoutPage verifyUpdatedPaymentMethod() throws IOException 
	/*This method is used to verify whether payment method updated is expected or not*/
	{
		
		WebElement paymentMethodMessage = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.PaymentMethodMessage.Xpath")));
		
		boolean paymentMethodMessagevalue = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(paymentMethodMessage);
		
		if(paymentMethodMessagevalue)
		{
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.PaymentInfoContinue.Xpath"))).click();
			
			reportStep("Payment Method is verified Successfully", "pass");
		}
		
		else
		{
			reportStep("Payment Method is not verified Successfully", "fail");
		}
		
		return this;
	}
	
	public CheckoutPage clickConfirmOrder() throws IOException 
	/*This method is used to Confirm the order*/
	{
		
		try {
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.Confirm.Xpath"))).click();
			
			reportStep("Order is confirmed Successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Order is not confirmed Successfully", "fail");
		}
		
		return this;
	}
	
	public CheckoutPage verifyOrderMessage() throws IOException
	/*This method is used to verify whether order message is displayed as expected or not*/
	{
		
		WebElement orderMessage = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.OrderMessage.Xpath")));
		
		boolean orderMessagevalue = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(orderMessage);
		
		if(orderMessagevalue)
		{
			
			reportStep("Order Message is displayed Successfully", "pass");
		}
		
		else
		{
			reportStep("Order Message is not displayed Successfully", "fail");
		}
		
		return this;
	}
	
	public Homepage printOrderMessage() throws IOException 
	/*This method is used to print the order number of the ordered item*/
	{
		
		try {
			
			String OrderNumber = driver.findElement(By.xpath(prop.getProperty("CheckoutPage.OrderNumber.Xpath"))).getText();
			
			String OrdernumberwithoutString = OrderNumber.replaceAll("[\\D]", "");
			
			test.log(Status.INFO, "The order number is : " +OrdernumberwithoutString);
			
			driver.findElement(By.xpath(prop.getProperty("CheckoutPage.OrderContinue.Xpath"))).click();
			
			reportStep("Order number is printed Successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Order number is not printed Successfully", "fail");
		}
		
		return new Homepage(driver);
	}
}
