package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.TestBase;

public class ProductPage extends TestBase
{
	public @FindBy(xpath="//div[@tabindex='0']")
	WebElement selectColour;
	
	public @FindBy(xpath="//label[text()='Color: Black']")
	WebElement blackcolourtxt;

	public @FindBy(xpath="//span[@class='up-arrow glyphicon-arrow_up']")
	WebElement upArrowtBtn;
	
	public @FindBy(xpath="//button[@type='submit']")
	WebElement addTocartBtn;
	
	public@FindBy(xpath="//a[@fm-id='4']")
	WebElement viewCartBtn;
	
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void select_Colour()
	{
		selectColour.click();
		blackcolourtxt.getText();
	}
	public void select_ThreeQty()
	{
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@type='number']"))).build().perform();
		act.doubleClick(upArrowtBtn).doubleClick().build().perform();
	}
	public void addTo_Cart()
	{
		addTocartBtn.click();
	}
	public boolean addToCartBtn()
	{
		return viewCartBtn.isDisplayed();
	}
	public CartPage view_CartBtn()
	{
		viewCartBtn.click();
		CartPage cart= new CartPage();		
		return cart;
	}
}
