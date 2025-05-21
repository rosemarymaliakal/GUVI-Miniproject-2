package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class ContactDisplayPage extends ProjectSpecificationMethods {
	
	public ContactDisplayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
