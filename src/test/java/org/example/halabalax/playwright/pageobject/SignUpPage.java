package org.example.halabalax.playwright.pageobject;

import com.microsoft.playwright.Page;
import org.example.halabalax.playwright.data.NewUser;

public class SignUpPage {
    private final Page page;

    public SignUpPage(Page page) {
        this.page = page;
    }

    public boolean isSignUpPage() {
        return page.getByText("ENTER ACCOUNT INFORMATION").isVisible() && page.url().endsWith("/signup");
    }

    public void createAccount(NewUser user) {
        if (user.getPrefix() == NewUser.Prefix.MR) {
            page.getByLabel("Mr.").check();
        } else {
            page.getByLabel("Mrs.").check();
        }
        page.getByLabel("Name *", new Page.GetByLabelOptions().setExact(true)).first().fill(user.getUsername());
        page.getByLabel("Password *").fill(user.getPassword());
    }
}
