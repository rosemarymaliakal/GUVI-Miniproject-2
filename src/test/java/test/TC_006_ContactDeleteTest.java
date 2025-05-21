package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.ContactPage;
import pages.HomePage;

public class TC_006_ContactDeleteTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Contact Details Test";
		testDescription="Testing of adding contact details";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	
	public void ContactDeletionTest() {
		HomePage obj = new HomePage(driver);
		obj.enterEmail("roseqwerty@gmail.com")
		.enterPwd("qwerty12")
		.clickLogin();
		
		ContactPage obj1 = new ContactPage(driver);
		obj1.clickOnFirstData()
		.clickOnDelete()
		.alertDisplayonClickDelete()
		.validateDeletion();
		
//		write code for 3rd case
	}

}
