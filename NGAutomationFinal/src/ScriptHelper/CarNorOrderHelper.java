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

public class CarNorOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\CarNor.xml");
	
	public CarNorOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void GetOrderDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for CAR/NOR provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Ethernet Connection Product Order");
		NCServiceId=GetText(getwebelement(xml.getlocator("//locators/NCSID")));
		Log.info(NCServiceId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the NC Service ID");
		ProductId=GetText(getwebelement(xml.getlocator("//locators/ProductID")));
		ProductId.toUpperCase();
		Log.info(ProductId);
		System.out.println(ProductId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Product ID : "+ProductId);
	}

	public void CreatCarNorOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/NewCompositeOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on New Composite Order");
		Ordernumber=GetText(getwebelement(xml.getlocator("//locators/OrderNumber")));
		Log.info(Ordernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: CarNor Order Number Generated : "+Ordernumber);
		String[] arrOfStr1 = Ordernumber.split("#", 0); 
		Log.info(arrOfStr1[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"CarNor Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(OrderscreenURL);
	}

	public void AddProduct(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AddonOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Link");
		//switchtofram(getwebelement(xml.getlocator("//locators/Productifram")));
		if(Inputdata[3].toString().equalsIgnoreCase("Ethernet Connection Product"))
		{
			Clickon(getwebelement(xml.getlocator("//locators/EthernetProductCheckBox")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Ethernet Option");
		}
		else
		{
			Log.info("Not a valid option");
		}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add button");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Under Lying Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Edit button");
	}
	
	public void AddProductdetails(Object[] Inputdata) throws Exception
	{
		Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
		SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[4].toString());
		Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[6].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[7].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[8].toString());
		Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[9].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/RetainedNCSerId")),NCServiceId);
		Thread.sleep(10000);		
		SendKeys(getwebelement(xml.getlocator("//locators/CarNorProductId")),ProductId);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CarNorProductId")),Keys.ENTER);
		Thread.sleep(20000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered and Updated");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
	}

	public void AddFeatureDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navgiate to General Information Tab");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature Link");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"End Site Product");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: End Site Product Entered");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Select button");
		Thread.sleep(5000);
	}
	
	public void DecomposeOrder(Object[] Inputdata) throws Exception
	{
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Decompose button");
		Thread.sleep(5000);
	}
	
	public void ProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on A End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		if(Inputdata[10].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[11].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[12].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"A END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[13].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are entered and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		//Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AutoNegotiation")),"Enable");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are entered and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated back to Aend site product order");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[14].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[15].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are entered and updated");
		Geturl(OrderscreenURL);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Order Screen");
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Orders tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Bend site product order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		if(Inputdata[10].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[30].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[31].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[32].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are entered and updated");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Access Port link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),"Physical Port");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are entered and updated");
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated back to Bend End site product order");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Infomration tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CPElink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on CPE link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateID")),Inputdata[34].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/CPE/CabinateType")),Inputdata[35].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required details are entered and updated");
		Geturl(OrderscreenURL);
	}
	
	public void ProcessCarNorOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Order tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected the required order for processing");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Start Processing button");
	}
	
	public void CreatCeaseOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		//Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for cease");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr1 = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr1[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order ");
		ProductInstancenumber=GetText(getwebelement(xml.getlocator("//locators/ProductInstNumber")));
		Log.info(ProductInstancenumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Instance Number");
		String[] arrOfStr2 = ProductInstancenumber.split("#", 0); 
		Log.info(arrOfStr2[1]);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/ProductInstTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Product Instance Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr2[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button");
		//Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance ");
		Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on create Disconnect product Order");
		Thread.sleep(10000);
		CeaseOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(CeaseOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Cease Order Number Generated : "+CeaseOrdernumber);
		String[] arrOfStr3 = CeaseOrdernumber.split("#", 0); 
		Log.info(arrOfStr3[1]);
		CeaseOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(CeaseOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr3[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Cease Order");
	}
	
	public void EditCeaseProduct(Object[] Inputdata) throws Exception
	{
        Clickon(getwebelement(xml.getlocator("//locators/DisconnectOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Disconnect Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
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

	public void DecomposeCeaseOrder(Object[] Inputdata) throws Exception
	{
		Geturl(CeaseOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/DisconnectSuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Disconnect Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button ");
		Thread.sleep(10000);
		Geturl(CeaseOrderscreenURL);
	}
		
	public void ProcessCeaseOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr3 = CeaseOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr3[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Cease Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr3[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Cease Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Geturl(CeaseOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr3[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
		//Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Thread.sleep(10000);
	}
		// Add the code here for the First order dissconnect
		// Navigate back to 2nd Order screen url for filling the new details after disconnect is complete
		//Counter=Counter+1;

	public void CompleteCarNorOrder(Object[] Inputdata) throws Exception
	{
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders tab");
		String[] arrOfStr = Ordernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated back to CarNor Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Tasks tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Workitems tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[43].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			Completworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders tab");	
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		//Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
	}
	
	public void GotoErrors() throws Exception
	{
		String[] arrOfStr = Ordernumber.split("#", 0);
//		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Accounts Composite Orders Tab");
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Errors=GetText(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::*[4]"));
//		Errors=GetText(getwebelement("//a/span[contains(text(),'69773')]/parent::*/parent::*/following-sibling::*[4]"));
		if(Errors.equalsIgnoreCase("Blocked by Errors"))
		{
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
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

	public void Completworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ Log.info("In Switch case with TaskName :"+taskname);
	switch(taskname[0])
	{
	case "Reserve Access Resources":
		if(!Inputdata[13].toString().equals(Inputdata[32].toString())){
			if(taskname[1].contains(Inputdata[13].toString()))	{
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
				getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
				Thread.sleep(1000);
				getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[16].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
				Thread.sleep(10000);
				getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[17].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
				Thread.sleep(10000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
				Thread.sleep(10000);
				//workitemcounter=workitemcounter+1;
				}
				else
				{
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
				getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
				Thread.sleep(1000);
				getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[36].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
				Thread.sleep(10000);
				getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[37].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
				Thread.sleep(10000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
				Thread.sleep(10000);
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
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[16].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
				Thread.sleep(10000);
				getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[17].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
				Thread.sleep(10000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
				Thread.sleep(10000);
				workitemcounter=workitemcounter+1;
				}
				else
				{
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
					getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
					Thread.sleep(1000);
					getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[36].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
					Thread.sleep(10000);
					getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[37].toString());
					Thread.sleep(10000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
					Thread.sleep(10000);
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
					Thread.sleep(10000);
					workitemcounter=workitemcounter+1;
				}
			}
	break;

	case "Transport Circuit Design":
		if(!Inputdata[13].toString().equals(Inputdata[32].toString())){
			if(taskname[1].contains(Inputdata[13].toString()))	{
				// Click on the task Name
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[18].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
				Thread.sleep(60000);
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[19].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(60000);
				Log.info("Entered the last value");
				getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[20].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
				//Scrollup();
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
				//Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
				Thread.sleep(2000);
				//workitemcounter=workitemcounter+1;
				}
			else
			{
				// Click on the task Name
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[38].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
				Thread.sleep(60000);
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[39].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(60000);
				Log.info("Entered the last value");
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
				getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[40].toString());
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
		else
		{
			if(workitemcounter%2==0)	{
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[18].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
				Thread.sleep(60000);
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[19].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(60000);
				Log.info("Entered the last value");
				getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[20].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
				//Scrollup();
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
				//Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
				Thread.sleep(2000);
				workitemcounter=workitemcounter+1;
				}
				else
				{
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
					getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
					Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[38].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
					Thread.sleep(60000);
					getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[39].toString());
					Thread.sleep(60000);
					SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
					Thread.sleep(60000);
					Log.info("Entered the last value");
					//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
					getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
					SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[40].toString());
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Inputdata[41].toString());
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}	
	break;

	case "Set/Validate Serial Number":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/UpdateAntSerialNumber")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/TransComplete")));
	}
	break;	

	case "Waiting for Hard Cease Date":
		default:
		// Nothing Found it will try to complete the Task	
	Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}
	}
	
	
// Hub and Spoke CarNor Order Creation and Processing		

	public void GetHubOrderDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for CAR/NOR provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr4 = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr4[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr4[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr4[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Ethernet Connection Product Order");
		HubNCServiceId=GetText(getwebelement(xml.getlocator("//locators/NCSID")));
		Log.info(HubNCServiceId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the NC Service ID");
	}
	
	public void GetSpokeOrderDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order number for CAR/NOR provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr5 = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr5[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr5[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr5[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Composite Order");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Ethernet Connection Product Order");
		SpokeNCServiceId=GetText(getwebelement(xml.getlocator("//locators/NCSID")));
		Log.info(SpokeNCServiceId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the NC Service ID");
		SpokeProductId=GetText(getwebelement(xml.getlocator("//locators/ProductID")));
		Log.info(SpokeProductId);
		System.out.println(SpokeProductId);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Product ID : "+SpokeProductId);
	}
	
	public void CreatCarNorSpokeOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewCompositeOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on New Composite Order");
		SpokeOrdernumber=GetText(getwebelement(xml.getlocator("//locators/OrderNumber")));
		Log.info(SpokeOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Spoke Order Number Generated : "+SpokeOrdernumber);
		String[] arrOfStr6 = SpokeOrdernumber.split("#", 0); 
		Log.info(arrOfStr6[1]);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDescription")),"Spoke Order Created using Automation script");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Description has been Entered");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Update button");
		SpokeOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(SpokeOrderscreenURL);
	}

	public void AddSpokeProduct(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AddonOrderTab ")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Product Link");
		//switchtofram(getwebelement(xml.getlocator("//locators/Productifram")));
		if(Inputdata[22].toString().equalsIgnoreCase("Ethernet Connection Product"))
	{
		Clickon(getwebelement(xml.getlocator("//locators/EthernetProductCheckBox")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Ethernet Option");
	}
	else
	{
		Log.info("Not a valid option");
	}
		Clickon(getwebelement(xml.getlocator("//locators/Addbutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add button");
		Clickon(getwebelement(xml.getlocator("//locators/UnderlyningOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Under Lying Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Edit button");
	}
	
	public void AddSpokeProductdetails(Object[] Inputdata) throws Exception
	{
		Select(getwebelement(xml.getlocator("//locators/OrderSystemName")),"SPARK");
		SendKeys(getwebelement(xml.getlocator("//locators/CarNorProductId")),SpokeProductId);
		Thread.sleep(20000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CarNorProductId")),Keys.ENTER);
		Thread.sleep(20000);
		SendKeys(getwebelement(xml.getlocator("//locators/Orderreferencenumber")),Inputdata[23].toString());
		Select(getwebelement(xml.getlocator("//locators/Topology")),Inputdata[24].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/Ordernumber")),Inputdata[25].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/CommercialProductName")),Inputdata[26].toString());
		Select(getwebelement(xml.getlocator("//locators/CircuitCategory")),"LE");
		SendKeys(getwebelement(xml.getlocator("//locators/ServiceBandwidth")),Inputdata[27].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/RetainedNCSerId")),SpokeNCServiceId);
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered and Updated");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
	}

	public void AddSpokeFeatureDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click On Add Feature Link");
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Suborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button");
		Thread.sleep(5000);
	}
	
	public void AddHub(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/NewEthernetConnProduct")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/AddHub")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Hub button");
		SendKeys(getwebelement(xml.getlocator("//locators/TypeofHub")),Inputdata[2].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Hub NC Service ID provided");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/AddHubProdOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Hub Order selected");
//		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/TypeofHub")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Hub added to the Spoke");
		Thread.sleep(5000);
		Geturl(SpokeOrderscreenURL);
	}
	
	public void SpokeProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductAend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on A end Site Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on General Information tab ");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[28].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[29].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Updated");
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[30].toString());
//		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Updated");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(10000);
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/NewEndSiteProductBend")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on B end Site Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessTechnolgy")),Inputdata[31].toString());
		if(Inputdata[34].toString().equalsIgnoreCase("Protected"))
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Protected");
		}
		else
		{
			Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/ResilienceOption")),"Unprotected");
		}
		Thread.sleep(20000);
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/AccessType")),Inputdata[32].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteEnd")),"B END");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/SiteID")),Inputdata[33].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Entered ");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on General Information Tab");
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessPortLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Edit button");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/PresentConnectType")),"LC/PC");
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/AccessportRole")),Inputdata[35].toString());
		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/Accessport/VlanTaggingMode")),Inputdata[36].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Updated");
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to General Information Tab");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/AddFeaturelink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Feature link ");
		SendKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),"VLAN");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/GeneralInformation/TypeofFeature")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/SelectFeature")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: VLAN Feature added");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VLANLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
		Clickon(getwebelement(xml.getlocator("//locators/Edit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Edit button");
		SendKeys(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/VlanTagId")),Inputdata[37].toString());
//		Select(getwebelement(xml.getlocator("//locators/SiteProductDetail/VLAN/Ethertype")),"VLAN (0x8100)");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Required Details are Updated");
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
		Thread.sleep(10000);
		Geturl(SpokeOrderscreenURL);
	}
	
    public void CreatSpokeCeaseOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement(xml.getlocator("//locators/NameFiltering")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Name Filter");
		//Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter ");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),Inputdata[1].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Spoke Order number for cease picked");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Apply button");
		CompOrdernumber=Inputdata[1].toString();
		Log.info(CompOrdernumber);
		String[] arrOfStr = CompOrdernumber.split("#", 0);
		Log.info(arrOfStr[1]);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for the spoke Order to be Completed");
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order");
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
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Selected Name in Filter");
		SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),""+arrOfStr1[1]+"");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided");
		Clickon(getwebelement(xml.getlocator("//locators/ApplyButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Apply button");
		//Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr1[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Instance");
		Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on create Disconnect product Order");
		Thread.sleep(10000);
		CeaseOrdernumber=GetText(getwebelement(xml.getlocator("//locators/LinkforOrder")));
		Log.info(CeaseOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Order Number Generated : "+CeaseOrdernumber);
		String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
		Log.info(arrOfStr2[1]);
		CeaseOrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		Log.info(CeaseOrderscreenURL);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Spoke Cease Order");
	}

	public void DecomposeSpokeCeaseOrder(Object[] Inputdata) throws Exception
	{
		Geturl(CeaseOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/OrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Orders Tab ");
		Clickon(getwebelement(xml.getlocator("//locators/DisconnectSuborder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Disconnect Ethernet Connection Product Order");
		Clickon(getwebelement(xml.getlocator("//locators/Decompose")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Decompose button");
		Thread.sleep(10000);
		Geturl(CeaseOrderscreenURL);
	}
		
	 public void ProcessSpokeCeaseOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr2 = CeaseOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select Spoke Cease Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Cease Order ");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Geturl(CeaseOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr2[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Spoke Cease to be Completed");
		Thread.sleep(10000);
//		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
//		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
	}

	public void ProcessSpokeCarNorOrder(Object[] Inputdata) throws Exception
	{
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigated to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr6 = SpokeOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr6[1]+"')]/parent::*/parent::*/parent::*/td//input"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Spoke Order");
		Clickon(getwebelement(xml.getlocator("//locators/StartProccessing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Start Processing button");
	}

	public void CompleteSpokeCarNorOrder(Object[] Inputdata) throws Exception
	 {
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		String[] arrOfStr6 = SpokeOrdernumber.split("#", 0); 
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr6[1]+"')]/parent::*"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Spoke Order");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Tasks Tab");
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExecutionFlowlink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Execution Flow link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Workitems Tab");
		Thread.sleep(5000);
		for (int k=1; k<=Integer.parseInt(Inputdata[50].toString());k++){
			waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
			// Task 1: what is the name ofthis task : Reserve Access Resources
			Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
			CompletSpokeworkitem(GetText2(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle"))),Inputdata);
			}
		Thread.sleep(10000);
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
//		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
		waitandclickForOrderCompleted("//a/span[contains(text(),'"+arrOfStr6[1]+"')]/parent::*/parent::*/following-sibling::td[contains(text(),'Process Completed')]",60);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Spoke Carnor Order to be Completed");
		Geturl(SpokeOrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Navigate to Composite Orders Tab");
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Thread.sleep(10000);
	}
	
	public void CompletSpokeworkitem(String[] taskname,Object[] Inputdata) throws Exception, DocumentException
	{ Log.info("In Switch case with TaskName :"+taskname);
	switch(taskname[0])
	{
	case "Reserve Access Resources":
	{
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(1000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Inputdata[39].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessNetworkElement")),Keys.ENTER);
		Thread.sleep(5000);
		getwebelement(xml.getlocator("//locators/Tasks/AccessPort")).clear();
		Thread.sleep(5000);
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Inputdata[40].toString());
		Thread.sleep(5000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/AccessPort")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
		workitemcounter=workitemcounter+1;
	}
	break;

	case "Transport Circuit Design":
       	 if(Inputdata[34].toString().equalsIgnoreCase("Protected"))
        	{ 
       	 		//Code for Protected
       		 	Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")).clear();
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")));
				Thread.sleep(30000);
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[41].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
				Thread.sleep(60000);
				getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[43].toString());
				Thread.sleep(10000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
				getwebelement(xml.getlocator("//locators/Tasks/Beacon")).clear();
				Thread.sleep(5000);
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Inputdata[47].toString());
				Thread.sleep(5000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/Beacon")),Keys.ENTER);
				Thread.sleep(10000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_1")));
				Clickon(getwebelement(xml.getlocator("//locators/Edit")));
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[42].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(120000);
				getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")),Inputdata[44].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")),Keys.ENTER);
				Thread.sleep(60000);
				Clickon(getwebelement(xml.getlocator("//locators/Update")));
				Clickon(getwebelement(xml.getlocator("//locators/TransportCfs")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				Clickon(getwebelement(xml.getlocator("//locators/GeneralInformation/GeneralInformationTab")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/EthernetLinkTransportRFS_2")));
				Clickon(getwebelement(xml.getlocator("//locators/Edit")));
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[45].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(120000);
				getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")),Inputdata[46].toString());
				Thread.sleep(60000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/CPETrunkPort")),Keys.ENTER);
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
				Thread.sleep(120000);
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Inputdata[41].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PENetworkElement")),Keys.ENTER);
				Thread.sleep(120000);
				getwebelement(xml.getlocator("//locators/Tasks/PePort")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Inputdata[42].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/PePort")),Keys.ENTER);
				Thread.sleep(120000);
				System.out.println("Entered the last value");
				getwebelement(xml.getlocator("//locators/Tasks/VCXController")).clear();
				SendKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Inputdata[43].toString());
				Thread.sleep(120000);
				SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/VCXController")),Keys.ENTER);
				//Scrollup();
				//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Popupclose")));
				//Thread.sleep(5000);
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
				Clickon(getwebelement(xml.getlocator("//locators/Tasks/TransComplete")));
				Thread.sleep(2000);
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
		SendKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Inputdata[48].toString());
		Thread.sleep(2000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/Tasks/OAMProfile")),Keys.ENTER);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}	
	break;

	case "Set/Validate Serial Number":
	{
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskTitle")));
		ANTCheck=GetText(getwebelement(xml.getlocator("//locators/Tasks/SerialTaskName")));
		Log.info(ANTCheck);
		if (ANTCheck.contains("New ANT"))
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

	case "Waiting for Hard Cease Date":
		default:
		// Nothing Found it will try to complete the Task	
	Clickon(getwebelement(xml.getlocator("//locators/Tasks/Complete")));
	}

}	
}