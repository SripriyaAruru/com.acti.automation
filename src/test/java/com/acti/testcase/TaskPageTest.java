package com.acti.testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTest extends BaseTest {
	
	@Test (dataProvider = "actilogin")
	public void testcreatCutomer  (String Username, String Password )
	{
		lp.enterUsername(Username);
		lp.enterPassword(Password);
		lp.Clicklogin();
		ep.clickTaskMenu();
		tp.ClickAddNewwButton();		
		tp.clicknewcustomeritem();
		tp.Entercustomernametextbox("TestCustomer");
		tp.EntercustomerDescription("Dummy Customer created for testing ");
		tp.ClickcreateCustomerButton();
		String sesuccessmessage = tp.getSuccessMessage();
		Assert.assertTrue(sesuccessmessage.contains(" has been created"));
		ep.ClickLogout();
	}
	@Test (dataProvider = "actilogin")
	public void testDeleteCustomer (String Username, String Password )
	{

		lp.enterUsername(Username);
		lp.enterPassword(Password);
		lp.Clicklogin();
		ep.clickTaskMenu();
		tp.enterSearchCustomer("TestCustomer");
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
