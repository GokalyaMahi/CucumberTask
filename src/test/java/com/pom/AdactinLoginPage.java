package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class AdactinLoginPage extends LibGlobal {
	public AdactinLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUser;

	@FindBy(id = "password")
	private WebElement txtPass;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void loginPage(String userName,String password) {
		type1(getTxtUser(), userName);
		type1(getTxtPass(), password);
		btnClick1(btnLogin);
		

	}

}
