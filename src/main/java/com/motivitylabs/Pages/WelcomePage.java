package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SelenumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    WebDriver driver;
    SelenumActions selenumActions;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenumActions = new SelenumActions(driver);
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement GearMenu;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bags;


    public void goingtoPLP() {
        selenumActions.clickElementUsingMouseHover(GearMenu, bags);

    }
}
