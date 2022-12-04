package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecifiMethods;
import pages.LoginPage;

public class LoginValidData extends ProjectSpecifiMethods {

	@BeforeTest
	public void setexcelfilename()
	{
		filename="Login";
		testName="demoWorkShopFunctionality";
		testDescription="Verify Functionality of DemoWebShop";
		testCategory="functional";
		testAuthor="Swatish";
	}
	
	@Test(dataProvider ="senddata")
	public void demoWorkShopFunctionality(String username, String password) throws InterruptedException, IOException
	{
	new LoginPage(driver).clickLoginToEnterCredentials().enterUsername(username).enterPassword(password).clickLoginbutton().
	verifyUserAccountId().validateRemoveShoppingCart().MouseOverComputerMenu().clickDesktopInComputer().enterFirstComputer().
	enterQuantity().clickAddToCart().validateCartAddedOrNot().clickShoppingCart().clickTermsOfService().clickCheckout().
	fillBillingAddress().fillShippingAddress().updateShippingMethod().updatePaymentMethod().verifyUpdatedPaymentMethod().
	clickConfirmOrder().verifyOrderMessage().printOrderMessage().clickLogOutButton();
	}
	
}
