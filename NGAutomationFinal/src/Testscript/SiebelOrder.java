package Testscript;
import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import Driver.DataReader;
import Driver.DriverTestcase;


public class SiebelOrder extends DriverTestcase {	



@Test(dataProviderClass=DataReader.class,dataProvider="Siebeldata")
	public void CreateNewOrder(Object[] data) throws Exception{
	if(data[35+2].toString().equals("P2P"))	{
		SiebelOrderhelper.CreateSiebelOrder(data);
		SiebelOrderhelper.AddEthernetLineSiteA(data);
		SiebelOrderhelper.AddEthernetLineSiteBAddress(data);
		SiebelOrderhelper.ASiteCustomize(data);
		SiebelOrderhelper.BSiteCustomize(data);
		SiebelOrderhelper.Workflow(data);
		}
	else if(data[35+2].toString().equals("HUB"))
		{
		SiebelOrderhelper.CreateSiebelOrder(data);
		SiebelOrderhelper.AddProductEthernetHub(data);
		}
	else if(data[35+2].toString().equals("Spoke"))
		{

		SiebelOrderhelper.CreateSiebelOrder(data);
		SiebelOrderhelper.AddProductEthernetSpoke(data);
		}
}
}
