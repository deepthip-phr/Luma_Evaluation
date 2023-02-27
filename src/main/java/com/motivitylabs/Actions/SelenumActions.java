package com.motivitylabs.Actions;

import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelenumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;
    Actions actions;

    public SelenumActions(WebDriver driver) {
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);

    }

    public boolean waitAndClickOnElement(WebElement element) {
        try {
            seleniumWaits.waitForElement(element).click();
        } catch (Exception e) {

        }
        return false;

    }

    public void clickElementUsingMouseHover(WebElement source, WebElement target) {
        actions = new Actions(driver);
        actions.moveToElement(source).moveToElement(target).click().build().perform();


    }
}
