package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccoutPage;
import testBase.BaseClass;

public class TC_002_Logintest extends BaseClass{
	
	@Test
	void test_logintest() {
		try {
		logger.info("TC_002_Logintest_started");
		HomePage HP=new HomePage(driver);
		HP.clickonMyaccount();
		logger.info("clickedonMyaccount");
		HP.clickonLogin();
		logger.info("clickedonLogin");
		LoginPage LP = new LoginPage(driver);
		LP.setemail(rb.getString("email"));
		logger.info("entered email");
		LP.setpassword(rb.getString("password"));
		logger.info("entered password");
		LP.clickonLogin();
		logger.info("clickedonLoginonLoginpage");
		MyAccoutPage myacc=new MyAccoutPage(driver);
		myacc.ismsgheadingdisaplayed();
		Assert.assertEquals(myacc.ismsgheadingdisaplayed(), true);
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_002_finished");
	}
}
