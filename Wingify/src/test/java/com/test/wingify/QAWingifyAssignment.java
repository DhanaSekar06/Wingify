package com.test.wingify;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.elements.Homepage;
import com.page.elements.Loginpage;
import com.wingify.base.Base;

public class QAWingifyAssignment extends Base {
	Loginpage lo;
	Homepage ho;

	@BeforeTest
	public void lunchBrwoser() {
		selectBrowserAndUrl("chrome", "https://sakshingp.github.io/assignment/login.html");
		lo = new Loginpage();
		ho = new Homepage();
	}

	@Test(priority = 0)
	public void loginPageValidation() {

		// Logo validation
		Assert.assertTrue(isDisplayed(lo.logo));

		// Header Text validation
		Assert.assertEquals(getText(lo.logopageText), "Login Form");

		// username visible text validation
		Assert.assertEquals(getText(lo.username), "Username");

		// User name Logo validation
		Assert.assertTrue(isDisplayed(lo.usernameLogo));

		// username Field validation
		Assert.assertTrue(isEnabled(lo.usernameField));

		// Password visible text validation
		Assert.assertEquals(getText(lo.password), "Password");

		// Password Logo validation
		Assert.assertTrue(isDisplayed(lo.passwordLogo));

		// Password Field validation
		Assert.assertTrue(isEnabled(lo.passwordField));

		// login Button validation
		Assert.assertTrue(isEnabled(lo.loginBtn));

		// Check box validation
		Assert.assertFalse(checkCheckBox(lo.remebermeCheckbox));

		// Check Box Text validation
		Assert.assertEquals(getText(lo.remebermeText), "Remember Me");

		// Twitter Logo validation
		Assert.assertTrue(isDisplayed(lo.twitterLogo));

		// Facebook Logo validation
		Assert.assertTrue(isDisplayed(lo.facebookLogo));

		// LionkedIn Logo validation
		Assert.assertTrue(isDisplayed(lo.linkedinLogo));

	}

	@Test(priority = 1)
	public void loginwithInvalid() {
		// Validating Error Massage for both empty set login
		clearTextbox(lo.usernameField);
		clearTextbox(lo.passwordField);
		click(lo.loginBtn);
		Assert.assertEquals(getText(lo.warningMsg), "Both Username and Password must be present");

		// Validating Error Massage for password empty
		sendData(lo.usernameField, "Name");
		clearTextbox(lo.passwordField);
		click(lo.loginBtn);
		Assert.assertEquals(getText(lo.warningMsg), "Password must be present");

		// Validating Error Massage for username empty
		clearTextbox(lo.usernameField);
		sendData(lo.passwordField, "1425");
		click(lo.loginBtn);
		Assert.assertEquals(getText(lo.warningMsg), "Username must be present");

		// clearing values from fields
		clearTextbox(lo.usernameField);
		clearTextbox(lo.passwordField);

	}

	@Test(priority = 2)
	public void logIn() {
		// Login with Valid inputs
		sendData(lo.usernameField, "Name");
		sendData(lo.passwordField, "1425");
		click(lo.loginBtn);
		Assert.assertEquals(getText(ho.homePageLogo), "DEMO");

	}

	@Test(priority = 3)
	public void homePageValidation() {

		click(ho.amountBtn);
		// Sorted Amount validation
		Assert.assertTrue(isSorted(ho.listofAmount));

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}