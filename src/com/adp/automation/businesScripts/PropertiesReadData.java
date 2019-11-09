package com.adp.automation.businesScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReadData 
{
	public static void main(String[] args) throws IOException 
	{
		
		//i want read and write data from properties file
		//1st specify the location of the file where it is
		FileInputStream fip = new FileInputStream("C:\\java programs\\eclips program\\MyFrameWorks\\src\\com\\adp\\automation\\businesScripts\\test.properties");
        //loas the file
		Properties properties =new Properties();
		properties.load(fip);
		//i want to get the data from properties file
		String key1 = properties.getProperty("name");
		String key2 = properties.getProperty("course");
		String key3 = properties.getProperty("practice");
		System.out.println(key1+"  "+key2+"  "+key3);
		String key4 = properties.getProperty("hello", "dont pass nullvalues");
		System.out.println(key4);
		
		
	}
	
	

}
