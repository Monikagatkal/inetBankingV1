package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustomer;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_DeleteCustomer_004 extends BaseClass{
	
	@Test
	public void deleteCustomerId() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User Name is Provided");
	lp.setPassword(password);
	logger.info("Password is Provided");
	lp.clickSubmit();
	
	Thread.sleep(5000);
	DeleteCustomer delete = new DeleteCustomer(driver);
	delete.deleteCustomer();
	Thread.sleep(5000);
	logger.info("Delete Customer information");
	delete.custID("65854");
	
	logger.info("Validation started....");
	
		
	
	}
}
