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

public class HomePage extends ProjectSpecificationMethods{
	@FindBy(id = "signup")
	WebElement signupButton;
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement loginpwd;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage visibleSignup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(signupButton));
		Assert.assertTrue(signupButton.isDisplayed(), "Signup Button is not visible");
		return this;
	}
	
	public HomePage clickableSignup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signupButton));
		Assert.assertTrue(signupButton.isEnabled(), "Signup button is not clickable");
		return this;
	}
	
	public SignupPage clickSignup() {
		signupButton.click();
		return new SignupPage(driver);
	}
	
	public HomePage visiblelLoginSubmitBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		Assert.assertTrue(submitBtn.isDisplayed(), "Login submit button is not visible");
		return this;
	}
	
	public HomePage clickableLoginSubmit() {
		Assert.assertTrue(submitBtn.isEnabled(), "Login submit button is not clickable");
		return this;
	}
	
	public HomePage enterEmail(String mail) {
		emailId.sendKeys(mail);
		return this;
	}
	
	public HomePage enterPwd(String pwd) {
		loginpwd.sendKeys(pwd);
		return this;
	}
	
	public LoginPage clickLogin(){
		submitBtn.click();
		return new LoginPage(driver);
	}
	
//	read from excel and validate login
	
	public HomePage InvalidCredentials(String emailid, String Password) {
		emailId.sendKeys(emailid);
		loginpwd.sendKeys(Password);
		submitBtn.click();
		return this;
	}
	
	
	public HomePage ValidateLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signupButton));
		Assert.assertTrue(signupButton.isDisplayed(), "Not redirected to Login page after Logout");
		return this;
	}
	}
