package psb.paymentgateway.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl)
    {

        if(browserName.equals("Chrome"))
        {
            // Use WebDriverManager to setup the ChromeDriver
            WebDriverManager.chromedriver().setup();

// Create a new ChromeDriver object
             driver = new ChromeDriver();
        }
        else if(browserName.equals("Firefox"))
        {
               //driver = new FirefoxDriver();
        }
        else if(browserName.equals("IE"))
        {
            //driver = new InternetExplorerDriver();
        }
        else
        {
            System.out.println("We do not support this browser ");
        }


        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;

    }

    public static void quitBrowser(WebDriver driver)
    {
        driver.quit();
    }

}
