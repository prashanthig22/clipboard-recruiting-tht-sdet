package amazon.pages;

import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import Commonutils.helperMethods;



public class TelevisionPage extends helperMethods{

	public static By Samsung =By.xpath("//span[(text()='Samsung')]");
	public static By sortButton = By.xpath("//span[@id='a-autoid-0-announce']");
	public static By highToLowOption =By.xpath("//a[text()='Price: High to Low']");
	public static By secondItem =By.xpath("(//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'])[2]/div/h2/a");
    public static Logger log;
    
	public static void selectSamsungOption() 	{  
		extentTest.info("scrolling and clicking on Samsung option");
		waituntilclickable(Samsung);
		scrollandclick(Samsung);
		attachScreenshotInReport();
	}
	
	public static void selectsortButton()
	{   
		waituntilclickable(sortButton);
		click(sortButton);
		extentTest.info("Clicked on sort Button");
		attachScreenshotInReport();
	}
	
	public static void selecthighToLow()
	{   
		
		waituntilclickable(highToLowOption);
		click(highToLowOption);
	    extentTest.info("Selected High to Low option");
	    attachScreenshotInReport();
	}
	
	public static void selectSecondItem()
	{
		waituntilclickable(secondItem);
		click(secondItem);
		extentTest.info("Selected second item");
		attachScreenshotInReport();
	}
	
	public static void switchwindow()
	{
		switchwindows();
	}
	
	
}
