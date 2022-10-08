package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TestFive extends BaseClass{

	@Test
	public void checkLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		logger.info("checkLogin is successfully checked");
	}
}
