package Testscript;
import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import Driver.DataReader;
import Driver.DriverTestcase;


public class SiebelOrder extends DriverTestcase {	

	@AfterMethod
	public void returntoAccountPages(Method method) throws Exception
	{
		if(method.getName().equals("CreateP2POrder")){
// Code to Logout once order is created
			Login.SiebelLogout("Siebel");
		}
	}
	
@Test(dataProviderClass=DataReader.class,dataProvider="SiebelOrder")

public void CreateNewOrder(Object[] data) throws Exception{
if(data[2].toString().equals("P2P"))	{
	SiebelOrderhelper.CreateSiebelOrder(data);
	SiebelOrderhelper.AddEthernetLineSiteA(data);
	SiebelOrderhelper.AddEthernetLineSiteBAddress(data);
	SiebelOrderhelper.ASiteCustomize(data);
	SiebelOrderhelper.BSiteCustomize(data);
	SiebelOrderhelper.Workflow(data);
	}
else if(data[2].toString().equals("HUB"))
	{
	SiebelOrderhelper.CreateSiebelOrder(data);
	SiebelOrderhelper.AddProductEthernetHub(data);
	}
else if(data[2].toString().equals("Spoke"))
	{
	SiebelOrderhelper.CreateSiebelOrder(data);
	SiebelOrderhelper.AddProductEthernetSpoke(data);
	}
}

@Test
	public void CompleteP2POrder() throws Exception
	{
	SiebelOrderhelper.OrderCompleteEthernetLine();
	}

@Test
	public void CreateHubOrder(Object[] data) throws Exception
	{
		SiebelOrderhelper.CreateSiebelOrder(data);
		SiebelOrderhelper.AddProductEthernetHub(data);
	}

@Test
	public void CompleteHubOrder() throws Exception
	{
		SiebelOrderhelper.OrderCompleteEthernetHub();
	}

@Test
	public void CreateSpokeOrder(Object[] data) throws Exception
	{
		SiebelOrderhelper.CreateSiebelOrder(data);
		SiebelOrderhelper.AddProductEthernetSpoke(data);
	}
	
@Test
	public void CompleteSpokeOrder() throws Exception
	{
		SiebelOrderhelper.OrderCompleteEthernetLine();
	}
}
