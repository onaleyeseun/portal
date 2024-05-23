package psb.paymentgateway.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BaseClass {

    WebDriver driver;

    //String email = config.getTestDataProperty("existingEmail");
    //constructor
    public SignUpPage(WebDriver lDriver)
    {
        this.driver=lDriver;

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"businessName\"]")
    public WebElement businessName;

    static By businessNameElement = By.xpath("//*[@id=\"businessName\"]");

    @FindBy(xpath="//*[@id=\"businessAddress\"]")
    public WebElement businessAddress;
    static By businessAddressElement = By.xpath("//*[@id=\"businessAddress\"]");

    @FindBy(xpath="//*[@id=\"firstName\"]")
    public WebElement firstName;
    static By firstNameElement = By.xpath("//*[@id=\"firstName\"]");


    @FindBy(xpath="//*[@id=\"lastName\"]")
    public WebElement lastName;
    static By lastNameElement = By.xpath("//*[@id=\"lastName\"]");


    @FindBy(xpath="//*[@id=\"emailAddress\"]")
    public WebElement emailAddress;
    static By emailAddressElement = By.xpath("///*[@id=\"emailAddress\"]");

    @FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[5]/div/div/select")
    public WebElement country;
    static By countryElement = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[5]/div/div/select");

    @FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[5]/div/input")
    public WebElement phoneNumber;
    static By phoneNumberElement = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[5]/div/input");


    @FindBy(xpath="//*[@id=\"password\"]")
    public WebElement passWord;
    static By passWordElement = By.xpath("/*[@id=\"password\"]");


    @FindBy(xpath="//*[@id=\"confirmPassword\"]")
    public WebElement confirmPassword;
    static By confirmPassswordElement = By.xpath("//*[@id=\"confirmPassword\"]");


    @FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[8]/button")
    public WebElement continueButton;

    @FindBy(xpath="//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div[1]/h1")
    public WebElement successMessage;


    @FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[1]/div")
    public WebElement businessNameErrorMessage;

    @FindBy(xpath="//*[text()='Passwords must match']")
    public WebElement passwordMatchError;

    static By passwordMatchElement = By.xpath("//*[@id=\"confirmPassword\"]");

    static By successfulSignUp = By.xpath("//*[text()='A link has been sent to your mail, kindly check your email to Activate your account']");

    static By  passwordSspecialCharacter = By.xpath("//*[text()='Password should contain at least one special character']");

    static By  passwordUpperCase = By.xpath("//*[text()='Password should contain at least one uppercase letter(A-Z)']");

    static By  passwordMatch = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[7]/div");


   static By  existingBussinessName = By.xpath("//*[text()='A business with name '%s' already exists']");

   // static By  existingEmailAddress = By.xpath("//*[text()='An account with email \'"+  + "\' already exists']");

    public By getBusinessNameElement() {

        return businessNameElement;
    }

    public By getPasswordMatchErrorElement(){
        return passwordMatchElement;
    }

    public By getSuccessfulSignUp(){
        return successfulSignUp;
    }

    public By getPasswordSspecialCharacter(){
        return passwordSspecialCharacter;
    }

    public By getPasswordUpperCase(){
        return passwordUpperCase;
    }

    public By getPasswordMatch(){
        return passwordMatch;
    }



    public boolean areAllFieldsEnabled() {
        return businessName.isEnabled() &&
                businessAddress.isEnabled() &&
                firstName.isEnabled() &&
                lastName.isEnabled() &&
                emailAddress.isEnabled() &&
                phoneNumber.isEnabled() &&
                passWord.isEnabled() &&
                confirmPassword.isEnabled();
    }

    public void fillAndSubmitSignUpForm22(String businessNameData, String businessAddressData, String firstNameData, String lastNameData, String emailAddressData, String phoneNumberData, String passwd, String confirmpassword) {
        businessName.sendKeys(businessNameData);
        businessAddress.sendKeys(businessAddressData);
        firstName.sendKeys(firstNameData);
        lastName.sendKeys(lastNameData);
        emailAddress.sendKeys(emailAddressData);
        phoneNumber.sendKeys(phoneNumberData);
        passWord.sendKeys(passwd);
        confirmPassword.sendKeys(confirmpassword);

        continueButton.click();
    }


    public void clickContinueButton(){
        continueButton.click();
}

    public String getErrorMessageForBusinessName() {
        return businessNameErrorMessage.getText();
    }


    public By getExistingEmailAddressLocator() {
        String email = config.getTestDataProperty("existingEmail");
        String existingEmailError = "//*[contains(text(), 'An account with email') and contains(text(), '" + email + "')] | //*[contains(text(), 'Customer with email') and contains(text(), '" + email + "')]";
        return By.xpath(existingEmailError);
    }

}
