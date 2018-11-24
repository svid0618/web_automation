package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootCategoryPage {

    private By lnkProduct(String productName) {
        return By.xpath(String.format("//a[contains(text(),'%s')]", productName));
    }

    public void clickOnProduct(String productName) throws InterruptedException {
        syscoLabUIOgm.scrollToElement(this.lnkProduct(productName));
        Thread.sleep(2000);
        syscoLabUIOgm.clickWithJavascript(this.lnkProduct(productName));
    }
}
