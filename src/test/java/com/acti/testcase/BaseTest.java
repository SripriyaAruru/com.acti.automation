package com.acti.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPages;
import com.acti.pages.TasksPage;
import com.acti.utility.ExcelLib;
import com.acti.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript {

	protected static ExtentTest logger;
	protected static ExtentReports report;
	LoginPages lp;
	EnterPage ep;
	TasksPage tp;

	@BeforeSuite
	public void setupReport() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter("/atreports/atreport.html" + System.currentTimeMillis() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeMethod
	public void setUp() {
		initApplication();
		lp = new LoginPages();
		ep = new EnterPage();
		tp = new TasksPage();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		report.flush();
		Helper.sleep();
		quitdriver();
	}

	@DataProvider(name = "actilogin")
	public Object[][] testData() {
		ExcelLib excel = new ExcelLib("./attestdata/actidata.xlsx");
		int rows = excel.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = excel.getCellData(0, i, 0);
			data[i][1] = excel.getCellData(0, i, 1);
		}

		return data;
	}

}