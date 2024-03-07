package PageObject;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthInsurance {
	WebDriver driver;
	Actions act;
	List<String> temp;  
	public HealthInsurance(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//------------------------>WebElements
	
	@FindBy(xpath="//*[text()=\"Insurance Products \"]")
	WebElement insurace_Products;
	
	@FindBy(xpath="((//*[@class=\"ruby-col-3 hidden-md\"])[2]//li)")
	List<WebElement> list_of_health_insurances;
	
	//------------------------->Functionalities
	
	public void hoverToInsuraceProducts()
	{
		act=new Actions(driver);
		act.moveToElement(insurace_Products).perform();
	}
	
	public List<String> print_health_insurances()
	{
		temp=new ArrayList<String>();
		
		for(WebElement ele:list_of_health_insurances)
		{
			String value=ele.getText();
			temp.add(value);
		}
		return temp;
		
	}
	

	
}
