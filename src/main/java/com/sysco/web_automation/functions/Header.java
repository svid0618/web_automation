package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootHeader;

import java.util.Arrays;

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

    public static String getFirstName() {
        return Arrays.asList(athletesFootHeader.getUsername().split(" ")[0])
                .toString().replace("[", "").replace("]", "");
    }

    public static String getLastName() {
        return Arrays.asList(athletesFootHeader.getUsername().split(" ")[1])
                        .toString().replace("[", "").replace("]", "");
    }

    public static String getUsername() {
        return athletesFootHeader.getUsername();
    }

    public static void openSlideBarCart() {
        athletesFootHeader.clickOnSlideBarCart();
    }

    public static void navigateToGivenCategory(String menuItem, String category) {
        athletesFootHeader.clickOnMenuCategory(menuItem);
        athletesFootHeader.clickOnCategory(category);
    }
}
