package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import java.util.List;

public class CustomOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options().
                setLaunchOptions(createLaunchOptions()).
                setContextOptions(createContextOptions()).
                setHeadless(false).
                setBrowserName("chromium").//chromium,firefox,edge
                setChannel("chrome")// especifico el chrome o edge
                .setTestIdAttribute("data-test")
                .setBaseUrl("https://www.saucedemo.com")
         ;
    }
    //opciones del Browser
    private BrowserType.LaunchOptions createLaunchOptions(){
        final var arguments= List.of("--start-maximized");
        return new BrowserType.
                LaunchOptions()
               // .setSlowMo(1500)
                .setArgs(arguments);
    }
    //opciones del Browser contex
    private Browser.NewContextOptions createContextOptions(){
        return new Browser.NewContextOptions().setViewportSize(null);
    }
}
