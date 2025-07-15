package BasicOperations;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicOp {
    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void startChrome() {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        System.out.println("Chrome browser is launched with version: " + browser.version());
    }

    public void openUrl(String url) {
        page.navigate(url);
    }

    @AfterClass
    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();
    }

}
