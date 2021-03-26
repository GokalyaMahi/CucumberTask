package com.stepdefinition;

import com.base.LibGlobal;
import com.pom.AdactinBookHotelPage;
import com.pom.AdactinLoginPage;
import com.pom.AdactinSearchHotelPage;
import com.pom.AdactinSelectHotelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends LibGlobal {
	AdactinLoginPage loginPage = new AdactinLoginPage();
	AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
	AdactinSelectHotelPage selectHotel = new AdactinSelectHotelPage();
	AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();
	
	

	@Given("UserA is on Adactin page")
	public void usera_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserA should enter {string}, {string} and click the login button")
	public void usera_should_enter_and_click_the_login_button(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserA should navigate to search hotel page")
	public void usera_should_navigate_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
	}

	@When("UserA should select a {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void usera_should_select_a(String location, String hotels, String roomType, String numberOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);

	}

	@Then("UserA should navigate to the select hotel page")
	public void usera_should_navigate_to_the_select_hotel_page() {
		implicitWait();
		selectHotel.checkText();
	}

	@Given("UserB is on Adactin page")
	public void userb_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserB should enter {string}, {string} and click the login button")
	public void userb_should_enter_and_click_the_login_button(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserB should navigate to search hotel page")
	public void userb_should_navigate_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
	}

	@When("UserB should select a mandatory fields {string}, {string}, {string}, {string}, {string}")
	public void userb_should_select_a_mandatory_fields(String location, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {
		searchHotel.searchHotel1(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@Then("UserB should navigate to the select hotel page")
	public void userb_should_navigate_to_the_select_hotel_page() {
		implicitWait();
		selectHotel.checkText();
	}

	@Given("UserC is on Adactin page")
	public void userc_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserC should enter {string}, {string} and click the login button")
	public void userc_should_enter_and_click_the_login_button(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserC should navigate to search hotel page")
	public void userc_should_navigate_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
	}

	@When("UserC should select a {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userc_should_select_a(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);
	}

	@Then("UserC should select the search button and verify the error messages")
	public void userc_should_select_the_search_button_and_verify_the_error_messages() {
		searchHotel.checkInVerify();
		searchHotel.checkOutVerify();
	}

	@Given("UserD is on Adactin page")
	public void userd_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserD should enter {string} and {string}")
	public void userd_should_enter_and(String userName, String password) {
		loginPage.loginPage(userName, password);
		
	}

	@When("UserD should click login button and navigated to search hotel page")
	public void userd_should_click_login_button_and_navigated_to_search_hotel_page() {
		searchHotel.checkText();
	}

	@Then("UserD should select the search button and verify the error message")
	public void userd_should_select_the_search_button_and_verify_the_error_message() {
		searchHotel.locationError();
	}

	@Given("UserE is on Adactin page")
	public void usere_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserE should enter {string} and {string}")
	public void usere_should_enter_and(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserE should click login button and navigated to search hotel page")
	public void usere_should_click_login_button_and_navigated_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
	}

	@When("UserE should select a {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void usere_should_select_a(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);
	}

	@When("UserE should click search button and user is on select hotel page, click that radio button and user should click continue button")
	public void usere_should_click_search_button_and_user_is_on_select_hotel_page_click_that_radio_button_and_user_should_click_continue_button() {
		implicitWait();
		selectHotel.checkText();
		selectHotel.selectHotel();
	}

	@When("UserE should enter {string}, {string}, {string}")
	public void usere_should_enter(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		bookHotel.bookHotel(firstName, lastName, billingAddress, dataTable);
	}

	@Then("UserE should verify success message")
	public void usere_should_verify_success_message() {
		
	}

	@Given("UserF is on Adactin page")
	public void userf_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserF should enter {string} and {string}")
	public void userf_should_enter_and(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserF should click login button and navigated to search hotel page")
	public void userf_should_click_login_button_and_navigated_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
	}

	@When("UserF should select a {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userf_should_select_a(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);
	}

	@When("UserF should click search button and user is on select hotel page")
	public void userf_should_click_search_button_and_user_is_on_select_hotel_page() {
		implicitWait();
		selectHotel.checkText();
		
	}

	@When("UserF should click the radio button and click continue button")
	public void userf_should_click_the_radio_button_and_click_continue_button() {
		selectHotel.selectHotel();
	}

	@When("UserF should not enter any credentials and click book now button")
	public void userf_should_not_enter_any_credentials_and_click_book_now_button() {
		bookHotel.bookNow();
	}

	@Then("UserF should verify the error messages")
	public void userf_should_verify_the_error_messages() {
		bookHotel.verify();
	
	}

	@Given("UserG is on Adactin page")
	public void userg_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserG should enter {string} and {string}")
	public void userg_should_enter_and(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserG should click login button and navigated to search hotel page")
	public void userg_should_click_login_button_and_navigated_to_search_hotel_page() {
		implicitWait();
		searchHotel.checkText();
		
	}

	@When("UserG should select a {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userg_should_select_a(String location, String hotels, String roomType, String numberOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);
	}

	@When("UserG should click search button and user is on select hotel page, click that radio button and user should click continue button")
	public void userg_should_click_search_button_and_user_is_on_select_hotel_page_click_that_radio_button_and_user_should_click_continue_button() {
		implicitWait();
		selectHotel.checkText();
		selectHotel.selectHotel();
	}

	@When("UserG should enter {string}, {string}, {string}")
	public void userg_should_enter(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		bookHotel.bookHotel(firstName, lastName, billingAddress, dataTable);
		implicitWait();
	}

	@When("UserG should select the Booked Itinerary")
	public void userg_should_select_the_Booked_Itinerary() {
	}

	@Then("UserG should select the cancel id button and verify the message")
	public void userg_should_select_the_cancel_id_button_and_verify_the_message() {
		bookHotel.orderId2();
	}

	@Given("UserH is on Adactin page")
	public void userh_is_on_Adactin_page() {
		maxWindow(driver);
	}

	@When("UserH should enter {string} and {string}")
	public void userh_should_enter_and(String userName, String password) {
		loginPage.loginPage(userName, password);
	}

	@When("UserH should click login button and navigated to search hotel page")
	public void userh_should_click_login_button_and_navigated_to_search_hotel_page() {
		searchHotel.checkText();
	}

	@When("UserH should select the Booked Itinerary")
	public void userh_should_select_the_Booked_Itinerary() {
		bookHotel.bookedItinerary();
	}

	@Then("UserH should select the cancel id button and verify the message")
	public void userh_should_select_the_cancel_id_button_and_verify_the_message() {
		bookHotel.cancelId1();
	}

}
