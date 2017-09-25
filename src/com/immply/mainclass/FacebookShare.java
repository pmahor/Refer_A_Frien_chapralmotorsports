package com.immply.mainclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;
import com.immply.readproperties.ReadProperties;

public class FacebookShare {
	public static WebDriver driver;
	Functions obj2;



	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(ReadProperties.Read().getProperty("driver1"),
					ReadProperties.Read().getProperty("driverpath1"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Facebook login successfully on firefox ");
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty(ReadProperties.Read().getProperty("driver3"),
					ReadProperties.Read().getProperty("driverpath2"));
			driver = new InternetExplorerDriver();

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

		}

		driver.get(ReadProperties.Read().getProperty("url1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obj2 = new Functions(driver);
	}

	@Test(priority = 1)
	public void testEnterDatails() throws InterruptedException {
		obj2.enterDetails("purpleroy", "purpleroy.sa@gmail.com");
	}

	@Test(priority = 2)
	public void testFBShare() throws InterruptedException {
		obj2.shareByFacebook("sa.lordpaul@gmail.com", "Test@1234");
	}

	@Test(priority = 3)
	public void testFBShareWindow() throws Exception, IOException {
		obj2.FBShareWindow();
	}

}
