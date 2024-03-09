package PageObject;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import  Utilities.Excel;

public class TravelInsurance {
	WebDriver driver;
	JavascriptExecutor js;
	
	public TravelInsurance(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}
	
	//---------------------------->WebElements

	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[7]//ancestor::a")
	WebElement travelInsurance;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//*[text()=\"United Kingdom\"]")
	WebElement UK;
	
	@FindBy(xpath="//button[@class=\"travel_main_cta\"]")
	WebElement next;
	
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[1]")
	WebElement from;
	
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input\"])[2]")
	WebElement to;
	
	@FindBy(xpath="//*[@id='traveller_2']")
	WebElement select_no_passengers;
	
	@FindBy(xpath="//*[@id='divarrow_undefined'][1]")
	WebElement drop_1;
	
	@FindBy(id="22 years_undefined")
	WebElement age_22;
	
	@FindBy(xpath="(//*[@id='divarrow_undefined'])[2]")
	WebElement drop_2;
	
	@FindBy(id="21 years_undefined")
	WebElement age_21;
	
	@FindBy(xpath="//*[@id='ped_no']")
	WebElement no;
	
	@FindBy(xpath="//*[text()='View plans']")
	WebElement view_plan;
	
	@FindBy(xpath="//input[@id=\"mobileNumber\"]")
	WebElement mob;
	
	@FindBy(xpath="//input[@id=\"studentTrip\"]")
	WebElement student_radio;
	
	@FindBy(xpath="(//input[@name=\"AMT\"])[1]")
	WebElement check_student1;
	
	@FindBy(xpath="(//input[@name=\"AMT\"])[2]")
	WebElement check_student2;
	
	@FindBy(xpath="//select[@id=\"feet\"]")
	WebElement Duration_Select;
	
	@FindBy(xpath="//button[text()=\"Apply\"]")
	WebElement Apply;

	@FindBy(xpath="//p[@class=\"filter_name_heading\"]")
	WebElement sort_by;
	
	@FindBy(xpath="//input[@id=\"17_sort\"]")
	WebElement low_radio;
	
	@FindBy(xpath="//*[text()=\"Policybazaar\"]")
	WebElement go_To_home;
	
	//--------------------------->Functionalities
	
	public void clickTravelInsurance()
	{

		travelInsurance.click();
		
	}
	
	public void sndCountry()
	{
		country.sendKeys("United");
	}
	
	public void clickUnitedKingdom()
	{
		UK.click();
	}
	
	public void clickNext()
	{
		js.executeScript("arguments[0].click()",next);
		
	}

	public void selectDates() throws InterruptedException
	{
		
		from.sendKeys("20 March, 2024");
		to.sendKeys("18 April, 2024");
		Thread.sleep(2000);
	}
	
	public void clickNoOfPersons()
	{
		js.executeScript("arguments[0].click()",select_no_passengers);
	}
	
	public void clickdrop_1()
	{
		drop_1.click();
	}
	
	public void selectAge_22()
	{
		js.executeScript("arguments[0].click()",age_22);
	}
	
	public void clickdrop_2()
	{
		drop_2.click();
	}
		
	public void selectAge_21()
	{
		js.executeScript("arguments[0].click()",age_21);
	}
		
	public void click_no()
	{
		no.click();
	}

	
	public void enter_mobNo()
	{
		mob.sendKeys("6382463922");
	}
	
	public void click_view_plan()
	{
		view_plan.click();
	}
	
	public void select_student_plans()
	{
		js.executeScript("arguments[0].click()", student_radio);
	}
	
	public void students_check()
	{
		check_student1.click();
		check_student2.click();
	}
	
	public void Select_Duration()
	{
		Select dropdown=new Select(Duration_Select);
		dropdown.selectByVisibleText("30 Days");
	}

	public void Apply()
	{
		Apply.click();
	}
	
	public void select_low_to_high() throws InterruptedException
	{
	sort_by.click();
	low_radio.click();
	Thread.sleep(3000);
	
	}
	
	public void print_first_three_companies()
	{
		for(int i=1;i<=3;i++)
		{
			String companyName=driver.findElement(By.xpath("(//div[@class=\"row_wrap flexRow contentWrapper\"]//div[@class=\"quotesCard__planName\"]//p[@class=\"quotesCard--insurerName\"])["+i+"]")).getText();
			String price=driver.findElement(By.xpath("(//p[@class=\"wrap-space \" ]//span[@class=\"premiumPlanPrice\"])["+i+"]")).getText();
			
			XSSFRow k1=Excel.createRow(i);
			Excel.setData(k1, 1, companyName);
			Excel.setData(k1, 2, price);
			System.out.println(companyName+" "+price);
			
		}
	}
	
	public void click_policy_bazar_logo()

	{
		js.executeScript("arguments[0].click()", go_To_home);
	}	

}
