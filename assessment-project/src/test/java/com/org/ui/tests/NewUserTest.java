package com.org.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.ui.common.BaseComponent;
import com.org.ui.menus.ToolsMenu;
import com.org.ui.pages.NewUserPage;
import com.org.ui.pages.UsersPage;

/**
 * NewUSer Test clicks on New User Button and enter UserName, Password, Email.
 * if its new user it creates the user successfully 
 * if its old user it clicks on Cancel and perform the fitler functionaly on User Page.
 */
public class NewUserTest extends BaseComponent {

	ToolsMenu toolsMenu;
	
	public NewUserTest() {
		super();
	}

	@BeforeTest
	public void setUp() {

		setupApplication();
		toolsMenu = new ToolsMenu();
	}

	@Test
	public void testNewUser() {

		toolsMenu.clickDashboardLink();
		NewUserPage newUser = toolsMenu.clickUsersLink();
		boolean verifyNewUserButton = newUser.clickNewUserLink();
		Assert.assertTrue(verifyNewUserButton, "New User button does not exist");
		newUser.enterUserName("SandeepUser");
		newUser.enterPassword("testing");
		newUser.enterEmail("abc@abcd.com");
		boolean verifyCreateUserButton = newUser.createUserButton();
		Assert.assertTrue(verifyCreateUserButton, "Create Button is not available to click on");
		
		boolean verifyUserCreatedSuccessfully = newUser.verifyUserCreatedSuccessfully();

		
		if (!verifyUserCreatedSuccessfully) {
			boolean verifyExistingUser = newUser.existingUser();
			Assert.assertTrue(verifyExistingUser, "Failed to Verify if this is Existing User or not");
			if (verifyExistingUser) {
				newUser.clickCancel();
				testFilters();

			}
		}

		toolsMenu.clickUsersLink();
	}

	@Test
	public void testFilters() {
		toolsMenu.clickUsersLink();
		UsersPage users = new UsersPage();
		users.filterUser("SandeepUser", "abc@abcd.com");
		users.clickFilterButton();
		Boolean verifyFilterUser = users.verifyFilterUser("SandeepUser", "abc@abcd.com");
		Assert.assertTrue(verifyFilterUser, "Fail to FIlter and verify user data");
		users.delete();

	}

	@AfterTest
	public void closeApplication() {
		driver.quit();
	}

}
