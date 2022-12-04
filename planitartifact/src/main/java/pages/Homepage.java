package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;
import utils.GeneralReUsableMethods;
import utils.VerifyElements;

public class Homepage extends ProjectSpecifiMethods{

	public Homepage(ChromeDriver driver){
		this.driver=driver;}
	
	VerifyElements objToAccessVerifyElementsMethods = new VerifyElements();
	GeneralReUsableMethods objToAccessGeneralReUsableMethods = new GeneralReUsableMethods();
	
	public Homepage verifyUserAccountId() throws IOException 
	/*This method used to verify username at the top of page once user logged in*/
	{
		WebElement AccountId = driver.findElement(By.xpath(prop.getProperty("HomePage.AccountId.Xpath")));
		
		boolean value = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(AccountId);
		
		if(value) {
			reportStep("AccountId is Displayed successfully", "pass");
		} 
		else {
			reportStep("AccountId is not Displayed successfully", "fail");}
		return this;
	}
	
	public Homepage validateRemoveShoppingCart() throws IOException 
	/*This method is used to Remove all existing carts*/
	{
		try
		{
			
		String text = driver.findElement(By.xpath(prop.getProperty("ShoppingCartPage.ShoppingCart.xpath"))).getText();
			
		int shoppingCartvalue = objToAccessGeneralReUsableMethods.generateIntValuesAlone(text);
			
		if(shoppingCartvalue!=0)
		{
			driver.findElement(By.xpath(prop.getProperty("ShoppingCartPage.ShoppingCartvalue.xpath"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("ShoppingCartPage.RemoveCart.xpath"))).click();
			
			driver.findElement(By.xpath(prop.getProperty("ShoppingCartPage.UpdateShoppingCart.xpath"))).click();
				
			WebElement shoppingCartStatus = driver.findElement(By.xpath(prop.getProperty("ShoppingCartPage.ShoppingCartStatus.xpath")));
			
			boolean shoppingCartIsDiplayed = objToAccessVerifyElementsMethods.verifyElementIsDisplayed(shoppingCartStatus);
			
			if(shoppingCartIsDiplayed) {
				reportStep("ShoppingCartStatus is emptied and it is Displayed successfully", "pass");
			} 
			else {
				reportStep("ShoppingCart Empty message is not displayed", "fail");}
		}
		else
		{
			reportStep("By Default ShoppingCart is Empty so no need to remove it", "pass");
		}
		}
		catch (Exception e) {
			reportStep("Not able to Remove Shopping Cart items", "fail");} 
		
		return new Homepage(driver);
	}
	
	public Homepage MouseOverComputerMenu() throws IOException 
	/*This method is used to Mouse Hover the cursor to Computer Menu*/
	{
		try {
			
			WebElement MouseoverComputer = driver.findElement(By.xpath(prop.getProperty("HomePage.Computer.Xpath")));
			
			objToAccessGeneralReUsableMethods.MouseOverToSpecificElement(driver, MouseoverComputer);
			
			reportStep("Mouseover to Computer Successfully", "pass");

		} catch (Exception e) {
			reportStep("Not able to mouseover to Computer", "fail");
		}
		return new Homepage(driver);
	}
	
	
	public DesktopPage clickDesktopInComputer() throws IOException 
	/*This method is used to Desktop Sub-Menu available inside the Computer Menu*/
	{
		try {
			
			driver.findElement(By.xpath(prop.getProperty("HomePage.Desktop.Xpath"))).click();
			
			reportStep("Desktop in Computer Menu is clicked Successfully", "pass");
			
		} catch (Exception e) {
			reportStep("Failed to click Desktop in Computer Menu", "fail");
		}
		return new DesktopPage(driver);
	}
	
	public LoginPage clickLogOutButton() throws IOException 
	/*This method is used to Logout the user*/
	{
		try {
			
			driver.findElement(By.xpath(prop.getProperty("HomePage.clickLogOutButton.Xpath"))).click();
			
			reportStep("Logged out successfully", "pass");
			
		} catch (Exception e) {
			
			reportStep("Not Logged out successfully", "fail");
		}
		return new LoginPage(driver);
	}
}

 
