package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;

import io.cucumber.java.*;


public class Hooks {
	 static WebDriver driver;
	 static Properties p;
	 
	@Before
    public static  void init() throws IOException
    {
		System.out.println("---------initializing------");
    	driver=BaseClass.initilizeBrowser();	
    	System.out.println("-----driver created----------");
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("URL"));
    	driver.manage().window().maximize();
    	
    			
	}
	
    @After
    public static void close() throws IOException { 		
    	driver.quit();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());	            
        }
        else {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
    }
}
    

