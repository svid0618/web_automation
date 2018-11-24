package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootMiniShoppingCart;
import com.sysco.web_automation.pages.AthletesFootShoppingCartOverlay;

/**
 * Created by Subodhi on 17/11/18.
 */
public class MiniShoppingCart {

    public static AthletesFootMiniShoppingCart miniShoppingCart = new AthletesFootMiniShoppingCart();
    public static AthletesFootShoppingCartOverlay shoppingCartOverlay = new AthletesFootShoppingCartOverlay();

    public static void removeAllCartItems() {
        if (miniShoppingCart.getAllDeleteButtonCount() != 0) {
            while (miniShoppingCart.getAllDeleteButtonCount() > 0) {
                miniShoppingCart.clickOnDelete();
                if (shoppingCartOverlay.isDisplayedAttentionMessage()) {
                    shoppingCartOverlay.clickOnOK();
                }
                shoppingCartOverlay.clickOnOK();
                miniShoppingCart.clickOnCloseButton();
                            }
        } else {
            miniShoppingCart.clickOnCloseButton();
        }
    }

    public static void clickOnViewCart() {
        miniShoppingCart.clickOnViewCartButton();
    }
}
