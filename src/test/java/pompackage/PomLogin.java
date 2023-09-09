package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseHRMClass;

public class PomLogin extends baseHRMClass {
	
	
	//obj repository
	// Wait for the Username input field to be visible before interacting with it
	@FindBy(css ="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
     WebElement Username;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input") 
	WebElement Password;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement Loginbtn;
	
	
	//initate page elements
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeUsername(String name) {
		
	Username.sendKeys(name);
	}
	
	public void typePassword(String pass) {
		Password.sendKeys(pass); 
	}
	
	public void clickBtn() {
		Loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
	}
}
