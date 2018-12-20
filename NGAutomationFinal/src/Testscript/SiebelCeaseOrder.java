package Testscript;


import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;


public class SiebelCeaseOrder extends DriverTestcase {	
//	@AfterMethod
//	public void returntoAccountPages(Method method) throws Exception
//	{
//		if(method.getName().equals("CreateOrder")){
////		NavigationHelper.GotoDocument();
////		NavigationHelper.GotoAccount();
//		itr=itr+1;
//		}
//	}
@Test(dataProviderClass=DataReader.class,dataProvider="SiebelCeaseOrder")

	public void CreateOrder(Object[] data) throws Exception
	{
		
//	1. Go to Accounts and enter the OCN number as 4159381 and click Enter.
//	2. Click on the name and Move to Install Assets and select New order.
//	3. Enter the Red marked fields like Opportunity, Request Received date, Delivery channel - WLC, Ordering Party, Ordering Party address, 
//	Ordering Party contract and Sales Channel - Direct.
//	4. Click on New Service Order.
	
	SiebelCeaseOrderhelper.CreateSiebelCeaseOrder(data);
	SiebelCeaseOrderhelper.Workflow(data);
	
	}
@Test(dataProviderClass=DataReader.class,dataProvider="SiebelCeaseOrder")
public void OrderComplete(String in1,String in2,String in3,String in4,String in5,String in6,String in7) throws Exception
{
	
//1. Go to Accounts and enter the OCN number as 4159381 and click Enter.
//2. Click on the name and Move to Install Assets and select New order.
//3. Enter the Red marked fields like Opportunity, Request Received date, Delivery channel - WLC, Ordering Party, Ordering Party address, 
//Ordering Party contract and Sales Channel - Direct.
//4. Click on New Service Order.
//SiebelOrderhelper.CreateSiebelOrder(in1,in2,in3,in4,in5,in6,in7);
}

}
