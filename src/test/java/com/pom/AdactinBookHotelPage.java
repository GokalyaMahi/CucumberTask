package com.pom;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class AdactinBookHotelPage extends LibGlobal {
	public AdactinBookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirst;

	@FindBy(id = "last_name")
	private WebElement txtLast;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCCNum;

	@FindBy(id = "cc_type")
	private WebElement dropCCType;

	@FindBy(name = "cc_exp_month")
	private WebElement dropExpMonth;

	@FindBy(name = "cc_exp_year")
	private WebElement dropExpYear;

	@FindBy(name = "cc_cvv")
	private WebElement txtCCV;

	@FindBy(id = "book_now")
	private WebElement btnBook;

	@FindBy(name = "order_no")
	private WebElement orderNo;

	@FindBy(id = "first_name_span")
	private WebElement firstNameError;

	@FindBy(id = "last_name_span")
	private WebElement lastNameError;

	@FindBy(id = "address_span")
	private WebElement addressError;

	@FindBy(id = "cc_num_span")
	private WebElement ccNumError;

	@FindBy(id = "cc_type_span")
	private WebElement ccTypeError;

	@FindBy(id = "cc_expiry_span")
	private WebElement expiryError;

	@FindBy(id = "cc_cvv_span")
	private WebElement ccvError;

	@FindBy(linkText = "Booked Itinerary")
	private WebElement btnItinerary;

	@FindBy(id = "search_result_error")
	private WebElement cancelExist;

	@FindBy(id = "order_id_text")
	private WebElement searchId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(id="search_result_error")
	private WebElement resultMsg;
	
	@FindBy(xpath="(//table//tr[2]//td[3])[3]")
	private WebElement btn;

	@FindBy(xpath="(//table)[5]//tr[13]//td[3]")
	private WebElement btn1;

	public WebElement getTxtFirst() {
		return txtFirst;
	}

	public WebElement getTxtLast() {
		return txtLast;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCCNum() {
		return txtCCNum;
	}

	public WebElement getDropCCType() {
		return dropCCType;
	}

	public WebElement getDropExpMonth() {
		return dropExpMonth;
	}

	public WebElement getDropExpYear() {
		return dropExpYear;
	}

	public WebElement getTxtCCV() {
		return txtCCV;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public WebElement getFirstNameError() {
		return firstNameError;
	}

	public WebElement getLastNameError() {
		return lastNameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCcNumError() {
		return ccNumError;
	}

	public WebElement getCcTypeError() {
		return ccTypeError;
	}

	public WebElement getExpiryError() {
		return expiryError;
	}

	public WebElement getCvvError() {
		return ccvError;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBtnItinerary() {
		return btnItinerary;
	}

	
	public WebElement getCancelExist() {
		return cancelExist;
	}

	public WebElement getSearchId() {
		return searchId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}
	
	public WebElement getBtn() {
		return btn;
	}

	public WebElement getBtn1() {
		return btn1;
	}
	
	public WebElement getResultMsg() {
		return resultMsg;
	}

	public void bookHotel(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		type1(getTxtFirst(), firstName);
		type1(getTxtLast(), lastName);
		type1(getTxtAddress(), billingAddress);

		List<Map<String, String>> emp = dataTable.asMaps();

		Map<String, String> m = emp.get(0);

		String creditCardNo = m.get("creditCardNo");

		type1(getTxtCCNum(), creditCardNo);

		String creditCardType = m.get("creditCardType");

		selectByVisibleText(getDropCCType(), creditCardType);

		String expiryMonth = m.get("expiryMonth");

		selectByVisibleText(getDropExpMonth(), expiryMonth);

		String expiryYear = m.get("expiryYear");

		selectByVisibleText(getDropExpYear(), expiryYear);

		String CVVNumber = m.get("CVVNumber");

		type1(getTxtCCV(), CVVNumber);

		btnClick1(getBtnBook());

	}

	public void verify() {
		btnClick1(getBtnBook());

		String text1 = getText(getFirstNameError());

		Assert.assertEquals("FirstName Error", "Please Enter your First Name", text1);

		String text2 = getText(getLastNameError());

		Assert.assertEquals("LastName Error", "Please Enter you Last Name", text2);

		String text3 = getText(getAddressError());

		Assert.assertEquals("Address Error", "Please Enter your Address", text3);

		String text4 = getText(getCcNumError());

		Assert.assertEquals("CCNum Error", "Please Enter your 16 Digit Credit Card Number", text4);

		String text5 = getText(getCcTypeError());

		Assert.assertEquals("CCType Error", "Please Select your Credit Card Type", text5);

		String text6 = getText(getExpiryError());

		Assert.assertEquals("Expiry Error", "Please Select your Credit Card Expiry Month", text6);

		String text7 = getText(getCvvError());

		Assert.assertEquals("CVV Error", "Please Enter your Credit Card CVV Number", text7);

	}

	public void bookedItinerary() {
		btnClick1(getBtnItinerary());

	}

	public void cancelId1() {

		btnClick1(getBtn1());

		simpleAlert(driver);

		String text = getText(getCancelExist());

		Assert.assertEquals("CancelError", "The booking has been cancelled.", text);
	}

	public void bookNow() {
		btnClick1(getBtnBook());
	}

	public void orderId2() {

		WebElement orderNo2 = getOrderNo();

		String text = orderNo2.getAttribute("value");

		btnClick1(getBtnItinerary());

		type(getSearchId(), text);

		btnClick1(getBtnGo());
		
		btnClick1(getBtn());
		
		simpleAlert(driver);
		
		String text2 = getText(getResultMsg());

		Assert.assertEquals("CancelError", "The booking has been cancelled.", text2);

	}

}
