package com.org.ui.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base Class to create driver instance and to setup application for automation
 * 
 */
public  class BaseComponent {
	// Base component variables
	public static WebDriver driver; 
	String url = "http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin";
	/**
	 * The BaseComponent constructor
	 *
	 * @param webDriver The current Selenium WebwebDriver
	 */
	
	public BaseComponent() {
		if(driver==null) {
		System.setProperty("webdriver.chrome.driver", "./selenium/chromedriver.exe");
		driver = new ChromeDriver();
		}
	}

	public void setupApplication() {
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

	
}
