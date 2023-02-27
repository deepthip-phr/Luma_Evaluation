package com.motivitylabs.Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Parameters;



public class LumaBasePage {
    public WebDriver driver;

    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }


    @BeforeTest
    public void launchApplication() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

     @AfterSuite
    public void killSession() {
        driver.quit();
    }

}


