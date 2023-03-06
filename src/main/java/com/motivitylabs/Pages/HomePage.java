package com.motivitylabs.Pages;


import com.motivitylabs.Actions.SelenumActions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    SeleniumWaits seleniumWaits;
    SelenumActions selenumActions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumWaits = new SeleniumWaits(driver);
        selenumActions = new SelenumActions(driver);
    }

    @FindBy(xpath = "//div[starts-with(@class,'panel')]//a[normalize-space()='Sign In']")
    WebElement signInLink;

    public void clickOnSignIn() {
        selenumActions.waitAndClickOnElement(signInLink);
    }
}

