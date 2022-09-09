package com.page.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wingify.base.Base;

public class Homepage extends Base {

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.logo-label")
	public WebElement homePageLogo;

	@FindBy(id = "amount")
	public WebElement amountBtn;

	@FindBy(css = "span.text-success")
	public List<WebElement> listofAmount;

}