package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccoutPage extends BasePage{

	public MyAccoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
  @FindBy(xpath ="//h2[normalize-space()='My Account']")
  WebElement msgheading;
  @FindBy (linkText="Logout")
  WebElement Logoutbtn;
  
  public boolean ismsgheadingdisaplayed() {
	  try{
		  return msgheading.isDisplayed();
	  }
	  catch (Exception e) {
		  return false;
	  }
  }
  public void clicklogout() {
	  Logoutbtn.click();
  }
}
