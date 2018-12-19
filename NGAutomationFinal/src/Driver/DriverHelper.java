package Driver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class DriverHelper {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	WebElement el;
	List<WebElement> ellist;
	public static String Ordernumber;
	public static String OrderscreenURL;
	public static String SchedulerURL;
	public static int workitemcounter=1;
	public static String NCServiceId;
	public static String HubNCServiceId;
	public static String ProductId;
	public static String SpokeOrdernumber;
	public static String SpokeOrderscreenURL;
	public static String SpokeNCServiceId;
	public static String SpokeProductId;
	public static String ProductInstancenumber;
	public static String ModifiedOrdernumber;
	public static String ModifyOrderscreenURL;
	public static String EndCheck;
	public static String CeaseOrderscreenURL;
	public static String CeaseOrdernumber;
	public static String CompOrdernumber;
	public static String EthernetProductOrdernumber;
	public static String ANTCheck;
	public static String Errors;
	public static String SiebelOrdernumber;
	public static String ServiceOrder;
	public static String CircuitReference;
	
	public static String CircuitRefnumber;
	public static String NetworkReference;
	public static String TechnicalOrderStatus;
	public static String ModifiedCircuitRefnumber;
	public static String HubCircuitRefNumber;
	public static String SpokeCircuitRefnumber;
	public static String ModifiedSiebelOrdernumber;
	public static String SiebelCeaseOrdernumber;
	public static String AendBuildingId;
	public DriverHelper(WebDriver dr)
	{
		driver=dr;
		wait = new FluentWait<WebDriver>(dr)       
				.withTimeout(600, TimeUnit.SECONDS)    
				.pollingEvery(15, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class); 
	}
	 
	public WebElement getwebelement(final String locator) throws InterruptedException
	{   //Log.info("Indriverhelper"+driver);
	 //WebElement el;
	final String[] finalval;
		if(locator.startsWith("name"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			//wait.until();  
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.name(finalval[1]));
					return driver.findElement(By.name(finalval[1]));     
				 }  
				});  
		}
		else if(locator.startsWith("id"))
		{
			finalval=locator.split("=");
			//Log.info(finalval[1]);
			//Log.info("Indriverhelper"+driver);
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.id(finalval[1]));
					return driver.findElement(By.id(finalval[1]));     
				 }  
				});
			 //el= driver.findElement(By.id(finalval[1]));
		}
		else if (locator.startsWith("//")|| locator.startsWith("(//"))
		{
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.xpath(locator)); 
					return driver.findElement(By.xpath(locator));     
				 }  
				});
			
		}
		Thread.sleep(1000);
		return el;
	}
	public WebElement getwebelement2(final String locator) throws InterruptedException
	{   
		if (locator.startsWith("//")|| locator.startsWith("(//"))
		{	
					el=driver.findElement(By.xpath(locator)); 
					return driver.findElement(By.xpath(locator));     	
		}
		Thread.sleep(1000);
		return el;
	}
	public void openurl(String environment) throws Exception {
		String URL=null;
		PropertyReader pr=new PropertyReader();
		Log.info(environment+"_URL");
		URL=pr.readproperty(environment+"_URL");
		
		driver.get(URL);
		
	}
	public void Geturl(String URL) throws Exception {
	
		driver.get(URL);
		
	}
	public void Clickon(WebElement el) {
		
		el.click();
	}
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	public void switchtofram(WebElement el){
		driver.switchTo().frame(0);
		
	}
	public void switchtodefault(){
		driver.switchTo().defaultContent();
		
	}
public String Getattribute(WebElement el,String attributename) {
		Log.info(el.getAttribute(attributename));
		return el.getAttribute(attributename);
	}
public void Moveon(WebElement el) {
		
	Actions action = new Actions(driver);
	 
    action.moveToElement(el).build().perform();
	}
public boolean isElementPresent(String locator) {
    try {
        driver.findElement(By.xpath(locator));
        Log.info("Element Found: True");
        return true;
    } catch (NoSuchElementException e) {
    	 Log.info("Element Found: False");
        return false;
    }
}

