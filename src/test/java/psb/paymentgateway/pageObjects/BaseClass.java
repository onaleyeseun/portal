package psb.paymentgateway.pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import psb.paymentgateway.utilities.BrowserFactory;
import psb.paymentgateway.utilities.configDataProvider;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public configDataProvider config = new configDataProvider();



    @BeforeClass
    public void setUp()
    {
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
    }

    //@AfterClass
    public void tearDown()
    {
        BrowserFactory.quitBrowser(driver);
    }

    protected WebElement waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public WebDriver getDriver() {
        return driver;
    }
}
