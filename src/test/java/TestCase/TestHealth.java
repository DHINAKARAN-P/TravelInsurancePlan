package TestCase;

import java.util.List;

import org.testng.annotations.Test;
import PageObject.HealthInsurance;

public class TestHealth extends BasePage {
	List<String>list_health_insurances;
	HealthInsurance obj3;

	@Test(priority=18,groups= {"regression Test Three"})
	public void entering_health_insurance_details()
	{
		obj3=new HealthInsurance(driver);
		obj3.hoverToInsuraceProducts();
		list_health_insurances=obj3.print_health_insurances();
		System.out.println(list_health_insurances);
		
	}
	
}
