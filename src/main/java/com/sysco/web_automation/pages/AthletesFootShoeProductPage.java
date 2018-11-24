package com.sysco.web_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootShoeProductPage {

    private By btnAddToCart = By.xpath("//button[@title='Add to Cart']");
    private By lblProductName = By.xpath("//span[@data-ui-id='page-title-wrapper']");
    private By lblProductPrice = By.xpath("//div[@class='product-info-price']//span[@class='price']");

    private By optionSize(String size) {//todo naming convention
        return By.xpath(String.format("//div[@option-tooltip-value = '%s']", size));
    }

    public void selectSize(String size) {
        syscoLabUIOgm.clickOnVisibleElement(this.optionSize(size));
    }

    public void clickOnAddToCart() {
        syscoLabUIOgm.click(btnAddToCart);
    }

    public String getProductName(){
        return syscoLabUIOgm.getText(lblProductName);
    }

    public String getProductPrice(){
        return syscoLabUIOgm.getText(lblProductPrice);
    }
}
