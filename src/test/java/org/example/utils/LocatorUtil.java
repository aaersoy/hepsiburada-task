package org.example.utils;

import org.example.enums.Locator;
import org.openqa.selenium.By;

public class LocatorUtil {

    public static By generateLocator(String value, Locator type) {
        switch (type) {
            case ID:
                return By.id(value);
            case CLASS:
                return By.className(value);
            case XPATH:
                return By.xpath(value);
            case CSS:
                return By.cssSelector(value);
            case LINK_TEXT:
                return By.linkText(value);
            case NAME:
                return By.name(value);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(value);
            case TAG_NAME:
                return By.tagName(value);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + type);
        }
    }
}
