package com.motivitylabs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailInputBox;
    @FindBy(id = "pass")
    WebElement passwordInputBox;
    @FindBy(xpath = "//fieldset[starts-with(@class,'fieldset')]//span[text()='Sign In']")
    WebElement signInButton;

    public void signIn(String email, String password) {
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

}
