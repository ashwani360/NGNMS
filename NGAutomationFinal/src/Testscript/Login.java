package Testscript;
import org.testng.annotations.Test;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class Login extends DriverTestcase {	
	
@Test
	public void LoginonNetCreacker() throws Exception
	{
		//ExtentTestManager.getTest().setDescription("Login on FaceBook");
		Login.Login("NC");
		Login.VerifySuccessLogin("NC");
		//Login.SkipWarning("NC");
	}
@Test
	public void LoginonSiebel() throws Exception
	{
		ExtentTestManager.getTest().setDescription("Login on FaceBook");
		Login.SiebelLogin("Siebel");
		Thread.sleep(10000);
		//SiebelLogin.SiebelVerifySuccessLogin("Siebel");
	}

}