public void waitandclickForworkitemsPresent(String locator, int timeout) throws InterruptedException
{
		for(int i=0;i<=timeout*60/20;i++){
			try {
	            if (isElementPresent(locator)){
	                break;
	            }
	            else{
	            	//Goto Error Tab
	            	// Clickon(getwebelement(xml.getlocator("//locators/Tasks/Errors")));
	            	//if any Error displayed
	            	//if(isElementPresent("Locator for first error"))
	            	//{
	            	//Assert.fail("An Error Occuured on Error Tab");
	            	//break;
	            	//}
	            	//else
	            	//{
	            	//Clickon(getwebelement(xml.getlocator("//locators/Tasks/Workitems")));
	            	//Log.info("Refreshing the Pages");
		        	//driver.navigate().refresh();
		        	//Log.info("Waiting For 20 Sec");
		        	//Thread.sleep(20000);
	            	//}
	            	//Assert False and Break
	            	//else navigate to WorkItems and do the page refresh and weight
	            	Log.info("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	Log.info("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	Log.info(e.getMessage());
	        }
		}
}

public void waitandclickForOrderCompleted(String locator, int timeout) throws InterruptedException
{
		for(int i=0;i<=timeout*60/20;i++){
			try {
	            if (isElementPresent(locator)){
	                break;
	            }
	            else{
	            	Log.info("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	Log.info("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	Log.info(e.getMessage());
	        }
		}
}

public void waitandclickForOrderStarted(String locator, int timeout) throws InterruptedException
{
		for(int i=0;i<=timeout*60/20;i++){
			try {
	            if (isElementPresent(locator)){
	                break;
	            }
	            else{
	            	Log.info("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	Log.info("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	Log.info(e.getMessage());
	        }
		}
}

public void waitandForElementDisplay(String locator, int timeout) throws InterruptedException
{
		for(int i=0;i<=timeout*60/20;i++){
			try {
	            if (isElementPresent(locator)){
	                break;
	            }
	            else{
	            	Log.info("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	Log.info("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	Log.info(e.getMessage());
	        }
		}
}

public int getwebelementscount(final String locator) throws InterruptedException
{ 
	ellist=driver.findElements(By.xpath(locator));
	return ellist.size();
}

	public void SendKeys(WebElement el,String value) {
		el.sendKeys(value);
	}
	public void SendkeaboardKeys(WebElement el,Keys k) {
		el.sendKeys(k);
	}
	
	
	public String GetText(WebElement el) {
		String actual=el.getText().toLowerCase().toString();
		return actual;
	}
	
	public String GetInputValue(WebElement el) {
		String actual=el.getAttribute("value");
		return actual;
		}
	
	public String Getkeyvalue(String Key) throws IOException
			{ PropertyReader pr=new PropertyReader();
		      String Keyvalue;
			 Keyvalue=pr.readproperty(Key);
		
			return Keyvalue;
			}
	public void VerifyTextpresent(String text) throws IOException
	{ 
		Log.info(text);
		Assert.assertFalse(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}
	public void VerifyText(String text) throws IOException
	{ 
		Log.info(text);
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}
	public String Gettext(WebElement el) throws IOException
	{ 
		String text=el.getText().toString();
		return text;
	}
	public String[] GetText2(WebElement el) throws IOException
	{ 
		String text=el.getText().toString();
		String[] text2=text.split(" \\[");
		Log.info("New Task Name is:"+text2);
		return text2;
	}
	public void Select(WebElement el, String value) throws IOException
	{ 
		Select s1=new Select(el);
		s1.selectByVisibleText(value);
		
	}
	public void Clear(WebElement el) throws IOException
	{ 
		el.clear();
		
	}
	public void AcceptJavaScriptMethod(){
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
	}
	
	public void savePage(){
		Actions keyAction = new Actions(driver);     
		keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
	}
	
}
