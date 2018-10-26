package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.DriverHelper;
import Driver.xmlreader;

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
		Clickon(getwebelement(xml.getlocator("//locators/ProductInstance")));
		Clickon(getwebelement(xml.getlocator("//locators/InstNameFiltering")));
		Select(getwebelement(xml.getlocator("//locators/FilterSelectName")),"Name");
		SendKeys(getwebelement(xml.getlocator("//locators/EndsiteName")),Inputdata[0].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Apply")));
		Clickon(getwebelement(xml.getlocator("//locators/EndsiteproductCheck")));
		Clickon(getwebelement(xml.getlocator("//locators/CreateDisconnectProductOrder")));
		Clickon(getwebelement(xml.getlocator("//locators/EndSiteProduct")));
		SendKeys(getwebelement(xml.getlocator("//locators/HardCeaseDelay")),Inputdata[1].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseDate")),Inputdata[2].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseMonth")),Inputdata[3].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/ColtPromiseYear")),Inputdata[4].toString());
		SendKeys(getwebelement(xml.getlocator("//locators/OrderSystemServiceID")),Inputdata[5].toString());
		Clickon(getwebelement(xml.getlocator("//locators/Update")));
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
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/ExceutionFlowlink")));
		Thread.sleep(10000);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
		Thread.sleep(5000);
		waitandclickForworkitemsPresent(xml.getlocator("//locators/Tasks/TaskReadytoComplete"),60);
		Clickon(getwebelement(xml.getlocator("//locators/Tasks/TaskReadytoComplete")));
		Geturl(OrderscreenURL);
		Clickon(getwebelement(xml.getlocator("//locators/Accountbredcrumb")));	
		Clickon(getwebelement(xml.getlocator("//locators/AccountNameSorting")));
		Clickon(getwebelement("//a/span[contains(text(),'"+arrOfStr[1]+"')]/parent::*"));
	}
}



