package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
* Class : LoginPages
* Desciption:Login page elements and actions
* Developed By : Sripriya (Like tester who writes this code for testing and runs)
* Date: 11/26/2022
* Reviewed By: Sripriya (Manager who reveiws it)
*/

public class LoginPages extends DriverScript

{
//********************************Page Elements**********************************//
	@FindBy(id="username")WebElement usernameTextbox;
	@FindBy(name="pwd") WebElement passwordTextbox;
	@FindBy(xpath = "//div[text( ) = 'Login ']") WebElement LoginButton;
	@FindBy(linkText = "Forgot your password?") WebElement ForgotpasswordLink;
	@FindBy(xpath = "//div[@class = 'atLogoImg']") WebElement actiTimeImage;
	
	//********************************Page Initialization*********************************//
	
	public LoginPages ()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	//********************************Page Method/Actions*********************************//
	
	public void enterUsername (String username)
	{
		usernameTextbox.sendKeys(username);
		
	}
	public void enterPassword (String Password)
	{
		passwordTextbox.sendKeys( Password);
	}
	
	public void loginClick ()
	{
		LoginButton.click();
	}
	public boolean VerifyForgotPassword ()
	{
		return ForgotpasswordLink.isDisplayed();
	}
	
	public boolean verifyActiTimeLogo ()
	{
		return actiTimeImage.isDisplayed();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
}
