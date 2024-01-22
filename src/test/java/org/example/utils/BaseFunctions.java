package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BaseFunctions {

    public static WebDriver webDriver;
    protected static WebDriverWait wait;

    public static void setWebDriver(WebDriver webDriver, int explicitWait) {
        BaseFunctions.webDriver = webDriver;
        BaseFunctions.wait = new WebDriverWait(webDriver, Duration.of(explicitWait, SECONDS));
    }

    public static void click(By element) {
        webDriver.findElement(element).click();
    }

    public static void navigateTo(String url) {
        webDriver.get(url);
    }

    public static boolean checkElementIsVisible(By element) {
        try {
            return wait.until(driver -> driver.findElement(element).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public static String getText(By element) {
        return webDriver.findElement(element).getText();
    }

    public static void clickByIndex(By element, int index) {
        webDriver.findElements(element).get(index).click();
    }

    public static void switchToNewTab() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }

    public static void refreshPage() {
        webDriver.navigate().refresh();
    }

    public static List<WebElement> getElements(By element) {
        return webDriver.findElements(element);
    }

    public static boolean waitElementToBeClickable(By element) {
        return wait.until(driver -> driver.findElement(element).isDisplayed());
    }
}
