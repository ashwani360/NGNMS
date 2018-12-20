package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.Log;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class SiebelCeaseOrderHelper extends DriverHelper {
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\SiebelCeaseOrder.xml");
	
	public SiebelCeaseOrderHelper(WebDriver parentdriver) {
		super(parentdriver);
		// TODO Auto-generated constructor stub
	}
	

		
			
		public void CreateSiebelCeaseOrder(Object[] Inputdata) throws Exception
		{
		ServiceOrder=Inputdata[2].toString();
		Log.info(ServiceOrder);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked Siebel Order Number for Cease : "+ServiceOrder);
		Thread.sleep(20000);
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceOrderTab");
		//Clickon(getwebelement(xml.getlocator("//locators/NewServiceOrder")));	
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New Service Order");		
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),ServiceOrder);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Order number provided");
		Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Search button");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order number");
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the TechnicalOrderTab");
		Thread.sleep(60000);
		Clickon(getwebelement(xml.getlocator("//locators/CeaseButton")));
		Thread.sleep(60000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Cease button");
		Thread.sleep(90000);
		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")),Inputdata[3].toString());
		SiebelCeaseOrdernumber = Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		//	int serviceOrder = Integer.parseInt(SiebelCeaseOrderNumber);
		Log.info(SiebelCeaseOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Cease  Order Generated : "+SiebelCeaseOrdernumber);
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Reference No");	
		}
		
		
		public void Workflow(Object[] Inputdata) throws Exception
		{
			Thread.sleep(20000);
			Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");
			Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")),"All");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/InputOrderSubType")),Keys.ENTER);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Select All");
			Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Sub Order Type");
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/OrderDates")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Dates");
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/OrderSignedDate")),Inputdata[5].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Signed Date");
			SendKeys(getwebelement(xml.getlocator("//locators/OrderReceivedDate")),Inputdata[6].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Received Date");
			SendKeys(getwebelement(xml.getlocator("//locators/CustomerRequestDate")),Inputdata[7].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer Request Date");
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/Billing")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing");
			Thread.sleep(5000);
			SendKeys(getwebelement(xml.getlocator("//locators/BillingEndDate")),Inputdata[8].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Billing End Date");
			Thread.sleep(30000);
			SendKeys(getwebelement(xml.getlocator("//locators/CeaseReason")),Inputdata[4].toString());
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cease Reason");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/CeaseReason")),Keys.ENTER);
			Thread.sleep(60000);
			getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
			SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),"Commercial Validation");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Commercial Validation");
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),Keys.ENTER);
			Thread.sleep(10000);
			SendkeaboardKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),Keys.TAB);		
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
			Thread.sleep(5000);
			Clickon(getwebelement(xml.getlocator("//locators/SelectDeliveryValidation")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Entered Order Status Delivery");
			Thread.sleep(60000);
			//CircuitReference = Gettext(getwebelement(xml.getlocator("//locators/CircuitReference")));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Generated Circuit Reference No: "+CircuitReference);
			waitandForElementDisplay(("//locators/CircuitReference"),2);
			CircuitReference=GetText(getwebelement(xml.getlocator("//locators/CircuitReference")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Generated Circuit Reference No: "+CircuitReference);
			Log.info(CircuitReference);
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/TechnicalOrderTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Technical Order Tab");
			TechnicalOrderStatus = Gettext(getwebelement(xml.getlocator("//locators/TechnicalOrderStatus")));
			VerifyText(TechnicalOrderStatus);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify Technical Order Status "+TechnicalOrderStatus);
				
		}
				  
		
			public void OrderComplete() throws Exception, Exception
		{
			Thread.sleep(10000);
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
			Thread.sleep(10000);
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),ServiceOrder);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input Order No");
			Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Order No");
			Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order No");
			Thread.sleep(10000);
			getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
			SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),"Completed");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Status");
			Thread.sleep(10000);
			//Clickon(getwebelement(xml.getlocator("//locators/OrderComplete")));
			//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
						
		}

		
	}
