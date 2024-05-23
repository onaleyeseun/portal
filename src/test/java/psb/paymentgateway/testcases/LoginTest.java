package psb.paymentgateway.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import psb.paymentgateway.pageObjects.BaseClass;
import psb.paymentgateway.pageObjects.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseClass {

    LoginPage page;




            @Test
            public void testSignUpLinkIsClickable() {
                // Create an instance of your page object
                page = new LoginPage(driver);

                // Verify that the sign-up link is clickable
                Assert.assertTrue(page.signUpLink.isEnabled(), "Sign-up link is not enabled");
                Assert.assertTrue(page.signUpLink.isDisplayed(), "Sign-up link is not displayed");

               }



        @Test
        public void testSignUpLinkRedirectToSignUpPage(){

           page = new LoginPage(driver);
            // Call the method to click the sign-up link
            page.verifySignUpLink();
            WebElement businessNameElement = waitForElementVisible(page.businessNameLocator());

            Assert.assertNotNull(businessNameElement, "Element with id 'businessName' not found");

        }




}
