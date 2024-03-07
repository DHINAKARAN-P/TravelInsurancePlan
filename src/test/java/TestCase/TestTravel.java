package TestCase;

import org.testng.annotations.Test;
import PageObject.TravelInsurance;

public class TestTravel extends BasePage {

	TravelInsurance obj1;
	
	@Test(priority=1,groups = {"smoke Test one"})
	public void open_travel_insurance()
	{
		obj1=new TravelInsurance(driver);
		obj1.clickTravelInsurance();
		
	}
	@Test(priority=2,groups = {"regression Test One"},dependsOnGroups = {"smoke Test one"})
	public void select_destination() throws InterruptedException
	{
		obj1.sndCountry();
		obj1.clickUnitedKingdom();	
		obj1.clickNext();
	}

	
	@Test(priority=3,groups = {"regression Test One"})
	public void select_Date() throws InterruptedException 
	{
		obj1.selectDates();
		obj1.clickNext();
		
	}
	
	@Test(priority=4,groups = {"regression Test One"})
	public void drop_1()
	{
		obj1.clickNoOfPersons();
		obj1.clickdrop_1();
		obj1.selectAge_21();
		obj1.clickdrop_2();
		obj1.selectAge_22();
		obj1.clickNext();

	}

	@Test(priority=5,groups= {"regression Test One"})
	public void press_no()
	{
		obj1.click_no();
		obj1.clickNext();
	}
	
	@Test(priority=6,groups= {"regression Test One"})
	public void enter_mob_no()
	{
		obj1.enter_mobNo();
		obj1.click_view_plan();
	}

	@Test(priority=7,groups= {"regression Test One"})
	public void select_student_plans()
	{
		obj1.select_student_plans();
	}

	@Test(priority=8,groups= {"regression Test One"})
	public void Select_Duration()
	{
		obj1.students_check();
		obj1.Select_Duration();
		obj1.Apply();
	}
	@Test(priority=9,groups= {"regression Test One"})
	public void Apply()
	{
		
	}

	@Test(priority=10,groups= {"regression Test One"})
	public void print_First_Three_companies() throws InterruptedException
	{
		obj1.select_low_to_high();	
		obj1.print_first_three_companies();
	}
	@Test(priority=11)
	public void go_To_Home_Page()
	{
		obj1.click_policy_bazar_logo();
	}
}