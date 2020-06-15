package pageClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.BasePageClass;
import bsh.ParseException;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class HomeLoan extends BasePageClass {

	public HomeLoan(RemoteWebDriver driver, ExtentTest logger) {

		super(driver, logger);
	}

	// WebElement of Home value
	@FindBy(id = "homeprice")
	WebElement hv;
	// WebElement of Down Payment
	@FindBy(id = "downpayment")
	WebElement dp;
	// WebElement of Home Insurance Amount
	@FindBy(id = "homeloaninsuranceamount")
	WebElement lins;

	// WebElement of Home Loan Amount
	@FindBy(id = "homeloanamount")
	WebElement la;
	// WebElement of Loan Interest
	@FindBy(id = "homeloaninterest")
	WebElement lint;

	// WebElement of Loan Term
	@FindBy(id = "homeloanterm")
	WebElement term;

	// WebElement of Loan fees
	@FindBy(id = "loanfees")
	WebElement fees;

	// WebElement of Start month and Year
	@FindBy(id = "startmonthyear")
	WebElement Startmandyr;

	@FindBy(css = "td#year2020")
	WebElement y2020;

	// WebElement of Calculators
	@FindBy(xpath = "/html/body/header/div/nav/div[2]/div/ul/li[1]/a")
	WebElement calbtn;

	// WebElement of Loan Calculators
	@FindBy(xpath = "//*[@id=\"menu-item-2423\"]/a")
	WebElement loanCal;
    
	//Method to enter the value in HV text box
	public void hvTxtBox(String homeValue) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		hv.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), homeValue);
		logger.log(Status.INFO, "Entered home value");
	}

	//Method to enter the value in DP text box
	public void dpTxtBox(String downPayment) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		dp.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), downPayment);
		logger.log(Status.INFO, "Entered DP");
	}
	
	//Method to enter the value in LI text box
	public void liTxtBox(String loanInsurance) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		lins.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), loanInsurance);
		logger.log(Status.INFO, "Entered Loan Insurance");
	}

	//Method to enter the value in LA text box
	public void laTxtBox(String loanAmount) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		la.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), loanAmount);

	}

	//Method to enter the value in IR text box
	public void irTxtBox(String interestRate) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		lint.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), interestRate);
		logger.log(Status.INFO, "Entered Interest Rate");
	}
	
	
	//Method to enter the value in Fees text box
	public void feesTxtBox(String Fees) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		fees.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Fees);
		logger.log(Status.INFO, "Entered Fees");
	}

	//Method to enter the value in Tenure text box
	public void tenureTxtBox(String tenure) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		term.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), tenure);
		logger.log(Status.INFO, "Entered Tenure");
	}

	//Method to select the starting month and year
	public void selectDateIncalendar(String date) throws Exception {
		Startmandyr.click();
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy");
		Date expectedDate = dateFormat.parse(date);

		// String day = new SimpleDateFormat("dd").format(expectedDate);
		String month = new SimpleDateFormat("MMM").format(expectedDate);
		String year = new SimpleDateFormat("yyyy").format(expectedDate);

		String expectedYear = year;

		while (true) {
			String displayDate = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]"))
					.getText();

			if (expectedYear.equals(displayDate)) {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//span[text()= '" + month + "']")).click();

				break;
			} else if (expectedDate.compareTo(currentDate) > 0) {
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[3]")).click();
			} else {
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[1]")).click();
			}

		}

	}

	//method to click the button 2020
	public void click2020() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
			y2020.click();
		

	}

	//Method to navigate to next page
	public LoanCalPage goToLoanCal() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		calbtn.click();
		loanCal.click();
		LoanCalPage lncalpgobj = new LoanCalPage(driver, logger);
		PageFactory.initElements(driver, lncalpgobj);
		return lncalpgobj;

	}

	public void ExportToExcel() throws FileNotFoundException {
		File source = new File("C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Test Data\\writing.xlsx");

		FileInputStream fis = new FileInputStream(source);

		
///html/body/div/div/main/article/div[3]/div/div[8]/table/tbody/tr[2]/td[2]
		///html/body/div/div/main/article/div[3]/div/div[8]/table/tbody/tr[2]/td[3]
	
		try {
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");

		String BeforePath = "//*[@id='paymentschedule']/table/tbody/tr[";
		//[@id='paymentschedule']/table/tbody/tr["\/td[2]
		String AfterPathPrincipal ="]/td[2]";
		String AfterPathInterest ="]/td[3]";
		String AfterPathTax ="]/td[4]";
		String AfterPathTotal ="]/td[5]";
		String AfterPathBalance ="]/td[6]";
		String AfterPathPaidPerct ="]/td[7]";

		String h0=driver.findElement(By.xpath("//*[@id='yearheader']")).getText();
		String h1=driver.findElement(By.xpath("//*[@id='principalheader']")).getText();
		String h2=driver.findElement(By.xpath("//*[@id='interestheader']")).getText();
		String h3=driver.findElement(By.xpath("//*[@id='insuranceandtaxesheader']")).getText();
		String h4=driver.findElement(By.xpath("//*[@id='totalheader']")).getText();
		String h5=driver.findElement(By.xpath("//*[@id='balanceheader']")).getText();
		String h6=driver.findElement(By.xpath("//*[@id='paidtodateheader']")).getText();


		sh.createRow(9).createCell(0).setCellValue(h0);
		sh.getRow(9).createCell(1).setCellValue(h1);
		sh.getRow(9).createCell(2).setCellValue(h2);
		sh.getRow(9).createCell(3).setCellValue(h3);
		sh.getRow(9).createCell(4).setCellValue(h4);
		sh.getRow(9).createCell(5).setCellValue(h5);
		sh.getRow(9).createCell(6).setCellValue(h6);
		int year =2020;


		for(int i= 2; i<=12 ;i=i+2)
		{
		String ActualP = BeforePath+i+AfterPathPrincipal;
		String ActualI = BeforePath+i+AfterPathInterest;
		String ActualT = BeforePath+i+AfterPathTax;
		String Actualtot = BeforePath+i+AfterPathTotal;
		String ActualB = BeforePath+i+AfterPathBalance;
		String ActualL = BeforePath+i+AfterPathPaidPerct;

		String amount1 = driver.findElement(By.xpath(ActualP)).getText();
		String amount2 = driver.findElement(By.xpath(ActualI)).getText();
		String amount3 = driver.findElement(By.xpath(ActualT)).getText();
		String amount4 = driver.findElement(By.xpath(Actualtot)).getText();
		String amount5 = driver.findElement(By.xpath(ActualB)).getText();
		String amount6 = driver.findElement(By.xpath(ActualL)).getText();

		int j=i/2;

		sh.createRow(j+9).createCell(0).setCellValue(year);
		sh.getRow(j+9).createCell(1).setCellValue(amount1);
		sh.getRow(j+9).createCell(2).setCellValue(amount2);
		sh.getRow(j+9).createCell(3).setCellValue(amount3);
		sh.getRow(j+9).createCell(4).setCellValue(amount4);
		sh.getRow(j+9).createCell(5).setCellValue(amount5);
		sh.getRow(j+9).createCell(6).setCellValue(amount6);
		year++;

		System.out.println(amount1+"  "+amount2+"   "+amount3+"  "+amount4+"  "+amount5+"  "+amount6);

		}

		FileOutputStream fos = new FileOutputStream(source);

		wb.write(fos);
		wb.close();
		//	reportPass("Sucessfully Stroed data in Excel");
		} catch (IOException e) {
			//reportFail(e.getMessage());
		}

	}

	//Methods to get the entered values from text boxes
	public String gethvvalue() {
		return hv.getAttribute("value");

	}

	public String getdpvalue() {
		return dp.getAttribute("value");

	}

	public String getlivalue() {
		return lins.getAttribute("value");

	}

	public String getirvalue() {
		return lint.getAttribute("value");

	}

	public String getltvalue() {
		return term.getAttribute("value");

	}

	public String getlfeesvalue() {
		return fees.getAttribute("value");

	}

}
