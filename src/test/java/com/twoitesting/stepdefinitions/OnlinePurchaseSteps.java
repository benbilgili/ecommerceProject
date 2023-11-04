package com.twoitesting.stepdefinitions;

import com.twoitesting.SharedDictionary;
import com.twoitesting.pom_pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom_pages.HomepagePOM;
import com.twoitesting.utils.UtilityLibrary.*;

import java.util.Objects;

import static com.twoitesting.utils.UtilityLibrary.waitForElementToBeClickable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OnlinePurchaseSteps {

    private WebDriver driver;
    private double initialCost;
    private double totalReduction;
    private String previousOrderNumber;
    private final SharedDictionary sharedDict;

    public OnlinePurchaseSteps(SharedDictionary sharedDict) { // takes shared dict only --------- UPDATE ME
        this.sharedDict = sharedDict;
        this.driver = (WebDriver)sharedDict.readDict("mydriver");// (WebDriver) > get the object as a WebDriver
    }


    @When("I add an {string} to my basket")
    public void i_add_an_to_my_basket(String searchTerm) {
        pom_pages.HomepagePOM home = new HomepagePOM(driver); // why does it insist on pom_pages.HomepagePOM
        home.typeSearchBox(searchTerm);

        SearchResultPOM search = new SearchResultPOM(driver);
        search.addItemToCart();
    }

    @When("I apply discount code {string}")
    public void i_apply_discount_code(String string) {
        BasePOM base = new BasePOM(driver);
        base.goCart();

        // REMOVE A COUPON CODE IF IT'S ALREADY THERE?

        CartPOM cart = new CartPOM(driver);
        initialCost = cart.findSubTotal();
        cart.enterCouponCode("edgewords");
        totalReduction = cart.findReduction();
    }

    @Then("The price should be reduced by 15%")
    public void the_price_should_be_reduced_by() {
        double expectedCostAfterReduction = (initialCost - totalReduction);
        assertEquals(expectedCostAfterReduction, (initialCost * 0.85), 0.001);
    }


        // Scenario 2

    @When("I complete the purchase")
    public void i_complete_the_purchase() {
        BasePOM base = new BasePOM(driver);
        base.goMyAccount();

        MyAccountPOM myAccount = new MyAccountPOM(driver);
        myAccount.goToOrders();
        previousOrderNumber = myAccount.getPreviousOrderNumber();

        base.goCheckout();

        CheckoutPOM checkout = new CheckoutPOM(driver);
        checkout.completeCheckout("Ben", "Bilgili", "46 The Road", "Edinburgh", "EH45 9BH", "07753456278", "ben.bilgili@2itesting.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { // need to find something better. Wait for an element on the next page to be available?
            throw new RuntimeException(e);
        }

    }

    @Then("I can view the order and order number")
    public void i_can_view_the_order_and_order_number() {
        BasePOM base = new BasePOM(driver);
        base.goMyAccount();

        MyAccountPOM myAccount = new MyAccountPOM(driver);
        myAccount.goToOrders();

        String newestOrderNumber = myAccount.getPreviousOrderNumber();


        assertNotEquals(previousOrderNumber, newestOrderNumber); // we assert that the top order number has changed, confirming that a new order has been made

        myAccount.clickViewRecentOrder();
        assertTrue(myAccount.confirmOrderDetails()); // confirm that we can see Order Details on the screen
    }


}
