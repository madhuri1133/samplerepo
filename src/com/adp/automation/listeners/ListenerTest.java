package com.adp.automation.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.adp.automation.baseengin.BaseEngine;

public class ListenerTest implements ITestListener
{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//if test case is faild take screenshot
		TakesScreenshot takesScreenShot = (TakesScreenshot)BaseEngine.getDriver();
		//taking screenshot in the form of file
		File file = takesScreenShot.getScreenshotAs(OutputType.FILE);
		//i want to save the file
	    try {
			FileUtils.copyFile(file, new File(BaseEngine.getUserDir()+"//screenshots//"+result.getName()+".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TC is faild so take a screenshot:"+result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//if test case is faild take screenshot
				TakesScreenshot takesScreenShot = (TakesScreenshot)BaseEngine.getDriver();
				//taking screenshot in the form of file
				File file = takesScreenShot.getScreenshotAs(OutputType.FILE);
				//i want to save the file
			    try {
					FileUtils.copyFile(file, new File(BaseEngine.getUserDir()+"//screenshots//"+result.getName()+".jpeg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("TC is skipped so take a screenshot:"+result.getName());
				

	} 

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
