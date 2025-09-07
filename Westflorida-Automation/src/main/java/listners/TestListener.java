package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import config.ConfigReader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReporter();
    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ConfigReader.loadConfig();
        System.out.println("=== Test Suite Started ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Test Suite Finished ===");
        extent.flush();  // Write the report to disk
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTING TEST: " + result.getName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
        testReport.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());
        testReport.get().fail(result.getThrowable());

        try {
            base.BaseTest testClass = (base.BaseTest) result.getInstance();
            WebDriver driver = testClass.getDriver();   //getter se driver milega

            String screenshotPath = utils.ScreenshotUtil.takeScreenshot(driver, result.getName());

            if (screenshotPath != null) {
                testReport.get().addScreenCaptureFromPath(screenshotPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
        testReport.get().skip("Test skipped");
    }
}
