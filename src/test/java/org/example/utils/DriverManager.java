package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private WebDriver webDriver;

    public void setWebDriver(String browser) {

        switch (browser) {
            case "chrome":
                setChromeDriver();
                break;
            case "firefox":
                setFirefoxDriver();
                break;
            default:
                setChromeDriver();
                break;
        }
    }

    private void setChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(options);
    }

    private void setFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();

        webDriver = new FirefoxDriver(options);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
