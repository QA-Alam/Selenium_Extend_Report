package com.hashmap;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HashmapTest {
	

	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // up casting
		driver.get("https://www.ups.com/us/en/Home.page?");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("(//a[text()='Log In'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		String adminCredentials = HashmapBaseClass.getUserLoginInfo().get("admin");
		String adminInfo[] = adminCredentials.split("_");

		driver.findElement(By.id("email")).sendKeys(adminInfo[0]);
		driver.findElement(By.id("pwd")).sendKeys(adminInfo[1]);

		WebElement element1 = driver.findElement(By.id("submitBtn"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);

		if (driver.getPageSource()
				.contains("The information that you have entered does not match any ups.com profile.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			String title = driver.getTitle();
			Assert.assertEquals(title, driver.getTitle());
			System.out.println("Page Title ::" + title);
		}

		String Status = driver.findElement(By.xpath("//*[contains(@class,'ups-headerTools_msg')]/h3")).getText();
		String successfullmsg = "Hello, MOHAMMED ALAM. Welcome back to My Choice!";
		if (Status.equalsIgnoreCase(successfullmsg)) {
			System.out.println("Login Test successfull ::" + Status);
		} else {
			System.out.println("<<<<< Test Failed>>>>>>");
		}
	}
}