package org.example.bases;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSpec;
import org.example.utils.BaseFunctions;
import org.example.utils.DriverManager;
import org.example.utils.PropertyManager;

public class TestBase {

    private DriverManager driverManager = new DriverManager();

    @BeforeScenario
    public void setup() {
        driverManager.setWebDriver(PropertyManager.getInstance().getBrowser());
        BaseFunctions.setWebDriver(driverManager.getWebDriver(),  Integer.parseInt(PropertyManager.getInstance().getDefaultTimeout()));
        BaseFunctions.navigateTo(PropertyManager.getInstance().getBaseUrl());
        CustomScreenshotGrabber screenshotGrabber = new CustomScreenshotGrabber(driverManager.getWebDriver());
    }

    @AfterScenario
    public void tearDown() {
        driverManager.getWebDriver().quit();
    }

}
