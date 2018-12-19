package Listeners;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverTestcase;
import Driver.Log;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Reporter.ExtentManager;
import Reporter.ExtentTestManager;
 
 
public class TestListener extends DriverTestcase implements ITestListener {
 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
    public void onStart(ITestContext iTestContext) {
        Log.info("I am on Start method " + iTestContext.getName());
        
        iTestContext.setAttribute("WebDriver", this.getwebdriver());
    }
 
    //After ending all tests, below method runs.
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am on Finish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestStart(ITestResult iTestResult) {
        Log.info("I am on TestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        //ExtentTestManager.
        //Log.info("I am in onStart method " + iTestResult.getTestContext().getAttribute("testname"));
        ExtentTestManager.startTest(iTestResult.getTestContext().getSuite().getXmlSuite().getName().toString()+"-"+iTestResult.getTestContext().getAttribute("testName").toString(),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        	ExtentTestManager.getTest().log(LogStatus.PASS, getTestMethodName(iTestResult)+" : Test Method has been passed");
    }
 
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("I am on TestFailure method " +  getTestMethodName(iTestResult) + " failed");
        //iTestResult.setStatus();
        //Get driver from BaseTest and assign to local webdriver variable.
    //	ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult)+" : Test Method has been Failed");
        Object testClass = iTestResult.getInstance();
        //iTestResult.setStatus(arg0);
        WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
                getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
       
    }
 
    public void onTestError(ITestResult iTestResult) {
        Log.info("I am on TestSuccess method " +  getTestMethodName(iTestResult) + " errored");
        //Extentreports log operation for passed tests.
        	ExtentTestManager.getTest().log(LogStatus.ERROR, getTestMethodName(iTestResult)+" : Test Method has been errored");
            Object testClass = iTestResult.getInstance();
            //iTestResult.setStatus(arg0);
            WebDriver webDriver = ((DriverTestcase) testClass).getwebdriver();
     
            //Take base64Screenshot screenshot.
            String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getwebdriver()).
                    getScreenshotAs(OutputType.BASE64);
     
            //Extentreports log and screenshot operations for failed tests.
            ExtentTestManager.getTest().log(LogStatus.ERROR,"Test Errored",
                    ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
 
}