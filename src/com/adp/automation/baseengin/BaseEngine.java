package com.adp.automation.baseengin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.adp.automation.utilities.DriverUtilities;

public class BaseEngine 
{
	private static WebDriver webDriver;
	private static String userDir;
	private static String tcName;
	@Parameters({"browser"})
	@BeforeSuite
	public void openBroser(@Optional("chrome")String browser)
	{
		userDir = System.getProperty("user.dir");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("sample git");
			System.setProperty(DriverUtilities.chromeKey,userDir+DriverUtilities.chromeValue );
			webDriver = new ChromeDriver();
			/*webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
			webDriver.manage().deleteAllCookies();*/
			init();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty(DriverUtilities.ieKey,userDir+DriverUtilities.ieValue );
		    webDriver = new InternetExplorerDriver();
			/*webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
			webDriver.manage().deleteAllCookies();*/
		    init();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(DriverUtilities.firefoxKey,userDir+DriverUtilities.firefoxValue );
		    webDriver = new FirefoxDriver();
			/*webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
			webDriver.manage().deleteAllCookies();*/
			init();
		}
	}
	private void init()
	{
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		webDriver.manage().deleteAllCookies();
	}
	@AfterSuite
	public void closeBrowser()
	{
		if(webDriver!=null)
			webDriver.close();
		else
			System.out.println("driver is pointing to null");
		
	}
	@BeforeMethod
	public void beforeTCExecution(Method method)
	{
	    tcName = method.getName();
		System.out.println("Currently Executing TestCase Name is:"+tcName);
	}
	
	/*@AfterMethod
	public void afterTCEection(ITestResult result) throws IOException
	{
		//i want to know the staus of the test case
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("TC Executed successfully:"+result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			//if test case is faild take screenshot
			TakesScreenshot takesScreenShot = (TakesScreenshot)webDriver;
			//taking screenshot in the form of file
			File file = takesScreenShot.getScreenshotAs(OutputType.FILE);
			//i want to save the file
		    FileUtils.copyFile(file, new File(userDir+"//screenshots//"+result.getName()+".jpeg"));
			System.out.println("TC is faild so take a screenshot:"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			//take screenshot
			 TakesScreenshot takesSreenShot= (TakesScreenshot)webDriver;
			 File file = takesSreenShot.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyDirectory(file, new File(userDir+"//screenshots//"+result.getName()+".jpeg"));
			 System.out.println("TC is skippes take a screenshot:"+result.getName());
			 
		}
	
	}*/
	public static WebDriver getDriver()
	{
		return webDriver;
		
	}
	public static String getUserDir()
	{
		return userDir;
	}
		
		
	


	
}
