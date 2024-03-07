package TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.CarInsurance;

public class TestCar extends BasePage{
	CarInsurance obj2;

	@Test(priority=12,groups = {"smoke Test Two"})
	public void open_car_insurance()
	{
		obj2=new CarInsurance(driver);
		obj2.click_car_insurace();
		
	}
	
	@Test(priority=13,groups= {"regression Test Two"},dependsOnGroups = {"smoke Test Two"})
	public void enter_new_car_details()
	{
		
		{	obj2.click_buying_new_car();	
		obj2.select_city_Chennai();
		obj2.click_TN07();;
		obj2.click_renault();
		obj2.click_ameo_car();
		obj2.click_petrol();
		obj2.click_model();
		}
	}
	@Test(priority=14,groups= {"regression Test Two"})
	public void enter_invalid_email() throws IOException, InterruptedException
	{
		obj2.enter_name();
		obj2.enter_invalid_email();
		System.out.println(obj2.get_email_errorMessage());
	
	}
	@Test(priority=15,groups= {"regression Test Two"})
	public void enter_valid_email() throws IOException, InterruptedException
	{
		
		obj2.enter_valid_email();
		obj2.send_mob_No();
		obj2.click_view_prices();
		obj2.click_Next_7_Days();
		obj2.enter_car_price();
		obj2.click_submit_button();
		obj2.click_first_insurance();
		String s=obj2.getInsuranceQuote();
		System.out.println(s);
		
		
	}
	
	@Test(priority=16)
	public void go_to_HomePage()
	{
		obj2.click_logo();
	}
	

}


