package com.page.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wingify.base.Base;

public class Loginpage extends Base {

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.logo-w")
	public WebElement logo;

	@FindBy(css = "h4.auth-header")
	public WebElement logopageText;

	@FindBy(xpath = "//div[@class='form-group']/label[1]")
	public WebElement username;

	@FindBy(css = "div.pre-icon.os-icon.os-icon-user-male-circle")
	public WebElement usernameLogo;

	@FindBy(id = "username")
	public WebElement usernameField;

	@FindBy(xpath = "//div[@class='form-group'][2]/label")
	public WebElement password;

	@FindBy(css = "div.pre-icon.os-icon.os-icon-fingerprint")
	public WebElement passwordLogo;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(id = "log-in")
	public WebElement loginBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement remebermeCheckbox;

	@FindBy(css = "label.form-check-label")
	public WebElement remebermeText;

	@FindBy(xpath = "// div[@style='text-align:center']/a[1]")
	public WebElement twitterLogo;

	@FindBy(xpath = "// div[@style='text-align:center']/a[2]")
	public WebElement facebookLogo;

	@FindBy(xpath = "// div[@style='text-align:center']/a[3]")
	public WebElement linkedinLogo;

	//
	@FindBy(css = "div.alert.alert-warning")
	public WebElement warningMsg;

}