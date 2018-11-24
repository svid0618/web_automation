package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.AthletesFootCategoryPage;

/**
 * Created by Subodhi on 17/11/18.
 */
public class Category {

    public static AthletesFootCategoryPage athletesFootCategoryPage = new AthletesFootCategoryPage();

    public static void clickOnProduct(String product) throws InterruptedException {
        athletesFootCategoryPage.clickOnProduct(product);
    }
}
