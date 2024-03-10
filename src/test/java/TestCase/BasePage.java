package TestCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Utilities.Excel;

public class BasePage {
	public  static WebDriver driver;
	public Properties p;
	
	 @BeforeTest
	  public void beforeClass() throws InterruptedException, IOException {
		 FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 p=new Properties();
		 p.load(file);
		 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			DesiredCapabilities capabilities=new DesiredCapabilities(option);
			
			//os
			if(p.getProperty("os").equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(p.getProperty("os").equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(p.getProperty("browser").toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(p.getProperty("browser").toLowerCase())
			{
			case "chrome":
				ChromeOptions chrome = new ChromeOptions();
				chrome.addArguments("--disable-notifications");
				driver=new ChromeDriver(chrome); 
				break;
			case "edge": 
				EdgeOptions edge = new EdgeOptions();
				edge.addArguments("--disable-notifications");
				driver=new EdgeDriver(edge); 
				break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.navigate().to(p.getProperty("URL"));
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  Excel.excelInit();
	  }

	  @AfterTest
	  	 public void afterClass() throws IOException {
		 Excel.closeExcel();
		 driver.quit();
	  }
	  
	  		public static String captureScreen(String tname) throws IOException {
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			FileUtils.copyFile(sourceFile, targetFile);
			sourceFile.renameTo(targetFile);
			return targetFilePath;

		}
}


