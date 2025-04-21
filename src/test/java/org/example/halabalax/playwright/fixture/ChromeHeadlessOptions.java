package org.example.halabalax.playwright.fixture;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.List;

public class ChromeHeadlessOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false)
                .setTestIdAttribute("data-qa")
                .setLaunchOptions(new BrowserType.LaunchOptions()
                        .setArgs(List.of("--no-sandbox", "--disable-extensions", "--disable-gpu")));
    }
}
