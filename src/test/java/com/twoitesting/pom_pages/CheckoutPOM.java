package com.twoitesting.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.twoitesting.utils.UtilityLibrary.waitForElementToBeClickable;

public class CheckoutPOM {
    private WebDriver driver;

    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Locators
    @FindBy(css = "input#billing_first_name")
    private WebElement firstNameField;

    @FindBy(css = "input#billing_last_name")
    private WebElement lastNameField;

    @FindBy(css = "input[name='billing_address_1']")
    private WebElement streetAddressField;

    @FindBy(css = "input#billing_city")
    private WebElement townCityField;

    @FindBy(css = "input#billing_postcode")
    private WebElement postCodeField;

    @FindBy(css = "input#billing_phone")
    private WebElement phoneNumberField;

    @FindBy(css = "input#billing_email")
    private WebElement emailField;

    @FindBy(css = "button#place_order")
    private WebElement placeOrderButton;

    @FindBy(css = ".entry-title")
    private WebElement orderReceivedText;




    // Service Methods
    public void completeCheckout(String firstName, String lastName, String streetAddress, String townCity, String postCode, String phoneNumber, String emailAddress) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        streetAddressField.clear();
        streetAddressField.sendKeys(streetAddress);
        townCityField.clear();
        townCityField.sendKeys(townCity);
        postCodeField.clear();
        postCodeField.sendKeys(postCode);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        emailField.clear();
        emailField.sendKeys(emailAddress);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { // find a way to bypass
            throw new RuntimeException(e);
        }

        waitForElementToBeClickable(driver, By.cssSelector("button#place_order"), 5);
        placeOrderButton.click();

        waitForElementToBeClickable(driver, By.cssSelector(".entry-title"), 3);
    }


}
