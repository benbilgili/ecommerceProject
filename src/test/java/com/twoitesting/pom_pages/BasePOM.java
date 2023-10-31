package com.twoitesting.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePOM {
    private WebDriver driver;

    public BasePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Locators
    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @FindBy(linkText = "Shop")
    private WebElement shopLink;

    @FindBy(linkText = "Cart")
    private WebElement cartLink;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutLink;

    @FindBy(linkText = "My account")
    private WebElement myAccountLink;

    @FindBy(linkText = "Blog")
    private WebElement blogLink;

    // Service Methods
    public void goHome() {
        homeLink.click();
    }

    public void goShop() {
        shopLink.click();
    }

    public void goCart() {
        cartLink.click();
    }

    public void goCheckout() {
        checkoutLink.click();
    }

    public void goMyAccount() {
        myAccountLink.click();
    }

    public void goBlog() {
        blogLink.click();
    }

}
