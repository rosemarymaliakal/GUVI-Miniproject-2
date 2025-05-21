package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility {
	
	@DataProvider
	
	public String[][] readData() throws IOException {
		String[][] data = readExcel(sheetname);
		return data;
	}
	
	@BeforeSuite
	public void reportInitialization() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\arunc\\eclipse-workspace\\GuviMiniProject2\\src\\test\\resources\\report\\ContactListApp.html");
		reporter.config().setReportName("Contact List App Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@Parameters("url")
	@BeforeMethod
	public void launchBrowser(String url) {
		openUrl(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeUrl();
	}
	
	@AfterSuite
	public void closeReport() {
		extent.flush();
	}

}
