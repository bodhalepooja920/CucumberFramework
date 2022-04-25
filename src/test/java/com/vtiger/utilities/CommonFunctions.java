package com.vtiger.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	 static WebDriver driver;
	
	public static void entervalue(WebDriver driver,WebElement elm,String val)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		
	    }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	public static void ClickElement(WebDriver driver,WebElement elm)
	{
		try
		{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		//elm.sendKeys(val);
		
	    }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
