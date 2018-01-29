package com.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.Pages.CartPage;
import junit.framework.Assert;

public class CartPageTest extends TestBase
{
	CartPage cart= new CartPage();
	
	@BeforeClass()
	public void setup()
	{
		cart = new CartPage();
	}
	@Test(priority=0)
	public void cartvalidation() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("TPAMultiSection_j4ci4xqg");
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(cart.expTotalAmountTxt));
		String expTotal= cart.cart_validating();
		Assert.assertEquals(expTotal, "C$75.00");
		cart.checkout_btn();
	}
	@Test(priority=1)
	public void checkOutMessageValidation()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(6);
		String expCheckOutMessage= cart.checkout_message();
		Assert.assertEquals("We are not able to accept online payments", expCheckOutMessage);
	}
}
