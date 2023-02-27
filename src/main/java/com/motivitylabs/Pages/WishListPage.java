package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SelenumActions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    WebDriver driver;
    String productTitle;
    SelenumActions selenumActions;
    SeleniumWaits seleniumWaits;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenumActions = new SelenumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    @FindBy(xpath = "//div[@class='products-grid wishlist']//li[@class='product-item']//strong")
    WebElement productNameInWL;
    @FindBy(xpath = "//form[@id='wishlist-view-form']/div[contains(@class,'message')]")
    WebElement textInWL;
    @FindBy(xpath = "//span[text()='My Cart']/parent::a")
    WebElement cartButton;
    @FindBy(css = "button[id$='checkout']")
    WebElement checkOutButton;

    public String getProductName() {
        productTitle = productNameInWL.getText();
        return productTitle;
    }

    public void addingToCart() {
        selenumActions.clickElementUsingMouseHover(driver.findElement(By.xpath("//div[@class='products-grid wishlist']//div[@class='product-item-info']//strong")), driver.findElement(By.xpath("//div[@class='products-grid wishlist']//div[@class='product-item-info']//strong/ancestor::div[@class='product-item-info']//span[text()='Add to Cart']")));
    }

    public String messageInWishlist() {
        String actualText = textInWL.getText();
        return actualText;
    }


    public void proceedToCheckOut() throws InterruptedException {
        Thread.sleep(5000);
        selenumActions.waitAndClickOnElement(cartButton);
        selenumActions.waitAndClickOnElement(checkOutButton);
    }
}
