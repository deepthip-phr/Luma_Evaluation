package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SelenumActions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PLPPages {
    WebDriver driver;
    String price;
    String TitleOfProduct;
    SelenumActions selenumActions;
    SeleniumWaits seleniumWaits;


    public PLPPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenumActions = new SelenumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    @FindBy(xpath = "//div[@class='product-item-info']//span[@class='price']")
    List<WebElement> priceList;
    @FindBy(xpath = "//span[text()='My Cart']/parent::a")
    WebElement cartButton;
    @FindBy(css = "div[class='block-content']>strong[class$='empty']")
    WebElement cartMessage;

    public String checkingTheCart() throws InterruptedException {
        Thread.sleep(5000);
        selenumActions.waitAndClickOnElement(cartButton);
        String textInCart = cartMessage.getText();
        return textInCart;

    }

    public String gettingHighestPriceItem() {
        List<Float> arraylist = new ArrayList<Float>();
        for (int i = 0; i < priceList.size(); i++) {
            String price = priceList.get(i).getText();
            String values = price.replace("$", "");
            Float valuesf = Float.parseFloat(values);
            arraylist.add(valuesf);
        }
        Float max = Collections.max(arraylist);
        String priceinString = Float.toString(max);
        String addZero = "0";
        String symbol = "$";
        price = symbol.concat(priceinString).concat(addZero);
        System.out.println("Product with Highest Price " + price);
        return price;

    }

    public String gettingName() {
        TitleOfProduct = driver.findElement(By.xpath("//span[text()='" + price + "']/ancestor::div[@class='product-item-info']//strong")).getText();
        System.out.println(TitleOfProduct);
        selenumActions.clickElementUsingMouseHover(driver.findElement(By.xpath("//span[text()='$74.00']/ancestor::div[@class='product-item-info']")), driver.findElement(By.xpath("//span[text()='" + price + "']/ancestor::div[@class='product-item-info']//strong/following-sibling::div[@class='product-item-inner']//span[text()='Add to Wish List']/parent::a")));
        return TitleOfProduct;

    }
}
