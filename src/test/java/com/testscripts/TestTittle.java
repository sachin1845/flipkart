package com.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.poi.HomePage;

import generic.BaseClass;
import generic.RetryAnalyzerImp;

public class TestTittle extends BaseClass  {


	@Test(retryAnalyzer = RetryAnalyzerImp.class)

	public void testTitle()
	{
		String atitile = driver.getTitle();

		String eTitle = "Welcome to the Simple Travel Agency!";
		System.out.println(atitile);

		assertNotEquals(atitile, eTitle);


	}
	@Test(retryAnalyzer = RetryAnalyzerImp.class)
	public void testNavigation() throws InterruptedException
	{
		HomePage hg=new HomePage(driver);
		hg.getLink().click();
		Set<String> df=driver.getWindowHandles();
		int count=df.size();
		
		
		if(count>1)
		{
			Reporter.log("the link is opened in new tab", true);
			
		}
		
		else
		{
			Reporter.log("the link is not opened in new tab", true);
			
		}
		driver.navigate().back();
		String etitle=driver.getTitle();
		String atitle="vacation";
		assertNotEquals(etitle,atitle);
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
	}

	@Test(retryAnalyzer = RetryAnalyzerImp.class)
	public void Ticket() throws InterruptedException
	{
	HomePage hg =new HomePage(driver);
	Select s=new Select(hg.getChooseyourdeparturecityDropdown());
	s.selectByValue("Mexico City");
			
		Select ss=new Select(hg.getChooseyourdestinationcityDropdown());
		ss.selectByValue("London");
		
		
		hg.getFindFlightstBtn().click();
		Thread.sleep(3000);
		
	List<WebElement>	prices=driver.findElements(By.xpath("//td[6]"));
		
	TreeSet<Double>	ts = new  TreeSet();
	
	for(WebElement p:prices)
	{
		
		String pr=p.getText().replaceAll("[^0-9.]", "");
		ts.add(Double.valueOf(pr));
	}
	driver.findElement(By.xpath("//td[contains(text(),'"+ts.first()+"')]/..//input[@type='submit']")).click();
	Thread.sleep(3000);
	String totalCost= driver.findElement(By.xpath("//p[text()='Total Cost: ']/em")).getText();
	System.out.println(totalCost);

	Assert.assertTrue(totalCost.matches("\\d{3}\\.\\d{2}"),"Total cost is not in the xxx.xx format");
	hg.getPurchaseFlightTicket().click();
	Thread.sleep(2000);
	String id=driver.findElement(By.xpath("//td[2]")).getText();
	Reporter.log("The Ticket"+id,true);
	
		
	}
}
		
	
	
		
		
		
		
