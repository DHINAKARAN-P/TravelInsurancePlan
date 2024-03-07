package StepDefinition;

import java.util.List;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObject.HealthInsurance;

public class HealthDefinition {
	List<String>list_health_insurances;
	HealthInsurance obj3;
	
	@Given("the user is on the policy bazar home page")
	public void the_user_is_on_the_policy_bazar_home_page() {
		obj3=new HealthInsurance(BaseClass.getDriver());
	}

	@When("the user hover to the insurace products")
	public void the_user_hover_to_the_insurace_products() {
		obj3.hoverToInsuraceProducts();

	}

	@Then("the user prints all the health insurance menu")
	public void the_user_prints_all_the_health_insurance_menu() {
		list_health_insurances=obj3.print_health_insurances();
		System.out.print(list_health_insurances);
	}

}
