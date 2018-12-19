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


public class SiebelNcIntegModOrder extends DriverTestcase  {	
 
@AfterMethod
public void returntoAccountPages(Method method) throws Exception
{
	if(method.getName().equals("NcIntegrationModProcess")){
// Code to navigate to the Error page and take the screenshot
//	CompositeOrderhelper.GotoErrors();
	NavigationHelper.GotoDocument();
	NavigationHelper.GotoAccount();
	itr=itr+1;
	}
}
	
@Test(dataProviderClass=DataReader.class,dataProvider="ModifyOrder")
	public void NcIntegrationModProcess(Object[] Data) throws Exception
	{
		SiebelNcIntegrationHelper.NcIntegrationModOrder(Data);
		ModifyOrderhelper.CompleteOrder(Data);
	}
}
