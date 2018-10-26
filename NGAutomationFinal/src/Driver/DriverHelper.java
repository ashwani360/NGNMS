package Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
	public static String SpokeOrdernumber;
	public static String SpokeOrderscreenURL;
	public static String ProductInstancenumber;
	public static String ModifiedOrdernumber;
	public static String ModifyOrderscreenURL;
	public static String CompOrdernumber;
	public DriverHelper(WebDriver dr)
	{
		driver=dr;
		wait = new FluentWait<WebDriver>(dr)       
				.withTimeout(120, TimeUnit.SECONDS)    
				.pollingEvery(5, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class); 
	}
	 
	public WebElement getwebelement(final String locator) throws InterruptedException
	{   //System.out.println("Indriverhelper"+driver);
	 //WebElement el;
	final String[] finalval;
		if(locator.startsWith("name"))
		{
			finalval=locator.split("=");
			//System.out.println(finalval[1]);
			//System.out.println("Indriverhelper"+driver);
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
			//System.out.println(finalval[1]);
			//System.out.println("Indriverhelper"+driver);
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
		System.out.println(environment+"_URL");
		URL=pr.readproperty(environment+"_URL");
		
		driver.get(URL);
		
	}
	public void Geturl(String URL) throws Exception {
	
		driver.get(URL);
		
	}
	public void Clickon(WebElement el) {
		
		el.click();
	}
	public void switchtofram(WebElement el){
		driver.switchTo().frame(0);
		
	}
	public void switchtodefault(){
		driver.switchTo().defaultContent();
		
	}
public String Getattribute(WebElement el,String attributename) {
		System.out.println(el.getAttribute(attributename));
		return el.getAttribute(attributename);
	}
public void Moveon(WebElement el) {
		
	Actions action = new Actions(driver);
	 
    action.moveToElement(el).build().perform();
	}
public boolean isElementPresent(String locator) {
    try {
        driver.findElement(By.xpath(locator));
        System.out.println("Element Found: True");
        return true;
    } catch (NoSuchElementException e) {
    	 System.out.println("Element Found: False");
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
	            	//System.out.println("Refreshing the Pages");
		        	//driver.navigate().refresh();
		        	//System.out.println("Waiting For 20 Sec");
		        	//Thread.sleep(20000);
	            	//}
	            	//Assert False and Break
	            	//else navigate to WorkItems and do the page refresh and weight
	            	System.out.println("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	System.out.println("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	System.out.println(e.getMessage());
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
	            	System.out.println("Refreshing the Pages");
		        	driver.navigate().refresh();
		        	System.out.println("Waiting For 20 Sec");
		        	Thread.sleep(20000);
	            }
	            }
	        catch (Exception e) {
	        	System.out.println(e.getMessage());
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
	public String Getkeyvalue(String Key) throws IOException
			{ PropertyReader pr=new PropertyReader();
		      String Keyvalue;
			 Keyvalue=pr.readproperty(Key);
		
			return Keyvalue;
			}
	public void VerifyTextpresent(String text) throws IOException
	{ 
		System.out.println(text);
		Assert.assertFalse(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
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
		System.out.println("New Task Name is:"+text2);
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
}
