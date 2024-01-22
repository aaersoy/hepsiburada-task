package org.example.steps;

import com.thoughtworks.gauge.Step;
import org.example.utils.BaseFunctions;
import org.example.bases.TestBase;
import org.example.repository.Cart;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CartSteps extends TestBase {

    private static final By CART_PAGE_HEADER = By.xpath("//*[@class = \"basket_headerTop_F06D4\"]");
    private static final By PRODUCT_DIV = By.xpath("//*[@class = \"basket_items_3C53o\"]");
    private static final By PRODUCT_PRICE = By.xpath("//*[@class = \"product_price_uXU6Q\"]");
    private static final By PRODUCT_COUNT = By.xpath("//*[@name = \"quantity\"]");
    private static final By PRODUCT_NAME = By.xpath("//*[@class = \"product_name_2Klj3\"]");
    private static final By CART_PRICE = By.xpath("//*[@class = \"total_price_3V-CM\"]");

    @Step("Check cart page and products.")
    public void checkCartPageAndProducts() {
        Assert.assertTrue("Cart page is not loaded", BaseFunctions.checkElementIsVisible(CART_PAGE_HEADER));
        Assert.assertTrue("Product count is not correct.", Cart.getProducts().size() == BaseFunctions.getElements(PRODUCT_DIV).size());

        BaseFunctions.getElements(PRODUCT_DIV).forEach(productDiv -> {
            String productName = productDiv.findElement(PRODUCT_NAME).getText();
            String productPrice = productDiv.findElement(PRODUCT_PRICE).getText();
            String productCount = productDiv.findElement(PRODUCT_COUNT).getAttribute("value");
            Cart.getProducts().forEach(product -> {
                if (product.getName().equals(productName)) {
                    Assert.assertEquals("Product price is not correct.", product.getPrice(), productPrice);
                    Assert.assertEquals("Product count is not correct.", String.valueOf(product.getCount()), productCount);
                }
            });
        });

    }

    @Step("Check total price.")
    public void checkTotalPrice() {
        Assert.assertTrue("Total price is not correct.", (String.valueOf(Cart.getTotalPrice()).replace(".",",") + "\nTL").equals(BaseFunctions.getText(CART_PRICE)));
    }
}
