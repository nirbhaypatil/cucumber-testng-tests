package com.myntra.stepdefinations;


import com.myntra.base.Config;
import com.myntra.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void setUp() {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}

	@After
	public void tearDown() throws Exception {
		Keyword keyword = new Keyword();
		keyword.closeBrowser();
	}

}
