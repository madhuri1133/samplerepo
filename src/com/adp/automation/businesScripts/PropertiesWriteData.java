package com.adp.automation.businesScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriteData 
{
	public static void main(String[] args) throws IOException 
	{
		//specify the properties file location
		FileInputStream fip = new FileInputStream("C:\\java programs\\eclips program\\MyFrameWorks\\src\\com\\adp\\automation\\businesScripts\\test.properties");
	    //load the file
		Properties properties = new Properties();
		properties.load(fip);
		properties.setProperty("name", "madhu");
		properties.setProperty("course", "java");
		properties.store(new FileOutputStream("C:\\java programs\\eclips program\\MyFrameWorks\\src\\com\\adp\\automation\\businesScripts\\test.properties"), "success");
	}

	

}
