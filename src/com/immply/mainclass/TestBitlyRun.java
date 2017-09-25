package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;


public class TestBitlyRun {
	public static WebDriver driver;
	Functions obj6;

    //constructor initialize
	public TestBitlyRun(){
		this.driver=driver;
		obj6 = new Functions(driver);
	}

	@Test(priority=10)
	public void TestFBLoginPage() throws InterruptedException {
		obj6.FBPage();
	}
    
	@Test(priority=11)
	public void TesttweetLoginPage() throws InterruptedException  {
		obj6.TwitterPage();
	}


	@Test(priority=12)
	public void testGmailPage() throws InterruptedException {
		obj6.GmailPage();
	}

}
