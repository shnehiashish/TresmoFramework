package test.practice;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemo extends WebDriverTest {
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Test Summary Report");
	}
	@Test
	public void extentReportsDemo() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Ashish\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		if(driver.getTitle().equals("Googlebye"))
		{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.FAIL,"Verify current page title",test.addScreenCapture(utilitiesFunction.capture(driver))+ "Titile doesn't match");
		}
	}
	@Test
	public void sample() throws Exception
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		if(driver.getTitle().equals("Googlebye"))
		{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.FAIL,"Verify page title",test.addScreenCapture(utilitiesFunction.capture(driver))+ "Titile doesn't match");
		}
	}
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		driver.quit();
	}
	
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
}