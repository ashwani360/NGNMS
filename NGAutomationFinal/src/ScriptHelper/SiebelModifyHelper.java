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
import ScriptHelper.SiebelOrderHelper;


public class SiebelModifyHelper extends DriverHelper{

		WebElement el;
		xmlreader xml=new xmlreader("src\\Locators\\SiebelModifyOrder.xml");

	public SiebelModifyHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}
	public static String ModifiedCircuitRefnumber;
	public static String ModifiedSiebelOrdernumber;
//---------------------------------	
	public void SoftModSiebelOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
		Thread.sleep(20000);
//		SiebelOrdernumber=Inputdata[3].toString();
//		Log.info(SiebelOrdernumber);
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Pick Siebel Order Number for Modify : "+SiebelOrdernumber);
//		Log.info(SiebelOrdernumber);
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),Inputdata[3].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Order number provided");
		Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search button");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Order number");
		Thread.sleep(20000);
		Clickon(getwebelement(xml.getlocator("//locators/Modifybutton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modify button");
		Thread.sleep(60000);
		ModifiedSiebelOrdernumber = Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		Log.info(ModifiedSiebelOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Modified Siebel Order Generated : "+ModifiedSiebelOrdernumber);
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNo")),Inputdata[4].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")),Inputdata[5].toString());
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Modified Order");
	}

	public void EditSiebelProduct(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");
//		Clickon(getwebelement(xml.getlocator("//locators/OrderSubType")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Input field of Order Subtype");
		Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderSubType")),Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Pick the Order subtype from Input");
		Thread.sleep(10000);
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderSubType")),Keys.ENTER);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Pick the Order subtype from Input");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ok button");
		Thread.sleep(10000);
