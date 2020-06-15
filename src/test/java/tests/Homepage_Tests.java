package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.BasePageClass;
import baseClasses.BaseTestClass;
import pageClasses.HomeLoan;
import pageClasses.HomePage;
import pageClasses.LoanCalPage;
import utils.TestData;


public class Homepage_Tests extends BaseTestClass{
	HomePage hmpgobj;
	
	
	
	@Parameters({"browser"})
	@Test(priority = 0)
	
	public void openingHomePageTest(@Optional String browser_value) throws InterruptedException, IOException {
		logger = report.createTest("Opening Home Page Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 1;
		try {
		if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
			baseobj.invokeParallelBrowser(browser_value);
		}
		else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
			baseobj.invokeBrowser(getPropertiesData("Browser"));	
		}
		hmpgobj = baseobj.openApplication(getPropertiesData("URL"));   
		hmpgobj.getTitle(getPropertiesData("Home_Page_Titile"));
		baseobj.reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " +getPropertiesData("Home_Page_Titile") ,row);
		}catch(AssertionError e){
			baseobj.reportFail(e.getMessage(),row);
		}
		
		}
	@Parameters({"browser"})
	@Test(priority = 1)
	public void CarLoan_Button_Click_Test(@Optional String browser_value) throws IOException {
		logger = report.createTest("Car loan button click test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
			baseobj.invokeParallelBrowser(browser_value);
		}
		else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
			baseobj.invokeBrowser(getPropertiesData("Browser"));	
		}
		hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
		hmpgobj.clickCarLoan();
		//baseobj.exit();

	}
	@Parameters({"browser"})
	@Test(priority = 2)
	public void Car_LoanAmount_Textbox(@Optional String browser_value) throws Exception {
		logger = report.createTest("Car loan amount text box test - valid");

		BasePageClass baseobj = new BasePageClass(driver, logger);
int row = 6;
		try {
			
			TestData d = new TestData();
		

			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.amount(d.getCarloan());
			//Assert.assertEquals(hmpgobj.getCarLnAmnt(), prop.getProperty("Actual_Carloan"));
			Assert.assertTrue(hmpgobj.getCarLnAmnt().contains(getPropertiesData("Actual_Carloan")));
			baseobj.reportPass("Successfully entered Car loan amount text box",row);
		
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	
	@Parameters({"browser"})
	@Test(priority = 3)
	public void Car_LoanInterest_Textbox(@Optional String browser_value) throws Exception {
		logger = report.createTest("car loan interest text box test - valid ");

		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 7;
		try {
			
			TestData d = new TestData();
		

			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.interest(d.getInterest());
			Assert.assertEquals(hmpgobj.getCarLnInt(), getPropertiesData("Actual_CarInt"));
			baseobj.reportPass("Successfully entered Car interest rate text box",row);
		
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	@Parameters({"browser"})
	@Test(priority = 4)
	public void Car_LoanTenureYr_Textbox(@Optional String browser_value) throws Exception {
		logger = report.createTest("Car loan tenure textbox year test - valid");

		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 8;
		try {
			
			TestData d = new TestData();
	
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.tenure(d.getTenureYr());
			//Assert.assertEquals(hmpgobj.getCarLnTen(), prop.getProperty("Actual_CarTenYr"));
			Assert.assertTrue(hmpgobj.getCarLnTen().contains(getPropertiesData("Actual_CarTenYr")));
			baseobj.reportPass("Successfully entered Car loan tenure text box",row);
			
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	@Parameters({"browser"})
	@Test(priority = 5)
	public void Car_LoanTenureMn_Textbox(@Optional String browser_value) throws Exception {
		logger = report.createTest("Car loan tenure textbox month test - valid");

		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 9;
		try {
			
			TestData d = new TestData();
			
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.tenure(d.getTenureMn());
			hmpgobj.clickMonth();
			Assert.assertEquals(hmpgobj.getCarLnTen(), getPropertiesData("Actual_CarTenMn"));
			baseobj.reportPass("Successfully entered Car loan tenure text box",row);
			
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	@Parameters({"browser"})
	@Test(priority = 6)
	public void Printing_AmountandInterest(@Optional String browser_value) throws Exception {
		logger = report.createTest("Printing the Principal and Interest Amount");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 3;
		try {
			TestData d = new TestData();
			
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}

			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			Thread.sleep(2000);

			hmpgobj.clickCarLoan();

			hmpgobj.amount(d.getCarloan());

			hmpgobj.interest(d.getInterest());
			hmpgobj.tenure(d.getTenureYr());
			hmpgobj.EMIArrearClick();

			hmpgobj.year2020Click();

			System.out.println("Principal Amount is" + " " + hmpgobj.getPAmntCarLoan());

			System.out.println("Interest Amount is" + " " + hmpgobj.getIAmntCarLoan());
			baseobj.reportPass("Sucessfully printed the Principal and Interest amount",row);

		} catch (IOException e) {
			baseobj.reportFail(e.getMessage(),row);
		}

	}
	
	@Parameters({"browser"})
	@Test(priority = 7)
	public void Car_LoanAmount_TextboxIn(@Optional String browser_value) throws IOException {
		logger = report.createTest("Car loan amount text box test - Invalid");

		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 10;
		try {
			TestData d = new TestData();
			
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.amount(getPropertiesData("Actual_CarloanIn"));
			//Assert.assertEquals(hmpgobj.getCarLnAmnt(), prop.getProperty("Actual_Carloan"));
			Assert.assertTrue(hmpgobj.getCarLnAmnt().contains("0"));
			baseobj.reportPass("Successfully entered Car loan amount text box and checked with invalid detail",row);
		
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	@Parameters({"browser"})
	@Test(priority = 8)
	public void Car_LoanInterest_TextboxIn(@Optional String browser_value) throws IOException {
		logger = report.createTest("car loan interest text box test - Invalid ");

		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 11;
		try {
TestData d = new TestData();
			
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.interest(getPropertiesData("Actual_CarIntIn"));
			hmpgobj.clickMonth();
			//Assert.assertEquals(hmpgobj.getCarLnInt(), prop.getProperty("Actual_CarInt"));
			Assert.assertTrue(hmpgobj.getCarLnInt().contains( getPropertiesData("Actual_CarInt")));
			baseobj.reportPass("Successfully entered Car interest rate text box and checked with invalid details",row);
		
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	
	@Parameters({"browser"})
	@Test(priority = 9)
	public void Car_LoanTenureYr_TextboxIn(@Optional String browser_value) throws IOException, InterruptedException {
		logger = report.createTest("Car loan tenure textbox year test - Invalid");

		BasePageClass baseobj = new BasePageClass(driver, logger);
int row = 12;
		try {
			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmpgobj.clickCarLoan();
			hmpgobj.tenure(getPropertiesData("Actual_CarTenYrIn"));
			Thread.sleep(2000);
			hmpgobj.clickMonth();
			Assert.assertEquals(hmpgobj.getCarLnTen(),getPropertiesData("Actual_CarTenYr"));
			baseobj.reportPass("Successfully entered Car loan tenure text box",row);
			
		} catch (AssertionError e) {

			baseobj.reportFail(e.getMessage(),row);
		}

	}
	
	
	

	
	
	

}
