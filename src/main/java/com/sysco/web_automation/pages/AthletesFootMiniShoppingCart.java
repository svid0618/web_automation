package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootMiniShoppingCart {

    private By btnDelete = By.xpath("//a[@class='action delete']");   //todo check naming conventions
    private By btnClose = By.xpath("//div[@class='close']");
    private By btnViewCart = By.xpath("//span[contains(text(),'View Cart')]/parent::span/parent::a");

    public int getAllDeleteButtonCount() {
        return syscoLabUIOgm.findElements(btnDelete).size();
    }

    public void clickOnDelete() {
        syscoLabUIOgm.clickWithJavascript(btnDelete);
    }

    public void clickOnCloseButton() {
        syscoLabUIOgm.clickWithJavascript(btnClose);
    }

    public void clickOnViewCartButton() {
        syscoLabUIOgm.scrollToElement(btnViewCart);
        syscoLabUIOgm.clickOnVisibleElement(btnViewCart);
    }
}
