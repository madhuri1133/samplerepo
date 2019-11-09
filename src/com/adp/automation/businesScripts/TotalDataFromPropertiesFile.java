package com.adp.automation.businesScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class TotalDataFromPropertiesFile 
{
	public static void main(String[] args) throws IOException 
	{
		//specify the location of the file
		FileInputStream fip = new FileInputStream("C:\\java programs\\eclips program\\MyFrameWorks\\src\\com\\adp\\automaation\\objectRepository\\OR.properties");
		Properties properties = new Properties();
		//load the file
		properties .load(fip);
		//we dont have direct method to get total data from properties file so
		//1st get all key by using keyset()
		//when ever u call the keyset wl get all key in the form of set
		Set keys = properties .keySet();
		//iterate one by one
		for(Object obj:keys)
		{
			// here all keys are in the form of object
			//so type casting is requrie because our keys r string
			String key = (String)obj;
			//we got key now i want value
			String value = properties.getProperty(key);
			System.out.println(key+" =  "+value);
		}
		 
		
	}

	
}
