package ScriptHelper;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class CeaseOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\CeaseOrder.xml");
	
	public CeaseOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void CreatCeaseOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
		//Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for cease  ");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button ");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Completed ");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
		ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/ProductInstNumber")));
		Log.info(ProductInstancenumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number ");
		String[] arrOfStr1 = ProductInstancenumber.split("#", 0); 
		Log.info(arrOfStr1[1]);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided ");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button ");
		//Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
		Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on create Disconnect product Order ");
		Thread.sleep(10000);
		CeaseOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(CeaseOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+CeaseOrdernumber);
		String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
		Log.info(arrOfStr2[1]);
		CeaseOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(CeaseOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Cease Order ");
	}
	
	public void EditProduct(Object[] Inputdata) throws Exception
	{
        Clickon(getwebelement(xml.getlocator("//locators/DisconnectOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Disconnect Ethernet Connection Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
		Clickon(getwebelement(xml.getlocator("//locators/HardCeaseDelay")));
		getwebelement(xml.getlocator("//locators/HardCeaseDelay")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/HardCeaseDelay")),"0");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/HardCeaseDelay")),Keys.ENTER);
		DateFormat Year = new SimpleDateFormat("yyyy");
		DateFormat Month = new SimpleDateFormat("MMM");
		DateFormat Day = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		Date modifiedDate = c.getTime();
		Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")));	
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")),(Month.format(modifiedDate)));
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseDate")));	
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseDate")),(Day.format(modifiedDate)));
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseDate")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseYear")));	
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseYear")),(Year.format(modifiedDate)));
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseYear")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(5000);
		Geturl(CeaseOrderscreenURL);
	}

	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(CeaseOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Disconnect Ethernet Connection Product Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
		Thread.sleep(10000);
		Geturl(CeaseOrderscreenURL);
	}
	
		
	    public void ProcessOrder(Object[] Inputdata) throws Exception
		{
			Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
			Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cease Order ");
			Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button ");
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cease Order ");
			Clickon(getwebelement(xml.getlocator("//locators/TaskTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab ");
			Clickon(getwebelement(xml.getlocator("//locators/ExecutionFlowlink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/Workitems")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
			Thread.sleep(5000);
			for (int k=1; k<=Integer.parseInt(Inputdata[3].toString());k++){
				waitandclickForworkitemsPresent(xml.getlocator("//locators/TaskReadytoComplete"),60);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Manual Workitems to be displayed");
				Clickon(getwebelement(xml.getlocator("//locators/TaskReadytoComplete")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Workitem in  Ready status");
				Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/DisconnectTaskTitle"))),Inputdata);
				}
			Geturl(CeaseOrderscreenURL);
			Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			Thread.sleep(10000);
			waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Spoke Order to be Completed ");
			Thread.sleep(10000);
			//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			Thread.sleep(10000);
			
			
		}

	    public void Completworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
		{ System.out.println("In Switch case with TaskName :"+taskname);
			switch(taskname[0])
			{
				
						
			case "Legacy Deactivation Completed":
			{
				Clickon(getwebelement(xml.getlocator("//locators/Complete")));
				Thread.sleep(2000);
					}
			

		}

	}	

			
	
		
	    public void CreatHubCeaseOrder(Object[] Inputdata) throws Exception
		{
			Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
			Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
			//Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
			SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[2].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step:Hub Order number for cease  ");
			Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button ");
			CompOrdernumber=Inputdata[2].toString();
			Log.info(CompOrdernumber);
			String[] arrOfStr = CompOrdernumber.split("#", 0);
			Log.info(arrOfStr[1]);
			waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Hub Order to be Completed ");
			Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
			ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/HubProductInstNumber")));
			Log.info(ProductInstancenumber);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number ");
			String[] arrOfStr1 = ProductInstancenumber.split("#", 0); 
			Log.info(arrOfStr1[1]);
			Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
			Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab ");
			Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
			Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
			SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided ");
			Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button ");
			//Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
			Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
			Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on create Disconnect product Order ");
			Thread.sleep(10000);
			CeaseOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
			Log.info(CeaseOrdernumber);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+CeaseOrdernumber);
			String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
			Log.info(arrOfStr2[1]);
			CeaseOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
			Log.info(CeaseOrderscreenURL);
//			Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Hub Cease Order ");
		}
		
	    
	    public void EditHubProduct(Object[] Inputdata) throws Exception
		{
			
	        Clickon(getwebelement(xml.getlocator("//locators/DisconnectHubOrder")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Disconnect Hub Ethernet Connection Product Order ");
			Clickon(getwebelement(xml.getlocator("//locators/Edit")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button ");
			Clickon(getwebelement(xml.getlocator("//locators/HardCeaseDelay")));
			getwebelement(xml.getlocator("//locators/HardCeaseDelay")).clear();
			SendKeys(getwebelement(xml.getlocator("//locators/HardCeaseDelay")),"0");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/HardCeaseDelay")),Keys.ENTER);
			DateFormat Year = new SimpleDateFormat("yyyy");
			DateFormat Month = new SimpleDateFormat("MMM");
			DateFormat Day = new SimpleDateFormat("dd");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);
			Date modifiedDate = c.getTime();
			Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")));	
			SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")),(Month.format(modifiedDate)));
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")),Keys.ENTER);
			Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseDate")));	
			SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseDate")),(Day.format(modifiedDate)));
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseDate")),Keys.ENTER);
			Clickon(getwebelement(xml.getlocator("//locators/ColtPromiseYear")));	
			SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseYear")),(Year.format(modifiedDate)));
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/ColtPromiseYear")),Keys.ENTER);
			Clickon(getwebelement(xml.getlocator("//locators/Update")));
			Thread.sleep(5000);
			Geturl(CeaseOrderscreenURL);
			}

							

		public void DecomposeHubOrder(Object[] Inputdata) throws Exception
		{
			Geturl(CeaseOrderscreenURL);
			Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
			Clickon(getwebelement(xml.getlocator("//locators/HubSubOrder")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Hub Disconnect Ethernet Connection Product Order ");
			Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
			Thread.sleep(10000);
			Geturl(CeaseOrderscreenURL);
		}
		
			
		    public void ProcessHubOrder(Object[] Inputdata) throws Exception
			{
				Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
				Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
				String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
				Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Hub  Cease Order ");
				Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button ");
				Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
				Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cease Order ");
				Clickon(getwebelement(xml.getlocator("//locators/TaskTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab ");
				Clickon(getwebelement(xml.getlocator("//locators/ExecutionFlowlink")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
				Thread.sleep(10000);
				Geturl(CeaseOrderscreenURL);
				Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
				Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
				Thread.sleep(10000);
				waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Hub  Order to be Completed ");
				//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
				Thread.sleep(10000);
				
			}
		    
		    public void CreatSpokeCeaseOrder(Object[] Inputdata) throws Exception
			{
				Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
				Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
				//Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
				//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
				SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Spoke Order number for cease  ");
				Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button ");
				CompOrdernumber=Inputdata[1].toString();
				Log.info(CompOrdernumber);
				String[] arrOfStr = CompOrdernumber.split("#", 0);
				Log.info(arrOfStr[1]);
				waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the spoke Order to be Completed ");
				Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
				ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/ProductInstNumber")));
				Log.info(ProductInstancenumber);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number ");
				String[] arrOfStr1 = ProductInstancenumber.split("#", 0); 
				Log.info(arrOfStr1[1]);
				Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
				Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab ");
				Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter ");
				Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
				SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided ");
				Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button ");
				//Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
				Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
				Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on create Disconnect product Order ");
				Thread.sleep(10000);
				CeaseOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
				Log.info(CeaseOrdernumber);
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+CeaseOrdernumber);
				String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
				Log.info(arrOfStr2[1]);
				CeaseOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
				Log.info(CeaseOrderscreenURL);
//				Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Spoke Cease Order ");
			}
			
										

			public void DecomposeSpokeOrder(Object[] Inputdata) throws Exception
			{
				Geturl(CeaseOrderscreenURL);
				Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
				Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Disconnect Ethernet Connection Product Order ");
				Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
				ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
				Thread.sleep(10000);
				Geturl(CeaseOrderscreenURL);
			}
			
				
			    public void ProcessSpokeOrder(Object[] Inputdata) throws Exception
				{
					Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
					Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
					String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
					Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Spoke Cease Order ");
					Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button ");
					Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
					Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cease Order ");
					Clickon(getwebelement(xml.getlocator("//locators/TaskTab")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab ");
					Clickon(getwebelement(xml.getlocator("//locators/ExecutionFlowlink")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link ");
					Thread.sleep(10000);
					Clickon(getwebelement(xml.getlocator("//locators/Workitems")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab ");
					Thread.sleep(5000);
					for (int k=1; k<=Integer.parseInt(Inputdata[3].toString());k++){
						waitandclickForworkitemsPresent(xml.getlocator("//locators/TaskReadytoComplete"),60);
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Manual Workitems to be displayed");
						// Task 1: what is the name ofthis task : Reserve Access Resources
						Clickon(getwebelement(xml.getlocator("//locators/TaskReadytoComplete")));
						ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Workitem in  Ready status");
						CompletSpokeworkitem(GetText2(getwebelement(xml.getlocator("//locators/DisconnectTaskTitle"))),Inputdata);
						}
					
					Geturl(CeaseOrderscreenURL);
					Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab ");
					Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
					Thread.sleep(10000);
					waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
					ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Spoke Order to be Completed ");
					Thread.sleep(10000);
					//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
					Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
					Thread.sleep(10000);
					
					
				}

			    public void CompletSpokeworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
				{ System.out.println("In Switch case with TaskName :"+taskname);
					switch(taskname[0])
					{
									
					case "Legacy Deactivation Completed":
					{
						Clickon(getwebelement(xml.getlocator("//locators/Complete")));
						Thread.sleep(2000);
					}
				

				}
					
				

			}	
			public void NavigatebacktoAccountScreen() throws Exception
			{
				Geturl(OrderscreenURL);
//				Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
			}
			}
	




