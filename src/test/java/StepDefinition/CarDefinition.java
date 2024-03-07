package StepDefinition;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObject.CarInsurance;

public class CarDefinition {
	CarInsurance obj2;
	
	@Given("the user is on the policy bazar page")
	public void the_user_is_on_the_policy_bazar_page() {
		obj2=new CarInsurance(BaseClass.getDriver());
	}

	@When("the user click on the car insurance")
	public void the_user_click_on_the_car_insurance() 
	{
		
	
			obj2.click_car_insurace();
	
	}

	@When("the user click on buying new car")
	public void the_user_click_on_buying_new_car() {
		obj2.click_buying_new_car();
	}

	@When("the user select city as delhi")
	public void the_user_select_city_as_delhi() {
		obj2.select_city_Chennai();
	}

	@When("the user select area in delhi")
	public void the_user_select_area_in_delhi() {
		obj2.click_TN07();
	}

	@When("the user select company as volkswagon")
	public void the_user_select_company_as_volkswagon() {
		obj2.click_renault();
	}

	@When("the user select the car name")
	public void the_user_select_the_car_name() {
		obj2.click_ameo_car();
	}

	@When("the user select the fuel type")
	public void the_user_select_the_fuel_type() {
		obj2.click_petrol();
	}

	@When("the user select the model as highline plus")
	public void the_user_select_the_model_as_highline_plus() {
		obj2.click_model();
	}

	@When("the user enter Invalid email {string} Name {string} Email {string} MobileNo")
	public void the_user_enter_invalid_email_name_email_mobile_no(String string, String string2, String string3) {
		obj2.enter_name();
		obj2.enter_invalid_email();

		System.out.println(obj2.get_email_errorMessage());
	}
	
	@When("the user enter valid  email {string} Name  {string} Email {string} MobileNo")
	public void the_user_enter_valid_email_name_email_mobile_no(String string, String string2, String string3) {
		obj2.enter_valid_email();
		obj2.send_mob_No();
	}

	@When("the user enters the details click on the viewprices")
	public void the_user_enters_the_details_click_on_the_viewprices() throws InterruptedException {
		obj2.click_view_prices();
	}

	@When("the user click the registration in next seven days")
	public void the_user_click_the_registration_in_next_seven_days() {
		obj2.click_Next_7_Days();
	}

	@When("the user enters the car price")
	public void the_user_enters_the_car_price() {
		obj2.enter_car_price();
	}

	@When("the  user clicks on the submit button")
	public void the_user_clicks_on_the_submit_button() {
		obj2.click_submit_button();
	}

	@When("the user clicks first insurance")
	public void the_user_clicks_first_insurance() {
		obj2.click_first_insurance();
	}

	@When("the user prints the car insurance quote")
	public void the_user_prints_the_car_insurance_quote() {
		String s=obj2.getInsuranceQuote();
		System.out.println(s);
	}

	@Then("the user return to home")
	public void the_user_return_to_home() {
		obj2.click_logo();
	}

}
