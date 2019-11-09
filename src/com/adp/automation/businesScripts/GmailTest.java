package com.adp.automation.businesScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.adp.automation.baseengin.BaseEngine;
import com.adp.automation.suporters.PojoUtility;
import com.adp.automation.suporters.PropertiesReusables;

public class GmailTest extends BaseEngine 
{
	@Test
	public void login() throws IOException
	{
		//specifying the configuration file
		PropertiesReusables fipconf = new PropertiesReusables(PojoUtility.confFilePath) ;
		/*
		 * FileInputStream fipconf = new
		 * FileInputStream("C:\\java programs\\eclips program\\MyFrameWorks\\config.properties"
		 * ); //load the file Properties confpr = new Properties();
		 * confpr.load(fipconf);
		 */
		String url = fipconf.getPropertyValue("url");
	    getDriver().get(url);
		System.out.println(url);
		
		
		
		PropertiesReusables fipor = new PropertiesReusables(PojoUtility.orFilePath);
		/*
		 * FileInputStream fipor = new
		 * FileInputStream("C:\\java programs\\eclips program\\MyFrameWorks\\src\\com\\adp\\automaation\\objectRepository\\OR.properties"
		 * ); Properties pror = new Properties(); pror.load(fipor);
		 */
		String un_id =fipor .getPropertyValue("un_id");
		
		getDriver().findElement(By.id(un_id)).sendKeys("madhu");
		getDriver().findElement(By.id(fipor.getPropertyValue("next_id"))).click();
	}

	

}
