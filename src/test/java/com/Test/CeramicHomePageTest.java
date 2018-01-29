package com.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.Pages.CeramicHomePage;


public class CeramicHomePageTest extends TestBase
{
	CeramicHomePage ceramic;
	
	@BeforeClass()
	public void setup()
	{
		initialisation();	
		ceramic  = new CeramicHomePage();
	}

	@Test(priority=1)
	public void validatingCeramicpage()
	{
		String expTitle =driver.getTitle();
		Assert.assertEquals(expTitle, "interview");	
	}

	@Test(priority=2)
	public void selectProduct() throws InterruptedException
	{
		ceramic.shopBtn.click();
		Thread.sleep(3000l);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1400);");
		driver.switchTo().frame(2);
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(ceramic.fourthProduct));
		ceramic.fourthProduct.click();
		driver.switchTo().defaultContent();
	}
}

