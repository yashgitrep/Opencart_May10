package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement Myaccount;
	@FindBy (xpath="//a[normalize-space()='Register']")  
	WebElement Register;
	@FindBy (linkText="Login")
	WebElement Login;
	
	//Action Methods
	public void clickonMyaccount() {
		Myaccount.click();
	}
    public void clickonRegister() {
    	Register.click();
    }
    public void clickonLogin() {
    	Login.click();
    }
}
