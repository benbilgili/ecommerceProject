package com.twoitesting.stepdefinitions;

import com.twoitesting.SharedDictionary;
import com.twoitesting.pom_pages.MyAccountPOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    private WebDriver driver;
    private final SharedDictionary sharedDict;
    private String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/my-account/";

    // Constructor
    public Hooks(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    // Methods
    public WebDriver getDriver() {
        return this.driver;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Before()
    public void setUp() {
        String browser = System.getProperty("BROWSER");
        if(browser==null){browser="";}
        switch (browser){
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.printf("No or unrecognised driver specified on command line. Using Chrome");
                driver = new ChromeDriver();
                break;
        }
        sharedDict.addDict("mydriver", driver);
        sharedDict.addDict("baseUrl", baseUrl);

        driver.get(baseUrl);
        MyAccountPOM myAccount = new MyAccountPOM(driver);
        myAccount.login("ben.bilgili@2itesting.com", "DavidRaya15");
        pom_pages.HomepagePOM home = new pom_pages.HomepagePOM(driver); // why does it insist on pom_pages.HomepagePOM
        home.acceptCookies();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
