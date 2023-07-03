package com.poi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BaseClass;

public class HomePage extends BaseClass

	{
	
	@FindBy(xpath = "//a[text()='destination of the week! The Beach!']")
	private WebElement link;
	
	@FindBy (xpath="//select[@name='fromPort']")
	private WebElement chooseyourdeparturecityDropdown;
	
	@FindBy (xpath="//select[@name='toPort']")
	private WebElement ChooseyourdestinationcityDropdown;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement FindFlightstBtn;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement PurchaseFlightTicket;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		
	}

	public WebElement getLink() {
		return link;
	}

	public WebElement getChooseyourdeparturecityDropdown() {
		return chooseyourdeparturecityDropdown;
	}

	public WebElement getChooseyourdestinationcityDropdown() {
		return ChooseyourdestinationcityDropdown;
	}

	public WebElement getFindFlightstBtn() {
		return FindFlightstBtn;
	}

	public WebElement getPurchaseFlightTicket() {
		return PurchaseFlightTicket;
	}


}
