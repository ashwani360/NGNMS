package Testscript;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DataReader;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class CeaseOrder extends DriverTestcase {	

@AfterMethod
public void returntoAccountPages(Method method,ITestResult result) throws Exception
{
	if(method.getName().equals("CeaseAndProcess")){
	CeaseOrderhelper.GotoErrors();
	String base64Screenshot="data:image/png;base64,"+((TakesScreenshot)dr).getScreenshotAs(OutputType.BASE64);
	ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)); 
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	//itr=itr+1;
	}
}
	
@Test(dataProviderClass=DataReader.class,dataProvider="CeaseOrder")
	public void CeaseAndProcess(Object[] Data) throws Exception
	{
	if(Data[0].toString().equalsIgnoreCase("Cease")){		

		CeaseOrderhelper.CreatCeaseOrder(Data);
		CeaseOrderhelper.EditProduct(Data);
		CeaseOrderhelper.DecomposeOrder(Data);
		CeaseOrderhelper.ProcessOrder(Data);
		CeaseOrderhelper.CompleteOrder(Data);
		}
		else
		{
			CeaseOrderhelper.CreatSpokeCeaseOrder(Data);
			CeaseOrderhelper.EditProduct(Data);
			CeaseOrderhelper.DecomposeSpokeOrder(Data);
			CeaseOrderhelper.ProcessSpokeOrder(Data);
			CeaseOrderhelper.CompleteSpokeOrder(Data);
			CeaseOrderhelper.CreatHubCeaseOrder(Data);
			CeaseOrderhelper.EditHubProduct(Data);
			CeaseOrderhelper.DecomposeHubOrder(Data);
			CeaseOrderhelper.ProcessHubOrder(Data);
			CeaseOrderhelper.CompleteHubOrder(Data);
		}
	}

}



