package org.example.steps;

import com.thoughtworks.gauge.Step;
import org.example.utils.BaseFunctions;
import org.example.bases.TestBase;
import org.example.modal.Product;
import org.example.repository.Cart;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductSteps extends TestBase {

    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[@class = \"product-variants-content add-to-cart-content\"]//*[@class = \"addToCartButton\"]");
    private static final By PRODUCT_NAME = By.xpath("//*[@class = \"product-name best-price-trick\"]");
    private static final By PRODUCT_PRICE = By.xpath("//*[@class = \"price merchant price-new-old\"]");
    private static final By CART_POPUP_CLOSE_BUTTON = By.xpath("//*[@class = \"checkoutui-Modal-iHhyy79iR28NvF33vKJb\"]");
    private static final By CART_BUTTON = By.xpath("//*[@class = \"sf-OldMyAccount-MjrNQp_LLdAaN1g0xvSz sf-OldMyAccount-VcxldoRSjUmlWBLJaTly\"]");

    @Step("Check product page and add product to basket.")
    public void checkProductPageAndAddProductToBasket() {
        BaseFunctions.switchToNewTab();
        Assert.assertTrue("Product page is not loaded.", BaseFunctions.checkElementIsVisible(ADD_TO_CART_BUTTON));
        BaseFunctions.click(ADD_TO_CART_BUTTON);
        Assert.assertTrue("Cart popup is not shown", BaseFunctions.checkElementIsVisible(CART_POPUP_CLOSE_BUTTON));
        BaseFunctions.click(CART_POPUP_CLOSE_BUTTON);
        String productName = BaseFunctions.getText(PRODUCT_NAME);
        String productPrice = BaseFunctions.getText(PRODUCT_PRICE);
        Product product = new Product(productName, productPrice);
        Cart.addProduct(product);
    }

    @Step("Go to cart page.")
    public void goToCartPage() {
        BaseFunctions.click(CART_BUTTON);
    }
}
