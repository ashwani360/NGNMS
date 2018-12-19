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
import ScriptHelper.CompositeOrderHelper;

public class ModifyOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\ModifyOrder.xml");
	
	public ModifyOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void SoftModCompositOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for Modification provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[2].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Completed");
//		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
//		Log.info(OrderscreenURL);
//		Geturl(OrderscreenURL);
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
		ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/ProductInstNumber")));
		Log.info(ProductInstancenumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number");
		String[] arrOfStr1 = ProductInstancenumber.split("#", 0); 
		Log.info(arrOfStr1[1]);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for Modification provided");
//		Clickon(getwebelement(xml.getlocator("//locators/FilterInputValue")));
//		Clickon(getwebelement(xml.getlocator("+arrOfStr1[1]+")));
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button ");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
		Clickon(getwebelement(xml.getlocator("//locators/ModifyCompositOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modify Composite Order button");
		Thread.sleep(10000);
		ModifiedOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(ModifiedOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+ModifiedOrdernumber);
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
		Log.info(arrOfStr2[1]);
		ModifyOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(ModifyOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Modified Order");		
//		Will it create disconnected order in orders page or it will be there in same screen.
	}

	public void EditProduct(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/UndelyingModifiedOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Inflight Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		getwebelement(xml.getlocator("//locators/ServiceBandwidth")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[4].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Bandwidth field updated");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(ModifyOrderscreenURL);
	}

	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(ModifyOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/ModifySuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Modified Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button");
		Thread.sleep(20000);
		Geturl(ModifyOrderscreenURL);
	}
	
	public void EditProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(20000);
		Geturl(ModifyOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/ModifyEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to A End site product order");
		EndCheck=GetText(getwebelement(xml.getlocator("//locators/EndCheck")));
		Log.info(EndCheck);
		if (EndCheck.equalsIgnoreCase(Inputdata[3].toString()))
		{
//		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
//		Thread.sleep(20000);
//		Geturl(ModifyOrderscreenURL);
//		Clickon(getwebelement(xml.getlocator("//locators/ModifyEndSiteProductAend")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to A End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to General Information Tab");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link");
		SendKeys(getwebelement(xml.getlocator("//locators/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		SendKeys(getwebelement(xml.getlocator("//locators/VlanTagId")),Inputdata[7].toString());
//		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		Select(getwebelement(xml.getlocator("//locators/AccessportRole")),Inputdata[5].toString());
		Select(getwebelement(xml.getlocator("//locators/VlanTaggingMode")),Inputdata[6].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required fields are updated");
		}
		else 
		{
			Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			Thread.sleep(20000);
			Geturl(ModifyOrderscreenURL);
//			Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
			Clickon(getwebelement(xml.getlocator("//locators/ModifyEndSiteProductBend")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to B End site product order");
			Clickon(getwebelement(xml.getlocator("//locators/GeneralInformationTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/AddFeaturelink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link");
			SendKeys(getwebelement(xml.getlocator("//locators/TypeofFeature")),"VLAN");
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TypeofFeature")),Keys.ENTER);
			Clickon(getwebelement(xml.getlocator("//locators/SelectFeature")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
			Thread.sleep(3000);
			Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
			Clickon(getwebelement(xml.getlocator("//locators/Edit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
			SendKeys(getwebelement(xml.getlocator("//locators/VlanTagId")),Inputdata[7].toString());
//			SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
			Clickon(getwebelement(xml.getlocator("//locators/Update")));
			Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			Clickon(getwebelement(xml.getlocator("//locators/GeneralInformationTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on General Information Tab");
			Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port link");
			Clickon(getwebelement(xml.getlocator("//locators/Edit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
			Select(getwebelement(xml.getlocator("//locators/AccessportRole")),Inputdata[5].toString());
			Select(getwebelement(xml.getlocator("//locators/VlanTaggingMode")),Inputdata[6].toString());
			Clickon(getwebelement(xml.getlocator("//locators/Update")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required fields are updated");
			Geturl(ModifyOrderscreenURL);
		}
	}

	public void ProcessOrder(Object[] Inputdata) throws Exception
	{
		Geturl(ModifyOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Modified Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
	}
	
	public void CompleteOrder(Object[] Inputdata) throws Exception
	{
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modified Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[19].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/ModTaskTitle"))),Inputdata);
			}
		Geturl(ModifyOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
//		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
	}
	
	public void GotoErrors() throws Exception
	{
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0);
//		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Errors=GetText(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::*[4]"));
//		Errors=GetText(getwebelement("//a/span[contains(text(),'69773')]/parent::*/parent::*/following-sibling::*[4]"));
		if(Errors.equalsIgnoreCase("Blocked by Errors"))
		{
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
//		Clickon(getwebelement("//a/span[contains(text(),'69773')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		ExtentTestManager.getTest().log(LogStatus.FAIL, " Step: Click on Errors Tab");
		Thread.sleep(10000);
		}
		else 
			{
			Log.info("Not required to Navigate to Errors tab");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order did not have any errors to be Captured");
			}
	}

	public void InflightSoftModCompositOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Order screen");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		CompOrdernumber=CompositeOrderHelper.Ordernumber;
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Log.info(arrOfStr[1]);
//		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[2].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for Modification provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button ");
//		CompOrdernumber=Inputdata[2].toString();
//		Log.info(CompOrdernumber);
//		String[] arrOfStr = CompOrdernumber.split("#", 0);
//		Log.info(arrOfStr[1]);
//		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order");
//		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
//		Log.info(OrderscreenURL);
//		Geturl(OrderscreenURL);		
		EthernetProductOrdernumber=GetText(getwebelement(xml.getlocator("//locators/EthernetConnProdOrderNumber")));
		Log.info(EthernetProductOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Ethernet Connection Product Order Number");
		String[] arrOfStr1 = EthernetProductOrdernumber.split("#", 0); 
		Log.info(arrOfStr1[1]);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/ProductOrdrTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for Modification provided");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/InflightSoftProdOrder")));
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Soft Inflight Product Order button");
		Thread.sleep(20000);
//		Geturl(OrderscreenURL);
//		ModifiedOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
//		Log.info(ModifiedOrdernumber);
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Modify Order Number Generated : "+ModifiedOrdernumber);
//		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
//		Log.info(arrOfStr2[1]);
//		ModifyOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
//		Log.info(ModifyOrderscreenURL);
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Modify Order URL : "+ModifyOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Modified Order ");		
//		Will it create disconnected order in orders page or it will be there in same screen.
	}	
	
	public void EditInflightProduct(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/UndelyingInfligtOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Inflight Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		getwebelement(xml.getlocator("//locators/ServiceBandwidth")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[4].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Bandwidth field is updated");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(OrderscreenURL);
	}

	public void DecomposeInflightOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/InflightSuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Inflight Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button");
		Thread.sleep(10000);
		Geturl(OrderscreenURL);
	}

	public void ProcessInflightOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = CompOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Modified Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
		Thread.sleep(30000);
	}
	public void CompleteInflightOrder(Object[] Inputdata) throws Exception
	{
		String[] arrOfStr = CompOrdernumber.split("#", 0); 
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderStarted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Started')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Started");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab");
		Thread.sleep(30000);
		for (int k=1; k<=Integer.parseInt(Inputdata[19].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			Thread.sleep(20000);
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle"))),Inputdata);
			}
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
	}	
	
	public void Completworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ Log.info("In Switch case with TaskName :"+taskname);
		switch(taskname[0])
		{
	case "Reserve Access Resources":
		if(!Inputdata[9].toString().equals(Inputdata[10].toString())){
			if(taskname[1].contains(Inputdata[9].toString()))	{
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(1000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[8].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(10000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[9].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		//workitemcounter=workitemcounter+1;
		}
			else
			{
			//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			Thread.sleep(1000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[10].toString());
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
			Thread.sleep(10000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[11].toString());
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
			//workitemcounter=workitemcounter+1;
			}
		}
				else
				{
					if(workitemcounter%2==0)	{
						//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
						getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
						Thread.sleep(1000);
						getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[8].toString());
						Thread.sleep(10000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
						Thread.sleep(10000);
						getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[9].toString());
						Thread.sleep(10000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
						Thread.sleep(10000);
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
						workitemcounter=workitemcounter+1;
						}
						else
						{
							//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							Thread.sleep(1000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[10].toString());
							Thread.sleep(10000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
							Thread.sleep(10000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[11].toString());
							Thread.sleep(10000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
							Thread.sleep(10000);
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
							workitemcounter=workitemcounter+1;
						}
				}
	break;

	case "Transport Circuit Design":
			if(!Inputdata[9].toString().equals(Inputdata[10].toString())){
				if(taskname[1].contains(Inputdata[9].toString()))	{
					// Click on the task Name
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[12].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
					Thread.sleep(60000);
					getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[13].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
					Thread.sleep(60000);
					Log.info("Entered the last value");
					getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[14].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
					//Scrollup();
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
					//Thread.sleep(5000);
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
					Thread.sleep(2000);
					//workitemcounter=workitemcounter+1;
					}
				else
				{
					// Click on the task Name
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[15].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
					Thread.sleep(60000);
					getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[16].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
					Thread.sleep(60000);
					Log.info("Entered the last value");
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
					getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[17].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
					//Thread.sleep(2000);
					//Scrollup();
					//Thread.sleep(5000);
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
					Thread.sleep(2000);
					//workitemcounter=workitemcounter+1;
				}
			}
			else
			{
				if(workitemcounter%2==0)	{
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[12].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
					Thread.sleep(60000);
					getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[13].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
					Thread.sleep(60000);
					Log.info("Entered the last value");
					getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[14].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
					//Scrollup();
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
					//Thread.sleep(5000);
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
					Thread.sleep(2000);
					workitemcounter=workitemcounter+1;
					}
					else
					{
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
						getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[15].toString());
						Thread.sleep(60000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
						Thread.sleep(60000);
						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[16].toString());
						Thread.sleep(60000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
						Thread.sleep(60000);
						Log.info("Entered the last value");
						//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
						getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[17].toString());
						Thread.sleep(10000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
						//Thread.sleep(2000);
						//Scrollup();
						//Thread.sleep(5000);
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
						Thread.sleep(2000);
						workitemcounter=workitemcounter+1;
					}
			}
	break;
		
	case "Activation Start Confirmation":
	   {
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(2000);
	   }	
	break;

	case "Bandwidth Profile Confirmation":
	   {
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(2000);
	   }
	break;
	
	case "Select Bandwidth profile":
		if(workitemcounter % 2!= 0)	{
			//Write the steps for A end Refer the Reserver Resource Task
		}
		else
		{
			//Write the steps for B end Refer the Reserver Resource Task
		}
	break;

	case "Select OAM Profile":
		{
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Inputdata[18].toString());
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		}
	break;
	
	case "Set/Validate Serial Number":
		{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/InflightTaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateAntSerialNumber")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
		}
	default:
		// Nothing Found it will try to complete the Task	
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}
}	
}
