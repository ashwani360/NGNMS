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
import ScriptHelper.CompositeOrderHelper;

public class ModifyOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\ModifyOrder.xml");
	
	public ModifyOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void ModifyCompositOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for Modification provided ");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button ");
		CompOrdernumber=Inputdata[4].toString();
		System.out.println(CompOrdernumber);
		String[] arrOfStr = CompOrdernumber.split("#", 0);
		System.out.println(arrOfStr[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Completed ");
//		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
//		System.out.println(OrderscreenURL);
//		Geturl(OrderscreenURL);
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
		ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/ProductInstNumber")));
		System.out.println(ProductInstancenumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number ");
		String[] arrOfStr1 = ProductInstancenumber.split("#", 0); 
		System.out.println(arrOfStr1[1]);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for Modification provided ");
//		Clickon(getwebelement(xml.getlocator("//locators/FilterInputValue")));
//		Clickon(getwebelement(xml.getlocator("+arrOfStr1[1]+")));
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button ");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
		Clickon(getwebelement(xml.getlocator("//locators/ModifyCompositOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modify Composite Order button ");
		Thread.sleep(10000);
//		Will it create disconnected order in orders page or it will be there in same screen.
	}

	public void EditProduct(Object[] Inputdata) throws Exception
	{
		ModifiedOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		System.out.println(ModifiedOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+ModifiedOrdernumber);
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
		System.out.println(arrOfStr2[1]);
		ModifyOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		System.out.println(ModifyOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Modified Order ");
		Clickon(getwebelement(xml.getlocator("//locators/UndelyingModifiedOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		getwebelement(xml.getlocator("//locators/ServiceBandwidth")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[2].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Bandwidth field updated ");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Geturl(ModifyOrderscreenURL);
	}

	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/ModifySuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Modified Ethernet Connection Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
		Thread.sleep(10000);
		Geturl(ModifyOrderscreenURL);
	}
	public void ProcessOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr2 = ModifiedOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Modified Composite Order ");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button ");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modified Composite Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[34].toString());k++){
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed ");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		
	}
	
	public void Completworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ System.out.println("In Switch case with TaskName :"+taskname);
		switch(taskname[0])
		{
			case "Reserve Access Resources":
		if(taskname[1].contains(Inputdata[9].toString()))	{
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[5].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[6].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
		}
		else
		{
		//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[7].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[8].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
		}
		break;

			case "Transport Circuit Design":
		if(taskname[1].contains(Inputdata[9].toString()))	{
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[9].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[10].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[11].toString());
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[12].toString());
		Thread.sleep(15000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
		Thread.sleep(10000);
		getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[13].toString());
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
		Thread.sleep(10000);
		System.out.println("Entered the last value");
		getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[14].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
		Thread.sleep(5000);
		workitemcounter=workitemcounter+1;
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Inputdata[15].toString());
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		}
	break;
		case "Transport circuit design task":
			if(workitemcounter % 2!= 0)	{
				//Write the steps for A end Refer the Reserver Resource Task
			}
			else
			{
				//Write the steps for B end Refer the Reserver Resource Task
			}
		
	break;
		case "Set/Validate serial number task":
		if(workitemcounter % 2!= 0)	{
			//Write the steps for A end Refer the Reserver Resource Task
		}
		else
		{
			//Write the steps for B end Refer the Reserver Resource Task
		}
	break;
			case "Set/Validate Serial Number":
		{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateAntSerialNumber")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
		}
	case "Waiting for Hard Cease Date":
		break;
	default:
		// Nothing Found it will try to complete the Task	
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}
}	
}