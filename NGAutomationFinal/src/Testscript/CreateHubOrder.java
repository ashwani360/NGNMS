package Testscript;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class CreateHubOrder extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="HubAndSpokeNewOrder")
	public void HubCreateAndProcess(Object[] Data) throws Exception
	{
//	Hub Order Creation		
//		4. Click on New Composite order and in the screen displayed Enter a description and click on Update.
	NewHubOrderhelper.CreatHubOrder(Data);
//		5. Navigate to Orders tab and click on Add button.
//		6. In the Order capture screen select Hub Product and click on Add.
	NewHubOrderhelper.AddHubProduct(Data);
//		7. In the same screen update Network Reference - Random no, Topology as Hub and Spoke, set Order number, Commercial Product name as Ethernet Hub and Service Bandwidth as 1Gbps.
//		8. Once all the fields are set click on Update button.
	NewHubOrderhelper.AddHubProductdetails(Data);
//		9. Go to the Hub product order and do a Decompose.
	NewHubOrderhelper.DecomposeHubOrder(Data);
//		10. Make sure that 1 Hub End site product orders being created.
//		11. Edit the Hub site product details like site id as FRA99903/092, access technology as Ethernet Over NGN and access type as Colt Fibre.
//		12. Navigate to General Information tab and click on Access Port link.
//		13. Now click on Edit button and set Port Role as Physical Port and click on Update button.
	NewHubOrderhelper.HubProductDeviceDetails(Data);
//		14. Navigate to Customer account, search for the composite order, select it and click Start Processing button on the top.
//		15. Now click on the order and move to Tasks tab.
//		16. Now click on the Execution flow link and move to Work Items tab.
//		17. Make sure that 1 work items Reserve access is created.
//		18. Click on Reserve access link and in Access network element search AR10.BLB & set Access Port as GigabitEthernet/0/0/0/37 and click on Complete button.
//		19. Wait for all the tasks to get completed and make that Composite order is in Process completed status.
	NewHubOrderhelper.ProcessHubOrder(Data);
//	Spoke Order Creation	
//		1. Click on New Composite order and in the screen displayed Enter a description and click on Update.
	NewHubOrderhelper.CreatCompositSpokeOrder(Data);
//		2. Navigate to Orders tab and click on Add button.
//		3. In the Order capture screen select Ethernet Connection Product and click on Add. 	
//		4. Click on Ethernet Connection Product order and in the screen click on Edit button.
	NewHubOrderhelper.AddSpokeProduct(Data);
//		5. Update Order system reference id, Topology as Hub and Spoke, set Order number, Commercial Product name as Ethernet Spoke and Service Bandwidth as 1Gbps.
//		6. Once all the fields are set click on Update button.
	NewHubOrderhelper.AddSpokeProductdetails(Data);
//		7. Navigate to General Information tab and click Add Feature button.
//		8. Now enter End Site product and click on Search button.
	NewHubOrderhelper.AddSpokeFeatureDetails(Data);
//		9. Now navigate to Customer account in the top and click the Composite order which was created in the starting.
//		10. Now make sure to be in Order tab, select the Ethernet product order and click on Decompose button.
//		11. Make sure that 2 End site product orders being created.
	NewHubOrderhelper.DecomposeSpokeOrder(Data);
//		12. Click on the Ethernet Connection product and click on Add Hub button.
//		13. Paste the NC service id in the search and do a select.
	NewHubOrderhelper.AddHub(Data);
//		14. Click the 1st end site product order and check whether the hub site is added to this end.
//		15. Navigate to General Information tab and click on Access Port link.
//		16. Now click on Edit button set Port Role as VLAN Port (existing) & Vlan Tagging mode as Translation and click on Update button.
//		17. Move to Composite order and click the other End site product order.
//		18. Now set the details as Access Technology as Ethernet_over_NGN, Access type as Colt Fibre, Site end as B end and enter a Site ID as	FRA99903/092 as taken from Search of the device.
//		19. Navigate to General Information tab click on Access Port link, click the Edit button, set Port Role as Physical Port and click Update.
	NewHubOrderhelper.SpokeProductDeviceDetails(Data);
//		20. Navigate to Customer account, search for the composite order, select it and click Start Processing button on the top.
//		21. Now click on the order and move to Tasks tab.
//		22. Now click on the Execution flow link and move to Work Items tab.
//		23. In the screen click the link and set Access network element search for AR10.BLB and set Access Port as GigabitEthernet/0/0/0/43 and click on Complete button.
//		24. Wait for the Start Activation confirmation work item to get created.
//		25. Once created click on the start activation link and click on Complete button.
//		26. Now wait for all the Automated tasks to get completed and make sure that the Spoke composite order also has Status as  Process Completed.
	NewHubOrderhelper.ProcessSpokeOrder(Data);
		
	}

}
