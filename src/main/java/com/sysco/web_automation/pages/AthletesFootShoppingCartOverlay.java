package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootShoppingCartOverlay {

    private By btnOK = By.xpath("//span[contains(text(),'OK')]/..");
    private By lblAttention = By.xpath("//h1[contains(text(),'Attention')]");

    public void clickOnOK() {
        syscoLabUIOgm.click(btnOK);
    }

    public boolean isDisplayedAttentionMessage(){
        if (syscoLabUIOgm.isDisplayed(lblAttention))
            return true;
        else
            return false;
    }
}
