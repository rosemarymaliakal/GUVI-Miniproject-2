package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ContactPage extends ProjectSpecificationMethods {

	@FindBy(id = "add-contact")
	WebElement addContact;
	
	@FindBy(tagName = "h1")
	WebElement heading;
	
	@FindBy(id = "myTable")
	WebElement contactTable;
	
	@FindBy(xpath = "//table[@id='myTable']/tr[1]/td[2]")
	WebElement FirstContact;
	
	@FindBy(xpath = "//table[@class='contactTable']")
	WebElement originalTable;
	
	@FindBy(xpath = "//table[@id='myTable']/tr[1]/td[4]")
	WebElement mailId;
	
	@FindBy(id = "error")
	WebElement errorMsg;
	
	public static String contactfirstemail;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddNewContactPage clickOnNewContact() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addContact));
		addContact.click();
		return new AddNewContactPage(driver);
	}
	
	public ContactPage validateWithMandatoryFields() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(heading));
		String pageheading = heading.getText();
		Assert.assertEquals(pageheading, "Contact List", "New contact not added with the mandatory fields");
		return this;
	}
	
	public ContactPage validateWithDateFormat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		String ActualError = errorMsg.getText();
		Assert.assertTrue(ActualError.equalsIgnoreCase("Contact validation failed: birthdate: Birthdate is invalid"), "New contact list created with Invalid date format");
		return new ContactPage(driver);
	}
	
	public FirstContactPage clickOnFirstData() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(contactTable));
		contactfirstemail = mailId.getText();
		FirstContact.click();
		return new FirstContactPage(driver);
	}
	
	public ContactPage validateDeletion() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(originalTable));
		List <WebElement> contactElements = driver.findElements(By.linkText(contactfirstemail));
		Assert.assertTrue(contactElements.isEmpty(), "Contact not deleted ");
		return this;
	}
}
