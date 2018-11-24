package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootMiniShoppingCart;
import com.sysco.web_automation.pages.AthletesFootShoppingCartOverlay;
import com.sysco.web_automation.pages.AthletesFootShoppingCartPage;

/**
 * Created by Subodhi on 17/11/18.
 */
public class ShoppingCart {

    public static AthletesFootShoppingCartPage shoppingCartPage = new AthletesFootShoppingCartPage();

    public static void clickOnSecureCheckout() {
        shoppingCartPage.clickOnSecureCheckoutButton();
    }

    public static String getProductNameByRow(int rowNumber) {
        return shoppingCartPage.getProductNameByRow(rowNumber);
    }

    public static String getProductPriceByRow(int rowNumber) {
        return shoppingCartPage.getProductPriceByRow(rowNumber);
    }
}
