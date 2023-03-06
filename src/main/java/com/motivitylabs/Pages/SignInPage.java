package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SelenumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;
    SelenumActions selenumActions;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenumActions = new SelenumActions(driver);
    }

    @FindBy(id = "email")
    WebElement emailInputBox;
    @FindBy(id = "pass")
    WebElement passwordInputBox;
    @FindBy(xpath = "//fieldset[starts-with(@class,'fieldset')]//span[text()='Sign In']")
    WebElement signInButton;

    public void signIn(String email, String password) {
        selenumActions.enterValue(emailInputBox,email);
        selenumActions.enterValue(passwordInputBox,password);
        selenumActions.clickOnElement(signInButton);
    }

}
