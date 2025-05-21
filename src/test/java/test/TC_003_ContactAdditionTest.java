package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.ContactPage;
import pages.HomePage;

public class TC_003_ContactAdditionTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetname="ContactList";
		testName="Contact Details Test";
		testDescription="Testing of adding contact details";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	
	public void contactTest() {
		HomePage obj = new HomePage(driver);
		obj.enterEmail("roseqwerty1@gmail.com")
		.enterPwd("qwerty123")
		.clickLogin();
		
		ContactPage obj1 = new ContactPage(driver);
		obj1.clickOnNewContact()
		.enterfirstName("arun")
		.enterLastname("Kumar")
		.clickAddSubmit()
		.validateWithMandatoryFields();
		
		
		obj1.clickOnNewContact()
		.enterfirstName("Geetha")
		.enterLastname("Sing")
		.enterBirthdate("21-21-21")
		.clickAddSubmit()
		.validateWithDateFormat();
		
		
	}

}
