package com.adp.automation.suporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReusables 
{
	//taking private variable
	private String filePath;
	private FileInputStream fip;
	private Properties properties;
	
	//intialize the filepath through constructor
	public PropertiesReusables(String filePath) throws IOException
	{
		this.filePath=filePath;//file path is initialized
	    fip =new FileInputStream(filePath);
		//load the file
	    properties = new Properties();
		properties .load(fip);
		
	}
	//by using overloading concept i want to get the data 
	public String getPropertyValue(String key)
	{
		String value=null;
		if(properties!=null)
		value = properties.getProperty(key);
		else
		System.out.println("propeties obj is pointing to null");
		return value; 
		
	}
	public String getPropertyValue(String key,String defaultvalue)
	{
		String value=null;
		if(properties!=null)
		{
			value = properties.getProperty(key);
		
		if(value==null)
		{
			value=defaultvalue;
		}
		
	}
	return value;

}
	//i want to write the data to properties file
	public void writeKeyValue(String key,String value) throws IOException
	{
		if(properties!=null)
		{
			properties.setProperty(key, value);
			FileOutputStream fop = new FileOutputStream(filePath);
			properties.store(fop, "data saved successfullt");
		}
	}
	
	//i want to get total data from the properties file
	public Map<String,String> getTotalKeysValues()
	{
		Map<String,String> propertiesData = new HashMap<>();
		Set keys = properties.keySet();
		for(Object obj:keys)
		{
			String key=(String) obj;
			String value = properties.getProperty(key);
			propertiesData.put(key, value);
		}
		return propertiesData;
	}
	//i want to remove data from properties file
	public void removeProperty(String key) throws IOException
	{
		if(properties!=null)
		properties.remove(key);
		FileOutputStream fop = new FileOutputStream(filePath);
		properties.store(fop, "file is saved");
	}
}
                           