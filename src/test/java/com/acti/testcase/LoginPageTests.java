package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPages;

public class LoginPageTests extends DriverScript
{
    @Test (priority = 1) 
    public void TestLoginPagesTitle ()
	{
    	initApplication();
		 LoginPages lp = new LoginPages();
		 String expected = "actiTIME - Login";
		   String actual = lp.getLoginPageTitle();
		 Assert.assertEquals(actual, expected);
		   quitdriver();
	}
    @Test (priority = 2)
    public void testActiImageIsDisplayed()
    {
    	initApplication();
    	LoginPages lp = new LoginPages();
    	boolean flag = lp.verifyActiTimeLogo();
    	Assert.assertTrue(flag);
    	quitdriver();
    }
    @Test (priority = 3)
    public void testForgotPasswordIsDisplayed()
    {
    	initApplication();
    	LoginPages lp = new LoginPages();
    	 boolean flag = lp.VerifyForgotPassword();
    	 Assert.assertTrue(flag);
     	 quitdriver();
    }
    @Test (priority = 4)
    public void testLoginFunction()
    {
    	initApplication();
    	LoginPages lp = new LoginPages();
    	lp.enterUsername("admin");
    	lp.enterPassword("manager");
    	lp.loginClick();
    	 EnterPage ep = new EnterPage();
    	 String expected = "John Doe";
    	  String actual = ep.VerifyUSerLoggedIn();
    	 Assert.assertEquals(actual, expected);
    	  ep.ClickLogout();
    	  quitdriver();
    }
}
