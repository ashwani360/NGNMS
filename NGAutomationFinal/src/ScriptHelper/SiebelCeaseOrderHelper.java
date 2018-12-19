package ScriptHelper;

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
	static String ServiceOrder;

		
		public void CreateSiebelCeaseOrder(Object[] Inputdata) throws Exception
		{
		SiebelOrdernumber=Inputdata[2].toString();
		Log.info(SiebelOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked Siebel Order Number for Cease : "+SiebelOrdernumber);
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on ServiceOrderTab");
		//Clickon(getwebelement(xml.getlocator("//locators/NewServiceOrder")));	
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on New Service Order");		
		SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),SiebelOrdernumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Order number provided");
		Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Search button");
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the Order number");
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on the TechnicalOrderTab");
		Clickon(getwebelement(xml.getlocator("//locators/Ceasebutton")));
		Thread.sleep(60000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Cease button");
		SiebelCeaseOrdernumber = Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		int SiebelCeaseOrder = Integer.parseInt(SiebelCeaseOrdernumber);
		System.out.println(SiebelCeaseOrder);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Siebel Cease  Order Generated : "+SiebelCeaseOrdernumber);
		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")),Inputdata[3].toString());
		Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clicked on Cease Order");
		}
		
		
		public void Workflow(Object[] Inputdata) throws Exception
		{
		Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Sub Type Search");
		Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Add Order Sub Type");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderSubTypeDropDown")),Inputdata[4].toString());
		Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Submit Sub Order Type");
		getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),"Commercial validation");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Status");
		getwebelement(xml.getlocator("//locators/CeaseReason")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Cease Reason");
		SendKeys(getwebelement(xml.getlocator("//locators/CeaseReason")),Inputdata[5].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Cease Reason");
		Clickon(getwebelement(xml.getlocator("//locators/OrderDates")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order Dates");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderSignedDate")),Inputdata[6].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Signed Date");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderReceivedDate")),Inputdata[7].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Received Date");
		SendKeys(getwebelement(xml.getlocator("//locators/CustomerRequestDate")),Inputdata[8].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Customer Request Date");
		Clickon(getwebelement(xml.getlocator("//locators/BillingDetails/Billing")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Billing");
		SendKeys(getwebelement(xml.getlocator("//locators/BillingDetails/BillingEndDate")),Inputdata[9].toString());
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Billing End Date");
		getwebelement(xml.getlocator("//locator/OrderStatus")).clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
		SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),"Delivery");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Status");
		Clickon(getwebelement(xml.getlocator("//locators/TechnicalOrderTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Technical Order Tab");
		String TechnicalOrderStatus = Gettext(getwebelement(xml.getlocator("//locators/TechnicalOrderStatus")));
		VerifyTextpresent(TechnicalOrderStatus);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify Technical Order Status ");
//		CircuitRefNumber=GetText(getwebelement(xml.getlocator("//locators/CircuitReference")));
//		System.out.println(CircuitRefNumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Picked the Circuit Reference " + CircuitRefnumber);
		//Clickon(getwebelement(xml.getlocator("//locators/Accounts")));
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Accounts");
		//SendKeys(getwebelement(xml.getlocator("//locators/FilterInputValue")),CircuitReference);
		//ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Instance number for cease provided ");
		}
		
			public void OrderComplete() throws Exception, Exception
		{
			Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderTab")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Service Order Tab");
			SendKeys(getwebelement(xml.getlocator("//locators/InputOrderNo")),ServiceOrder);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Input Order No");
			Clickon(getwebelement(xml.getlocator("//locators/SearchOrderNo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Search Order No");
			Clickon(getwebelement(xml.getlocator("//locators/ClickOrderNo")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Order No");
			getwebelement(xml.getlocator("//locators/OrderStatus")).clear();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Clear Order Status");
			SendKeys(getwebelement(xml.getlocator("//locators/OrderStatus")),"Completed");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Order Status");
			Clickon(getwebelement(xml.getlocator("//locators/OrderComplete")));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click Order Complete");
						
		}

		
	}
