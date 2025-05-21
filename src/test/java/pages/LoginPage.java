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

public class LoginPage extends ProjectSpecificationMethods {

	@FindBy(id = "add-contact")
	WebElement loginPageElement;
	
	@FindBy(id = "error")
	WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

public void validateLogin(String testType, String ExpectedMessage) {
		
		if(testType.equalsIgnoreCase("Valid Credentials")) {
//			String actualMessage = contactList.getText();
//			Assert.assertEquals(actualMessage, ExpectedMessage);
			Assert.assertTrue(loginPageElement.isDisplayed(), ExpectedMessage);
		} 
		else if(testType.equalsIgnoreCase("Invalid Credentials")) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOf(errorMsg));
			String actualMessage = errorMsg.getText();
			Assert.assertEquals(actualMessage, ExpectedMessage);
		}
	}
	

}
