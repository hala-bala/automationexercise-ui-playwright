package org.example.halabalax.playwright.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.halabalax.playwright.data.NewUser;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class SignUpPage {
    private final Page page;

    public SignUpPage(Page page) {
        this.page = page;
    }

    public boolean isSignUpPage() {
        return page.getByText("ENTER ACCOUNT INFORMATION").isVisible() && page.url().endsWith("/signup");
    }

    public void createAccount(NewUser user) {
        Locator signUpForm = page.locator(".login-form");
        if (user.getPrefix() == NewUser.Prefix.MR) {
            signUpForm.getByLabel("Mr.").check();
        } else {
            signUpForm.getByLabel("Mrs.").check();
        }
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName(Pattern.compile("^Name"))).fill(user.getUsername());
        signUpForm.getByLabel("Password *").fill(user.getPassword());
        LocalDate birthDate = user.getBirthDate();
        signUpForm.locator("#days").selectOption(String.valueOf(birthDate.getDayOfMonth()));
        signUpForm.locator("#months").selectOption(String.valueOf(birthDate.getMonthValue()));
        signUpForm.locator("#years").selectOption(String.valueOf(birthDate.getYear()));
        signUpForm.getByRole(AriaRole.CHECKBOX, new Locator.GetByRoleOptions().setName("Sign up for our newsletter!")).check();
        signUpForm.getByRole(AriaRole.CHECKBOX, new Locator.GetByRoleOptions().setName("Receive special offers from")).check();
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("First name *")).fill(user.getFirstName());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Last name *")).fill(user.getLastName());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Company").setExact(true)).fill(user.getCompany());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Address * (Street address, P.")).fill(user.getAddress());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Address 2")).fill(user.getAddress2());
        signUpForm.getByLabel("Country *").selectOption(user.getCountry());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("State *")).fill(user.getState());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("City * ")).fill(user.getCity());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Zipcode *")).fill(user.getZipCode());
        signUpForm.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Mobile Number *")).fill(user.getPhoneNumber());
        signUpForm.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Create Account")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Delete Account")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();

    }
}
