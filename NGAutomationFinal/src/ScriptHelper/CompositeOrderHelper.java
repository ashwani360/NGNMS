package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class CompositeOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\CompositOrder.xml");
	
	public CompositeOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void CreatCompositOrder(Object[] Inputdata) throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/NewCompositeOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on New Composite Order");
		Ordernumber=GetText(getwebelement(xml.getlocator("//locators/OrderNumber")));
		Log.info(Ordernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+Ordernumber);
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Log.info(arrOfStr[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Update button");
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(OrderscreenURL);
	}
	public void AddProduct(Object[] Inputdata) throws Exception
	{
				
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AddonOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Link");
		//switchtofram(getwebelement(xml.getlocator("//locators/Productifram")));
		if(Inputdata[0].toString().equalsIgnoreCase("Ethernet Connection Product"))
		{
		Clickon(getwebelement(xml.getlocator("//locators/EthernetProductCheckBox")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Ethernet Option");
		}
		else
		{
			Log.info("Not a valid option");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the H&S Option");
		}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked On Add button");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Opened the UnderLying Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked On Edit button");
	}
	
	public void AddProductdetails(Object[] Inputdata) throws Exception
	{
		Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
		SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[1].toString());
		Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[2].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[3].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[4].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Networkreference")),Inputdata[34].toString());
		Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[5].toString());
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are filled and updated");
	}

	public void AddFeatureDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Add Feature Link");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"End Site Product");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered End site product");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Feature selected");
		Thread.sleep(5000);
	}
	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Ethernet Connection Product Order");
		//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		//Clickon(getwebelement("//a/span[text()='"+Ordernumber+"']//parent::*/parent::*/parent::*/td//input"));
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Decompose button");
		Thread.sleep(5000);
	}
	
	public void ProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on A End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[7].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"A END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[9].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[31].toString());
		//Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AutoNegotiation")),"Enable");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order Page");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[12].toString());
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on B End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[25].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[10].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[35].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[13].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[14].toString());
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Geturl(OrderscreenURL);
	}
	
	public void ProductDeviceDetailsSpoke(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on A End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[7].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"A END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[9].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[30].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order Page");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[12].toString());
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[32].toString());
		//getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")).clear();
		//SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		//Thread.sleep(20000);
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),Keys.ENTER);
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on B End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[25].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[10].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[13].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[14].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Geturl(OrderscreenURL);
	}
	
	public void ProductDeviceDetailsBothVlan(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on A End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[7].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"A END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[9].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[30].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[31].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order Page");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[12].toString());
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[32].toString());
		//getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")).clear();
		//SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		//Thread.sleep(20000);
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),Keys.ENTER);
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on B End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[25].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[10].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[30].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[35].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order Page");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked to General Information Tab");
		
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE Link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[13].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[14].toString());
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are filled and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[32].toString());
		//getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")).clear();
		//SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		//Thread.sleep(20000);
		//SendkeaboardKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),Keys.ENTER);
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		Geturl(OrderscreenURL);
		
	}
	public void ProcessOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Start Processing Link");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Execution Flow Link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Workitems Tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[36].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),30);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Manual Workitems to be displayed");
			// Task 1: what is the name ofthis task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Workitem in  Ready status");
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
//		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		//Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		
	}
	public void CompleteOrder(Object[] Inputdata) throws Exception
	{
		String[] arrOfStr = Ordernumber.split("#", 0);
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Composite Order");
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Execution Flow Link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Workitems Tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[34].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Manual Workitems to be displayed");
			// Task 1: what is the name ofthis task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Workitem in  Ready status");
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		//Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
	}
	
	public void ProcessInflightOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Modified Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
	}
	
	public void CompleteInflightOrder(Object[] Inputdata) throws Exception
	{
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[34].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			CompletInflightworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
	}	

	public void GotoErrors() throws Exception
	{
		String[] arrOfStr = Ordernumber.split("#", 0);
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Sorting the Orders");
		Errors=GetText(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::*[4]"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Getting the value of In Error column for the order");
//		Errors=GetText(getwebelement("//a/span[contains(text(),'71022')]/parent::*/parent::*/following-sibling::*[4]"));
		if(Errors.equalsIgnoreCase("Blocked by Errors"))
		{
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
//		Clickon(getwebelement("//a/span[contains(text(),'71022')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Composite Order");
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

	public void CompletInflightworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[15].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(10000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[16].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Thread.sleep(20000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(5000);
		//workitemcounter=workitemcounter+1;
		}
			else
			{
			//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			Thread.sleep(1000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[17].toString());
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
			Thread.sleep(10000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[18].toString());
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
			Thread.sleep(20000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
			Thread.sleep(5000);
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
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[15].toString());
						Thread.sleep(10000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
						Thread.sleep(10000);
						getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[16].toString());
						Thread.sleep(10000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
						Thread.sleep(20000);
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
						Thread.sleep(5000);
						workitemcounter=workitemcounter+1;
						}
						else
						{
							//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							Thread.sleep(1000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[17].toString());
							Thread.sleep(10000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
							Thread.sleep(10000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[18].toString());
							Thread.sleep(10000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
							Thread.sleep(20000);
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
							Thread.sleep(5000);
							workitemcounter=workitemcounter+1;
						}
				}
		}
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[15].toString());
		Thread.sleep(20000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(20000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[16].toString());
		Thread.sleep(20000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Thread.sleep(20000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		//workitemcounter=workitemcounter+1;
		}
			else
			{
			//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			Thread.sleep(1000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[17].toString());
			Thread.sleep(20000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
			Thread.sleep(20000);
			getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[18].toString());
			Thread.sleep(20000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
			Thread.sleep(20000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
			//workitemcounter=workitemcounter+1;
			}
		}
				else
				{
					if(workitemcounter%2==0 )	{
						
						//SiteEnd=GetText(getwebelement(xml.getlocator("//a[contains(text(),'A END')]")));
						//System.out.println(SiteEnd);
						
						
						//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
						getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
						Thread.sleep(1000);
						getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[15].toString());
						Thread.sleep(20000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
						Thread.sleep(20000);
						getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[16].toString());
						Thread.sleep(20000);
						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
						Thread.sleep(20000);
						Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
						workitemcounter=workitemcounter+1;
						}
						
						else{
							//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							Thread.sleep(1000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[17].toString());
							Thread.sleep(20000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
							Thread.sleep(20000);
							getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[18].toString());
							Thread.sleep(20000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
							Thread.sleep(20000);
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
							workitemcounter=workitemcounter+1;
							
						}
					}
						
				
		break;

		case "Transport Circuit Design":
            if(!Inputdata[9].toString().equals(Inputdata[10].toString())) 
            				{
                             if(taskname[1].contains(Inputdata[9].toString()))
                             					{
                            	 if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
                             		{ 
                            	 		//Code for Protected
                            		 Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
             						Thread.sleep(60000);
             						getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
             						Thread.sleep(10000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
             						getwebelement(xml.getlocator("//locators/Tasks/Beacon")).clear();
             						Thread.sleep(5000);
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Inputdata[26].toString());
             						Thread.sleep(5000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Keys.ENTER);
             						Thread.sleep(10000);
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_1")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_2")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[27].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
             						Thread.sleep(2000);
             						//workitemcounter=workitemcounter+1;
                             		}
                             else{
								//Code for unProtected
								Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
								getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
								Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
								SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
								Thread.sleep(60000);
								SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
								Thread.sleep(60000);
								getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
								SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
								Thread.sleep(60000);
								SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
								Thread.sleep(60000);
								System.out.println("Entered the last value");
								getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
								SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[21].toString());
								Thread.sleep(10000);
								SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
								//Scrollup();
								//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
								//Thread.sleep(5000);
								Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
								Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
								Thread.sleep(2000);
								}
								
								}
                             else
                             {
                            	 if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
									{ 
                            		 Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
             						Thread.sleep(60000);
             						getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
             						Thread.sleep(10000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
             						getwebelement(xml.getlocator("//locators/Tasks/Beacon")).clear();
             						Thread.sleep(5000);
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Inputdata[26].toString());
             						Thread.sleep(5000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Keys.ENTER);
             						Thread.sleep(10000);
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_1")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs"))); 
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_2")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[27].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));                        
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
             						Thread.sleep(2000);
             						//workitemcounter=workitemcounter+1;
									}
									else{
					//Code for unProtected
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
					getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[22].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
					Thread.sleep(60000);
					getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[23].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
					Thread.sleep(60000);
					System.out.println("Entered the last value");
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
					getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
					//Thread.sleep(2000);
					//Scrollup();
					//Thread.sleep(5000);
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
					Thread.sleep(2000);
					//workitemcounter=workitemcounter+1;
					}
					
					}
					             }
					             
                                                                             
             else 
             {
                             if(workitemcounter%2==0)      
                             	{
                            	 if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
                                             	{ 
									//Code for Protected
                            		 Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
             						Thread.sleep(60000);
             						getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
             						Thread.sleep(10000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
             						getwebelement(xml.getlocator("//locators/Tasks/Beacon")).clear();
             						Thread.sleep(5000);
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Inputdata[26].toString());
             						Thread.sleep(5000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Keys.ENTER);
             						Thread.sleep(10000);
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_1")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_2")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
             						SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[27].toString());
             						Thread.sleep(60000);
             						SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
             						Thread.sleep(60000);
             						Clickon(getwebelement(xml.getlocator("//locators/Update")));
             						Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));                        
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
             						Clickon(getwebelement(xml.getlocator("//locators/Edit")));
             						Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
             						Thread.sleep(2000);
             						workitemcounter=workitemcounter+1;
									}
									else{
									{
									
									Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
									getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
									Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
									SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
									Thread.sleep(60000);
									SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
									Thread.sleep(60000);
									getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
									SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
									Thread.sleep(60000);
									SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
									Thread.sleep(60000);
									System.out.println("Entered the last value");
									getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
									SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[21].toString());
									Thread.sleep(10000);
									SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
									//Scrollup();
									//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
									//Thread.sleep(5000);
									Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
									Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
									Thread.sleep(2000);
									workitemcounter=workitemcounter+1;						}
									}
									
									}
							  else
                                             {
								  if(Inputdata[6].toString().equalsIgnoreCase("Protected"))
							{ 
							//Code for Protected
									  Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
										getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
										SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
										Thread.sleep(60000);
										SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
										Thread.sleep(60000);
										getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
										SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
										Thread.sleep(10000);
										SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
										getwebelement(xml.getlocator("//locators/Tasks/Beacon")).clear();
										Thread.sleep(5000);
										SendKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Inputdata[26].toString());
										Thread.sleep(5000);
										SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Keys.ENTER);
										Thread.sleep(10000);
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
										Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_1")));
										Clickon(getwebelement(xml.getlocator("//locators/Edit")));
										getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
										SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
										Thread.sleep(60000);
										SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
										Thread.sleep(60000);
										Clickon(getwebelement(xml.getlocator("//locators/Update")));
										Clickon(getwebelement(xml.getlocator("//locators/TransportCfs"))); 
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
										Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_2")));
										Clickon(getwebelement(xml.getlocator("//locators/Edit")));
										getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
										SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[27].toString());
										Thread.sleep(60000);
										SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
										Thread.sleep(60000);
										Clickon(getwebelement(xml.getlocator("//locators/Update")));
										Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
										Clickon(getwebelement(xml.getlocator("//locators/Edit")));
										Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
										Thread.sleep(2000);
										workitemcounter=workitemcounter+1;
							}
							else{
							//Code for unProtected
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
							getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[22].toString());
							Thread.sleep(60000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
							Thread.sleep(60000);
							getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[23].toString());
							Thread.sleep(60000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
							Thread.sleep(60000);
							System.out.println("Entered the last value");
							//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
							getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
							SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
							Thread.sleep(10000);
							SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
							//Thread.sleep(2000);
							//Scrollup();
							//Thread.sleep(5000);
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
							Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
							Thread.sleep(2000);
							workitemcounter=workitemcounter+1;
							}
							
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Inputdata[25].toString());
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}	
		break;

		case "Set/Validate Serial Number":
		{
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
			ANTCheck=GetText(getwebelement(xml.getlocator("//locators/Tasks/ANTSerialNumber")));
			Log.info(ANTCheck);
				if (ANTCheck.equalsIgnoreCase("New ANT"))
				{
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateAntSerialNumber")));
				}
				else 
				{
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateSerialNumber")));
				}
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
		}
		break;
		
		case "Set Legacy CPE Capability Profile":
		{
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")),Inputdata[28].toString());
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")),Keys.ENTER);
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")),Inputdata[29].toString());
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		}
		break;
		
		case "Legacy Activation Completed":
		{
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
			Thread.sleep(2000);
				}
		break;

		case "Waiting for Hard Cease Date":
		default:
		// Nothing Found it will try to complete the Task	
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}

}	

public void NavigatebacktoAccountScreen() throws Exception
{
	Geturl(OrderscreenURL);
//	Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
}
}
