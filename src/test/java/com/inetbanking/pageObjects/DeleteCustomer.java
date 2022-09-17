package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {
WebDriver ldriver;
	
	public DeleteCustomer(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);		 
	}
	
	@FindBy(xpath ="//a[text()='Delete Customer']")
	@CacheLookup
	WebElement deleteCustomer1;
	
	@FindBy(name = "cusid")
	@CacheLookup
	WebElement delcustId;
	
	@FindBy(name ="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void deleteCustomer()
	{
		deleteCustomer1.click();
		System.out.print("Delete Customer");
	}
	
	public void custID(String cId) {
		delcustId.sendKeys(String.valueOf(cId));
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	

}
