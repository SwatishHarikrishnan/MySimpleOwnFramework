package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecifiMethods {

	public ChromeDriver driver;
	public String filename;
	public static Properties prop;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName, testDescription,testCategory,testAuthor;
	
	
	@BeforeSuite
	public void startReport()
	/*This method is used to generate HTML file once test case is executed using Extent reports class*/
	{
	String currentpath = System. getProperty("user.dir");
	String Reportspath = currentpath+"\\reports\\reports.html";
	reporter = new ExtentHtmlReporter(Reportspath);
	reporter.setAppendExisting(true);
	extent = new ExtentReports();
	extent.attachReporter(reporter);}
	
	@BeforeClass
	public void testDetails()
	/*This method is used to pass the test name, description, category and author from the script developer*/
	{
	    test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	public int takesnap() throws IOException {
		/*This method is used to generate take screenshot and store it in specific place*/
		int rannum=(int)(Math.random()*99999);
		java.io.File source = driver.getScreenshotAs(OutputType.FILE);
		java.io.File target = new java.io.File("./snaps/img"+rannum+".png");
		FileUtils.copyFile(source, target);
		return rannum;
	}
	
	public void reportStep(String msg, String status) throws IOException
	/*This method is used to classify pass and fail of specific case*/
	{
	if(status.equalsIgnoreCase("pass")){
		test.log(Status.PASS, status, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takesnap()+".png").build());
		test.pass(msg);
		extent.flush();
	}
	else if(status.equalsIgnoreCase("fail")) {
		test.fail(msg);
		throw new RuntimeException();}}
	
	@DataProvider(name="senddata")
	/*This method is used to retrieve the input from the ReadExcel class available inside utility folder*/
	public String[][] senddata() throws IOException{
		return ReadExcel.ExcelRead(filename);
	}
	
	@BeforeMethod
	public void startapp() throws IOException
	/*This method is used to Initiate chrome instance, properties file and implicit wait*/
	{
		FileInputStream readfile = new FileInputStream("./src/main/resources/english.properties");
		prop = new Properties();
		prop.load(readfile);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closebrowser()
	/*This method is used to close the Browser*/
	{
		driver.quit();
	}
}