//		ModifiedCircuitRefnumber=GetInputValue(getwebelement(xml.getlocator("//locators/ModifyCircuitRef")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Modified Circuit Reference No: "+ModifiedCircuitRefnumber);
//		Log.info(ModifiedCircuitRefnumber);
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Modified circuit id");
//		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Status");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectCommercialValidation")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Commercial Validation");
		Thread.sleep(50000);
	}
	
	public void UpdateBandwidth(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/CustomizeButton")));
		Thread.sleep(30000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Customize button");
		Clickon(getwebelement(xml.getlocator("//locators/CustomizeServiceBandwidth")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Service Bandwidth");
		Select(getwebelement(xml.getlocator("//locators/CustomizeServiceBandwidth")),Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the updated bandwidth");
		Thread.sleep(5000);
	}
	
	public void UpdateSiteDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/CustomizeButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize button");
		Thread.sleep(30000);
		Clickon(getwebelement(xml.getlocator("//locators/EthernetConnectionLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/AendSiteLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/InstallationTimeLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
		SendKeys(getwebelement(xml.getlocator("//locators/InstallTime")),Inputdata[9].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update the Installation time");
		Clickon(getwebelement(xml.getlocator("//locators/EthernetConnectionLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/BendSiteLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/InstallationTimeLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Time link");
		SendKeys(getwebelement(xml.getlocator("//locators/InstallTime")),Inputdata[9].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Installation time");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
		Thread.sleep(60000);
	}

	public void EditProductDeviceDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/CustomizeButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize button");
		Thread.sleep(30000);
		Clickon(getwebelement(xml.getlocator("//locators/EthernetConnectionLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
		Thread.sleep(10000);
		if (Inputdata[2].toString().equalsIgnoreCase("A end"))
		{
			Clickon(getwebelement(xml.getlocator("//locators/AendSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/CPEInformationLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information link");
			Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
			Clickon(getwebelement(xml.getlocator("//locators/PortRole")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Port Role");
			Select(getwebelement(xml.getlocator("//locators/PortRole")),Inputdata[10].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Port Role");
			Clickon(getwebelement(xml.getlocator("//locators/VLANTaggingMode")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
			Select(getwebelement(xml.getlocator("//locators/VLANTaggingMode")),Inputdata[11].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
			Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
			getwebelement(xml.getlocator("//locators/VLANTagID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
			SendKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Inputdata[12].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Port Id");
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
			Thread.sleep(90000);
		}
		else 
		{
			Clickon(getwebelement(xml.getlocator("//locators/BendSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Bend Site link");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/CPEInformationLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information link");
			Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
			Clickon(getwebelement(xml.getlocator("//locators/PortRole")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Bend Port Role");
			Select(getwebelement(xml.getlocator("//locators/PortRole")),Inputdata[13].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Port Role");
			Clickon(getwebelement(xml.getlocator("//locators/VLANTaggingMode")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN Tagging Mode");
			Select(getwebelement(xml.getlocator("//locators/VLANTaggingMode")),Inputdata[14].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tagging Mode");
			Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
			getwebelement(xml.getlocator("//locators/VLANTagID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
			SendKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Inputdata[15].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Port Id");
			Thread.sleep(5000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
			Thread.sleep(90000);
		}
	}

	public void UpdateVlanDetails(Object[] Inputdata) throws Exception
	{ 
		Clickon(getwebelement(xml.getlocator("//locators/CustomizeButton")));
		Thread.sleep(30000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Customize button");
		Clickon(getwebelement(xml.getlocator("//locators/EthernetConnectionLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Ethernet Connection link");
		Thread.sleep(10000);
		if (Inputdata[2].toString().equalsIgnoreCase("A end"))
		{
			Clickon(getwebelement(xml.getlocator("//locators/AendSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Aend Site link");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/CPEInformationLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information link");
			Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
			Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
			getwebelement(xml.getlocator("//locators/VLANTagID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
			SendKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Inputdata[12].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update VLAN Tag Id");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
			Thread.sleep(90000);
		}
		else 
		{
			Clickon(getwebelement(xml.getlocator("//locators/BendSiteLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Bend Site link");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/CPEInformationLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on CPE Information link");
			Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Access Port link");
			Clickon(getwebelement(xml.getlocator("//locators/VLANLink")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on VLAN link");
			getwebelement(xml.getlocator("//locators/VLANTagID")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Tag Id");
			SendKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Inputdata[15].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Updated VLAN Tag Id");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/VLANTagID")),Keys.ENTER);
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Ethernet Connection");
			Thread.sleep(90000);
		}
	}
	
	public void UpdateOrderDetails(Object[] Inputdata) throws Exception
	{
		Thread.sleep(60000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderDate/OrderDates")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Dates Tab");
		Thread.sleep(20000);
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDate/OrderSignedDate")),Inputdata[16].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Order Signed Date");
	    SendKeys(getwebelement(xml.getlocator("//locators/OrderDate/ColtActualDate")),Inputdata[17].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Colt Actual Date");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderDate/OrderReceivedDate")),Inputdata[18].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Update Order Received Date");
		Thread.sleep(10000);;
	}

	public void UpdateBillingDetails(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/Billing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing");
		Thread.sleep(10000);
		SendKeys(getwebelement(xml.getlocator("//locators/BillingDetails/ContractRenewalFlag")),Inputdata[24].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Contract Renewal Flag");
		SendkeaboardKeys(getwebelement(xml.getlocator("//locators/BillingDetails/ContractRenewalFlag")),Keys.TAB);
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/ExpandAllButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Expand All button");
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/InstallationChargeNRC")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation Charge NRC");
		getwebelement(xml.getlocator("//locators/BillingDetails/InputinstallationChargeNRC")).clear();
		SendKeys(getwebelement(xml.getlocator("//locators/BillingDetails/InputinstallationChargeNRC")),Inputdata[19].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Installation Charge NRC");
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/BCNInstallationChargeNRC")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Installation Charge NRC");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/BCNInstallationChargeNRCSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN Installation Charge NRC Search");
		SendKeys(getwebelement(xml.getlocator("//locators/BillingDetails/BCNInstallationChargeNRCInput")),Inputdata[21].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter BCN Installation Charge NRC Input");
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/BCNNRCSubmit")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on BCN NRC Submit");
		Thread.sleep(5000);
	}
	
	public void ProcessSiebelOrder(Object[] Inputdata) throws Exception
	{
//		SendKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")),Inputdata[7].toString());
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Provided Existing Capacity Lead Time Primary");
		Thread.sleep(20000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Technical Validation");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectTechnicalValidation")));
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Trigger TR Button");
		Thread.sleep(30000);
		SendKeys(getwebelement(xml.getlocator("//locators/ExistingCapacityLeadTimePrimary")),Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Provided Existing Capacity Lead Time Primary");
		Thread.sleep(8000);
		savePage();
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectDelivery")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Delivery");
//		Thread.sleep(10000);
//		Select(getwebelement(xml.getlocator("//locators/OSSPlatformFlag")),"IQNet");
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select OSS Platform Flag");
		Thread.sleep(20000);
		waitandForElementDisplay(("//locators/SubmitTechnicalOrder"),2);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Waiting for Submit Technical Order button");
		Clickon(getwebelement(xml.getlocator("//locators/SubmitTechnicalOrder")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Technical Order");
		Thread.sleep(120000);
		waitandForElementDisplay(("//locators/CircuitReference"),2);
		ModifiedCircuitRefnumber=GetInputValue(getwebelement(xml.getlocator("//locators/CircuitReference")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Generated Circuit Reference No: "+ModifiedCircuitRefnumber);
		Log.info(ModifiedCircuitRefnumber);
		Thread.sleep(5000);
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Technical Order Tab");
		TechnicalOrderStatus = Gettext(getwebelement(xml.getlocator("//locators/TechnicalOrderStatus")));
		VerifyText(TechnicalOrderStatus);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify Technical Order Status "+TechnicalOrderStatus);
	}
	
	public void CompleteModifyOrder() throws Exception, Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),ModifiedSiebelOrdernumber);
//		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),"871324854/181215-0005");
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input Order No");
		Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Order No");
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order No");
		Thread.sleep(30000);
		Clickon(getwebelement(xml.getlocator("//locators/DropDown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Drop down");
		Select(getwebelement(xml.getlocator("//locators/DropDown")),"Installation and Test");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Installation And Test Tab");
		Thread.sleep(10000);
		SendKeys(getwebelement(xml.getlocator("//locators/PrimaryTestingMethod")),"Not Required");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Primary Testing Method");
		getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
//		Clickon(getwebelement(xml.getlocator("//locators/WarningOk")));
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Ok in displayed Warning");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order status drop down");
		Thread.sleep(3000);
		Clickon(getwebelement(xml.getlocator("//locators/SelectCompleted")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Completed Status");
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/OrderComplete")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
		Thread.sleep(20000);
	}
}