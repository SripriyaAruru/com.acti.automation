package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPages;

public class BaseTest extends DriverScript {
	LoginPages lp;
	EnterPage ep;

	@BeforeMethod
	public void Setup() {
		initApplication();
		lp = new LoginPages();
		ep = new EnterPage();

	}

	@AfterMethod
	public void Teardown() {
		quitdriver();
	}


}
