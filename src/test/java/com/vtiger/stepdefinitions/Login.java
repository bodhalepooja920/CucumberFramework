package com.vtiger.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseDefinitions {
	LoginPage lp;
	HomePage hp;
	//public WebDriver driver;
	
	@Given("user should navigate url {string}")
	public void user_should_navigate_url(String string) throws Exception {
		launchApp();	}
	@Then("login page should be appear")
	public void login_page_should_be_appear() {
        lp = new LoginPage(driver);
        lp.username_display();
	}
	@When("User enters valid userid and valid password")
	public void user_enters_valid_userid_and_valid_password() {
		lp.enterusername("admin");
		lp.enterpassword("admin");}
		
	@When("User enters Invalid userid and Invalid password")
	public void user_enters_Invalid_userid_and_valid_password() {
		lp.enterusername("admin123");
		lp.enterpassword("admin123");
	
	    
	}
	@When("User enters Invalid userid {string} and Invalid password {string}")
	public void user_enters_invalid_userid_and_invalid_password(String userid, String pwd) {
		lp.enterusername("userid");
		lp.enterpassword("pwd");
	}
	
	@When("User enters Invalid userid {string} and Invalid password {string} and click login")
	public void user_enters_invalid_userid_and_invalid_password_and_click_login(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists();
	    int i=1;
	    for(List<String> ls:data)
	
	    {
	     if(i==1)
	     {}
	     else
	     {
	     
		lp.enterusername(ls.get(0));
		lp.enterpassword(ls.get(1));
		lp.clickLoginbutton();
	     }
	     i=0;
	}}





	@When("click on login button")
	public void click_on_login_button() {
        lp.clickLoginbutton();	    
	    
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
         hp = new HomePage(driver);	    
	}
	@Then("can see logout link appear on top right corner")
	public void can_see_logout_link_appear_on_top_right_corner() {
         hp.clickLogout();
         driver.quit();
	  
	}



	




}
