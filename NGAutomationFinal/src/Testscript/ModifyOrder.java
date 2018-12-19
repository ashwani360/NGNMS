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
import Driver.Log;
import Reporter.ExtentTestManager;


public class ModifyOrder extends DriverTestcase {	

@AfterMethod
public void returntoAccountPages(Method method,ITestResult result) throws Exception
{
	if(method.getName().equals("ModfiyAndProcess")){
	ModifyOrderhelper.GotoErrors();
	String base64Screenshot="data:image/png;base64,"+((TakesScreenshot)dr).getScreenshotAs(OutputType.BASE64);
	ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)); 
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	//itr=itr+1;
	}
}

@Test(dataProviderClass=DataReader.class,dataProvider="ModifyOrder")
	public void ModfiyAndProcess(Object[] Data) throws Exception 
	{
	if (Data[1].toString().equalsIgnoreCase("Soft-Mod")) 
	 	{
		if (Data[0].toString().equalsIgnoreCase("BW Upgrade"))
			{		
			ModifyOrderhelper.SoftModCompositOrder(Data);
			ModifyOrderhelper.EditProduct(Data);
			ModifyOrderhelper.DecomposeOrder(Data);
			ModifyOrderhelper.ProcessOrder(Data);
			ModifyOrderhelper.CompleteOrder(Data);
			}
		else if(Data[0].toString().equalsIgnoreCase("VLAN Tagging Mode"))
			{
			ModifyOrderhelper.SoftModCompositOrder(Data);
			ModifyOrderhelper.DecomposeOrder(Data);
			ModifyOrderhelper.EditProductDeviceDetails(Data);
			ModifyOrderhelper.ProcessOrder(Data);
			ModifyOrderhelper.CompleteOrder(Data);
			}
		else
			{
 			Log.info("To include code for Vlan ID changes");
			}
	 	}
	}

@Test(dataProviderClass=DataReader.class,dataProvider="EtherNetP2PNewOrder")
	public void InflightCreateAndProcess(Object[] Data) throws Exception 
	{
		CompositeOrderhelper.CreatCompositOrder(Data);
		CompositeOrderhelper.AddProduct(Data);
		CompositeOrderhelper.AddProductdetails(Data);
		CompositeOrderhelper.AddFeatureDetails(Data);
		CompositeOrderhelper.DecomposeOrder(Data);
		CompositeOrderhelper.ProductDeviceDetails(Data);
		CompositeOrderhelper.ProcessInflightOrder(Data);
		CompositeOrderhelper.CompleteInflightOrder(Data);
	}	

@Test(dataProviderClass=DataReader.class,dataProvider="ModifyOrder")
	public void InflightModifyAndProcess(Object[] Data) throws Exception
	{
		ModifyOrderhelper.InflightSoftModCompositOrder(Data);
		ModifyOrderhelper.EditInflightProduct(Data);
		ModifyOrderhelper.DecomposeInflightOrder(Data);
		ModifyOrderhelper.ProcessInflightOrder(Data);
		ModifyOrderhelper.CompleteInflightOrder(Data);
	}
}