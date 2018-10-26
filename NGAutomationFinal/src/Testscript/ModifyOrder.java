package Testscript;
import org.testng.annotations.Test;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class ModifyOrder extends DriverTestcase {	
	
@Test(dataProviderClass=DataReader.class,dataProvider="InputData")
	public void ModfiyAndProcess(Object[] Data) throws Exception
	{
//		
	ModifyOrderhelper.ModifyCompositOrder(Data);
//
//
	ModifyOrderhelper.EditProduct(Data);
//
// 	
//
	ModifyOrderhelper.DecomposeOrder(Data);
//
//
	ModifyOrderhelper.ProcessOrder(Data);
	}

}
