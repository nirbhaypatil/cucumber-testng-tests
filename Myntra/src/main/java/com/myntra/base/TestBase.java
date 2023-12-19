package com.myntra.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myntra.keywords.Keyword;


public class TestBase {
	@BeforeMethod
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Keyword keyword = new Keyword();
		keyword.quitAllWindows();
	}
}
