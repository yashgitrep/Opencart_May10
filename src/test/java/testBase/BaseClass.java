package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

 	public static WebDriver driver;
 	public Logger logger;
 	public ResourceBundle rb;
 	
 @BeforeClass
 @Parameters ({"browser"})
  public void setup(String br) {
	 
	 logger=LogManager.getLogger(this.getClass());
	 rb=ResourceBundle.getBundle("config");
	 if(br.equals("chrome")) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
	 }
	 else if(br.equals("edge")) {
		 driver=new EdgeDriver();
	 }
	 else {
		 driver=new FirefoxDriver();
	 }
		
		driver.get(rb.getString("appURL3"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

@AfterClass
public void tearDown() {
	driver.quit();
}

 public String randomstring() {
	 String generatedstring=RandomStringUtils.randomAlphabetic(5);
	 return generatedstring;
 }
 public String randomNumber() {
	 String generatedstring2=RandomStringUtils.randomNumeric(10);
	 return generatedstring2;
	 }
 public String alpanumeric() {
	 String generatedstring3=RandomStringUtils.randomNumeric(4);
	 String generatedstring4=RandomStringUtils.randomNumeric(3);
	 return (generatedstring3+"@"+generatedstring4);
	  
 }
 public String caputurescreen(String tname) throws IOException {
	 String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	 File Source=takesScreenshot.getScreenshotAs(OutputType.FILE);
	 String destination=System.getenv("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
	 try {
	 FileUtils.copyFile(Source, new File(destination));
	 }
	 catch (Exception e) {
		 e.getMessage();
	 }
	 return destination;
	 
 }

	/*public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;*/

	}
