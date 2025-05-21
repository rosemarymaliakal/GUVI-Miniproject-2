package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class FirstContactPage extends ProjectSpecificationMethods {
	
	@FindBy(id = "contactDetails")
	WebElement details;
	
	@FindBy(id = "delete")
	WebElement deleteBtn;
		
	public FirstContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public FirstContactPage clickOnDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(details));
		deleteBtn.click();
		return this;
	}
	
	public ContactPage alertDisplayonClickDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertmsg = driver.switchTo().alert();
		alertmsg.accept();
		return new ContactPage(driver) ;
		
	}
	
	

}
