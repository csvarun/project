package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BaseTest.TestBase;

public class CartPage extends TestBase
{
	public @FindBy(xpath="//*[@id='total-sum']")
	WebElement expTotalAmountTxt;
	
	public @FindBy(xpath="//button[@data-hook='checkout-button-button']")
	WebElement checkOutBtn;
	
	public @FindBy(xpath="//span[text()='We are not able to accept online payments']")
	WebElement checkOutMessage;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String cart_validating()
	{
		return expTotalAmountTxt.getText();
		
	}
	public void checkout_btn()
	{
		checkOutBtn.click();
	}
	public String checkout_message()
	{
		return checkOutMessage.getText();
	}
	
}
