package org.example.steps;

import com.thoughtworks.gauge.Step;
import org.example.utils.BaseFunctions;
import org.example.enums.Locator;
import org.example.utils.LocatorUtil;
import org.example.bases.TestBase;
import org.openqa.selenium.By;

public class HomePageSteps extends TestBase {

    private String CATEGORY = "//*[@class=\"treeCategoryContent-XPVj5InCxOWIJtyTC35Z\" and text()=\"%s\"]";
    private By ACCEPT_BUTTON = By.xpath("//*[@id = \"onetrust-button-group\"]//*[@id = \"onetrust-accept-btn-handler\"]");

    @Step("Select <category> category.")
    public void selectCategory(String category) {
        BaseFunctions.click(LocatorUtil.generateLocator(String.format(CATEGORY, "Pet Shop"), Locator.XPATH));
        BaseFunctions.refreshPage();
    }

    @Step("Accept cookies.")
    public void acceptCookies() {
        if (BaseFunctions.checkElementIsVisible(ACCEPT_BUTTON)){
            BaseFunctions.click(ACCEPT_BUTTON);
        }
    }
}
