package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;


import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException 
	{
		
		driver.get(baseURL);
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		//System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else
		{
			takeScreenShot("loginTest",driver);
			Assert.assertTrue(false);
			logger.info("Login test Failed");
		}
	}
}
