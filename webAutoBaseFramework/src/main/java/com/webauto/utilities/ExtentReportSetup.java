package com.webauto.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {

	ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;

	public void reportSetup() {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/ExtentReports");

		htmlReporter.config().setTheme(Theme.DARK);
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Web Automation Testing");
		extent.setSystemInfo("Environment", "QA");

	}

	public void reportTeardown() {
		//Calling flush writes everything to the extent report file
		extent.flush();
	}
}
