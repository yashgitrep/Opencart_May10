package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   @FindBy (name="email")
   WebElement email;
   @FindBy (name="password")
   WebElement password;
   @FindBy (xpath="//input[@value='Login']")
   WebElement loginbtn;
   public void setemail(String myemail) {
	   email.sendKeys(myemail);
   }
   public void setpassword(String mypassword) {
	   password.sendKeys(mypassword);
   }
   public void clickonLogin() {
	   loginbtn.click();
   }
}
