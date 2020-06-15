package pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.BasePageClass;

public class LoanCalPage extends BasePageClass {
	public LoanCalPage(RemoteWebDriver driver, ExtentTest logger) {
		
		super(driver,logger);
		
	}
	
	//WebElement of Loan amount text box
	@FindBy(id = "loanamount")
	WebElement Loanamt;
	
	//WebElement of Loan Interest text box
	@FindBy(id = "loaninterest")
	WebElement Loanint;
	
	//WebElement of Loan term text box
	@FindBy(id = "loanterm")
	WebElement Loantrm;
	
	//WebElement of Loan Fees text box
	@FindBy(id = "loanfees")
	WebElement Loanfees;
	
	//WebElement of EMI in arrears button
	@FindBy(xpath = "//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	WebElement emiarr;
	
	//WebElement of Loan Calculator button
	@FindBy(xpath="//*[@id=\"loan-amount-calc\"]/a[1]")
	WebElement Loanamtcal;
	
	////WebElement of EMI text box
	@FindBy(id = "loanemi")
	WebElement EMI;
	
	//Method to enter into Loan Amount textbox
	public void loanAmnt(String loanAmount) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Loanamt.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),loanAmount);
		logger.log(Status.INFO, "Successfully entered into Loan Amount Textbox");
	}
	
	//Method to enter into Loan Interest textbox
	public void loanInt(String loanIntrst) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Loanint.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),loanIntrst);
		logger.log(Status.INFO, "Successfully entered into Interest Rate Textbox");
	}
	
	//Method to enter into Loan Tenure textbox
	public void loanTerm(String loantenure) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Loantrm.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),loantenure);
		logger.log(Status.INFO, "Successfully entered into Tenure textbox");
	}
	
	////Method to enter into Loan Fees textbox
	public void loanFees(String loanfees) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		Loanfees.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),loanfees);
		logger.log(Status.INFO, "Successfully entered into Fees textbox");
	}
	
	//Method to click emi arrear button 
	public void clckemiarr() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		emiarr.click();
		
	}
	
	//Method to click Loan Amount Calculator button
	public void clickLoanAmtCal() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Loanamtcal.click();
	}
	
	
	//Method to enter EMI amount 
	public void emi(String EMIAmnt){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		EMI.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),EMIAmnt);
		logger.log(Status.INFO, "Successfully entered into EMI textbox");
		
	}
	
	
	//Methods to get the entered values in text boxes
	public String getlnamntvalue() {
		return Loanamt.getAttribute("value");
	}
	public String getintrtvalue() {
		return Loanint.getAttribute("value");
	}
	public String gettenurevalue() {
		return Loantrm.getAttribute("value");
	}
	public String getfeesvalue() {
		return Loanfees.getAttribute("value");
	}
	public String getEMIvalue() {
		return EMI.getAttribute("value");
	}
	
	

}
