package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "userid")
    private ExtendedWebElement mailField;

    @FindBy(id = "signin-continue-btn")
    private ExtendedWebElement continueButton;

    @FindBy(id = "pass")
    private ExtendedWebElement passwordField;

    @FindBy(id = "sgnBt")
    private ExtendedWebElement loginButton;


    public HomePage login(String email, String password){
        mailField.type(email);
        continueButton.click();
        passwordField.type(password);
        loginButton.click();
        return new HomePage(driver);
    }


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
