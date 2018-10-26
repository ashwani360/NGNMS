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

public class LoginHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Login.xml");
	
	public LoginHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void Login(String Application) throws Exception
	{
		openurl(Application);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to "+Application+" Login Page");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Username")),Getkeyvalue(Application+"_Username"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Password")),Getkeyvalue(Application+"_Password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/Loginbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
		
	}
	
	public void VerifySuccessLogin(String application) throws Exception
	{	
		Assert.assertEquals(Getkeyvalue(application+"_LoggedinUser").contains(Gettext(getwebelement(xml.getlocator("//locators/"+application+"/Userinfo")))),true);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify Correct user has been logged in");
		
	}
	
	
	public void SkipWarning(String application) throws Exception, DocumentException
	{
		Clickon(getwebelement(xml.getlocator("//locators/"+application+"/skipwarning")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on continue to skip the timezone warning");
	}

//---------------------------------
	
	public void SiebelLogin(String Application) throws Exception
	{
		openurl(Application);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navegated to "+Application+" Login Page");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelUsername")),Getkeyvalue(Application+"_Username"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter User Name");
		
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelPassword")),Getkeyvalue(Application+"_Password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Password");
		
		Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/SiebelLoginbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Login Button");
		
	}
	
}
