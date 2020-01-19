package extent1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Demo1  extends BaseTest 
{
	@Test
	public void testE() throws Exception
	{
		logger = extent.createTest("TestE", "Go to google and Enter QSP");
		logger.log(Status.INFO, "TestE is started");
		try 
		{
			driver.findElement(By.name("q")).sendKeys("Qspiders");
			logger.info("Enterd QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			logger.pass("Clicked on Enter Key");
			String path =BaseTest.getScreenshot(driver);
			logger.pass("Passed ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} 
		catch (Exception e)
		{
			logger.error("Failed");
			logger.error(e.getMessage());
			String path = getScreenshot(driver);
			logger.fail("Failed ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		logger.log(Status.INFO, "TestE is Finished");
	}
	
	@Test
	public void testD() throws Exception
	{
		logger = extent.createTest("TestD", "Go to google and Enter QSP");
		logger.log(Status.INFO, "TestD is started");
		try 
		{
			driver.findElement(By.name("q")).sendKeys("Qspiders");
			logger.info("Enterd QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			logger.pass("Clicked on Enter Key");
			String path =BaseTest.getScreenshot(driver);
			logger.pass("Passed ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} 
		catch (Exception e)
		{
			logger.error("Failed");
			logger.error(e.getMessage());
			String path = getScreenshot(driver);
			logger.fail("Failed ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		logger.log(Status.INFO, "TestD is Finished");
	}
	
	@Test
	public void testF() throws Exception
	{
		logger = extent.createTest("TestF", "Go to google and Enter QSP");
		logger.log(Status.INFO, "TestF is started");
		try 
		{
			driver.findElement(By.name("q123")).sendKeys("Qspiders");
			logger.info("Enterd QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			logger.pass("Clicked on Enter Key");
			String path =BaseTest.getScreenshot(driver);
			logger.pass("Passed ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} 
		catch (Exception e)
		{
			logger.error("Failed");
			logger.error(e.getMessage());
			String path = getScreenshot(driver);
			logger.fail("Failed ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			Assert.fail();
		}
		logger.log(Status.INFO, "TestF is Finished");
	}


}
