package Testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.baseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends baseHRMClass {

	PomLogin Log = new PomLogin();
    
	public LoginTest() {
		super();

	}

	@BeforeMethod
	public void initsetup() {
		initiation();
		Screenshot("Logon");

		Log = new PomLogin();
	}

	@Test(priority=1)
	public void Title() {
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");

	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
		
		
		
	}

	@Test(priority=2, dataProvider="Details")
	public void Login(String name,String password) {
	    Log.typeUsername(name); 
		Log.typePassword(password);
		//Log.clickBtn();
	}

	 @AfterMethod 
	public void quit() {
		driver.quit();
	}

}