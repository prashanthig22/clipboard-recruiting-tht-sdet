//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import com.typesafe.config.Config;

import Commonutils.helperMethods;
import amazon.config.EnvFactory;
import amazon.pages.*;

public class AmazonTestCase {
	
	private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    
    @BeforeEach
	 void setup()
	{   
		helperMethods.initialiseReports();
		helperMethods.navigateToURL(HOME_PAGE_URL);
		
	}
	
	@Test
	 void amazonAssignment()  
	{  		
		
		HomePage.clickhamburgermenu();
		HomePage.clickTvAppliancesElectronics();
		HomePage.clickTelevisions();
		TelevisionPage.selectSamsungOption();
		TelevisionPage.selectsortButton();
		TelevisionPage.selecthighToLow();
		TelevisionPage.selectSecondItem();
		TelevisionPage.switchwindow();
		ProductDescriptionPage.checkAboutThisItemDisplayed();
	}
	
	
	@AfterEach
	 void closebrowser() throws Exception
	{
		helperMethods.generateExtentReports();
		helperMethods.quitbrowser();
	}
}
