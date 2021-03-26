package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class AdactinSelectHotelPage extends LibGlobal{
	public AdactinSelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id="continue")
	private WebElement btnContinue;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotel() {
		btnClick1(getBtnRadio());
		btnClick1(getBtnContinue());

	}
	
	public void checkText() {
		
		String currentUrl = getCurrentUrl(driver);
		
		Assert.assertEquals("Navigated to select hotel page", "http://adactinhotelapp.com/SelectHotel.php", currentUrl);
		
	}

}
