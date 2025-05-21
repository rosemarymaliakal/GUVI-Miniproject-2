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

public class LogoutPage extends ProjectSpecificationMethods {
	
	@FindBy(id = "logout")
	WebElement logoutBtn;
	
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public LogoutPage visibleLogoutBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		Assert.assertTrue(logoutBtn.isDisplayed(), "Logout button is not visible");
		return this;
	}
	
	public HomePage clickLogout() {
		logoutBtn.click();
		return new HomePage(driver);
	}
}

