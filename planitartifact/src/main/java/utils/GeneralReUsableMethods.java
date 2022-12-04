package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecifiMethods;

public class GeneralReUsableMethods extends ProjectSpecifiMethods {

	Actions action;
	JavascriptExecutor je;
	WebDriverWait wait;
	
	public int generateIntValuesAlone(String text)
	/*This method is used to generate the Integer value alone from the given String*/
	{
	char[] ch = text.toCharArray();
	
	int value=0;
	
	for(int i=0;i<ch.length;i++)
	{
		if(Character.isDigit(ch[i]))
		{
			value = Character.getNumericValue(ch[i]);
		}
	}
	return value;
	}
	
	public void MouseOverToSpecificElement(ChromeDriver driver,WebElement Element)
	/*This method is used to Move over the cursor to specific element using Actions class*/
	{
		action = new Actions(driver);
		action.moveToElement(Element).build().perform();
	}
	
	public void scrollToSpecificElement(ChromeDriver driver,WebElement Element)
	/*This method is used to scroll to specific element using javascript executor*/
	{
		je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",Element);
	}
	
	public void javaScriptClick(ChromeDriver driver,WebElement Element)
	/*This method is used to click specific element using javascript executor*/
	{
		je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", Element);
	}
	
	public void explicitWaituntilVisibility(ChromeDriver driver,WebElement Element)
	/*This method is used to wait until specific element is visible using explicit wait*/
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void explicitWaituntilClickable(ChromeDriver driver,WebElement Element)
	/*This method is used to wait until specific element is clickable using explicit wait*/
	{
	    wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	
}
