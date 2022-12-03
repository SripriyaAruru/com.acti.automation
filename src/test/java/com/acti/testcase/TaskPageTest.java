package com.acti.testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTest extends BaseTest {
	
	@Test (dataProvider = "actilogin")
	public void testcreatCutomer  (String Username, String Password )
	{
		lp.enterUsername(Username);
		lp.enterPassword(Password);
		lp.clickLogin();
		ep.clickTaskMenu();
		tp.clickAddNewButton();		
		tp.clickNewCustomerItem();
		tp.enterCustomerName("Test");
		tp.enterCustomerDescription("Dummy Customer created for testing ");
		tp.clickCreateCustomer();
		String sesuccessmessage = tp.getSuccessMessage();
		Assert.assertTrue(sesuccessmessage.contains(" has been created"));
		ep.ClickLogout();
	}
	@Test (dataProvider = "actilogin")
	public void testDeleteCustomer (String Username, String Password )
	{

		lp.enterUsername(Username);
		lp.enterPassword(Password);
		lp.clickLogin();
		ep.clickTaskMenu();
		tp.enterSearchCustomer("Test");
		tp.clickSearchedCustomer();
		tp.clickEditButton();
		tp.clickAction();
		tp.clickDelete();
		tp.clickDeletePermanently();
		String sesuccessmessage = tp.getSuccessMessage();
		Assert.assertTrue(sesuccessmessage.contains(" has been deleted"));
		ep.ClickLogout();
	}

		
}
