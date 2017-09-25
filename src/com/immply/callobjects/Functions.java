package com.immply.callobjects;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.immply.pageobjects.Objects;
import com.immply.readproperties.ReadProperties;

public class Functions {
	private static final FirefoxProfile firefoxProfile = null;
	public static WebDriver driver;
	Objects obj1;

	// constructor initialization
	public Functions(WebDriver driver) {
		this.driver = driver;
		obj1 = new Objects(driver);
	}

	// Enter details in form
	public void enterDetails(String name, String Email) throws InterruptedException {
		Thread.sleep(5000);
		obj1.findElement1("fname").sendKeys(name);
		obj1.findElement1("emaild").sendKeys(Email);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.id("button")));
		Thread.sleep(10000);
	}
	// .......................................................................................................................................

	// Click on FShare button
	public void shareByFacebook(String id, String pwd) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("sa_v2_ifame")));
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//div[@class='fb_share']")));
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Switch to new window opened & Login to Facebook
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			Thread.sleep(5000);
			obj1.findElement1("email").clear();
			obj1.findElement1("email").sendKeys(id);

			obj1.findElement1("pass").clear();
			obj1.findElement1("pass").sendKeys(pwd);

			obj1.findElement1("u_0_2").click();
			Thread.sleep(5000);
		}   catch (WebDriverException e) {
			e.printStackTrace();

		}
	}
  
	// Enter and Share post by Facebook
	public void FBShareWindow() throws InterruptedException, IOException {
		    Thread.sleep(30000);
//			WebDriverWait wait = new WebDriverWait(driver, 40);
			Set<String> winHandles = driver.getWindowHandles();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				Thread.sleep(10000);
			}
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("socialannex-frame"));
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.id("socialannex-frame")));
			Thread.sleep(5000);
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".FB_UI_Dialog")));
			driver.switchTo().frame(driver.findElement(By.cssSelector(".FB_UI_Dialog")));

			Thread.sleep(10000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.name("__CONFIRM__")));
			Thread.sleep(10000);
			driver.navigate().refresh();
			Thread.sleep(8000);
			driver.switchTo().defaultContent();
		}

	// ..........................................................................................................................
	// Click on Twitter Share button
	public void ClickOnTwitterShare() throws InterruptedException {
		Set<String> winHandles = driver.getWindowHandles();
		for (String handle : winHandles) {
			driver.switchTo().window(handle);
		}
		driver.switchTo().frame(driver.findElement(By.id("sa_v2_ifame")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//div[@class='tw_share']")));
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	// Enter Details in Twitter Login Page and share
	public void TwittLoginPage(String id, String pwd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("bd")).click();
		Thread.sleep(10000);
		if (driver.getClass() == ChromeDriver.class) {
			driver.findElement(By.id("status")).sendKeys("T");
		}

		if (driver.getClass() == FirefoxDriver.class) {
			driver.findElement(By.id("status")).sendKeys("U");
			System.out.println("Clicked Twitter button");
		}
		
		  if(driver.getClass() == InternetExplorerDriver.class) {
		  driver.findElement(By.id("status")).sendKeys("V"); }
		 
		obj1.findElement1("username_or_email").clear();
		obj1.findElement1("username_or_email").sendKeys(id);
		obj1.findElement1("password").clear();
		obj1.findElement1("password").sendKeys(pwd);
		obj1.findElement2("//input[@class='button selected submit']").click();
		Thread.sleep(30000);
		if (driver.getClass() == FirefoxDriver.class) {
			obj1.findElement2("//input[@class='button selected submit']").click();
			System.out.println("Clicked Twitter button");
		}
	}

	// ......................................................................................................................................................................................................

	// Click on Email Share
	public void ClickOnEmailShare() throws InterruptedException {
		Thread.sleep(5000);
		Set<String> winHandles = driver.getWindowHandles();
		for (String handle : winHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.id("sa_v2_ifame")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//div[@class='sa_email_share']")));
		Thread.sleep(10000);
	}

	public void ClickOnEmailShareNothing(String shareEmail) throws InterruptedException {
		Thread.sleep(6000);
		obj1.findElement1("email_to_share").clear();
		obj1.findElement1("email_to_share").sendKeys(shareEmail);
		driver.findElement(By.name("submit")).click();

		// This will capture error message
		String actual_msg = driver.findElement(By.id("email_error_message_share")).getText();

		// Store message in variable
		String expect = "Oops! You must separate each email address by a comma only(no spaces).";

		// Verify error message
		Assert.assertEquals(actual_msg, expect);
	}

	public void ClickOnEmailShareInvalid(String shareEmail) throws InterruptedException {
		Thread.sleep(6000);
		obj1.findElement1("email_to_share").clear();
		obj1.findElement1("email_to_share").sendKeys(shareEmail);
		driver.findElement(By.name("submit")).click();

		// This will capture error message
		String actual_msg2 = driver.findElement(By.id("email_error_message_share")).getText();

		// Store message in variable
		String expect2 = "Please enter the valid email addresses.";

		// Verify error message
		Assert.assertEquals(actual_msg2, expect2);
	}

	public void ClickOnEmailShareValid(String shareEmail) throws InterruptedException {
		Thread.sleep(8000);
		obj1.findElement1("email_to_share").clear();
		obj1.findElement1("email_to_share").sendKeys(shareEmail);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}

	// Copy Link
	public void CopyLink() throws InterruptedException {
		String parentwindow = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for(String handle : winHandles) {
			driver.switchTo().window(handle);
		}
		driver.switchTo().frame(driver.findElement(By.id("sa_v2_ifame")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.id("ZeroClipboardMovie_1")));
		Thread.sleep(10000);
		String link = "https://goo.gl/8wWefS";
		System.setProperty(ReadProperties.Read().getProperty("driver1"),ReadProperties.Read().getProperty("driverpath1"));
		FirefoxDriver objc = new FirefoxDriver();
		objc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objc.manage().window().maximize();
		objc.get(link);
		Thread.sleep(30000);
		objc.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");  
		objc.get("//c.socialannex.com/c-sale-track/?site_id=9991141&order_id=1235t&sale_amount=100&email_id=sa.lordpaul@gmail.com&coupon=RAFK8JVDM8");  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		objc.close();
		driver.switchTo().window(parentwindow);
	}

	public void ClickOnClaimReward() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("sa_v2_ifame")));
		obj1.findElement2("//div[@class='sa_2_reward_url']").click();
		Thread.sleep(15000);
		obj1.findElement2("//a[@class='sa_2_reward_back_link']").click();
		Thread.sleep(5000);
		driver.quit();
	}

	// ...............................Script for Test Bitly Run On Facebook,Twitter,Email............................................................................................
	
	// Switch to facebook login page
	public void FBPage() throws InterruptedException {
		FirefoxDriver obja = new FirefoxDriver();
		obja.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		obja.get(ReadProperties.Read().getProperty("url2"));
		obja.manage().window().maximize();
		obja.findElement(By.id("email")).sendKeys("sa.lordpaul@gmail.com");
		obja.findElement(By.id("pass")).sendKeys("Test@1234");
		obja.findElement(By.id("loginbutton")).click();
		Thread.sleep(10000);
		obja.findElement(By.xpath("//a[@class='_52c6']")).click();
		Thread.sleep(20000);
		obja.quit();

	}

	// Switch to Twitter login page
	public void TwitterPage() throws InterruptedException {
		FirefoxDriver obja = new FirefoxDriver();
		obja.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		obja.get(ReadProperties.Read().getProperty("url3"));
        Thread.sleep(3000);
		obja.manage().window().maximize();
		obja.findElement(By.xpath("//a[@class='Button StreamsLogin js-login']")).click();
		Thread.sleep(2000);
		obja.findElement(By.xpath("//input[@class='text-input email-input js-signin-email']")).sendKeys("sa.lordpaul@gmail.com");
		Thread.sleep(10000);
		obja.findElement(By.xpath("//input[@class='text-input']")).sendKeys("Test@1234");
		Thread.sleep(10000);
		obja.findElement(By.xpath("//input[@class='submit btn primary-btn js-submit']")).click();
		Thread.sleep(10000);
		obja.findElement(By.xpath("//img[@class='DashboardProfileCard-avatarImage js-action-profile-avatar']")).click();
		obja.findElement(By.xpath("//span [@class='js-display-url']")).click();
		Thread.sleep(20000);
		obja.quit();
	}

	// Switch to gmail login page
	public void GmailPage() throws InterruptedException {
		System.setProperty(ReadProperties.Read().getProperty("driver1"),
				ReadProperties.Read().getProperty("driverpath1"));
		ChromeDriver objc = new ChromeDriver();
		objc.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		objc.get(ReadProperties.Read().getProperty("url4"));
		objc.manage().window().maximize();
		objc.findElement(By.id("Email")).sendKeys("sa.lordpaul@gmail.com");
		objc.findElement(By.id("next")).click();
		Thread.sleep(3000);
		objc.findElement(By.id("Passwd")).sendKeys("Test@1234");
		objc.findElement(By.id("signIn")).click();
		Thread.sleep(20000);
		objc.findElement(By.name("q")).sendKeys("John");
		objc.findElement(By.id("gbqfb")).click();
		Thread.sleep(5000);
		objc.findElement(By.xpath("//*[@id=':ls']/td[5]")).click();
		Thread.sleep(10000);
		objc.findElement(By.xpath("//img[@class='CToWUd']")).click();
		Thread.sleep(20000);
		objc.quit();

	}
	    
}
