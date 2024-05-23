package psb.paymentgateway.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    //constructor
    public LoginPage(WebDriver lDriver)
    {
        this.driver=lDriver;

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/p/a")
    public WebElement signUpLink;

    @FindBy(xpath="//*[@id=\"businessName\"]")
    public WebElement businessName;
    static By businessNameLocat = By.xpath("//*[@id=\"businessName\"]");


    public static By businessNameLocator() {

        return businessNameLocat;
    }



    public void verifySignUpLink() {
        // TODO Auto-generated method stub
       signUpLink.click();

    }




}
