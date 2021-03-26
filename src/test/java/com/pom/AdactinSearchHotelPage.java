package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class AdactinSearchHotelPage extends LibGlobal {

	public AdactinSearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dropLocation;

	@FindBy(id = "hotels")
	private WebElement dropHotels;

	@FindBy(id = "room_type")
	private WebElement dropRoomType;

	@FindBy(id = "room_nos")
	private WebElement dropRoomNos;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckin;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckout;

	@FindBy(id = "adult_room")
	private WebElement dropAdults;

	@FindBy(id = "child_room")
	private WebElement dropChild;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(id = "checkin_span")
	private WebElement checkInError;

	@FindBy(id = "checkout_span")
	private WebElement checkOutError;

	@FindBy(id = "location_span")
	private WebElement locationError;

	public WebElement getDropLocation() {
		return dropLocation;
	}

	public WebElement getDropHotels() {
		return dropHotels;
	}

	public WebElement getDropRoomType() {
		return dropRoomType;
	}

	public WebElement getDropRoomNos() {
		return dropRoomNos;
	}

	public WebElement getTxtCheckin() {
		return txtCheckin;
	}

	public WebElement getTxtCheckout() {
		return txtCheckout;
	}

	public WebElement getDropAdults() {
		return dropAdults;
	}

	public WebElement getDropChild() {
		return dropChild;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getCheckInError() {
		return checkInError;
	}

	public WebElement getCheckOutError() {
		return checkOutError;
	}

	public WebElement getLocationError() {
		return locationError;
	}

	public void searchHotel(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		selectByVisibleText(getDropLocation(), location);
		selectByVisibleText(getDropHotels(), hotels);
		selectByVisibleText(getDropRoomType(), roomType);
		selectByVisibleText(getDropRoomNos(), numberOfRooms);
		clear(getTxtCheckin());
		type1(getTxtCheckin(), checkInDate);
		clear(getTxtCheckout());
		type1(getTxtCheckout(), checkOutDate);
		selectByVisibleText(getDropAdults(), adultsPerRoom);
		selectByVisibleText(getDropChild(), childrenPerRoom);
		btnClick1(getBtnSearch());

	}

	public void checkText() {

		String currentUrl = getCurrentUrl(driver);

		Assert.assertEquals("Navigated to search hotel page", "http://adactinhotelapp.com/SearchHotel.php", currentUrl);

	}

	public void searchHotel1(String location, String numberOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		selectByVisibleText(getDropLocation(), location);
		selectByVisibleText(getDropRoomNos(), numberOfRooms);
		clear(getTxtCheckin());
		type1(getTxtCheckin(), checkInDate);
		clear(getTxtCheckout());
		type1(getTxtCheckout(), checkOutDate);
		selectByVisibleText(getDropAdults(), adultsPerRoom);
		btnClick1(getBtnSearch());

	}

	public void checkInVerify() {
		String text = getText(getCheckInError());

		Assert.assertEquals("CheckIn Error", "Check-In Date shall be before than Check-Out Date", text);

	}

	public void checkOutVerify() {
		String text1 = getText(getCheckOutError());

		Assert.assertEquals("CheckOut Error", "Check-Out Date shall be after than Check-In Date", text1);

	}

	public void locationError() {
		btnClick1(getBtnSearch());

		String text2 = getText(getLocationError());

		Assert.assertEquals("Location Error", "Please Select a Location",
				text2);

	}

}
