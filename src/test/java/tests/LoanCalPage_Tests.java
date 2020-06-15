package tests;

import java.io.FileInputStream;
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
import pageClasses.LoanCalPage;
import utils.TestData;

public class LoanCalPage_Tests extends BaseTestClass{
	HomePage hmpgobj;
	HomeLoan hmlnobj;
	LoanCalPage lncalobj;
	
	@Parameters({"browser"})
	@Test(priority = 0)
	public void opening_LoanCalPage_Test(@Optional String browser_value) {
		logger = report.createTest("Opening Loan Calculator Page Test");
		BasePageClass baseobj = new BasePageClass(driver, logger);
		int row = 5;
		try {
			TestData d = new TestData();
			

			if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
				baseobj.invokeParallelBrowser(browser_value);
			}
			else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
				baseobj.invokeBrowser(getPropertiesData("Browser"));	
			}
			hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
			hmlnobj = hmpgobj.navigateToHmLnCal();
			lncalobj = hmlnobj.goToLoanCal();
			lncalobj.getTitle(getPropertiesData("LoanCal_Page_Title"));
			baseobj.reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " +getPropertiesData("LoanCal_Page_Title") ,row);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			baseobj.reportFail(e.getMessage(), row);
		}
		
		

	}
	
	@Parameters({"browser"})
	  @Test(priority = 1)
		public void LoanCal_LoanAmountTextbox_Test(@Optional String browser_value) throws IOException {
			logger = report.createTest("Loan Amount Text Box Test");
			BasePageClass baseobj = new BasePageClass(driver, logger);
			int row = 21;
			try {
				TestData d = new TestData();
				

				if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
					baseobj.invokeParallelBrowser(browser_value);
				}
				else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
					baseobj.invokeBrowser(getPropertiesData("Browser"));	
				}

				hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
				hmlnobj = hmpgobj.navigateToHmLnCal();
				lncalobj = hmlnobj.goToLoanCal();
				lncalobj.loanAmnt(d.getLoanAmount());
				Assert.assertEquals(getPropertiesData("Loan_Amount"),lncalobj.getlnamntvalue());
				baseobj.reportPass("Succesfully entered into Loan Amount text box",row);
				//baseobj.exit();
			}catch (AssertionError e) {
				baseobj.reportFail(e.getMessage(),row);
			}
			
		}
	@Parameters({"browser"})
	  @Test(priority= 2)
	    public void LoanCal_InterestRateTextbox_Test(@Optional String browser_value) throws IOException {
			logger = report.createTest("Interest Rate Text Box Test");
		int row = 22;
			BasePageClass baseobj = new BasePageClass(driver, logger);
			try {
TestData d = new TestData();
				

				if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
					baseobj.invokeParallelBrowser(browser_value);
				}
				else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
					baseobj.invokeBrowser(getPropertiesData("Browser"));	
				}

				hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
				hmlnobj = hmpgobj.navigateToHmLnCal();
				lncalobj = hmlnobj.goToLoanCal();
				lncalobj.loanInt(d.getInterestRate());
				Assert.assertEquals(getPropertiesData("Interest_Rate"),lncalobj.getintrtvalue());
				baseobj.reportPass("Succesfully entered into Interest Rate text box",row);
				//baseobj.exit();
			}catch (AssertionError e) {
				baseobj.reportFail(e.getMessage(),row);
			}
			
		}
	@Parameters({"browser"})
	  @Test(priority = 3)
	    public void LoanCal_TenureTextbox_Test(@Optional String browser_value) throws IOException, InterruptedException {
			logger = report.createTest("Interest Tenure  Textbox Test");
			BasePageClass baseobj = new BasePageClass(driver, logger);
			int row = 23;
			try {
TestData d = new TestData();
				

				if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
					baseobj.invokeParallelBrowser(browser_value);
				}
				else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
					baseobj.invokeBrowser(getPropertiesData("Browser"));	
				}

				hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
				Thread.sleep(3000);
				hmlnobj = hmpgobj.navigateToHmLnCal();
				lncalobj = hmlnobj.goToLoanCal();
				lncalobj.loanTerm(d.getLoanTenure());
				Assert.assertEquals(getPropertiesData("Loan_Tenure"),lncalobj.gettenurevalue());
				baseobj.reportPass("Succesfully entered into Tenure  text box",row);
				//baseobj.exit();
			}catch (AssertionError e) {
				baseobj.reportFail(e.getMessage(),row);
			}
			
		}
	@Parameters({"browser"})
		@Test(priority = 4)
	    public void LoanCal_FeesandChargesTextbox_Test(@Optional String browser_value) throws IOException, InterruptedException {
			logger = report.createTest("Interest Fees and Charges Textbox Test");
			BasePageClass baseobj = new BasePageClass(driver, logger);
			int row = 24;
			try {
TestData d = new TestData();
				

				if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
					baseobj.invokeParallelBrowser(browser_value);
				}
				else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
					baseobj.invokeBrowser(getPropertiesData("Browser"));	
				}


				hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
				Thread.sleep(3000);
				hmlnobj = hmpgobj.navigateToHmLnCal();
				lncalobj = hmlnobj.goToLoanCal();
				lncalobj.loanFees(d.getFees());
				//Assert.assertEquals(prop.getProperty("Fees_and_charges"),lncalobj.getfeesvalue());
				Assert.assertTrue(getPropertiesData("Fees_and_charges").contains(lncalobj.getfeesvalue()));
				baseobj.reportPass("Succesfully entered into Fees and Charges  text box",row);
				//baseobj.exit();
			}catch (AssertionError e) {
				baseobj.reportFail(e.getMessage(),row);
			}
			
		}
	@Parameters({"browser"})
		@Test(priority = 5)
	    public void LoanCal_EMITextbox_Test(@Optional String browser_value) throws IOException {
			logger = report.createTest("Interest EMI Textbox Test");
			BasePageClass baseobj = new BasePageClass(driver, logger);
			int row = 25;
			try {
TestData d = new TestData();
				

				if(getPropertiesData("parallel").equalsIgnoreCase("on")) {
					baseobj.invokeParallelBrowser(browser_value);
				}
				else if(getPropertiesData("parallel").equalsIgnoreCase("off")) {
					baseobj.invokeBrowser(getPropertiesData("Browser"));	
				}


				hmpgobj = baseobj.openApplication(getPropertiesData("URL"));
				hmlnobj = hmpgobj.navigateToHmLnCal();
				lncalobj = hmlnobj.goToLoanCal();
				lncalobj.clickLoanAmtCal();
				lncalobj.emi(d.getEMI());
				//Assert.assertEquals(prop.getProperty("Fees_and_charges"),lncalobj.getfeesvalue());
				Assert.assertTrue(getPropertiesData("EMI").contains(lncalobj.getEMIvalue()));
				baseobj.reportPass("Succesfully entered into EMI  text box",row);
				//baseobj.exit();
			}catch (AssertionError e) {
				baseobj.reportFail(e.getMessage(),row);
			}
			
		}
	@Parameters({"browser"})
		  @Test(priority = 6)
			public void LoanCal_LoanAmountTextbox_TestIn(@Optional String browser_value) throws IOException, InterruptedException {
				logger = report.createTest("Loan Amount Text Box Test - Invalid");
				BasePageClass baseobj = new BasePageClass(driver, logger);
				int row= 26;
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
					lncalobj = hmlnobj.goToLoanCal();
					lncalobj.loanAmnt(getPropertiesData("Loan_AmountIn"));
					lncalobj.loanInt("5");
				
					Assert.assertEquals(getPropertiesData("LoanAmount"),lncalobj.getlnamntvalue());
					baseobj.reportPass("Succesfully entered into Loan Amount text box",row);
					//baseobj.exit();
				}catch (AssertionError e) {
					baseobj.reportFail(e.getMessage(),row);
				}
				
			}
		  

		
	
	
	

}
