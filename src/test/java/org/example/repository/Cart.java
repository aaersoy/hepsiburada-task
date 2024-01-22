package org.example.repository;

import org.example.modal.Product;

import java.util.ArrayList;

public class Cart {

    private static ArrayList<Product> products = new ArrayList<>();
    private static double totalPrice = 0.00;

    public static void addProduct(Product product) {
        totalPrice += convertPriceToDouble(product.getPrice());

        Product productInCart = getProductIfItIsExistedInCart(product);

        if(productInCart != null) {
            productInCart.setCount(product.getCount() + 1);
            return;
        }else{
            product.setCount(1);
            products.add(product);
        }
    }

    public static void removeProduct(Product product) {
        products.remove(product);
    }

    public static void clearCart() {
        products.clear();
        totalPrice = 0.00;
    }

    private static double convertPriceToDouble(String price) {
        price = price.replace("TL", "");
        price = price.replace(",", ".");
        double priceDouble = Double.parseDouble(price);

        return priceDouble;
    }

    private static Product getProductIfItIsExistedInCart(Product product) {
        for (Product productInCart : products) {
            if (productInCart.getName().equals(product.getName())) {
                return productInCart;
            }
        }
        return null;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }
}
