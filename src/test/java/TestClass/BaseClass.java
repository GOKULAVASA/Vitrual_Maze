package TestClass;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import TestUtils.ReadConfig;



public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getWebApplicationUrl();
	public static WebDriver driver;
	public static   Logger logger;
	WebDriverWait wait;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String bwrs) {

		logger=LogManager.getLogger(BaseClass.class);
		
		if(bwrs.equals("chrome")) {
			driver=new ChromeDriver();
			
			
			logInfo("Chrome get launched ");
		}else if (bwrs.equals("firefox")) {
			driver=new FirefoxDriver();
			logInfo("firfox get launched ");
		} else if(bwrs.equals("msedge")) {
			driver=new EdgeDriver();
			logInfo("MsEdge get launched ");
		}
		// Set implicit wait after initializing the driver
	    if (driver != null) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(readconfig.implicitDurationcount()));
	        driver.get(baseUrl);
	    } else {
	    	logError("WebDriver initialization failed. Check the browser parameter.");
	    }
	}


/*

	@AfterClass
	public void teardown() {
		driver.quit();
		logInfo("quitting browser");
	}

	     public static void CaptureScreenShot(WebDriver driver,String tname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File SOURCE=ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+tname+".png");
			FileUtils.copyFile(SOURCE, target);
			System.out.println("Screenshot taken");
				
		}

*/

	     protected void logInfo(String message) {
	         logger.info(message);
	     }

	    
	     protected void logWarning(String message) {
	         logger.warn(message);
	     }

	     
	     protected void logError(String message) {
	         logger.error(message);
	     }

	
	     protected void logDebug(String message) {
	         logger.debug(message);
	     }    
	
	     public    WebDriverWait waitForElement(WebElement locator) {
		        
			  wait = new WebDriverWait(driver,Duration.ofSeconds(readconfig.implicitDurationcount())); 
			  wait.until(ExpectedConditions.visibilityOf(locator));
			  return wait;
	     }
	
}
