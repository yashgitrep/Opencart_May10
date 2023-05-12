package pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Elements
	@FindBy(name = "firstname")
	WebElement txtFirstname;

	@FindBy(name = "lastname")
	WebElement txtLasttname;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "telephone")
	WebElement txtTelephone;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;

	@FindBy(name = "agree")
	WebElement chkdPolicy;

	@FindBy(xpath ="//button[normalize-space()='Continue']") ////button[normalize-space()='Continue']
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
   
	public void setFirstname(String First)
	{
	txtFirstname.sendKeys(First);
	}
	
	public void setLastname(String Last) {
		txtLasttname.sendKeys(Last);
	}
	public void setemail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void setconfirmPassword(String Password) {
		txtConfirmPassword.sendKeys(Password);
	}
	public void clickagree() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", chkdPolicy);
		//chkdPolicy.click();
	}
	public void clickcontinue() {
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.visibilityOfElementLocated((By) btnContinue));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btnContinue);
		//btnContinue.click();
	}
	
   public String getmsgconfirmation() {
	  try { 
	  return msgConfirmation.getText();
	  }
	  catch (Exception e) {
		  return (e.getMessage());
	  }
   }
  }
