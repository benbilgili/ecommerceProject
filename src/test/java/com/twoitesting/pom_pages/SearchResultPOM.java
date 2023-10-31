package com.twoitesting.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPOM {

    private WebDriver driver;

    public SearchResultPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = "button[name='add-to-cart']") // would need to be by class with the variable
    private WebElement addToCart;

    // Service Methods
    public void addItemToCart() {
//        waitForElementToBeClickable(driver, By.name("add-to-cart"), 3);
        addToCart.click();
    }


}
