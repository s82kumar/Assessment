package com.org.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class NewUserPage extends UsersPage {

	protected static final By NEW_USERS_LINK = By.xpath("//*[@id='titlebar_right']/div/span/a");
	protected static final By USER_USERNAME = By.id("user_username");
	protected static final By USER_PASSWORD = By.id("user_password");
	protected static final By USER_EMAIL = By.id("user_email");
	protected static final By CREATE_USER_BUTTON = By.id("user_submit_action");
	protected static final By VALIDATION_MESSSAGE = By.xpath("//*[text()='has already been taken']");
	protected static final By CANCEL_BUTTON = By.xpath("//*[@class='cancel']/a");
	protected static final By USER_CREATED_SUCCESSFULLY = By.xpath("//*[text()='User was successfully created.']");

	public boolean clickNewUserLink() {
		if (driver.findElement(NEW_USERS_LINK).isDisplayed()) {
			driver.findElement(NEW_USERS_LINK).click();
			return true;
		}
		return false;
	}

	public void enterUserName(String _inputUserName) {
		driver.findElement(USER_USERNAME).sendKeys(_inputUserName);
	}

	public void enterPassword(String _inputPassword) {
		driver.findElement(USER_PASSWORD).sendKeys(_inputPassword);
	}

	public void enterEmail(String _inputEmail) {
		driver.findElement(USER_EMAIL).sendKeys(_inputEmail);
	}

	public void clickCancel() {
		driver.findElement(CANCEL_BUTTON).click();
	}
	
	public boolean createUserButton() {

		if (driver.findElement(CREATE_USER_BUTTON).isDisplayed()) {
			driver.findElement(CREATE_USER_BUTTON).click();
			return true;
		}
		return false;
	}

	public boolean existingUser() {
		List<WebElement> validatonMessage =driver.findElements(VALIDATION_MESSSAGE); 
		if(validatonMessage.isEmpty())
		{
			return false;
		}
		
		return true;
	}

	public boolean verifyUserCreatedSuccessfully(){
	
		try {
		if(driver.findElement(USER_CREATED_SUCCESSFULLY).isDisplayed()) {
			return true;
		}
		}
		catch(NoSuchElementException e) 
		{
			
		}
		return false;
	}
		
		
		
	}

	

