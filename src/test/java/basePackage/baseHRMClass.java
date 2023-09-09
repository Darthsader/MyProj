package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseHRMClass {

	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	
	
	//Step 1
	public baseHRMClass() {
		
		
	    try {
			FileInputStream file=new FileInputStream("/Users/nagyida/eclipse-workspace/HRmanagement/src/test/java/Environmentvariables/Config.properties");
		    prop.load(file);
		}
	    
	    catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	    catch(IOException a) {
	    	a.printStackTrace();
	    }
	}
	
	//Step 2
	
	public static void initiation() {
	String browsername=prop.getProperty("browser");
	if (browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","/Users/nagyida/Desktop/java/geckodriver" );
		
		driver= new FirefoxDriver();}
		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/nagyida/Desktop/chrome-mac-x64/Google Chrome for Testing.app");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void Screenshot(String Filename) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("/Users/nagyida/eclipse-workspace/HRmanagement/src/test/java/Screenshot/screenshots" +Filename+".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	}


	
