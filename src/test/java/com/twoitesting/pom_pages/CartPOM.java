package com.twoitesting.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.twoitesting.utils.UtilityLibrary.waitForElementToBeClickable;

public class CartPOM {

    private WebDriver driver;

    public CartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Locators
    @FindBy(id = "coupon_code")
    private WebElement couponCodeBox;

    @FindBy(css = ".cart-subtotal > td > .amount.woocommerce-Price-amount > bdi")
    private WebElement cost;

    @FindBy(css = ".cart-discount.coupon-edgewords > td > .amount.woocommerce-Price-amount")
    private WebElement couponDiscount;



    // Service Methods
    public void enterCouponCode(String code) { // could click remove coupon code first (if there is one already applied)
        couponCodeBox.click();
        couponCodeBox.clear();
        couponCodeBox.sendKeys(code + Keys.RETURN);
    }

    public void logCost() {
        System.out.println("Cost is: " + cost);
    }

    public double findSubTotal(){
        String rawValue = cost.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        double valueAsDouble = Double.parseDouble(rawValue);
        return valueAsDouble;
    }

    public double findReduction(){
        waitForElementToBeClickable(driver, By.cssSelector(".cart-discount.coupon-edgewords > td > .amount.woocommerce-Price-amount"), 5);
        String rawValue = couponDiscount.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        double valueAsDouble = Double.parseDouble(rawValue);
        return valueAsDouble;
    }

}
