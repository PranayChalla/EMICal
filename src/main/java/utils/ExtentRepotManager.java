package utils;


import java.util.Date;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepotManager {
	public static ExtentReports report;
	public static ExtentReports getReportInstance(){
		Date date = new Date();
		String Timestamp =  date.toString().replaceAll(":", "-").replaceAll(" ", "_");
		    
		
		if(report == null){
			String reportName =Timestamp+".html";  
			ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Reports\\test-output"+reportName);
			report  = new ExtentReports();
			report.attachReporter(htmlReporter);
			// to generate what we are using 
			report.setSystemInfo("OS", "windows10");
			
			//to set report variables
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle("UIT AI Automachine");
			htmlReporter.config().setReportName("EMI Calculator ");
			htmlReporter.config().setTimeStampFormat("MM dd,yyyy HH:mm:ss");
		}
		  return report;
		//this will define in base class
	}

}
