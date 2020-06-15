package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.BasePageClass;
import baseClasses.BaseTestClass;
import pageClasses.HomeLoan;
import pageClasses.HomePage;
import utils.TestData;


public class HomeLoanPage_Tests extends BaseTestClass{
	HomePage hmpgobj;
	HomeLoan hmlnobj;

	
	@Parameters({"browser"})
	@Test(priority = 0)
	public void opening_HomeLoanPage_Test(@Optional String browser_value) {
		logger = report.createTest("Opening Home loan Page Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
int row = 4;
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

			hmpgobj.interest(d.getInterest());
			hmpgobj.tenure(d.getTenureYr());

			hmpgobj.EMIArrearClick();

			hmpgobj.year2020Click();
			Thread.sleep(2000);

			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.getTitle(getPropertiesData("HomeLoan_Page_Title"));
			baseobj.reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " +getPropertiesData("HomeLoan_Page_Title") ,row);
		} catch (Exception e) {

		baseobj.reportFail(e.getMessage(),row);
		}
		        

	}
	
	@Parameters({"browser"})
	@Test(priority = 1)
	public void HomeLoanPage_HVTextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("Home Value Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 13;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			//System.out.println(d.);
			hmlnobj.hvTxtBox(d.getHV());
			Assert.assertEquals(getPropertiesData("HV_Value"),hmlnobj.gethvvalue());
			baseobj.reportPass("Succesfully entered into HV text box",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	@Parameters({"browser"})
	@Test(priority = 2)
	public void HomeLoanPage_DPTextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("DownPayment Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 14;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.dpTxtBox(d.getDP());//
			Assert.assertEquals(getPropertiesData("DP_Value"),hmlnobj.getdpvalue());
			baseobj.reportPass("Succesfully entered into down Payment text box",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	
	@Parameters({"browser"})
	@Test(priority = 3)
	public void HomeLoanPage_LITextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("Loan Insurance Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 15;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.liTxtBox(d.getLI());
			Assert.assertEquals(getPropertiesData("LI_Value"),hmlnobj.getlivalue());
			baseobj.reportPass("Succesfully entered into Loan Insurance text box",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
	}
	@Parameters({"browser"})
	@Test(priority = 4)
	public void HomeLoanPage_IRTextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("Loan Interest Rate Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 16;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.irTxtBox(d.getIR());
			Assert.assertEquals(getPropertiesData("IR_Value"),hmlnobj.getirvalue());
			baseobj.reportPass("Succesfully entered into Interest Rate text box",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	
	@Parameters({"browser"})
	@Test(priority = 5)
	public void HomeLoanPage_LTTextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("Loan Tenure Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 17;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.tenureTxtBox(d.getLT());
			Assert.assertEquals(getPropertiesData("LT_Value"),hmlnobj.getltvalue());
			baseobj.reportPass("Succesfully entered into Loan Tenure text box",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	@Parameters({"browser"})
	@Test(priority = 6)
	public void HomeLoanPage_LFeesTextbox_Test(@Optional String browser_value) throws Exception {
		logger = report.createTest("Loan Fees Text Box Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 18;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.feesTxtBox(d.getLFees());
			Assert.assertEquals(getPropertiesData("LFees_Value"),hmlnobj.getlfeesvalue());
			baseobj.reportPass("Succesfully entered into Loan Fees text box",row);
		//	baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	
	@Parameters({"browser"})
	@Test(priority = 7)
	public void HomeLoanPage_HVTextbox_TestIn(@Optional String browser_value) throws IOException, InterruptedException {
		logger = report.createTest("Home Value Text Box Test with invalid details");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 19;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.hvTxtBox(getPropertiesData("HV_ValueIn"));
			hmlnobj.dpTxtBox("20");
			Thread.sleep(2000);
			Assert.assertEquals(getPropertiesData("HV_Value"),"6000000");
			baseobj.reportPass("Succesfully entered into HV text box and checked with invalid details",row);
			//baseobj.exit();
		} catch (AssertionError e) {
			baseobj.reportFail(e.getMessage(),row);
		}
		
		
	}
	@Parameters({"browser"})
	@Test(priority = 8)
	public void Exporting_Data_To_Excel(@Optional String browser_value) throws Exception {
		logger = report.createTest("Home Value Text Box Test with invalid details");
		BasePageClass baseobj = new BasePageClass(driver, logger);
	int row = 20;
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
			hmlnobj = hmpgobj.navigateToHmLnCal();
			hmlnobj.dpTxtBox(d.getHV());
			hmlnobj.liTxtBox(d.getDP());
			hmlnobj.irTxtBox(d.getIR());
			hmlnobj.tenureTxtBox(d.getLT());
			hmlnobj.feesTxtBox(d.getLFees());
			hmlnobj.selectDateIncalendar("Jun/2020");
			hmlnobj.ExportToExcel();
			baseobj.reportPass("Successfully printed data in excel", row);
		} catch (FileNotFoundException e) {
			baseobj.reportFail(e.getMessage(), row);
			
		}
		
		
	}
	

}
