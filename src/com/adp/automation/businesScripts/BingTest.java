package com.adp.automation.businesScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.adp.automation.baseengin.BaseEngine;

public class BingTest extends BaseEngine 
{
	@Test
	public void binglogin()
	{
		getDriver().get("https://www.bing.com");
		getDriver().findElement(By.id("123"));
	}
	

	
}
