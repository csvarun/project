package com.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.Pages.ProductPage;

public class ProductPageTest extends TestBase
{
	ProductPage product;
	
	@BeforeClass()
	public void setup()
	{
		product = new  ProductPage();
	}
	
	@Test(priority=0)
	public void validatingProductpageTitle()
	{
		String expTitle= driver.getTitle();
		Assert.assertEquals(expTitle, "interview | I'm a product");
	}
	@Test(priority=1)
	public void customisedItemSelection() throws InterruptedException
	{
		driver.switchTo().frame(3);
		product.select_Colour();
		boolean actualColour= product.blackcolourtxt.isDisplayed();
		Assert.assertTrue(actualColour, "Colour might be different || it is not selected");
		product.select_ThreeQty();
		product.addTo_Cart();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(5);
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(product.viewCartBtn));
		boolean expAddToCartBtn= product.addToCartBtn();
		Assert.assertTrue(expAddToCartBtn, "Add to cart button is not found");
		product.view_CartBtn();
	}
	
}
