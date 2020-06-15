package baseClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.HomePage;
import utils.ExtentRepotManager;



public class BaseTestClass {
	//public static WebDriver driver;
	public static RemoteWebDriver driver;
	public ExtentReports report = ExtentRepotManager.getReportInstance();
	public ExtentTest logger;
     
	/**************Invoking Browser*******************/
	public void invokeBrowser(String browser) {

		try{
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}		
		else{
		
			System.out.println("invalid browser ");
		}
		
		driver.manage().window().maximize();
	}catch(Exception e){
	  logger.log(Status.FAIL, e.getMessage());
	}
}
	
	@Parameters({ "browser" })
	
	public void invokeParallelBrowser(String browser) throws MalformedURLException {
	
		System.out.println("*******Invoking "+browser+ "************");
		DesiredCapabilities capabilities = null;

		// Decide which browser need to invoke
		if (browser.equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			capabilities = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("edge")) {
			capabilities = DesiredCapabilities.edge();
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void exit() {
		
	report.flush();
	if(driver!=null) {
		
	driver.close();
	}
	}
	
	public String getPropertiesData(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Test Data\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	

}
