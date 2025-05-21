package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class AddNewContactPage extends ProjectSpecificationMethods {

	@FindBy(id = "firstName")
	WebElement fname;
	
	@FindBy(id = "lastName")
	WebElement lname;
	
	@FindBy(id = "birthdate")
	WebElement dob;
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "phone")
	WebElement phonenumber;
	
	@FindBy(id = "street1")
	WebElement sAddress_1;
	
	@FindBy(id = "street2")
	WebElement sAddress_2;
	
	@FindBy(id = "city")
	WebElement cityname;
	
	@FindBy(id = "stateProvince")
	WebElement statename;
	
	@FindBy(id = "postalCode")
	WebElement pincode;
	
	@FindBy(id="country")
	WebElement countryname;
	
	@FindBy(id = "submit")
	WebElement addSubmit;
	
	
	
	public AddNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public AddNewContactPage enterfirstName(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fname));
		fname.sendKeys(firstname);
		return this;
	}
	
	public AddNewContactPage enterLastname(String lastname) {
		lname.sendKeys(lastname);
		return this;
	}
	
	public AddNewContactPage enterBirthdate(String dateofbirth) {
		dob.sendKeys(dateofbirth);
		return this;
	}
	
	public AddNewContactPage enterEmailid(String emailid) {
		emailId.sendKeys(emailid);
		return this;
	}
	
	public AddNewContactPage enterPhonenumber(String PhNumber) {
		phonenumber.sendKeys(PhNumber);
		return this;
	}
	
	public AddNewContactPage enterfirstAddress(String Add_1) {
		sAddress_1.sendKeys(Add_1);
		return this;
	}
	
	public AddNewContactPage entersecondAddress(String Add_2) {
		sAddress_2.sendKeys(Add_2);
		return this;
	}
	
	public AddNewContactPage enterCityname(String city) {
		cityname.sendKeys(city);
		return this;
	}
	
	public AddNewContactPage enterStatename(String state) {
		statename.sendKeys(state);
		return this;
	}
	
	public AddNewContactPage enterPin(String pcode) {
		pincode.sendKeys(pcode);
		return this;
	}
	
	public AddNewContactPage enterCountryname(String countryName) {
		countryname.sendKeys(countryName);
		return this;
	}
	

	public ContactPage clickAddSubmit() {
		addSubmit.click();
		return new ContactPage(driver) ;
	}
	
	
	
}
