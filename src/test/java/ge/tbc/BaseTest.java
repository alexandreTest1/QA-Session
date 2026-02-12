package ge.tbc;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import ge.tbc.data.Constants;
import org.testng.annotations.*;

import java.util.List;


public class BaseTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeMethod
    public void openURL (){

              playwright = Playwright.create();

              browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))

        );

                  context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null)
        );
                  page = context.newPage();
                     page.navigate(Constants.BASE_URL,
                             new Page.NavigateOptions()
                                     .setWaitUntil(WaitUntilState.LOAD));



    }


    @AfterMethod
    void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }



    }



