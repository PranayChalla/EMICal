package pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.BasePageClass;

public class HomePage extends BasePageClass {

	public HomePage(RemoteWebDriver driver , ExtentTest logger) {
		
		super(driver,logger);
		
	}

	// WebElement of Car Loan button
	@FindBy(xpath = "//*[@id=\"car-loan\"]/a")
	WebElement carLoanbtn;

	// WebElement of Car Loan Amount textbox
	@FindBy(id = "loanamount")
	WebElement carLoanamt;

	// WebElement of Interest rate textbox
	@FindBy(id = "loaninterest")
	WebElement interestRate;

	// WebElement of Loan Tenure textbox
	@FindBy(id = "loanterm")
	WebElement loanTenure;
	
	//WebElement of month button
	@FindBy(xpath = "//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[2]")
	WebElement mnbtn;
	
	

	// WebElement of EMI in Arrear button
	@FindBy(xpath = "//*[@id='leschemewrapper']/div/div/div/div/label[2]")
	WebElement EMIinArr;
    
	//WebElement for dropwdown 
	@FindBy(xpath = "//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement dropdown;

	// WebElement of 2020 button
	@FindBy(id = "year2020")
	WebElement yearbutton;

	// WebElement of Principal amount
	@FindBy(xpath = "//*[@id=\"monthyear2020\"]/td/div/table/tbody/tr[1]/td[2]")
	WebElement PAmntCar;

	// WebElement of Interest amount
	@FindBy(xpath = "//*[@id=\"monthyear2020\"]/td/div/table/tbody/tr[1]/td[3]")
	WebElement IAmntCar;

     //WebElement of Calculators
	@FindBy(xpath="/html/body/header/div/nav/div[2]/div/ul/li[1]/a")
	WebElement calbtn;
	
	//WebElement of Home Loan 
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a")
	WebElement hmlnbtn;
	

	// method for clicking Car Loan Button
	public void clickCarLoan() {
		int row = 2;
		try {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		carLoanbtn.click();
		reportPass("Car loan button clicked",row);
		}
		catch(Exception e) {
			reportFail(e.getMessage(),row);
		}
		
	}

	// method to enter the loan amount
	public void amount(String LoanAmount) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		carLoanamt.clear();
		carLoanamt.sendKeys(LoanAmount);
		logger.log(Status.INFO, "Carloan amount entered");
		
		
	}

	// method to enter the interest rate
	public void interest(String Interest) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		interestRate.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Interest);
		logger.log(Status.INFO,"Car interest entered");
		
	}

	// method to enter the Tenure
	public void tenure(String Tenure) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		loanTenure.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Tenure);
		logger.log(Status.INFO,"Car tenure entered");
	}

	// method to click the EMI in Arrear button
	public void EMIArrearClick() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		EMIinArr.click();
		logger.log(Status.INFO,"EMI in arrers button clicked");
	}

	// method to click the 2020 button
	public void year2020Click() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		yearbutton.click();
		logger.log(Status.INFO,"2020  button clicked");
	}

	// method to get the Pamount
	public String getPAmntCarLoan() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return PAmntCar.getText();

	}

	// method to get the Iamount
	public String getIAmntCarLoan() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		return IAmntCar.getText();
		

	}
	
	//Method to clcik the month button
	public void clickMonth() {
		mnbtn.click();
		logger.log(Status.INFO, "Month button clicked");
		
	}
	
	//method to click the select from drop down
	public HomeLoan navigateToHmLnCal() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		calbtn.click();
		
		hmlnbtn.click();
		
		 logger.log(Status.INFO,"Clicked Home Loan Button");
	
	
		
		
		
		HomeLoan hmlnobj = new HomeLoan(driver,logger);
	 PageFactory.initElements(driver, hmlnobj);
	 return hmlnobj;
		
	}
	
//returns the values entered in the text boxes
public String getCarLnAmnt() {
	return carLoanamt.getAttribute("value");
}
public String getCarLnInt() {
	return interestRate.getAttribute("value");
}
public String getCarLnTen() {
	return loanTenure.getAttribute("value");
}

	

}
