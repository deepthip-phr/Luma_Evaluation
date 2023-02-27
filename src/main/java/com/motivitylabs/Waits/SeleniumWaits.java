package com.motivitylabs.Waits;

import com.motivitylabs.Constants.WiatTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    WebDriverWait webDriverWait;
    WebDriver driver;
    WiatTime wiatTime;

    public SeleniumWaits(WebDriver driver) {
        this.driver = driver;
        wiatTime = new WiatTime();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(wiatTime.EXPLICITWAIT));

    }

    public WebElement waitForElement(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void givingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wiatTime.IMPLICITWAIT));

    }

    public void killingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wiatTime.KILLIMPLICITWAIT));

    }
}
