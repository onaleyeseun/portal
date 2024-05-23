package psb.paymentgateway.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import psb.paymentgateway.pageObjects.BaseClass;

import java.io.File;
import java.io.IOException;

public class ITestListenerClass implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport() {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Add system information/environments info to reports
        reports.setSystemInfo("Machine", "RaviPc");
        reports.setSystemInfo("OS", "Windows11");

        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my first Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Implement any logic you want to perform at the start of each test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of the test method successfully executed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));

        // Capture Screenshot
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver();
        try {
            captureScreenShot(driver, result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        File screenShotFile = new File(screenShotPath);

        if (screenShotFile.exists()) {
            test.fail("Captured Screenshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
        }
    }

    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath = new File("." + "//Screenshots//" + testName + ".png");
        FileUtils.copyFile(src, srcpath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implement any logic you want to perform for tests that fail within the success percentage
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On start method invoked.....");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finished method invoked.....");
        reports.flush(); // It is mandatory to call flush method to ensure information is written to the started reporter
    }
}
