package Testscript;
import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import Driver.DataReader;
import Driver.DriverTestcase;
import Driver.Log;


public class SiebelModifyOrder extends DriverTestcase {	

@AfterMethod
	public void returntoAccountPages(Method method) throws Exception
	{
		if(method.getName().equals("SiebelModfiyAndProcess")){
// Code to Logout once order is created
			Login.SiebelLogout("Siebel");
			//itr=itr+1;
		}
	}
	
@Test(dataProviderClass=DataReader.class,dataProvider="SiebelModifyOrder")
	
	public void SiebelModfiyAndProcess(Object[] Data) throws Exception 
	{
	if (Data[1].toString().equalsIgnoreCase("Soft-Mod")) 
	 	{
		if (Data[0].toString().equalsIgnoreCase("BW Upgrade"))
			{		
			SiebelModifyhelper.SoftModSiebelOrder(Data);
			SiebelModifyhelper.EditSiebelProduct(Data);
			SiebelModifyhelper.UpdateBandwidth(Data);
			SiebelModifyhelper.UpdateSiteDetails(Data);
			SiebelModifyhelper.UpdateOrderDetails(Data);
			SiebelModifyhelper.UpdateBillingDetails(Data);
			SiebelModifyhelper.ProcessSiebelOrder(Data);
			}
		else if(Data[0].toString().equalsIgnoreCase("VLAN Tagging Mode"))
			{
			SiebelModifyhelper.SoftModSiebelOrder(Data);
			SiebelModifyhelper.EditSiebelProduct(Data);
			SiebelModifyhelper.UpdateSiteDetails(Data);
			SiebelModifyhelper.EditProductDeviceDetails(Data);
			SiebelModifyhelper.UpdateOrderDetails(Data);
			SiebelModifyhelper.UpdateBillingDetails(Data);
			SiebelModifyhelper.ProcessSiebelOrder(Data);
			}
		else if(Data[0].toString().equalsIgnoreCase("VLAN ID"))
			{
			SiebelModifyhelper.SoftModSiebelOrder(Data);
			SiebelModifyhelper.EditSiebelProduct(Data);
			SiebelModifyhelper.UpdateSiteDetails(Data);
			SiebelModifyhelper.UpdateVlanDetails(Data);
			SiebelModifyhelper.UpdateOrderDetails(Data);
			SiebelModifyhelper.UpdateBillingDetails(Data);
			SiebelModifyhelper.ProcessSiebelOrder(Data);
			}
	 	}
	}
	
	public void CompleteModOrder() throws Exception
	{
		SiebelModifyhelper.CompleteModifyOrder();
	}
}
