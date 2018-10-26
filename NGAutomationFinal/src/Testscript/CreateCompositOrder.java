package Testscript;
import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class CreateCompositOrder extends DriverTestcase  {	
 
@AfterMethod
public void returntoAccountPages(Method method) throws Exception
{
	if(method.getName().equals("CreateAndProcess")){
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	}
}
	
@Test(dataProviderClass=DataReader.class,dataProvider="EtherNetP2PNewOrder")
	public void CreateAndProcess(Object[] Data) throws Exception
	{
	
//		4. Click on New Composite order and in the screen displayed Enter a description and click on Update.
	CompositeOrderhelper.CreatCompositOrder(Data);
//		5. Navigate to Orders tab and click on Add button.
//		6. In the Order capture screen select Ethernet Connection Product and click on Add.
	CompositeOrderhelper.AddProduct(Data);
//		7. In the screen displayed set Order system service id as the id taken from Siebel.
//		8. In the same screen update Topology as Point to point, set Order number, Commercial Product name as Ethernet line and Service Bandwidth as 1Gbps.
//		9. Once all the fields are set click on Update button.	
	//CompositeOrderhelper.AddProductdetails(Data);
//		10. Navigate to General Information tab and click Add Feature button.
//		11. Now enter End Site product and click on Search button.
	//CompositeOrderhelper.AddFeatureDetails(Data);
//		12. Now navigate to Customer account in the top and click the Composite order which was created in the begining.
//		13. Now make sure to be in Order tab, select the Ethernet product order and click on Decompose button.
//		14. Make sure that 2 End site product orders being created.
	//CompositeOrderhelper.DecomposeOrder(Data);
//		15. Click the 1st end site product order and click on Edit button in the screen displayed.
//		16. Now set the details as Access Technology as Ethernet_over_NGN, Access type as Colt Fibre, Site End as A End and enter a Site ID as 	
//		TKY0000112258/002 as taken from Search of the device.
//		17. Navigate to General Information tab and click on Access Port link.
//		18. Now click on Edit button and set Port Role as Physical Port.
//		19. Move back to End site product order and click on CPE Information from General information tab.
//		20. Now click on Edit button and set Cabinet id as 37 and Cabinet type as Existing Colt cabinet & click on Update button.
//		21. Move to Composite order and click the other End site product order.
//		22. Now set the details as Access Technology as Ethernet_over_NGN, Access type as Colt Fibre, Site End as B End and enter a Site ID as 	
//		TKY0000112258/002 as taken from Search of the device.
//		23. Navigate to General Information tab click on Access Port link, click the Edit button and set Port Role as Physical Port and click Update.
//		25. Move back to End site product order and click on CPE Information from General information tab.
//		26. Now click on Edit button and set Cabinet id as 43 and Cabinet type as Existing Colt cabinet & click on Update button.
	//CompositeOrderhelper.ProductDeviceDetails(Data);
//		27. Navigate to Customer account, search for the composite order, select it and click Start Processing button on the top.
//		28. Now click on the order and move to Tasks tab..
//		29. Now click on the Execution flow link and in the screen set Access network element search for AR10.BLB and set Access Port as Gigabit/Ethernet/0/0/0/37 and click on Complete button.
//		30. Do the above step for B end as well with Access network element search as AR10.BLB and Access port as 43 and click the Complete button.
//		31. Navigate to Tasks and click the OAM profile order and set the OAM profile as L1_MEG_MEP and click the Complete button.
	//CompositeOrderhelper.ProcessOrder(Data);
	//CompositeOrderhelper.NavigatebacktoAccountScreen();
	itr=itr+1;
	}
	
	@Test(dataProviderClass=DataReader.class,dataProvider="InputData")
	public void CreateAndProcess1(Object[] Data) throws Exception
	{
		
//		4. Click on New Composite order and in the screen displayed Enter a description and click on Update.
	CompositeOrderhelper.CreatCompositOrder(Data);
//		5. Navigate to Orders tab and click on Add button.
//		6. In the Order capture screen select Ethernet Connection Product and click on Add.
	CompositeOrderhelper.AddProduct(Data);
//		7. In the screen displayed set Order system service id as the id taken from Siebel.
//		8. In the same screen update Topology as Point to point, set Order number, Commercial Product name as Ethernet line and Service Bandwidth as 1Gbps.
//		9. Once all the fields are set click on Update button.	
	CompositeOrderhelper.AddProductdetails(Data);
//		10. Navigate to General Information tab and click Add Feature button.
//		11. Now enter End Site product and click on Search button.
	CompositeOrderhelper.AddFeatureDetails(Data);
//		12. Now navigate to Customer account in the top and click the Composite order which was created in the begining.
//		13. Now make sure to be in Order tab, select the Ethernet product order and click on Decompose button.
//		14. Make sure that 2 End site product orders being created.
	CompositeOrderhelper.DecomposeOrder(Data);
//		15. Click the 1st end site product order and click on Edit button in the screen displayed.
//		16. Now set the details as Access Technology as Ethernet_over_NGN, Access type as Colt Fibre, Site End as A End and enter a Site ID as 	
//		TKY0000112258/002 as taken from Search of the device.
//		17. Navigate to General Information tab and click on Access Port link.
//		18. Now click on Edit button and set Port Role as Physical Port.
//		19. Move back to End site product order and click on CPE Information from General information tab.
//		20. Now click on Edit button and set Cabinet id as 37 and Cabinet type as Existing Colt cabinet & click on Update button.
//		21. Move to Composite order and click the other End site product order.
//		22. Now set the details as Access Technology as Ethernet_over_NGN, Access type as Colt Fibre, Site End as B End and enter a Site ID as 	
//		TKY0000112258/002 as taken from Search of the device.
//		23. Navigate to General Information tab click on Access Port link, click the Edit button and set Port Role as Physical Port and click Update.
//		25. Move back to End site product order and click on CPE Information from General information tab.
//		26. Now click on Edit button and set Cabinet id as 43 and Cabinet type as Existing Colt cabinet & click on Update button.
	CompositeOrderhelper.ProductDeviceDetails(Data);
//		27. Navigate to Customer account, search for the composite order, select it and click Start Processing button on the top.
//		28. Now click on the order and move to Tasks tab..
//		29. Now click on the Execution flow link and in the screen set Access network element search for AR10.BLB and set Access Port as Gigabit/Ethernet/0/0/0/37 and click on Complete button.
//		30. Do the above step for B end as well with Access network element search as AR10.BLB and Access port as 43 and click the Complete button.
//		31. Navigate to Tasks and click the OAM profile order and set the OAM profile as L1_MEG_MEP and click the Complete button.
	CompositeOrderhelper.ProcessOrder(Data);
	}

	

}
