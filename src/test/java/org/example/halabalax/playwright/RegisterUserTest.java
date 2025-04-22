package org.example.halabalax.playwright;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.assertj.core.api.Assertions;
import org.example.halabalax.playwright.data.UserFactory;
import org.example.halabalax.playwright.fixture.ChromeHeadlessOptions;
import org.example.halabalax.playwright.pageobject.LoginPage;
import org.example.halabalax.playwright.pageobject.NavBar;
import org.example.halabalax.playwright.pageobject.SignUpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UsePlaywright(ChromeHeadlessOptions.class)
public class RegisterUserTest {
    private NavBar navBar;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @BeforeEach
    void setUp(final BrowserContext browserContext) {
        Page page = browserContext.newPage();
        navBar = new NavBar(page);
        loginPage = new LoginPage(page);
        signUpPage = new SignUpPage(page);
    }

    @Test
    void registerUser() {
        navBar.gotoHome();
        Assertions.assertThat(navBar.isOnHomePage())
                .as("Home page should be opened")
                .isTrue();
        navBar.gotoSignUpLogin();
        Assertions.assertThat(loginPage.isLoginPage())
                .as("Login page should be opened")
                .isTrue();
        var user = UserFactory.getRandomUser();
        loginPage.signUp(user);
        Assertions.assertThat(signUpPage.isSignUpPage())
                .as("Sign up page should be opened")
                .isTrue();
        signUpPage.createAccount(user);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
}
