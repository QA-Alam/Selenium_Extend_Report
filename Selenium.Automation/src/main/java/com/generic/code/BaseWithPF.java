package com.generic.code;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amazon.extend.report.WebEventListener;

public class BaseWithPF {
	
	public static Logger logger;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	protected static WebDriver driver;
	String workingDir;
	protected MasterPageFactory pf;
	protected ObjectMap objmap;


	    public void login() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();// up casting
		driver.manage().window().maximize(); //

		workingDir = System.getProperty("user.dir");
		try {
			objmap = new ObjectMap(workingDir + "./config");
		} catch (Throwable e) {

		}
	/*	e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver; */
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(BaseWithPF.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BaseWithPF.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(objmap.getConfig("URL"));

		pf = PageFactory.initElements(driver, MasterPageFactory.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pf.getSigninbtn()));
		
		getExplicitWait(pf.getSigninbtn(),driver);
		pf.getSigninbtn().click();
		
		wait.until(ExpectedConditions.visibilityOf(pf.getEmail()));
		WebElement email = pf.getEmail();
		email.sendKeys(objmap.getConfig("email"));
		
		getExplicitWait(pf.getPass(),driver);
		WebElement pass = pf.getPass();
		pass.sendKeys(objmap.getConfig("pass"));
		pass.submit();


	
	    }

	    public static WebElement getExplicitWait(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		return element1;
	    }

	    public boolean isElementPresent(WebElement element, WebDriver driver, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return driver;
		}
	}

