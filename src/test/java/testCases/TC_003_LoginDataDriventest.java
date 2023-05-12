package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccoutPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDriventest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void test_logintest(String email, String password, String exp) {
		logger.info("TC_003_LoginDataDriventest_started");
		try {
		HomePage HP=new HomePage(driver);
		HP.clickonMyaccount();
		HP.clickonLogin();
	
		LoginPage LP = new LoginPage(driver);
		LP.setemail(email);
		LP.setpassword(password);
		LP.clickonLogin();
		
		MyAccoutPage myacc=new MyAccoutPage(driver);
		boolean Act=myacc.ismsgheadingdisaplayed();
		
		if(exp.equals("valid")) 
		{
			if(Act==true) {
				myacc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid")) 
		{
			if(Act==true) {
				myacc.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("TC_003_finished_LoginDataDrivenTest");
	}

}
