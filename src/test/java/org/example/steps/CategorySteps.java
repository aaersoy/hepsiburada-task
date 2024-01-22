package org.example.steps;

import com.thoughtworks.gauge.Step;
import org.example.utils.BaseFunctions;
import org.example.bases.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CategorySteps extends TestBase {

    private static final By CATEGORY_FILTER = By.xpath("//*[@class = \"treeCategoryContent-XPVj5InCxOWIJtyTC35Z treeCategoryContent-MyO6mtk47l73JXmpol8O\"]");
    private static final By PRODUCT = By.xpath("//*[@class = \"productListContent-zAP0Y5msy8OHn5z7T_K_\"]");

    @Step("Check <category> page and select <indexOfElement> th element.")
    public void checkCategoryPageAndSelectElement(String category, int indexOfElement){
        Assert.assertTrue("Category page is not loaded.", BaseFunctions.checkElementIsVisible(CATEGORY_FILTER));
        Assert.assertEquals("Category is not shown correctly.", category, BaseFunctions.getText(CATEGORY_FILTER));
        BaseFunctions.clickByIndex(PRODUCT, indexOfElement - 1);
    }
}
