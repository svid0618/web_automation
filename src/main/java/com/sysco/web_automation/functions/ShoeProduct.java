package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootShoeProductPage;

/**
 * Created by Subodhi on 17/11/18.
 */
public class ShoeProduct {

    public static AthletesFootShoeProductPage shoeProductPage = new AthletesFootShoeProductPage();

    public static void addProductToCart(String size) {
        shoeProductPage.selectSize(size);
        shoeProductPage.clickOnAddToCart();
    }

    public static String getProductName() {
        return shoeProductPage.getProductName();
    }

    public static String getProductPrice() {
        return shoeProductPage.getProductPrice();
    }
}
