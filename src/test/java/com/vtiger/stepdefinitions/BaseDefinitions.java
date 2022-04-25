package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.utilities.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
           public static WebDriver driver;
           public static Properties prop;
           public static Map<String,List<String>> data;
	
	        
	        public void launchApp() throws Exception
	        {
	        	readproperties();
	        	//data=readdata();
	        	if(prop.getProperty("browser").equals("chrome"))
                {


	        	WebDriverManager.chromedriver().setup();
	        	driver = new ChromeDriver();
                }
	        	else if(prop.getProperty("browser").equals("firefox"))
	        	{


		        	WebDriverManager.firefoxdriver().setup();
		        	driver = new FirefoxDriver();
	            }
	        	else
	        	{
	        		WebDriverManager.edgedriver().setup();
		        	driver = new EdgeDriver();
	        	}
	        		
	        	
	        	driver.get(prop.getProperty("AppUrl"));
	        	driver.manage().window().maximize();
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("GlobalTimeOut"))));
      }  
	        
	        public void closeApp()
	        {
	        	driver.quit();
	        	
	        }
	        
	       public void readproperties() throws Exception
	        {
	            prop = new Properties();
	        	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/gobalconfig.properties");
	        	prop.load(fis);
	        }
	       
	       public Map<String,List<String>> readdata()
	       {
	    	   Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
	    	   int rowcount = xr.getRowCount("Sheet1");
	    	   int colmcount = xr.getColumnCount("Sheet1");
	    	   
	    	   Map<String,List<String>> map = new HashMap<String,List<String>>();
	    	   for(int i=2;i<rowcount;i++)
	    	   {
	    		   String tcname = xr.getCellData("Sheet1","TCName", i).trim();
	    		   List<String> lst = new ArrayList<String>();
	    		   for(int j=1;j<=rowcount;i++)
	    		   {
	    			   String d= xr.getCellData("Sheet1", j, i).trim();
	    			   lst.add(d);
	    		   }
	    		   map.put(tcname, lst);
	    	   }
	    	   return map;
	       }
	       
	       
}

