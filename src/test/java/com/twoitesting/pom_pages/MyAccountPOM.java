package com.twoitesting.pom_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class MyAccountPOM {

    private WebDriver driver; // does this need to come from SharedDict?

    public MyAccountPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Locators
    @FindBy(id = "username")
    private WebElement usernameBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(css = "button[name='login']")
    private WebElement submitButton;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders > a")
    private WebElement ordersLink;

    @FindBy(css = "tr:nth-of-type(1) > .woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number > a")
    private WebElement orderNumberElement;

    @FindBy(css = "tr:nth-of-type(1) > .woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-actions > .button.view.woocommerce-button")
    private WebElement viewRecentOrder;

    @FindBy(css = ".woocommerce-order-details > .woocommerce-order-details__title")
    private WebElement orderDetails;



    // Service Methods
    public void enterUsername(String username) {
        usernameBox.click();
        usernameBox.clear();
        usernameBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordBox.click();
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        submitButton.click();
    }

    public void goToOrders() {
        ordersLink.click();
    }

    public String getPreviousOrderNumber() {
        return orderNumberElement.getText();
    }

    public void clickViewRecentOrder() {
        viewRecentOrder.click();
    }

    public Boolean confirmOrderDetails() {
        System.out.println("TEXT " + orderDetails.getText());
        return Objects.equals(orderDetails.getText(), "Order details");
    }



}
