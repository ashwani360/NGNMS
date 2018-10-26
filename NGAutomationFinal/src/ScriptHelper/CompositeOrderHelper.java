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
		System.out.println(Ordernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+Ordernumber);
		String[] arrOfStr = Ordernumber.split("#", 0); 
		System.out.println(arrOfStr[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Update button");
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		System.out.println(OrderscreenURL);
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
			System.out.println("Not a valid option");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the H&S Option");
		}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add button");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Under Lying Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Edit button");
	}
	
	public void AddProductdetails(Object[] Inputdata) throws Exception
	{
		
	Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
	SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[1].toString());
	Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[2].toString());
	SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[3].toString());
	SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[4].toString());
	Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
	SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[5].toString());
//	SendKeys(getwebelement(xml.getlocator("//locators/ResilienceOption")),Inputdata[6].toString());
	Clickon(getwebelement(xml.getlocator("//locators/Update")));
	}
	public void AddFeatureDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"End Site Product");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		Thread.sleep(5000);
		
		//System.out.println("AddProductDetails");
		
	}
	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		
		//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		//Clickon(getwebelement("//a/span[text()='"+Ordernumber+"']//parent::*/parent::*/parent::*/td//input"));
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		Thread.sleep(5000);
	}
	public void ProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
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
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		//Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AutoNegotiation")),"Enable");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[12].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
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
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[10].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[13].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[14].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(OrderscreenURL);
	}
	public void ProcessOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[35].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			// Task 1: what is the name ofthis task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		/*Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement"))).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[14].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		(getwebelement(xml.getlocator("//locators/Tasks/AccessPort"))).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[15].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(10000);*/
		/////////////////////
		/*Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement"))).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[16].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		(getwebelement(xml.getlocator("//locators/Tasks/AccessPort"))).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[17].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		Thread.sleep(50000);*/
		///////////////////////////////
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		//Thread.sleep(10000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		//waitandclickForworkitemsPresent(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")),0);
		//Thread.sleep(150000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		//Thread.sleep(8000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/ActivationTaskCofirm")));
		//Thread.sleep(50000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		//Thread.sleep(50000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		//Thread.sleep(50000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		//Thread.sleep(600000);
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
		//Thread.sleep(200000);
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
//		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
	}
	
public void Completworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
{ System.out.println("In Switch case with TaskName :"+taskname);
	switch(taskname[0])
	{
		case "Reserve Access Resources":
	if(taskname[1].contains(Inputdata[9].toString()))	{
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(1000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[15].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[16].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
	}
	else
	{
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(1000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[17].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[18].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
	}
	break;
		
		case "Transport Circuit Design":
	if(taskname[1].contains(Inputdata[9].toString()))	{
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[19].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[20].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[21].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
		Thread.sleep(5000);	
		workitemcounter=workitemcounter+1;
	}
		else
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
		Thread.sleep(10000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[22].toString());
		Thread.sleep(15000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		Thread.sleep(10000);
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[23].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		Thread.sleep(10000);
		System.out.println("Entered the last value");
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[24].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
		Thread.sleep(5000);
		workitemcounter=workitemcounter+1;
	}

	break;
		case "Set/Validate Serial Number":
			 {
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
			//Clickon(getwebelement(xml.getlocator("//locators/UpdateSerialNumber")));
			Clickon(getwebelement(xml.getlocator("//locators/UpdateAntSerialNumber")));
			Thread.sleep(6000);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
			Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
			}
		break;
		case "Activation Start Confirmation":
		
		if(workitemcounter % 2!= 0)	{
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

		case "Set Legacy CPE Capability Profile":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeProfile")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeOamLevel")));
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/LegacyCpeSupportsCFM")),"LC/PC");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
	}
	break;
	case "Legacy Activation Completed":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));	
	}	
		
	break;
		case "Waiting for Hard Cease Date":
	break;
		default:
		// Nothing Found it will try to complete the Task	
	Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}

}	
public void NavigatebacktoAccountScreen() throws Exception
{
	Geturl(OrderscreenURL);
	Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
}
}