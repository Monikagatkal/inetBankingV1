package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.testCases.BaseClass;


public class Reporting extends TestListenerAdapter implements ITestListener{

	public ExtentReports extent;
	public ExtentHtmlReporter htmlreport;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		htmlreport=new ExtentHtmlReporter("report123.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);

	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		//logger=extent.createTest("Test is Passed");
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		//logger=extent.createTest("Test is Failed");
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

		File f= new File(screenshotPath);

		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below: "+ logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		//logger=extent.createTest("Test is Skipped");
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}


}
