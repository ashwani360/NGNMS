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

public class NewHubOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\HubOrder.xml");
	
	public NewHubOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void CreatHubOrder(Object[] Inputdata) throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/NewCompositeOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on New Composite Order");
		Ordernumber=GetText(getwebelement(xml.getlocator("//locators/OrderNumber")));
		System.out.println(Ordernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Hub Order Number Generated : "+Ordernumber);
		String[] arrOfStr = Ordernumber.split("#", 0); 
		System.out.println(arrOfStr[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"Hub Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		System.out.println(OrderscreenURL);
	}
	public void AddHubProduct(Object[] Inputdata) throws Exception
	{
				
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AddonOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Link");
		if(Inputdata[0].toString().equalsIgnoreCase("Hub Product"))
		{
		Clickon(getwebelement(xml.getlocator("//locators/HubProductCheckBox")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Hub Option");
		}
		else
		{
			System.out.println("Not a valid option");
		}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add button");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningHubOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Under Lying Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Edit button");
	}
	
	public void AddHubProductdetails(Object[] Inputdata) throws Exception
	{
		
		Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
		SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[1].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/NetworkReference")),Inputdata[2].toString());
		Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[3].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[4].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[5].toString());
		Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[6].toString());
		if(Inputdata[7].toString().equalsIgnoreCase("Protected"))
	   {
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
	   }
	   else
	  {
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
	  }
		//SendKeys(getwebelement(xml.getlocator("//locators/ResilienceOption")),Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
	}

	public void DecomposeHubOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navgiated to Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/HubSuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Hub Order ");
		//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		//Clickon(getwebelement("//a/span[text()='"+Ordernumber+"']//parent::*/parent::*/parent::*/td//input"));
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
		Thread.sleep(5000);
	}
	public void HubProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewHubSiteProductend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Hub Site End ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[9].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[10].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information ");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port Link ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		//Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AutoNegotiation")),"Enable");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information ");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Link ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[12].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(OrderscreenURL);
	}
	public void ProcessHubOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Hub Order ");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Hub Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Tasks Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
		Thread.sleep(10000);
		for (int k=1; k<=Integer.parseInt(Inputdata[36].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
// Task 1: what is the name of this task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			CompletHubworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Errors Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/WorkItemSelect")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Completed Workitem ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/View")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Biew button ");
		NCServiceId=GetText(getwebelement(xml.getlocator("//locators/Tasks/NCSID")));
		System.out.println(NCServiceId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Pick the NC Service ID ");
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Hub Order to be Completed ");
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
	}

	public void CompletHubworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ System.out.println("In Switch case with TaskName :"+taskname);
		switch(taskname[0])
		{
			case "Reserve Access Resources":
	if(taskname[1].contains(Inputdata[10].toString()))	{
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Thread.sleep(6000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[13].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(5000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[14].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		}
		else 
		{
			System.out.println("Not a valid option");
		}
		break;

			case "Transport Circuit Design":
	if(taskname[1].contains(Inputdata[10].toString()))	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(6000);
		getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[15].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		Thread.sleep(5000);
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[16].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		Thread.sleep(10000);
		System.out.println("Entered the last value");
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[17].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		workitemcounter=workitemcounter+1;
		}
		else
		{
			System.out.println("Not a valid option");
		}
		break;		
			
			case "Set/Validate Serial Number":
		{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateAntSerialNumber")));
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		}
		break;
		
			case "Activation Start Confirmation":
		{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(2000);
		}
		}
	}	
	
	public void CreatCompositSpokeOrder(Object[] Inputdata) throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/NewCompositeOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on New Composite Order");
		SpokeOrdernumber=GetText(getwebelement(xml.getlocator("//locators/OrderNumber")));
		System.out.println(SpokeOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Spoke Order Number Generated : "+SpokeOrdernumber);
		String[] arrOfStr = SpokeOrdernumber.split("#", 0); 
		System.out.println(arrOfStr[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"Spoke Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Update button");
		SpokeOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		System.out.println(SpokeOrderscreenURL);
	}
	public void AddSpokeProduct(Object[] Inputdata) throws Exception
	{
				
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AddonOrderTab ")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Link ");
		//switchtofram(getwebelement(xml.getlocator("//locators/Productifram")));
		if(Inputdata[18].toString().equalsIgnoreCase("Ethernet Connection Product "))
	{
		Clickon(getwebelement(xml.getlocator("//locators/EthernetProductCheckBox")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Ethernet Option ");
	}
	else
	{
		System.out.println("Not a valid option");
	}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add button ");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Under Lying Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Edit button ");
	}
	
	public void AddSpokeProductdetails(Object[] Inputdata) throws Exception
	{
		
		Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
		SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[19].toString());
		Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[20].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[21].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[22].toString());
		Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[23].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
	}
	public void AddSpokeFeatureDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add Feature Link ");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"End Site Product");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter End Site Product ");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Feature Selected ");
		Thread.sleep(5000);
	
	}
	public void DecomposeSpokeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
		Thread.sleep(5000);
	}
	
	public void AddHub(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/NewEthernetConnProduct")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/AddHub")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Hub button ");
		SendKeys(getwebelement(xml.getlocator("//locators/TypeofHub")),NCServiceId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: NC Service ID provided ");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/AddHubProdOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Hub Order selected ");
//		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TypeofHub")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Hub added to the Spoke ");
		Thread.sleep(5000);
		Geturl(SpokeOrderscreenURL);
	}
	
	public void SpokeProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on A end Site Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on General Information tab ");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[24].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[25].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link ");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added ");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[26].toString());
//		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on B end Site Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[27].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[28].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on General Information Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[30].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(SpokeOrderscreenURL);
	}
	
	public void ProcessSpokeOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = SpokeOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Order ");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[37].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			// Task 1: what is the name ofthis task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			CompletSpokeworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
	}
	
	public void CompletSpokeworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ System.out.println("In Switch case with TaskName :"+taskname);
	switch(taskname[0])
	{
		case "Reserve Access Resources":
	{
//		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
//		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.BACK_SPACE);
		Thread.sleep(6000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Thread.sleep(6000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[31].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(5000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[32].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
	}
	break;

		case "Transport Circuit Design":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(6000);
		getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[33].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[34].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[35].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		Thread.sleep(5000);	
		workitemcounter=workitemcounter+1;
	}
	break;
	
		case "Activation Start Confirmation":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));	
	}
	break;

		case "Set/Validate Serial Number":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/UpdateSerialNumber")));
		Thread.sleep(6000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		
	}
	break;
		case "Set Legacy CPE Capability Profile":
		{
			getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")).clear();
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")),Inputdata[36].toString());
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")),Keys.ENTER);
			getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")).clear();
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")),Inputdata[37].toString());
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")),Keys.ENTER);
			SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeSupportsCFM")),"yes");
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
			Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		}
	break;
		case "Legacy Activation Completed":
		{
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));	
		}	
	break;
	}
}	
}