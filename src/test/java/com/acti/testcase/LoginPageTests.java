package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

	
	@Test
	public void TestLoginPagesTitle() {

		String expected = "actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void testActiImageIsDisplayed() {

		boolean flag = lp.verifyActiTimeLogo();
		Assert.assertTrue(flag);

	}

	@Test
	public void testForgotPasswordIsDisplayed() {

		boolean flag = lp.VerifyForgotPassword();
		Assert.assertTrue(flag);

	}

	@Test
	public void testLoginFunction() {

		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.Clicklogin();
		String expected = "John Doe";
		String actual = ep.VerifyUSerLoggedIn();
		Assert.assertEquals(actual, expected);
		ep.ClickLogout();

	}
}
