package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustome() throws InterruptedException, IOException 
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage add = new AddCustomerPage(driver);
		
		add.clickAddNewCustomer();
		
		Thread.sleep(10000);
		
		driver.switchTo().frame("iframe");		
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		
		logger.info("PRovided Customer Details....");
		add.custName("Monika");
		add.custgender("female");
		add.custdob("04", "06", "1991");
		Thread.sleep(3000);
		add.custaddress("INDIA");
		add.custcity("Nashik");
		add.custstate("MH");
		add.custpinno("422006");
		add.custtelephoneno("7767050633");
		String email =randomestring()+"@gmail.com";
		add.custemailid(email);
		add.custpassword("adsfgh");
		
		add.custsubmit();
		Thread.sleep(3000);
		logger.info("Validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("TestCase Passed...");
			//captureScreen(driver, "addNewCustomer");
		}
		else
		{
			logger.info("TestCase Failed...");
			//captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
