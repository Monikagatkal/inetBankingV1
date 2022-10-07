package utilities;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentReportClass {
		
		public static ExtentReports extentReports;
		
		public static ExtentReports getExtentReport() {
			
			String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
			reporter.config().setReportName("Automation Result");
			reporter.config().setDocumentTitle("Test Results");
			
			extentReports = new ExtentReports();
			extentReports.attachReporter(reporter);
			extentReports.setSystemInfo("Operating System", "Windows 10");
			extentReports.setSystemInfo("Tested By", "Monika Gatkal");
			
			return extentReports;
		}
	}


