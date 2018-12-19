package Driver;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Listeners.TestListener;
import ScriptHelper.AccountNavigationHelper;
import ScriptHelper.CompositeOrderHelper;
import ScriptHelper.LoginHelper;
import ScriptHelper.NewHubOrderHelper;
import ScriptHelper.SiebelCeaseOrderHelper;
import ScriptHelper.ModifyOrderHelper;
import ScriptHelper.CeaseOrderHelper;
import ScriptHelper.CarNorOrderHelper;
import ScriptHelper.SiebelOrderHelper;
import ScriptHelper.SiebelModifyHelper;
import ScriptHelper.SiebelNcIntegrationHelper;

public class DriverTestcase {
	
	public static WebDriver dr;
	
	public static LoginHelper Login;
	public static AccountNavigationHelper NavigationHelper;
	public static CompositeOrderHelper CompositeOrderhelper;
	//public static AccountNavigationHelper SiebelNavigationHelper;
	public static SiebelOrderHelper SiebelOrderhelper;
	public static NewHubOrderHelper NewHubOrderhelper;
	public static ModifyOrderHelper ModifyOrderhelper;
	public static CeaseOrderHelper CeaseOrderhelper;
	public static CarNorOrderHelper CarNorOrderhelper;
	public static SiebelModifyHelper SiebelModifyhelper;
	public static SiebelCeaseOrderHelper SiebelCeaseOrderhelper;
	public static SiebelNcIntegrationHelper SiebelNcIntegrationHelper;
	public static TestListener Testlistener;
	public static String CircuitRefnumber;
	public static String ModifiedCircuitRefnumber;
	public static String ModifiedSiebelOrdernumber;
	
	//public static CarNorOrderHelper CarNorOrderhelper;
	public ThreadLocal<String> TestName=new ThreadLocal(); 
	public static int  itr;
	@BeforeMethod
	 public void BeforeMethod(Method method,ITestContext ctx,Object[] data) throws IOException{
		 
		 
		Object[] st = null;
		
		try 
		
		{
	 	st=(Object[]) data[0];
		}
		catch(Exception e)
		{
			st=new Object[][] {{""}};
		}
	//Log.info("Index is:"+itr+"Length od data is:"+data.length);
	      if(method.getName().equals("CreateAndProcess"))
	      {
//	   		DataReader dt=new DataReader();
//	   		Object[][] data=dt.datareader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else if(method.getName().equals("HubCreateAndProcess"))
	      {
//	    	DataReader dt=new DataReader();
//	    	Object[][] data=dt.hubreader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
	    	ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else if(method.getName().equals("ModfiyAndProcess"))
	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.modreader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
//	    else if(method.getName().equals("InflightCreateAndProcess"))
//	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.inmodreader();
//		    Object[] st= (Object[]) data[itr][0];
//		    Log.info(st[st.length-2].toString());
//		    ctx.setAttribute("testName", st[st.length-2].toString());
//	      }	
	    else if(method.getName().equals("CarNorCreateAndProcess"))
	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.carnorreader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }		      
	    else if(method.getName().equals("CeaseAndProcess"))
	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.ceasereader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
//	    else if(method.getName().equals("CreateP2POrder"))
//	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.siebelreader();
//		    Object[] st= (Object[]) data[itr][0];
//		    Log.info(st[st.length-2].toString());
//		    ctx.setAttribute("testName", st[st.length-2].toString());
//	      }
	    else if(method.getName().equals("SiebelModfiyAndProcess"))
	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.siebelmodifyreader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else if(method.getName().equals("CreateOrder"))
	      {
//		    DataReader dt=new DataReader();
//		    Object[][] data=dt.siebelceasereader();
//		    Object[] st= (Object[]) data[itr][0];
		    Log.info(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else
	    	ctx.setAttribute("testName", method.getName());
	      	Log.info(ctx.getAttribute("testName").toString());
	}

	@BeforeTest
	public void setup() throws IOException
	{
		// Open Browser
		
		PropertyReader pr=new PropertyReader();
		String targatedbrowser=pr.readproperty("browser");
		String url=pr.readproperty("URL");
		Log.info("URL");
		if(targatedbrowser.equals("chrome"))
		{ 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
			dr= new ChromeDriver(capabilities);
		}
		else if (targatedbrowser.equals("ie"))
		{
			Log.info("For IE inprogress");
		}
		
		else
		{
			Log.info("For FF inprogress");
		}
		
		dr.manage().window().maximize();
		Login=new LoginHelper(getwebdriver());
		NavigationHelper= new AccountNavigationHelper(getwebdriver());
		CompositeOrderhelper=new CompositeOrderHelper(getwebdriver());
		//SiebelNavigationHelper= new AccountNavigationHelper(getwebdriver());
		SiebelOrderhelper=new SiebelOrderHelper(getwebdriver());
		SiebelModifyhelper=new SiebelModifyHelper(getwebdriver());
		NewHubOrderhelper=new NewHubOrderHelper(getwebdriver());
		ModifyOrderhelper=new ModifyOrderHelper(getwebdriver());
		CeaseOrderhelper= new CeaseOrderHelper(getwebdriver());
		SiebelCeaseOrderhelper= new SiebelCeaseOrderHelper(getwebdriver());
		CarNorOrderhelper=new CarNorOrderHelper(getwebdriver());
		SiebelNcIntegrationHelper=new SiebelNcIntegrationHelper(getwebdriver());
		//CarNorOrderhelper=new CarNorOrderHelper(getwebdriver());
	}

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite(){
	//itr=0;
	DOMConfigurator.configure("log4j.xml");
	}
	
	@AfterTest
	public void Teardown()
	{
		
//		dr.close();
	}
	public WebDriver getwebdriver() {
		return dr;
	}
}
