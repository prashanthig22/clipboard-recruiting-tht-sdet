package amazon.pages;

import org.openqa.selenium.By;
import Commonutils.helperMethods;

public class ProductDescriptionPage extends helperMethods{

	public static By aboutThisItem = By.xpath("//h1[(text()=' About this item ')]");
	
	public static void checkAboutThisItemDisplayed() {
		waituntilvisible(aboutThisItem);
		assertIfElementisDisplayed(aboutThisItem);
		extentTest.pass( "About this item is displayed");
		attachScreenshotInReport();
	}

}
