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

    //@Parameters({"browser"})
//@BeforeTest
    public void setUp(String browser) throws MalformedURLException {
        switch (browser) {
            case "chrome":
                desiredCapabilities = new DesiredCapabilities();
                chromeOptions = new ChromeOptions();
                desiredCapabilities.setCapability("browserName", "chrome");
                chromeOptions.merge(desiredCapabilities);
                //driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), chromeOptions);
                driver = new RemoteWebDriver(new URL("https://pinnintideepthi0:AIDHa72ZAM7kUQ0MPefcqgL238FsZSPvlDu5GckWutX2UPum1E@hub.lambdatest.com/wd/hub"), chromeOptions);


                break;
            case "edge":
                desiredCapabilities = new DesiredCapabilities();
                edgeOptions = new EdgeOptions();
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.merge(desiredCapabilities);
                //driver = new RemoteWebDriver(new URL( "http://192.168.1.5:4444/wd/hub"), edgeOptions);
                driver = new RemoteWebDriver(new URL("https://pinnintideepthi0:AIDHa72ZAM7kUQ0MPefcqgL238FsZSPvlDu5GckWutX2UPum1E@hub.lambdatest.com/wd/hub"), edgeOptions);


                break;

        }
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }


    @AfterSuite
    public void killSession() {
        driver.quit();
    }

}


