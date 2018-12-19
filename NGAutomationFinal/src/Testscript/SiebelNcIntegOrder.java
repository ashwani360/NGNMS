package Testscript;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import Driver.DataReader;
import Driver.DriverTestcase;
import Listeners.TestListener;
import org.testng.ITestResult;

import Reporter.ExtentManager;
import Reporter.ExtentTestManager;


public class SiebelNcIntegOrder extends DriverTestcase  {	
 
@AfterMethod
public void returntoAccountPages(Method method) throws Exception
{
	if(method.getName().equals("NcIntegrationProcess")){
// Code to navigate to the Error page and take the screenshot
//	CompositeOrderhelper.GotoErrors();
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	itr=itr+1;
	}
}
	
@Test(dataProviderClass=DataReader.class,dataProvider="EtherNetP2PNewOrder")
	public void NcIntegrationProcess(Object[] Data) throws Exception
	{
		SiebelNcIntegrationHelper.NcIntegrationCompositeOrder(Data);
		CompositeOrderhelper.CompleteOrder(Data);
	}
}
