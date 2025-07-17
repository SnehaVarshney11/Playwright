package BasicOperations;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicOp {
    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected Page page;
    BrowserContext context;

    @BeforeClass
    public void startChrome() {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        System.out.println("Chrome browser is launched with version: " + browser.version());

        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page = context.newPage();
    }

    public void openUrl(String url) {
        page.navigate(url);
    }

    @AfterClass
    public void closeBrowser() {
        try {
            // Stop tracing and save to file
            Path tracePath = Paths.get("trace.zip");
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
            System.out.println("Tracing stopped and saved to trace.zip");
            System.out.println("Trace saved at: " + tracePath.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed to stop tracing: " + e.getMessage());
        } finally {
            if (page != null) page.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        }
    }
}
