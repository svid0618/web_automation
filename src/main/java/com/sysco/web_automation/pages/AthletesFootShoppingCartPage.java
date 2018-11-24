package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootShoppingCartPage {

    private By btnSecureCheckout = By.xpath("//button[@data-role='proceed-to-checkout']");

    private By lnkProductName(int rowNumber) {
        return By.xpath(String.format("//table[@id='shopping-cart-table']//tr[%s]//strong", rowNumber));
    }

    private By lnkProductPrice(int rowNumber) {
        return By.xpath(String.format("//table[@id='shopping-cart-table']//tr[%s]//span[@class='price']", rowNumber));
    }

    public void clickOnSecureCheckoutButton() {
        syscoLabUIOgm.click(btnSecureCheckout);
    }

    public String getProductNameByRow(int rowNumber) {
        return syscoLabUIOgm.getText(lnkProductName(rowNumber));
    }

    public String getProductPriceByRow(int rowNumber) {
        return syscoLabUIOgm.getText(lnkProductPrice(rowNumber));
    }
}
