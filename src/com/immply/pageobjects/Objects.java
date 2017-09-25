package com.immply.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Objects {
	
	public static WebDriver driver;
	
	//Class Constructor
	public Objects(WebDriver driver){
		this.driver=driver;
	}
	
	
	public WebElement findElement1(String id){
		
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	
	public WebElement findElement2(String xpath){
		
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	
	public WebElement findElement3(String name){
		
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	

	public WebElement findElement4(String cssSelector) {
		WebElement element = driver.findElement(By.cssSelector(cssSelector));
		return element;
	}
   


}
