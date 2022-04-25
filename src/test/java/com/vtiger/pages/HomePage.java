package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.CommonFunctions;

public class HomePage extends HeaderPage{
	


      public HomePage(WebDriver driver)
      {
    	   super(driver);
    	   this.driver = driver;
    	   PageFactory.initElements( driver,this);
      }
   
}
