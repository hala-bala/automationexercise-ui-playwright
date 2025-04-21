package org.example.halabalax.playwright.pageobject;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.halabalax.playwright.data.NewUser;

public class LoginPage {
    private final static String SIGNUP_NAME_PLACEHOLDER = "Name";
    private final static String SIGNUP_EMAIL_PLACEHOLDER = "Email Address";
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void signUp(NewUser newUser) {
        var signUpForm = page.locator("div.signup-form");
        signUpForm.getByPlaceholder(SIGNUP_NAME_PLACEHOLDER).fill(newUser.getUsername());
        signUpForm.getByPlaceholder(SIGNUP_EMAIL_PLACEHOLDER).fill(newUser.getEmail());
        signUpForm.getByRole(AriaRole.BUTTON).click();
    }

    public boolean isLoginPage() {
        return page.url().endsWith("/login") && page.getByText("New User Signup!").isVisible();
    }
}
