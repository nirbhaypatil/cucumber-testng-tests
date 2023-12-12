package stepdefinitions;

import base.Config;
import errors.InvalidBrowserError;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import keywords.Keyword;

public class hooks {
    Keyword keyword = new Keyword();

    @Before
    public void setUp() throws InvalidBrowserError {
        keyword.openBrowser(Config.getBrowserName());
        keyword.maximizeBrowser();
        keyword.openUrl(Config.getAppUrl("uat"));
    }

    @After
    public void tearDown(){
        keyword.quitAllWindows();
    }
}
