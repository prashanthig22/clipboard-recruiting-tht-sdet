package amazon.pages;
import org.openqa.selenium.By;
import Commonutils.helperMethods;

public class HomePage extends helperMethods{

	public static By hamburger_menu= By.id("nav-hamburger-menu");
	public static By tv_Appliance_Electronics =By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
	public static By Televisions = By.xpath("//a[contains(text(),'Televisions')]");
	
	 public static void clickhamburgermenu() {
	
	waituntilclickable(hamburger_menu);
	click(hamburger_menu);
	extentTest.info("Clicked on hamburger menu");
	attachScreenshotInReport();
	}
    
	public static void clickTvAppliancesElectronics()
	{
		
		waituntilclickable(tv_Appliance_Electronics);
		click(tv_Appliance_Electronics);
		extentTest.info("Clicked on Tv,Appliance, Electronics");
		attachScreenshotInReport();
	}
	
	public static void clickTelevisions()
	{   
		waituntilvisible(Televisions);
		click(Televisions);
		extentTest.info("Clicked on Televisions");
		attachScreenshotInReport();
	}
}
