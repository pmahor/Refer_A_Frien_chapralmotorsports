package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.immply.callobjects.Functions;

public class TwitterShare {
	public static WebDriver driver;
	Functions obj3 = new Functions(driver);

	// Initialize Constructor
	public TwitterShare() {
		this.driver = driver;
	}

	@Test(priority = 4)
	public void TweetShare() throws InterruptedException {
		obj3.ClickOnTwitterShare();
	}

	@Test(priority = 5)
	public void TweetLoginPage() throws InterruptedException {
		obj3.TwittLoginPage("sa.lordpaul@gmail.com", "Test@1234");
	}

}
