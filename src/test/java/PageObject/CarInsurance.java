package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarInsurance {
	
	public CarInsurance(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	WebDriver driver;
	JavascriptExecutor js;
	Actions act;
	public String s1;
	WebDriverWait wait;

	
	//-------------------------->WebElements
	
	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[4]//ancestor::a")
	WebElement Car_insurance_logo;
	
	@FindBy(xpath="//span[@class='CarRegDetails_blueTextButton__P1blP blueTextButton fontMedium']")
	WebElement Buying_New_car;
	
	@FindBy(xpath="//*[text()=\"Chennai\"]")
	WebElement city;
	
	@FindBy(xpath="//*[text()=\"TN07\"]")
	WebElement TN07;
	
	@FindBy(xpath="//span[@class=\"brandName\" and text()=\"RENAULT\"]")
	WebElement renault;
	
	@FindBy(xpath="//li[text()=\"DUSTER\"]")
	WebElement duster;
	
	@FindBy(xpath="//li[text()=\"Petrol\"]")
	WebElement petrol;
	
	@FindBy(xpath="//li[text()=\"RXE PETROL 104 PS (1598 cc)\"]")
	WebElement model;
	
	@FindBy(xpath="(//input[@class=\"form-control\"])[1]")
	WebElement name;
	
	@FindBy(xpath="(//input[@class=\"form-control\"])[2]")
	WebElement email;
	
	@FindBy(xpath="//div[@class=\"errorMsg\"]")
	WebElement error_message;
	
	@FindBy(xpath="(//input[@class=\"form-control\"])[3]")
	WebElement mobile_no;
	
	@FindBy(xpath="//button[text()=\"View Prices\"]")
	WebElement view_prices;
	
	@FindBy(xpath="(//*[@class=\"radioBox bgWhite\"])[2]")
	WebElement Next_7_Days;
	
	@FindBy(xpath="//*[@name=\"exShowRoomPrice\"]")
	WebElement car_price;
	
	@FindBy(xpath="//*[text()=\"Submit\"]")
	WebElement submit;
	
	@FindBy(xpath="//*[@class=\"primaryBtnV2 fillingEffect\"]")
	WebElement firstoption;
	
	@FindBy(name="summaryFormPF")
	WebElement summary;
	
	@FindBy(xpath="//*[@class=\"logo\"]")
	WebElement logo;
	
	//------------------------>Functionalities
	
	public void click_car_insurace()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Car_insurance_logo));
		Car_insurance_logo.click();
	}
	


	public void click_buying_new_car()
	{
		Buying_New_car.click();
	}

	public void select_city_Chennai()
	{
		city.click();
	}
	
		public void click_TN07()
	{
		TN07.click();
	}
	
	public void click_renault()
	{
		renault.click();
	}
		
	public void click_ameo_car()
	{
		act=new Actions(driver);
		act.moveToElement(duster).perform();
		act.click(duster).perform();
	}
		
	public void click_petrol()
	{
		petrol.click();
	}
	
	public void click_model()
	{
		model.click();
	}
	
	public void enter_name()
	{
		name.sendKeys("Dhina");
	}
		
	public void enter_invalid_email()
	{
		email.sendKeys("policy123#gmail.com");
		email.sendKeys(Keys.TAB);
	}
	
	public void enter_valid_email()
	{
		email.sendKeys(Keys.CONTROL + "a");
		email.sendKeys(Keys.DELETE);
		email.sendKeys("policy123@gmail.com");
	}
	
	public String get_email_errorMessage()
	{
		s1=error_message.getText();
		return error_message.getText();
	}
	
	public void send_mob_No()
	{
		mobile_no.sendKeys("6382463927");
		mobile_no.sendKeys(Keys.TAB);
	}

	public void click_view_prices()
	{
	
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",view_prices);
		
	}
	
	public void click_Next_7_Days()
	{
		
		act.moveToElement(Next_7_Days).perform();
		act.click().perform();

	}
	
	public void enter_car_price()
	{
		car_price.sendKeys("900000");
	}
	
	public void click_submit_button()
	{
		submit.click();
	}
	
	public void click_first_insurance()
	{
		firstoption.click();	
	}
	
	public String getInsuranceQuote()
	{
		return summary.getText();
	}
	
	public void click_logo()
	{
	logo.click();;
	}
	
}
