package Driver;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import ScriptHelper.AccountNavigationHelper;
import ScriptHelper.CeaseOrderHelper;
import ScriptHelper.CompositeOrderHelper;
import ScriptHelper.LoginHelper;
import ScriptHelper.ModifyOrderHelper;
import ScriptHelper.NewHubOrderHelper;
import ScriptHelper.SiebelOrderHelper;

public class DriverTestcase {
	
	public static WebDriver dr;
	
	public static LoginHelper Login;
	public static AccountNavigationHelper NavigationHelper;
	public static CompositeOrderHelper CompositeOrderhelper;
	public static AccountNavigationHelper SiebelNavigationHelper;
	public static SiebelOrderHelper SiebelOrderhelper;
	public static NewHubOrderHelper NewHubOrderhelper;
	public static ModifyOrderHelper ModifyOrderhelper;
	public static CeaseOrderHelper CeaseOrderhelper;
	public ThreadLocal<String> TestName=new ThreadLocal(); 
	public static int  itr;
	@BeforeMethod
	   public void BeforeMethod(Method method,ITestContext ctx) throws IOException{
	 
	 
	 
	//System.out.println("Index is:"+itr+"Length od data is:"+data.length);
	      if(method.getName().equals("CreateAndProcess"))
	      {
   		DataReader dt=new DataReader();
   		Object[][] data=dt.datareader();
	     Object[] st= (Object[]) data[itr][0];
	     System.out.println(st[st.length-2].toString());
	      ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else if(method.getName().equals("HubCreateAndProcess"))
	      {
    	DataReader dt=new DataReader();
    	Object[][] data=dt.hubreader();
	     Object[] st= (Object[]) data[itr][0];
	     System.out.println(st[st.length-2].toString());
	      ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	    else
	      ctx.setAttribute("testName", method.getName());
	      System.out.println(ctx.getAttribute("testName"));
	}


	@BeforeTest
	public void setup() throws IOException
	{
		// Open Browser
		
		PropertyReader pr=new PropertyReader();
		String targatedbrowser=pr.readproperty("browser");
		String url=pr.readproperty("URL");
		System.out.println("URL");
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
			System.out.println("For IE inprogress");
		}
		
		else
		{
			System.out.println("For FF inprogress");
		}
		
		dr.manage().window().maximize();
		Login=new LoginHelper(getwebdriver());
		NavigationHelper= new AccountNavigationHelper(getwebdriver());
		CompositeOrderhelper=new CompositeOrderHelper(getwebdriver());
		SiebelNavigationHelper= new AccountNavigationHelper(getwebdriver());
		SiebelOrderhelper=new SiebelOrderHelper(getwebdriver());
		NewHubOrderhelper=new NewHubOrderHelper(getwebdriver());
		ModifyOrderhelper=new ModifyOrderHelper(getwebdriver());
		CeaseOrderhelper= new CeaseOrderHelper(getwebdriver());
	}

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite(){
	itr=0;
	}
	
	@AfterTest
	public void Teardown()
	{
		//dr.close();
	}
	public WebDriver getwebdriver() {
		return dr;
	}
}
