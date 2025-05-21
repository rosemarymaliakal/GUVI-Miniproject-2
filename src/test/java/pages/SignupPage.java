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

public class SignupPage extends ProjectSpecificationMethods {
	
	@FindBy(tagName = "h1")
	WebElement pageTitle;

	@FindBy(id = "firstName")
	WebElement firstname;
	
	@FindBy(id = "lastName")
	WebElement lastname;
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement pwd;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignupPage signupPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pageTitle));
		String title = driver.getTitle();
		Assert.assertEquals("Add User", title, "Not redirected to Add user page after click on signup" );
		return this;
	}

	public SignupPage enterUsername() {
		firstname.sendKeys("rose");
		return this;
	}
	
	public SignupPage enterLastname() {
		lastname.sendKeys("mary");
		return this;
	}
	
	public SignupPage entermail() {
		emailId.sendKeys("roseqwerty1@gmail.com");
		return this;
	}
	
	public SignupPage enterPassword() {
		pwd.sendKeys("qwerty123");
		return this;
	}
	
	public SignupPage clickSubmit() {
		submitBtn.click();
		return this;
	}
}
