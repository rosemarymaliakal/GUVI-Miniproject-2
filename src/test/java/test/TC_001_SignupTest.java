package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_SignupTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Signup Test";
		testDescription="Testing Signup Button is visiblity,clickable,Modal opening";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	
	public void signupTest() {
		HomePage obj = new HomePage(driver);
		obj.visibleSignup()
		.clickableSignup()
		.clickSignup()
		.signupPageTitle()
		.enterUsername()
		.enterLastname()
		.entermail()
		.enterPassword()
		.clickSubmit();
	}
}
