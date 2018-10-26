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

public class SiebelOrderHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\SiebelOrder.xml");
	
	public SiebelOrderHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------


	public void CreateSiebelOrder(Object[] Inputdata) throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Accounts")));
		SendKeys(getwebelement(xml.getlocator("//locators/OCNfield")),Inputdata[1].toString());
		Clickon(getwebelement(xml.getlocator("//locators/GoButton")));
		Clickon(getwebelement(xml.getlocator("//locators/AccountName")));
		Clickon(getwebelement(xml.getlocator("//locators/InstalledAssetNew")));
		SendKeys(getwebelement(xml.getlocator("//locators/OpportunityNo")),Inputdata[2].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/RequestReceivedDate")),Inputdata[3].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/DeliveryChannel")),Inputdata[4].toString());
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartySearch")));
		Clickon(getwebelement(xml.getlocator("//locators/PartySearchPopupDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/PartyName")));
		SendKeys(getwebelement(xml.getlocator("//locators/InputPartyname")),Inputdata[5].toString());
		Clickon(getwebelement(xml.getlocator("//locators/PickAccntOk")));
		//  SendKeys(getwebelement(xml.getlocator("//locators/OrderingParty")),Inputdata[4]);
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyAddrSearch")));
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyAddrSearchDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/PartyAddr")));
		SendKeys(getwebelement(xml.getlocator("//locators/InputPartyAddr")),Inputdata[6].toString());
		Clickon(getwebelement(xml.getlocator("//locators/PickAddrSubmit")));
		//SendKeys(getwebelement(xml.getlocator("//locators/OrderingPartyAddr")),Inputdata[5]);
		Clickon(getwebelement(xml.getlocator("//locators/OrderingPartyContactSearch")));
		Clickon(getwebelement(xml.getlocator("//locators/PartyContactPopupDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/FirstName")));
		SendKeys(getwebelement(xml.getlocator("//locators/InputFirstname")),Inputdata[7].toString());
		Clickon(getwebelement(xml.getlocator("//locators/FirstnameSubmit")));
		//SendKeys(getwebelement(xml.getlocator("//locators/OrderingPartyContact")),Inputdata[6]);
		SendKeys(getwebelement(xml.getlocator("//locators/SalesChannel")),Inputdata[8].toString());
		Clickon(getwebelement(xml.getlocator("//locators/NewServiceOrder")));		
		
		
		
		//OrderscreenURL=Getattribute(getwebelement(xml.getlocator("//locators/LinkforOrder")),"href");
		//System.out.println(OrderscreenURL);
	}
	public void AddProduct(Object[] Inputdata) throws Exception{
		Clickon(getwebelement(xml.getlocator("//locators/AdddEthernetHub")));
		   String OrderNo = Gettext(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		   int orderNo = Integer.parseInt(OrderNo);
		   System.out.println(orderNo);
		   Clickon(getwebelement(xml.getlocator("//locators/ServiceOrderReferenceNo")));
		   Clickon(getwebelement(xml.getlocator("//locators/Searchbutton")));
		   SendKeys(getwebelement(xml.getlocator("//locators/StreetName")),Inputdata[10].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/Country")),Inputdata[11].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/City")),Inputdata[12].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/PostalCode")),Inputdata[13].toString());
		   SendKeys(getwebelement(xml.getlocator("//locatos/Premises")),Inputdata[14].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/Search")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickAddress")));
		   Clickon(getwebelement(xml.getlocator("//locators/Pick")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickBulding")));
		   Clickon(getwebelement(xml.getlocator("//locators/Pick")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickSite")));
		   Clickon(getwebelement(xml.getlocator("//locators/Pick")));
		   Clickon(getwebelement(xml.getlocator("locators/ServicePartySearch")));
		   Select(getwebelement(xml.getlocator("//locators/SelectServiceParty")),"Party Name");
		   SendKeys(getwebelement(xml.getlocator("//locators/InputServicePartyName")),Inputdata[15].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/SearchServicePartyName")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickServiceParty")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickButton")));
		   Clickon(getwebelement(xml.getlocator("//locators/SiteContactSearch")));
		   SendKeys(getwebelement(xml.getlocator("//locators/InputContactName")),Inputdata[16].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/SearchContactName")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickContactName")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickContact")));
		   Clickon(getwebelement(xml.getlocator("//locators/SiteDetailCustomize")));
		   Select(getwebelement(xml.getlocator("//locators/CustomerSitePopStatus")),"New");
		   Select(getwebelement(xml.getlocator("//locators/BuildingType")),"Existing Building");
		   Clickon(getwebelement(xml.getlocator("//locators/CPEInformationLink")));
		   Select(getwebelement(xml.getlocator("//locators/CabinetType")),"Existing Colt Cabinet");
		   getwebelement(xml.getlocator("//locators/CabinetType")).clear();
		   SendKeys(getwebelement(xml.getlocator("//locators/CabinetId")),Inputdata[17].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/AccessPortLink")));
		   Select(getwebelement(xml.getlocator("//locators/PortRole")),"Physical Port");
		   Clickon(getwebelement(xml.getlocator("//locators/PresentationInterfaceSearch")));
		   Clickon(getwebelement(xml.getlocator("//locators/PickPresentationInterface")));
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitPresentationInterface")));
		   Clickon(getwebelement(xml.getlocator("//locators/EthernetHubLink")));
		   Select(getwebelement(xml.getlocator("//locators/SelectServiceBandwidth")),"1 Gbps");
		   Select(getwebelement(xml.getlocator("//locators/SelectResilienceOption")),"Protected");
		   Clickon(getwebelement(xml.getlocator("//locators/EthernetConnectionLink")));
		   Clickon(getwebelement(xml.getlocator("//locators/HubSiteLink")));
		   Clickon(getwebelement(xml.getlocator("//locators/AccessTechnologySearch")));
		   Clickon(getwebelement(xml.getlocator("//locators/SelectAccessTechnology")));
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitAccessTechnology")));
		   Clickon(getwebelement(xml.getlocator("//locators/DoneEthernetConnection")));
		   AcceptJavaScriptMethod();
		   Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeSearch")));
		   Clickon(getwebelement(xml.getlocator("//locators/AddOrderSubType")));
		   Clickon(getwebelement(xml.getlocator("//locators/OrderSubTypeDropDown")));
		   Clickon(getwebelement(xml.getlocator("//locators/SelectNew")));
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitSubOrderType")));
		   Clickon(getwebelement(xml.getlocator("//locators/ContractSearch")));
		   Clickon(getwebelement(xml.getlocator("//locators/SelectContract")));
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitContract")));
		   Clickon(getwebelement(xml.getlocator("//locators/NetworkReferenceSearch")));
		   Clickon(getwebelement(xml.getlocator("//locators/SelectNetworkReference")));
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitNetworkReference")));
		   Clickon(getwebelement(xml.getlocator("//locators/OrderDates")));
		   SendKeys(getwebelement(xml.getlocator("//locators/OrderSignedDate")),Inputdata[18].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/ColtActualDate")),Inputdata[19].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/OrderReceivedDate")),Inputdata[20].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/Billing")));
		   Clickon(getwebelement(xml.getlocator("//locators/ExpandAllButton")));
		   SendKeys(getwebelement(xml.getlocator("//locators/InstallationChargeNRC")),Inputdata[21].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/RecurringChargeMRC")),Inputdata[22].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/BCNInstallationChargeNRC")),Inputdata[23].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/BCNRecurringChargeMRC")),Inputdata[24].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/OrderStatusDropdown")));
		   Clickon(getwebelement(xml.getlocator("//locators/SelectTechnicalValidation")));
		   Clickon(getwebelement(xml.getlocator("//locators/BDWREVWCheckbox")));
		   Clickon(getwebelement(xml.getlocator("//locators/TriggerTRButton")));
		   SendKeys(getwebelement(xml.getlocator("//locators/PrimaryTestCompleted")),Inputdata[25].toString());
		   SendKeys(getwebelement(xml.getlocator("//locators/ExistingCapacity")),Inputdata[26].toString());
		   Clickon(getwebelement(xml.getlocator("//locators/SubmitTechnicalOrder")));
		   
		   
		
	}
//	private void SendKeys(WebElement el, Object object) {
//		
//		el.sendKeys((CharSequence[]) object);
//	}	
//	
	
}
