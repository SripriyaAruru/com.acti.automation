package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;


/*
* Class : Task Page
* Desciption:Tasks page elements and actions
* Developed By : Pritish (Like tester who writes this code for testing and runs)
* Date: 11/26/2022
* Reviewed By: Sripriya (Manager who reveiws it)
*/

public class TasksPage extends DriverScript {
	
	// ********************************Page  Elements**********************************//
	
	@FindBy(xpath="//div[@class='title ellipsis']") WebElement AddNewButton;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement newcustomeritem;
	@FindBy(xpath = "(//input[@placeholder = 'Enter Customer Name'])[2]") WebElement customernameTextbox;
	@FindBy(xpath = "//textarea[@placeholder = 'Enter Customer Description']") WebElement CustomerDescriptionTextBox;
	@FindBy(linkText = "Create Customer") WebElement createCustomerButton;
	@FindBy(xpath = "//span[@class='innerHtml']") WebElement SuccessMessage;
	
    
	// ********************************Page Initialization*********************************//

	public TasksPage()

	{
		PageFactory.initElements(driver, this);
	}

	// ********************************Page Method/Actions*********************************//
	
	public void ClickAddNewwButton ()
	{
		AddNewButton.click();
	}
	public void clicknewcustomeritem ()
	{
		newcustomeritem.click();
	}
	public void Entercustomernametextbox (String Custname)
	{
		customernameTextbox.sendKeys(Custname);
	}
	public void EntercustomerDescription (String Desc)
	{
		CustomerDescriptionTextBox.sendKeys(Desc);
	}
	public void ClickcreateCustomerButton ()
	{
		createCustomerButton.click();
	}
	public String getSuccessMessage ()
	{
		return SuccessMessage.getText();
	}

}
