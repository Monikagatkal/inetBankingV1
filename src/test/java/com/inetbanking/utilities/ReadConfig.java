package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath = pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getEdgePath() {
		String edgePath = pro.getProperty("edgePath");
		return edgePath;
	}	
}
