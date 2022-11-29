package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
* Class : Enter textPage / EnterPage
* Desciption:Enter  page elements and actions
* Developed By : Sripriya (Like tester who writes this code for testing and runs)
* Date: 11/26/2022
* Reviewed By: Sripriya (Manager who reveiws it)
*/

public class EnterPage extends DriverScript {

	// ********************************Page  Elements**********************************//
	@FindBy(xpath = "//a[@class='userProfileLink username ']") 	WebElement usernameText;
	@FindBy(id = "logoutLink") 	WebElement LogoutLink;
    @FindBy(xpath = "//a[@class='content tasks']") WebElement TasksMenu;
    
	// ********************************Page Initialization*********************************//

	public EnterPage()

	{
		PageFactory.initElements(driver, this);
	}

	// ********************************Page Method/Actions*********************************//
	
	
	public  void clickTaskMenu()
	{
		TasksMenu.click();
	}
public String VerifyUSerLoggedIn()
{
	return usernameText.getText();
}
public String getEnterPageTitle()
{
	return driver.getTitle();
}
public void ClickLogout()
{
	LogoutLink.click();
}

}
