package org.example.bases;

import com.thoughtworks.gauge.screenshot.CustomScreenshotWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class CustomScreenshotGrabber implements CustomScreenshotWriter {
    private WebDriver driver;

    public CustomScreenshotGrabber(WebDriver driver) {
        this.driver = driver;
    }

    // Return a screenshot file name
    @Override
    public String takeScreenshot() {
        TakesScreenshot driver = (TakesScreenshot) this.driver;
        String screenshotFileName = String.format("screenshot-%s.png", UUID.randomUUID().toString());
        try {
            Files.write(Path.of(System.getenv("gauge_screenshots_dir"), screenshotFileName),
                    driver.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFileName;
    }
}
