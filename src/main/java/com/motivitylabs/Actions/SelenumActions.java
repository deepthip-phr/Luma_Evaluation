package com.motivitylabs.Actions;

import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelenumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;
    Actions actions;

    public SelenumActions(WebDriver driver) {
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);

    }
    /**
     * Wait for element using webdriver wait and click on the element
     * @param element - webelement
     * @return boolean value
     */

    public boolean waitAndClickOnElement(WebElement element) {
        try {
            seleniumWaits.waitForElement(element).click();
            return true;
        } catch (Exception e) {
            return false;

        }

    }
    /**
     * Click an element using MouseHover
     * @param element - webelement
     *
     */


    public void clickElementUsingMouseHover(WebElement source, WebElement target) {
        actions = new Actions(driver);
        actions.moveToElement(source).moveToElement(target).click().build().perform();


    }

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;
        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    /**
     * Entering the value usinh
     *
     * @param element
     * @param data
     * @return boolean value
     */

    public boolean enterValue(WebElement element, String data) {
        boolean flag = false;
        try {
            element.sendKeys(data);
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect) {
        try {
            Select select = new Select(element);
            switch (typeSelect) {
                case "index":
                    select.selectByIndex(Integer.parseInt(data));
                    break;
                case "value":
                    select.selectByValue(data);
                    break;
                case "text":
                    select.selectByVisibleText(data);
                    break;
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
