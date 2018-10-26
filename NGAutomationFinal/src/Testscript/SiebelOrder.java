package Testscript;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class SiebelOrder extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="SiebelData")
	public void CreateOrder(Object[] Inputdata) throws Exception
	{
		
//	1. Go to Accounts and enter the OCN number as 4159381 and click Enter.
//	2. Click on the name and Move to Install Assets and select New order.
//	3. Enter the Red marked fields like Opportunity, Request Received date, Delivery channel - WLC, Ordering Party, Ordering Party address, 
//	Ordering Party contract and Sales Channel - Direct.
//	4. Click on New Service Order.
	SiebelOrderhelper.CreateSiebelOrder(Inputdata);
	SiebelOrderhelper.AddProduct(Inputdata);
	}

}
