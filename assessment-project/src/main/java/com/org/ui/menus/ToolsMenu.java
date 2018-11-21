package com.org.ui.menus;

import org.openqa.selenium.By;

import com.org.ui.common.BaseComponent;
import com.org.ui.pages.NewUserPage;

public class ToolsMenu extends BaseComponent {
    protected static final By DASHBOARD_LINK = By.xpath("//*[@id='dashboard']/a");
    protected static final By USERS_LINK = By.xpath("//*[@id='users']/a");


    
    
    public void clickDashboardLink() {
    	driver.findElement(DASHBOARD_LINK).click();
    }
    
    
    public NewUserPage clickUsersLink() {
    	 
        driver.findElement(USERS_LINK).click();
        return new NewUserPage();
      }
}
