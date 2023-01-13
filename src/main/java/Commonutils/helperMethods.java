package Commonutils;
import java.awt.Desktop;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.time.*;

import amazon.factories.DriverFactory;
import net.jodah.failsafe.internal.util.Assert;
import zmq.ZError.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.reporter.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class helperMethods {

	public static int timeout=10;
	public static WebDriver driver=DriverFactory.getDriver();
	public static ExtentTest extentTest;
	public static ExtentReports extent;
	public static String path;
	public static void navigateToURL(String URL)
	{try {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		extentTest.info("Navigated to URL: "+ URL);
	}
	catch(Exception e)
	{
		extentTest.fail(URL+ "did not load");
	}
		
	}
	public static void waituntilclickable(By selector)
	{  try
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		 wait.until(ExpectedConditions.elementToBeClickable(selector));
	}
	catch(Exception e)
	{
		extentTest.info("The element: "+driver.findElement(selector).getText() +" is not clickable");
	}
	}
	
	public static WebElement click(By selector)
	{
		driver.findElement(selector).click();
		return null;
	}
	
	public static WebElement scrollandclick(By selector) 	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement element =driver.findElement(selector);   
        js.executeScript("arguments[0].scrollIntoView(false);",element);
        element.click();
		return null;
		
	}
	
	public static WebElement waituntilvisible(By selector)
	{
		  try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		}
		catch(Exception e)
		{
			extentTest.info("The element: "+driver.findElement(selector).getText() +"is not visible");
		}	
		
		return null;
	}
	public static void switchwindows()
	{
		 String parent=driver.getWindowHandle();
	        Set<String> s =driver.getWindowHandles();
	        Iterator<String> I1=s.iterator();
	        while(I1.hasNext())
	        {
	        	String childwindow=I1.next();
	        	if(!parent.equals(childwindow))
	        	driver.switchTo().window(childwindow);
	        	
	        }
	       extentTest.info("Switched to child window :"+driver.getTitle());
	
	}
	
	public static WebElement assertIfElementisDisplayed(By selector)
	{   
		boolean aboutThisItemDisplayed=driver.findElement(selector).isDisplayed();
		 Assert.isTrue(aboutThisItemDisplayed, "About this Item is not displayed");
         return null;
	}
	public static void reportgeneration()
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		extent.flush();
	}
	public static void quitbrowser()
	{
		driver.close();
		driver.quit();
	}
	
	public static void initialiseReports()
	{
		 extent = new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		extentTest= extent.createTest("AmazonTestCase");

	}
	
	public static void attachScreenshotInReport()
	{
		path= captureScreenshot(driver);
		extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String filepath="./Screenshots/screenshot"+ LocalTime.now().toString().replace(":", "") +".jpg";
		File destFile =new File(filepath);
				try {
					FileUtils.copyFile(sourceFile, destFile);
				} catch (java.io.IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        return destFile.getAbsolutePath();
		
	}
	
	public static void generateExtentReports() throws Exception
	{
		extent.flush();
	//	Desktop.getDesktop().browse(new File("target/Spark.html").toURI());
	}
}

	
	

