package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetname="Login";
		testName="Login Test";
		testDescription="Testing login submit Button visiblity,clickable,Modal opening";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test(dataProvider = "readData")
	
	public void loginTest(String Email, String Password, String TestType, String ExpectedMessage) {
		HomePage obj = new HomePage(driver);
		obj.visiblelLoginSubmitBtn()
		.clickableLoginSubmit()
		.enterEmail(Email)
		.enterPwd(Password)
		.clickLogin()
		.validateLogin(TestType, ExpectedMessage);
		
	}

}
