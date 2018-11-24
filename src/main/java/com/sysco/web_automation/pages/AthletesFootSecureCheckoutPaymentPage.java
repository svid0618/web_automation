package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootSecureCheckoutPaymentPage {

    private By txtCreditCardNumber = By.xpath("//input[@id='credit-card-number']");
    private By frameCreditCardNumber = By.xpath("//*[@id=\"braintree-hosted-field-number\"]");
    private By creditCardFieldRequiredMsg = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By btnPlaceOrder = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");

    private By rdBtnPaymentOption(String option) {
        return By.xpath(String.format("//*[contains(text(),'%s')]/ancestor::label/../input", option));
    }

    public String getEnterValidCreditCardText() {
        return syscoLabUIOgm.getText(creditCardFieldRequiredMsg);
    }

    public void setCreditCardNumberText(String CreditCardNumber) {
        syscoLabUIOgm.switchToFrame(frameCreditCardNumber);
        syscoLabUIOgm.sendKeys(txtCreditCardNumber, CreditCardNumber);
    }

    public void clickOnPlaceOrder() {
        syscoLabUIOgm.click(btnPlaceOrder);
    }

    public void selectPaymentOption(String option) {
        syscoLabUIOgm.clickWithJavascript(this.rdBtnPaymentOption(option));
    }
}
