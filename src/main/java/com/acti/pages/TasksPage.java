package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;
import com.acti.utility.Helper;


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
	@FindBy(xpath = "//div[contains(text(),'Create Customer')]") WebElement createCustomerButton;
	@FindBy(xpath = "//span[@class='innerHtml']") WebElement SuccessMessage;
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]") WebElement textboxStartTyping;
	@FindBy(xpath="//div[@class='filteredContainer']//div[@class='title']") WebElement searchedCustomer;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']//div[@class='editButton']") WebElement buttonEdit;
	@FindBy(xpath="//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']" )
	WebElement buttonAction;
	@FindBy(xpath="//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']")
	WebElement buttonDelete;
	@FindBy(xpath="(//span[@class='submitTitle buttonTitle'])[1]") WebElement buttonDeletePermanently;


    
	// ********************************Page Initialization*********************************//

	public TasksPage()

	{
		PageFactory.initElements(driver, this);
	}

	// ********************************Page Method/Actions*********************************//
	

	public void enterSearchCustomer(String custname)
	{
		textboxStartTyping.sendKeys(custname);
	}
	
	public void clickDeletePermanently()
	{
		buttonDeletePermanently.click();
		Helper.sleep();
	}
	
	public void clickDelete()
	{
		buttonDelete.click();
	}
	
	public void clickAction()
	{
		buttonAction.click();
		Helper.sleep();
	}
	
	public void clickEditButton()
	{
		buttonEdit.click();
		Helper.sleep();
	}
	
	public void clickSearchedCustomer()
	{
		searchedCustomer.click();
	}
	
		
	
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
