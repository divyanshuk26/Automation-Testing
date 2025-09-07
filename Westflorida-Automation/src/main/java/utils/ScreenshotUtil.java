package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String fileName) {
        try {
            // timestamp to avoid overwrite
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // save in reports/screenshots folder
            String destPath = "reports/screenshots/" + fileName + "_" + timestamp + ".png";
            File destFile = new File(destPath);

            destFile.getParentFile().mkdirs(); // folder create if not exist
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
            return destFile.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
