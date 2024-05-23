package psb.paymentgateway.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import psb.paymentgateway.pageObjects.BaseClass;
import psb.paymentgateway.pageObjects.LoginPage;
import psb.paymentgateway.pageObjects.SignUpPage;
import psb.paymentgateway.utilities.configDataProvider;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseClass {

    private SignUpPage signUpPage;
    private configDataProvider config;

    private String businessNameData;
    private String businessAddressData;
    private String firstNameData;
    private String lastNameData;
    private String emailAddressData;
    private String phoneNumberData;

    private  String passwordData;
    private String confirmPasswordData;



    @BeforeMethod
    public void signUpSetUp() {
        // Initialize the login page
        LoginPage page = new LoginPage(driver);
        // Click the sign-up link to navigate to the sign-up page
        page.verifySignUpLink();
        // Initialize the sign-up page
        signUpPage = new SignUpPage(driver);
        // Load configuration data
        config = new configDataProvider();
        // Wait for the business name input field to be visible
        WebElement businessNameElement = waitForElementVisible(signUpPage.getBusinessNameElement());

        businessNameData = config.getTestDataProperty("businessName");
        businessAddressData = config.getTestDataProperty("businessAddress");
        firstNameData = config.getTestDataProperty("firstName");
        lastNameData = config.getTestDataProperty("lastName");
        emailAddressData = config.getTestDataProperty("emailAddress");
        phoneNumberData = config.getTestDataProperty("phoneNumber");
        passwordData = config.getTestDataProperty("validPassWord");
        confirmPasswordData = config.getTestDataProperty("validConfirmPassword");
    }


    @Test
    public void testAllMandatoryFieldsAreEnabled() {
        Assert.assertTrue(signUpPage.areAllFieldsEnabled(), "Not all mandatory fields are enabled.");
    }

    @Test
    public void testSuccessfulSignUp() {
        passwordData = config.getTestDataProperty("validPassWord");
        confirmPasswordData = config.getTestDataProperty("validConfirmPassword");
       signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getSuccessfulSignUp());

        // Assert that the element is present
        Assert.assertTrue(element.isDisplayed(), "The text 'A link has been sent to your mail, kindly check your email to Activate your account");

    }



    @Test
    public void testSubmissionOfEmptyForm() {

        signUpPage.clickContinueButton();

        // Add assertions to verify error message for empty business name
        String businessNameErrorMessage = signUpPage.getErrorMessageForBusinessName(); // Implement this method in SignUpPage class
        Assert.assertEquals(businessNameErrorMessage, "Required", "Error message for empty business name is incorrect.");
    }


    @Test
    public void testSpecialCharacterInPassword() {
        passwordData = config.getTestDataProperty("invalidPassword");
        confirmPasswordData = config.getTestDataProperty("invalidPassword");
        signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getPasswordSspecialCharacter());

        // Assert that the element is present and visible
        Assert.assertNotNull(element, "The element for uppercase letter message is not present.");
        Assert.assertTrue(element.isDisplayed(), "The element for uppercase letter message is not visible.");

    }

    @Test
    public void testForUppercaseValidationInPassword() {
        passwordData = config.getTestDataProperty("passWord");
        confirmPasswordData = config.getTestDataProperty("passWord");
        signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getPasswordUpperCase());

        // Assert that the element is present and visible
        Assert.assertNotNull(element, "The element for uppercase letter message is not present.");
        Assert.assertTrue(element.isDisplayed(), "The element for uppercase letter message is not visible.");

    }

    @Test
    public void testForExisstingBusinessName() {
        passwordData = config.getTestDataProperty("passWord");
        confirmPasswordData = config.getTestDataProperty("passWord");
        signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getPasswordUpperCase());

        // Assert that the element is present and visible
        Assert.assertNotNull(element, "The element for uppercase letter message is not present.");
        Assert.assertTrue(element.isDisplayed(), "The element for uppercase letter message is not visible.");

    }

    @Test
    public void testForExistingEmailAddress() {
        passwordData = config.getTestDataProperty("validPassWord");
        confirmPasswordData = config.getTestDataProperty("validPassWord");
        signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getExistingEmailAddressLocator());

        // Assert that the element is present and visible
        Assert.assertNotNull(element, "The element for uppercase letter message is not present.");
        Assert.assertTrue(element.isDisplayed(), "An account with email \\'\" + emailAddressData + \"\\' already exists");

    }



    @Test
    public void testForValidationOfMatchedConfirmPasssword() {
        passwordData = config.getTestDataProperty("validPassWord");
        confirmPasswordData = config.getTestDataProperty("notMatchConfirmPassword");
        signUpPage.fillAndSubmitSignUpForm22(businessNameData, businessAddressData, firstNameData, lastNameData, emailAddressData, phoneNumberData, passwordData, confirmPasswordData);

        WebElement element = waitForElementVisible(signUpPage.getPasswordMatch());

        // Assert that the element is present
        Assert.assertTrue(element.isDisplayed(), "The text 'Passwords must match' is not displayed.");


    }





}


