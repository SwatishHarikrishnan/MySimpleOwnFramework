package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecifiMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends ProjectSpecifiMethods {
	
	public LoginPage(ChromeDriver driver){
		this.driver=driver;}
	
	public LoginPage clickLoginToEnterCredentials() throws IOException
	/*This method used to click Login Button Present at Top of Page*/
	{
		try {
			driver.findElement(By.xpath(prop.getProperty("LoginPage.ClickLoginEnterCred.xpath"))).click();;
			reportStep("Successfully able to click Login to Enter Credentials", "pass");
		} catch (Exception e) {
			reportStep("Not able to click Login to Enter Credentials", "fail");}
		return this;}
	
	public LoginPage enterUsername(String username) throws IOException 
	/*This method used to Pass the username Input*/
	{
		try {
			driver.findElement(By.xpath(prop.getProperty("LoginPage.Username.xpath"))).sendKeys(username);
			reportStep("username is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("username is not entered successfully", "fail");}
		return this;}
	
	public LoginPage enterPassword(String password) throws IOException
	/*This method used to Pass the Password Input*/
	{
		try {
			driver.findElement(By.xpath(prop.getProperty("LoginPage.Password.xpath"))).sendKeys(password);
			reportStep("password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password is not entered successfully", "fail");} 
		return this;}
	
	public Homepage clickLoginbutton() throws IOException
	/*This method used to click Login Button After Input is passed for Username and Password*/
	{
		try
		{
		driver.findElement(By.xpath(prop.getProperty("LoginPage.LoginButton.xpath"))).click();
		reportStep("Able to click Login button Successfully with credentials", "pass");}
		catch (Exception e) {
		reportStep("Not able to click Login button Successfully with credentials", "fail");} 
		return new Homepage(driver);
	}
		}
