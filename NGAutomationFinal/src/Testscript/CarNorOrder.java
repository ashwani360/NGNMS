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


public class CarNorOrder extends DriverTestcase  {	
 
@AfterMethod
public void returntoAccountPages(Method method,ITestResult result) throws Exception
{
	if(method.getName().equals("CarNorCreateAndProcess")){
	CarNorOrderhelper.GotoErrors();
	String base64Screenshot="data:image/png;base64,"+((TakesScreenshot)dr).getScreenshotAs(OutputType.BASE64);
	ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)); 
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	//itr=itr+1;
	}
}
	
@Test(dataProviderClass=DataReader.class,dataProvider="CarNor")
	public void CarNorCreateAndProcess(Object[] Data) throws Exception
	{
	if (Data[0].toString().equalsIgnoreCase("P2P"))
	{
	CarNorOrderhelper.GetOrderDetails(Data);
	CarNorOrderhelper.CreatCarNorOrder(Data);
	CarNorOrderhelper.AddProduct(Data);
	CarNorOrderhelper.AddProductdetails(Data);
	CarNorOrderhelper.AddFeatureDetails(Data);
	CarNorOrderhelper.DecomposeOrder(Data);
	CarNorOrderhelper.ProductDeviceDetails(Data);
	CarNorOrderhelper.ProcessCarNorOrder(Data);
	CarNorOrderhelper.CreatCeaseOrder(Data);
	CarNorOrderhelper.EditCeaseProduct(Data);
	CarNorOrderhelper.DecomposeCeaseOrder(Data);
	CarNorOrderhelper.ProcessCeaseOrder(Data);
	CarNorOrderhelper.CompleteCarNorOrder(Data);
	CompositeOrderhelper.NavigatebacktoAccountScreen();
	}
	else if (Data[0].toString().equalsIgnoreCase("HS"))
		{
//			CarNorOrderhelper.GetHubOrderDetails(Data);
			CarNorOrderhelper.GetSpokeOrderDetails(Data);
			CarNorOrderhelper.CreatCarNorSpokeOrder(Data);
			CarNorOrderhelper.AddSpokeProduct(Data);
			CarNorOrderhelper.AddSpokeProductdetails(Data);
			CarNorOrderhelper.AddSpokeFeatureDetails(Data);
			CarNorOrderhelper.DecomposeSpokeOrder(Data);
			CarNorOrderhelper.AddHub(Data);
			CarNorOrderhelper.SpokeProductDeviceDetails(Data);
			CarNorOrderhelper.CreatSpokeCeaseOrder(Data);
			CarNorOrderhelper.EditCeaseProduct(Data);
			CarNorOrderhelper.DecomposeSpokeCeaseOrder(Data);
			CarNorOrderhelper.ProcessSpokeCeaseOrder(Data);
			CarNorOrderhelper.ProcessSpokeCarNorOrder(Data);
			CarNorOrderhelper.CompleteSpokeCarNorOrder(Data);
			CompositeOrderhelper.NavigatebacktoAccountScreen();
		}
}
}
