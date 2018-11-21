package com.org.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.org.ui.common.BaseComponent;

public class UsersPage extends BaseComponent {
	
	protected static final By USER_USERNAME = By.id("q_username");
	protected static final By USER_EMAIL = By.id("q_email");
	protected static final By FILTER_BUTTON = By.xpath("//*[@class='buttons']/input");
	protected static final By USER_DATA =By.xpath("//*[@id='index_table_users']");
	
	
	public void filterUser(String _UserName, String _Email){
		
		driver.findElement(USER_USERNAME).sendKeys(_UserName);
		driver.findElement(USER_EMAIL).sendKeys(_Email);
		
	}
	
	public void clickFilterButton() {
		driver.findElement(FILTER_BUTTON).click();
		
	}
	
	public boolean verifyFilterUser(String _UserName, String _Email) {
		boolean verifyData = false;
		List<WebElement> userData = driver.findElements(USER_DATA);
		for(WebElement data: userData) {
			if(data.getText().contains(_UserName) || data.getText().contains(_Email)) {
				verifyData = true;
			}
		}
		return verifyData;
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}
	

	
}
