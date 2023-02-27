package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SelenumActions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class CheckoutPage {
    WebDriver driver;
    SelenumActions selenumActions;
    SeleniumWaits seleniumWaits;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenumActions = new SelenumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);

    }

    @FindBy(xpath = "//table[starts-with(@class,'table')]/thead/tr/th[text()='Select Method']/ancestor::thead/following-sibling::tbody/tr/following-sibling::tr/td/input")
    WebElement checkBox;
    @FindBy(css = "input[name^='street']")
    WebElement streetName;
    @FindBy(css = "input[name='city']")
    WebElement cityName;
    @FindBy(css = "select[name^='region_id']")
    WebElement stateDropdown;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement pincodeInputBox;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement telephone;
    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;
    @FindBy(xpath = "//div[@class='billing-address-details']")
    WebElement billingAddress;
    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement placeOrderButton;

    @FindBy(css = ".order-number")
    WebElement orderNumber;
    @FindBy(css = "div[class$=' selected-item']")
    WebElement defaultAddress;
    @FindBy(xpath = "//span[text()='Order Date:']/following-sibling::span")
    WebElement date;
    @FindBy(css = "td[class$='col price']>span")
    WebElement priceInCart;


    public void shippingAddress(String street, String city, String state, String zipcode, String mobile) {
        try {


            selenumActions.waitAndClickOnElement(checkBox);
            streetName.sendKeys(street);
            cityName.sendKeys(city);
            stateDropdown.click();
            Select select = new Select(stateDropdown);
            select.selectByVisibleText(state);
            stateDropdown.click();
            pincodeInputBox.sendKeys(zipcode);
            telephone.sendKeys(mobile);
            nextButton.click();

        } catch (Exception e) {
            e.printStackTrace();
            //selenumActions.waitAndClickOnElement(checkBox);
            nextButton.click();

        }
    }

    public String gettingAddress() throws InterruptedException {
        seleniumWaits.waitForElement(billingAddress);
        String billinngAddress = billingAddress.getText();
        return billinngAddress;
    }


    public void placingOrder() {
        selenumActions.waitAndClickOnElement(placeOrderButton);
    }

    public boolean verifyingOrderNumber() throws InterruptedException {
        boolean status = true;
        seleniumWaits.waitForElement(orderNumber);
        orderNumber.isDisplayed();
        return status;
    }

    public ArrayList clickOnOrderNUmber() throws InterruptedException {
        ArrayList<String> arraylist = new ArrayList<String>();
        selenumActions.waitAndClickOnElement(orderNumber);
        seleniumWaits.waitForElement(date);
        String dateInCart = date.getText();
        String price = priceInCart.getText();
        arraylist.add(dateInCart);
        arraylist.add(price);
        System.out.println(arraylist);
        return arraylist;
    }
}
