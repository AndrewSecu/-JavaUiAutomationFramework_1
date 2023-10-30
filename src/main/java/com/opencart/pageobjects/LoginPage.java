package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "input-email")
    private WebElement usernameInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void fillInTheLoginForm(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        ScrollManager.scrollToTheElement(loginBtn);
        loginBtn.click();
    }


}
