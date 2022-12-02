package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPages;
import com.acti.pages.TasksPage;
import com.acti.utility.ExcelLib;

public class BaseTest extends DriverScript {
	LoginPages lp;
	EnterPage ep;
	 TasksPage tp;

	@BeforeMethod
	public void Setup() {
		initApplication();
		lp = new LoginPages();
		ep = new EnterPage();
		 tp = new TasksPage();
		}

	@AfterMethod
	public void Teardown() {
		quitdriver();
	}
	@DataProvider(name="actilogin")
	public Object[][] Testdata()
	{
		ExcelLib excel = new ExcelLib("./attestdata/actidata.xlsx");
		 int rows = excel.getRowCount(0);
		 
		Object[][] data = new Object[rows][2];
		
		for(int i = 0;i<rows;i++)
		{
			data [i][0] = excel.getCellData(0, i, 0);
			data [i][1] = excel.getCellData(0, i, 1);
		}
				
		return data;
	}


}
