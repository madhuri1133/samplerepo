package com.adp.automation.businesScripts;

import org.testng.annotations.Test;

import com.adp.automation.baseengin.BaseEngine;

public class FbTest extends BaseEngine
{
	@Test
	public void binglogin()
	{
		getDriver().get("https://www.facebook.com");
	}

	

}
