package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LogoutPage;

public class TC_007_LogoutTest extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setup() {
		testName="Logout Test";
		testDescription="Testing of Logout Button display, page redirection to Login page";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}

	@Test
	
	public void LogoutTest() {
		HomePage obj = new HomePage(driver);
		obj.enterEmail("roseqwerty@gmail.com")
		.enterPwd("qwerty12")
		.clickLogin();
		
		LogoutPage obj1 = new LogoutPage(driver);
		obj1.visibleLogoutBtn()
		.clickLogout()
		.ValidateLogout();
	}
}
