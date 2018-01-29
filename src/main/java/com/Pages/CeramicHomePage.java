package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BaseTest.TestBase;

public class CeramicHomePage extends TestBase
{
	public 	@FindBy(xpath="//p[text()='Shop']") 
	WebElement shopBtn;

	public @FindBy(xpath="//span[text()=' C$25.00 ']") 
	WebElement fourthProduct;
	
	public CeramicHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void shopBtn()
	{
		shopBtn.click();
	}
	public void fourthProduct()
	{
		
		fourthProduct.click();
	}
}
