package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootHeader;

/**
 * Created by Subodhi on 17/11/18.
 */
public class Header {

    public static AthletesFootHeader athletesFootHeader = new AthletesFootHeader();

    public static void isDisplayedLoginButton() {
        athletesFootHeader.isDisplayedLoginButton();
    }

    public static void navigateToLoginPage() {
        athletesFootHeader.clickOnLoginButton();
    }

    public static String getUsername() {
       return athletesFootHeader.getUsername();
    }

    public static void openSlideBarCart() {
        athletesFootHeader.clickOnSlideBarCart();
    }

    public static void navigateToGivenCategory(String category, String subCategory) {//todo names variable
        athletesFootHeader.clickOnMenuCategory(category);
        athletesFootHeader.clickOnCategory(subCategory);
    }
}
