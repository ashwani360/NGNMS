package Testscript;

import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;

public class CeaseOrder extends DriverTestcase {	
		
	@Test(dataProviderClass=DataReader.class,dataProvider="InputData")
		public void CreateAndProcess(Object[] Data) throws Exception
		{
		if(Data[0].equals("Cease")){		

		CeaseOrderhelper.CreatCeaseOrder(Data);
//	1. Navigate to Accounts Composite Order page and click the order which you want to Disconnect.
//	2. In the screen under Instance field pick the Instance id of Ethernet Connection product order and move to main composite order page.
//	3. In the screen navigate to Product Instances tab and search for the Instance id.
//	4. Now select the instance id and click on Create Disconnect Product Order button.
//	5. Now navigate to Composite orders page and check for the newly created Disconnected order and click on it.
//	6. In the screen click on Edit button and update Hard Cease Delay as 0 and Colt Promise Date as yesterdays date and click on Update button.
		
		CeaseOrderhelper.DecomposeOrder(Data);
//		6.Once updated go to Accounts order page, search for the newly disconnected order, select it and click on Decompose button.
//		7. Now 2 End site disconnected product orders should be created.
		CeaseOrderhelper.ProcessOrder(Data);
		
//		8. Navigate back to Accounts order page, select the newly disconnected order and click on Start Processing.
//		9.Now move to Tasks tab and click on Execution flow link and wait for all tasks to get completed.
//		10. Meanwhile check the scheduler for any errors.*/
		}
		else
		{
			//Code for Hub and Spoke
			CeaseOrderhelper.CreatCeaseOrder(Data);
//			1. Navigate to Accounts Composite Order page and click the order which you want to Disconnect.
//			2. In the screen under Instance field pick the Instance id of Ethernet Connection product order and move to main composite order page.
//			3. In the screen navigate to Product Instances tab and search for the Instance id.
//			4. Now select the instance id and click on Create Disconnect Product Order button.
//			5. Now navigate to Composite orders page and check for the newly created Disconnected order and click on it.
//			6. In the screen click on Edit button and update Hard Cease Delay as 0 and Colt Promise Date as yesterdays date and click on Update button.
				
				CeaseOrderhelper.DecomposeOrder(Data);
//				6.Once updated go to Accounts order page, search for the newly disconnected order, select it and click on Decompose button.
//				7. Now 2 End site disconnected product orders should be created.
				CeaseOrderhelper.ProcessOrder(Data);
				
				CeaseOrderhelper.CreatCeaseOrder(Data);
//				1. Navigate to Accounts Composite Order page and click the order which you want to Disconnect.
//				2. In the screen under Instance field pick the Instance id of Ethernet Connection product order and move to main composite order page.
//				3. In the screen navigate to Product Instances tab and search for the Instance id.
//				4. Now select the instance id and click on Create Disconnect Product Order button.
//				5. Now navigate to Composite orders page and check for the newly created Disconnected order and click on it.
//				6. In the screen click on Edit button and update Hard Cease Delay as 0 and Colt Promise Date as yesterdays date and click on Update button.
					
					CeaseOrderhelper.DecomposeOrder(Data);
//					6.Once updated go to Accounts order page, search for the newly disconnected order, select it and click on Decompose button.
//					7. Now 2 End site disconnected product orders should be created.
					CeaseOrderhelper.ProcessOrder(Data);
		}
		
		}

	}



