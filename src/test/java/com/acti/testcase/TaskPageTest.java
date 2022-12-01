package com.acti.testcase;

import org.testng.annotations.Test;

public class TaskPageTest extends BaseTest {
	
	@Test (dataProvider = "actilogin")
	public void testcreatCutomer  (String Username, String Password )
	{
		lp.enterUsername(Username);
		lp.enterPassword(Password);
		lp.Clicklogin();
		ep.clickTaskMenu();
		tp.clicknewcustomeritem();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ep.ClickLogout();
	}

		
}
