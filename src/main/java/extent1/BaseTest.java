package extent1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	 WebDriver driver;
	 public static ExtentHtmlReporter htmlreport ;
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeTest
	public void preTestBlock()
	{
		htmlreport = new ExtentHtmlReporter("./Reports/ProjectResult.html");
		htmlreport.config().setDocumentTitle("ProjectReport");
		htmlreport.config().setReportName("Regression report");
		htmlreport.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("OS","Win10");
		extent.setSystemInfo("BrowserName", "Chrome");
		extent.setSystemInfo("QA","RS");
		
	}
	
	@AfterTest
	public void postTestBlock()
	{
		extent.flush();
	}
	
	@BeforeClass
	public void preClass()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@AfterClass
	public void postClass()
	{
		driver.close();
	}

	@AfterMethod
	public void postMethod(ITestResult res) throws IOException
	{
		String name = res.getName();
		if (res.getStatus() == res.SUCCESS)
		{
			logger.log(Status.PASS,"Test() is pass :"+name);
		}
		else if(res.getStatus() == res.FAILURE)
		{
			String path = getScreenshot(driver, name);
			logger.log(Status.FAIL,"Test() is Fail :"+name);
			logger.log(Status.FAIL,res.getThrowable());
			logger.fail("Fail", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	
	public static String getScreenshot(WebDriver driver,String name) throws IOException
	{
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+name+date+".png");
		FileUtils.copyFile(src, dest);
		String path = dest.getAbsolutePath();
		return path;
		
	}	
	
	
	public static String getScreenshot(WebDriver driver) throws IOException
	{
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/+"+date+".png");
		FileUtils.copyFile(src, dest);
		String path = dest.getAbsolutePath();
		return path;
		
	}	
	
}
