package com.immply.mainclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.immply.callobjects.Functions;


public class EmailShare {
	public static WebDriver driver;
	Functions obj5;

    //contructor initialization
	public EmailShare(){
		this.driver=driver;
		obj5 = new Functions(driver);
	}


	@Test(priority=6)
	public void testEmailShare() throws InterruptedException {
		obj5.ClickOnEmailShare();
	}


	@Test(priority=7)
	public void testEmailShareEnterNothing() throws InterruptedException {
		System.out.println("Verifying blank field");
		obj5.ClickOnEmailShareNothing("");
	}


	@Test(priority=8)
	public void testEmailShareEnterInvalidData() throws InterruptedException {
		System.out.println("Verifying wrong input");
		obj5.ClickOnEmailShareInvalid("sa.lordpaulgmail.com");
	}


	@Test(priority=9)
	public void testEmailShareEntervalidData() throws InterruptedException {
		System.out.println("Verifying correct email");
		obj5.ClickOnEmailShareValid("sa.lordpaul@gmail.com");
	}



	@Test(priority=10)
	public void testCopyUrl() throws InterruptedException{
		obj5.CopyLink();
	}


	@Test(priority=11)
	public void testPaymentLink() throws InterruptedException{
		obj5.ClickOnClaimReward();
	}

}

