package org.example.halabalax.playwright.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class NavBar {
    private final Page page;

    public NavBar(Page page) {
        this.page = page;
    }

    public void gotoHome() {
        page.addLocatorHandler(page.locator("button.fc-cta-consent"), Locator::click, new Page.AddLocatorHandlerOptions().setTimes(1));
        page.navigate("https://automationexercise.com");
    }

    public void gotoSignUpLogin() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup / Login")).click();
    }

    public boolean isOnHomePage() {
        return page.title().equals("Automation Exercise");
    }

}