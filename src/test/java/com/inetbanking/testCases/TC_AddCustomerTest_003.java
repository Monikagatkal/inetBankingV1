package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{
		
	@Test
	public void addNewCustome() throws InterruptedException, IOException 
	{		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		AddCustomerPage add = new AddCustomerPage(driver);
		
		Thread.sleep(10000);
		add.clickAddNewCustomer();
		
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
