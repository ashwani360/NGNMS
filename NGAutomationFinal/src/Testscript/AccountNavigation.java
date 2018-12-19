package Testscript;
import org.testng.annotations.Test;
import Driver.DriverTestcase;


public class AccountNavigation extends DriverTestcase {	
	
@Test
	public void NavigatetoDocument() throws Exception
	{
		//ExtentTestManager.getTest().setDescription("Login on FaceBook");
		NavigationHelper.GotoDocument();
		
	}
@Test
public void NavigatetoAccount() throws Exception
{
	//ExtentTestManager.getTest().setDescription("Login on FaceBook");
	NavigationHelper.GotoAccount();
	
}

@Test
public void NavigatetoSiebelAccount() throws Exception
{
	//ExtentTestManager.getTest().setDescription("Login on FaceBook");
	NavigationHelper.GotoSiebelAccount();
	
}

}
