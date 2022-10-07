package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;


	ReadConfig readconfig=new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();



	public static Logger logger;




	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String br)
	{

		logger =Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");


		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();

	}

	public String takeScreenShot(String testName, WebDriver driver) throws IOException {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(sourceFile, new File(destinationFilePath));

		return destinationFilePath;
	}


	public String randomestring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public String randomeNum()
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}





}
