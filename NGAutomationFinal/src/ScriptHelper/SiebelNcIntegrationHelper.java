package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class SiebelNcIntegrationHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\SiebelNcIntegration.xml");
	
	public SiebelNcIntegrationHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void NcIntegrationCompositeOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/ProdIdFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Product ID Filter");
		Thread.sleep(40000);
		Select(getwebelement(xml.getlocator("//locators/FilterSelectProdId")),"Product ID");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Product ID in Filter");
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),SiebelOrderHelper.CircuitRefnumber);
//		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),"FRA/FRA/LE-500177");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Circuit ID provided for further processing");
		Thread.sleep(40000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Product ID link");
		Clickon(getwebelement(xml.getlocator("//locators/OrderLink")));
		Thread.sleep(10000);
		Ordernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(Ordernumber);
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Log.info(arrOfStr[1]);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Triggered in Siebel Generated : "+Ordernumber);
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderStarted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Started')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Started");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
	}

	public void NcIntegrationSpokeOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/ProdIdFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Product ID Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectProdId")),"Product ID");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Product ID in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),CircuitRefnumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Circuit ID provided for further processing");
		Clickon(getwebelement(xml.getlocator("//locators/SelectLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Product ID link");
		Clickon(getwebelement(xml.getlocator("//locators/OrderLink")));
		Thread.sleep(10000);
		SpokeOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(SpokeOrdernumber);
		String[] arrOfStr = SpokeOrdernumber.split("#", 0); 
		Log.info(arrOfStr[1]);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Triggered in Siebel Generated : "+SpokeOrdernumber);
		SpokeOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(SpokeOrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderStarted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Started')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Started");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
	}
	
	public void NcIntegrationModOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/ProdIdFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Product ID Filter");
		Thread.sleep(40000);
		Select(getwebelement(xml.getlocator("//locators/FilterSelectProdId")),"Product ID");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Product ID in Filter");
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),SiebelModifyHelper.ModifiedCircuitRefnumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Circuit ID provided for further processing");
		Thread.sleep(40000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Product ID link");
		Clickon(getwebelement(xml.getlocator("//locators/OrderLink")));
		Thread.sleep(10000);
		ModifiedOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(ModifiedOrdernumber);
		String[] arrOfStr = ModifiedOrdernumber.split("#", 0); 
		Log.info(arrOfStr[1]);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Triggered in Siebel Generated : "+ModifiedOrdernumber);
		ModifyOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(ModifyOrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderStarted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Started')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Started");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
	}
}
