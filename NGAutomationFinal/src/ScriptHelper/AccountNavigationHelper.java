package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class AccountNavigationHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\AccountNavigation.xml");
	
	public AccountNavigationHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void GotoDocument() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/Topnavegation")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Top Navigation link");
		
		
		Clickon(getwebelement(xml.getlocator("//locators/Submenu")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Document Link");
		
	}
	
	public void GotoAccount() throws Exception
	{	
		Clickon(getwebelement(xml.getlocator("//locators/Customertype")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the customer type");
				
				
		Clickon(getwebelement(xml.getlocator("//locators/Customername")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Test Customer");
				
	}

//---------------------------------
	public void GotoSiebelAccount() throws Exception
	{	
		Clickon(getwebelement(xml.getlocator("//locators/SiebelAccounts")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Account link");
				
		SendKeys(getwebelement(xml.getlocator("//locators/SiebelOCN")),"4159381");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Steps: Enter the Test Customer");
		
		Clickon(getwebelement(xml.getlocator("//locators/SiebelAccountGo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Go");
		
		Clickon(getwebelement(xml.getlocator("//locators/SiebelCustomerName")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Test Customer");
				
	}
}