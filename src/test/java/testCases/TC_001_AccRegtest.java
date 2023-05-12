package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccRegtest extends BaseClass{
	
	@Test
	void test_acc_reg() {
		logger.info("TC_001_AccRegtest started");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickonMyaccount();
		logger.info("cliked on My account");
		hp.clickonRegister();
		logger.info("clicked on Register");
		AccountRegistrationPage ARP =new AccountRegistrationPage(driver);
		ARP.setFirstname(randomstring());
		ARP.setLastname(randomstring());
		ARP.setemail(randomstring()+"@gmail.com");
		String Password1=alpanumeric();
		ARP.setPassword(Password1);
		ARP.setconfirmPassword(Password1);
		ARP.clickagree();
		ARP.clickcontinue();
		logger.info("clicked on continue");
		String confmsg=ARP.getmsgconfirmation();
		Assert.assertEquals(confmsg, "Your Account has been created!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
