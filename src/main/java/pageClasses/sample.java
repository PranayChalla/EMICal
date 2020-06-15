package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class sample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\Pranay challa\\Desktop\\Hackathon Project\\msedgedriver.exe"); 
		 
        WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");

	}

}
