package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.HomePage;

import utils.ExtentRepotManager;
import utils.SummaryReport;

public class BasePageClass extends BaseTestClass {
	Date date = new Date();
	String Timestamp =  date.toString().replaceAll(":", "-").replaceAll(" ", "_");
	
	public BasePageClass(RemoteWebDriver driver,ExtentTest logger ) {
		this.driver=driver;
		this.logger=logger;
	}
	
	public ExtentTest logger;


	/***********Method to report failed testcase**************/ 
	public void reportFail(String reportString, int rown) {
		int rowNum = rown;
		SummaryReport srobj = new SummaryReport();
		srobj.write(rowNum, "FAIL");
		logger.log(Status.FAIL, reportString);
	
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	/***********Method to report passed testcase**************/ 
	public void reportPass(String reportString,int rown) {
		int rowNum = rown;
		SummaryReport srobj = new SummaryReport();
		srobj.write(rowNum, "PASS");
		logger.log(Status.PASS, reportString);
	}


	
	/***********Method to get and verify the page title*****************/
	public void getTitle(String expectedTitle) {
		
		
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			
		
	}
	
    /******************Method to screenshot***************************/
	public void takeScreenShotOnFailure() {
		// taken screen shot
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		// stored in source file
		File sourcefile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		// create one folder for thatto destiantoion binaruy to image file
		File destinationfile = new File("C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Screenshots\\Screenshots"
				+Timestamp  + ".png");
		try {// coping source into destination file
			FileUtils.copyFile(sourcefile, destinationfile);
			logger.addScreenCaptureFromPath("C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Screenshots\\Screenshots"
					+ Timestamp + ".png");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**************opening the application*****************/
	public HomePage openApplication(String URL) {

		driver.get(URL);

		HomePage hmpgobj = new HomePage(driver, logger);

		PageFactory.initElements(driver, hmpgobj);
		return hmpgobj;
	}
	

	
	
}
