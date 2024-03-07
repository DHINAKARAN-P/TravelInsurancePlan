package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Factory.BaseClass;
import PageObject.TravelInsurance;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

import Utilities.Excel;

public class TravelDefinition {
	TravelInsurance obj1;
	Logger log;
	
	
	@Given("the user clicks on the policy bazar page")
	public void the_user_clicks_on_the_policy_bazar_page() throws FileNotFoundException {
		obj1=new TravelInsurance(BaseClass.getDriver());
		log=BaseClass.getLogger();
		Excel.excelInit();
	}

	@When("the user clicks the travel insurance")
	public void the_user_clicks_the_travel_insurance() {
		log.info("User Clicked Travel Insurance...");
		obj1.clickTravelInsurance();
	}

	@When("the user enters {string} and select United Kingdom")
	public void the_user_enters_and_select_united_kingdom(String string) {
//		obj1.clickDestination();
		obj1.sndCountry();
		obj1.clickUnitedKingdom();	
	}

	@When("the user clicks next after selecting destination")
	public void the_user_clicks_next_after_delecting_destination() throws InterruptedException {
		obj1.clickNext();
	}

	@When("the user slecting the date")
	public void the_user_clicks_select_date() throws InterruptedException {
		obj1.selectDates();
	}

	@When("the user clicks next after selecting date")
	public void the_user_clicks_next_after_selecting_date() throws InterruptedException {
		obj1.clickNext();
	}

	@When("the user selects no of persons as two")
	public void the_user_selects_no_of_persons_as_two() {
		obj1.clickNoOfPersons();
	}

	@When("the user selects age for the two students")
	public void the_user_selects_age_for_the_two_students() {
		obj1.clickdrop_1();
		obj1.selectAge_21();
		obj1.clickdrop_2();
		obj1.selectAge_22();
	}

	@When("the user clicks next after students selection")
	public void the_user_clicks_next_after_students_selection() throws InterruptedException {
		obj1.clickNext();
	}

	@When("the user clicks no for medical issues")
	public void the_user_clicks_no_for_medical_issues() {
		obj1.click_no();
	}

	@When("the user clicks next after no")
	public void the_user_clicks_next_after_no() {
		obj1.clickNext();
	}

	@When("the user enters {string}")
	public void the_user_enters(String string) {
		obj1.enter_mobNo();
	}

	@When("the user clicks viewplans")
	public void the_user_clicks_viewplans() {
		obj1.click_view_plan();
	}
	@When("the user check student plans")
	public void the_user_check_plans() {
		obj1.select_student_plans();
	}
	@When("the user select students and duration")
	public void the_user_select_students_duration() {
		obj1.students_check();
		obj1.Select_Duration();
	}
	@When("the user clicks apply")
	public void the_user_clicks_apply() {
		obj1.Apply();
	}
	

	@When("the user select price as low to high")
	public void the_user_select_price_as_low_to_high() throws InterruptedException {
		obj1.select_low_to_high();	
	}

	@When("the user prints the first three companies details")
	public void the_user_prints_the_first_three_companies_details() throws IOException {
		obj1.print_first_three_companies();
		Excel.closeExcel();
	}
	@Then("the user get back to home")
	public void the_user_get_back_to_home() throws IOException {
		obj1.click_policy_bazar_logo();
		
	}

	
}
