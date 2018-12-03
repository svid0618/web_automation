package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootHeader {

    private By lnkLogin = By.xpath("//a[contains(text(),'Login')]");
    private By lnkUsername = By.xpath("//span[@class='name']");
    private By lnkSlideBarCart = By.xpath("//div[@class='minicart-wrapper']");

    private By lnkMenuCategory(String menuCategory) {
        return By.xpath(String.format("//a[@title='%s']", menuCategory));
    }

    private By lnkCategory(String category) {
        return By.xpath(String.format("//a[contains(text(),'%s')]", category));
    }

    public boolean isDisplayedLoginButton() {
        syscoLabUIOgm.waitTillElementLoaded(lnkLogin);
        return syscoLabUIOgm.isDisplayed(lnkLogin);
    }

    public void clickOnLoginButton() {
        syscoLabUIOgm.click(lnkLogin);
    }

    public String getUsername() {
        syscoLabUIOgm.sleep(1);
        return syscoLabUIOgm.getText(lnkUsername);
    }

    public void clickOnSlideBarCart() {
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.click(lnkSlideBarCart);
    }

    public void clickOnMenuCategory(String menuCategory) {
        syscoLabUIOgm.click(this.lnkMenuCategory(menuCategory));
    }

    public void clickOnCategory(String categoryName) {
        syscoLabUIOgm.clickOnVisibleElement(this.lnkCategory(categoryName));
    }
}
