package pom_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM {
    private WebDriver driver;

    public HomepagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Locators
    @FindBy(linkText = "Dismiss")
    private WebElement dismissLink;

    @FindBy(partialLinkText = "Hoodies")
    private WebElement hoodieCategory;

    @FindBy(id = "woocommerce-product-search-field-0")
    private WebElement searchBox;

    // Service Methods
    public void acceptCookies() {
        dismissLink.click();
    }

    public void goHoodiesCategory() {
        hoodieCategory.click();
    }

    public void typeSearchBox(String searchText) {
        searchBox.clear();
        searchBox.sendKeys(searchText + Keys.RETURN);
    }
}
