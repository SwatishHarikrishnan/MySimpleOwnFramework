package utils;

import org.openqa.selenium.WebElement;

import base.ProjectSpecifiMethods;

public class VerifyElements extends ProjectSpecifiMethods {

	public boolean verifyElementIsDisplayed(WebElement Element)
	/*This method is used to verify whether element is displayed in the page or not*/
	{
		boolean value = Element.isDisplayed();
		return value;
	}
}
