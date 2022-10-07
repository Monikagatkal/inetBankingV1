package listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetbanking.testCases.BaseClass;

import utilities.ExtentReportClass;
	
public class Listeners extends BaseClass implements ITestListener{


		 WebDriver driver=null;
		ExtentReports extentReport = ExtentReportClass.getExtentReport();
		ExtentTest extentTest ;
		ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();


		@Override
		public void onTestStart(ITestResult result) {
			String testName = result.getName();
			extentTest = extentReport.createTest(testName);
			extentTestThread.set(extentTest);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String testName = result.getName();
			//extentTest.log(Status.PASS, testName+ "Got Passed");
			extentTestThread.get().log(Status.PASS, testName+"Got Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String testName = result.getName();
			
			//extentTest.fail(result.getThrowable());
			extentTestThread.get().fail(result.getThrowable());
			WebDriver driver = null;
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String screenshotFilePath=takeScreenShot(testName, driver);
				extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);		} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}
		

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			
		}

		@Override
		public void onStart(ITestContext context) {
			
		}

		@Override
		public void onFinish(ITestContext context) {
			extentReport.flush();
		}
}
