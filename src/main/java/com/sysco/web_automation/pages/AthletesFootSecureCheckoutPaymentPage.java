package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootSecureCheckoutPaymentPage {

    private By txtCreditCardNumber = By.xpath("//input[@id='credit-card-number']");
    private By txtExpMonth = By.xpath("//input[@id='expiration-month']");
    private By txtExpYear = By.xpath("//input[@id='expiration-year']");
    private By txtCvv = By.xpath("//input[@id='cvv']");
    private By frameCreditCardNumber = By.xpath("//*[@id=\"braintree-hosted-field-number\"]");
    private By frameExpMonth = By.xpath("//*[@id='braintree-hosted-field-expirationMonth']");
    private By frameExpYear = By.xpath("//*[@id='braintree-hosted-field-expirationYear']");
    private By frameCvv = By.xpath("//*[@id='braintree-hosted-field-cvv']");
    private By enterValidCreditCardMsg = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By enterValidExpDateMsgInMonthFiled = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By enterValidExpDateMsgInYearFiled = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[2]/div[2]/span");
    private By btnPlaceOrder = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");

    private By rdBtnPaymentOption(String option) {
        return By.xpath(String.format("//*[contains(text(),'%s')]/ancestor::label/../input", option));
    }

    public void setCreditCardNumberText(String CreditCardNumber) {
        syscoLabUIOgm.switchToFrame(frameCreditCardNumber);
        syscoLabUIOgm.sendKeys(txtCreditCardNumber, CreditCardNumber);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void setExpirationMonth(String month) {
        syscoLabUIOgm.switchToFrame(frameExpMonth);
        syscoLabUIOgm.sendKeys(txtExpMonth, month);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void setExpirationYear(String year) {
        syscoLabUIOgm.switchToFrame(frameExpYear);
        syscoLabUIOgm.sendKeys(txtExpYear, year);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void setCvv(String cvv) {
        syscoLabUIOgm.switchToFrame(frameCvv);
        syscoLabUIOgm.sendKeys(txtCvv, cvv);
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public String getEnterValidCreditCardText() {
        return syscoLabUIOgm.getText(enterValidCreditCardMsg);
    }

    public String getEnterValidExpDateTextInMonthField() {
        return syscoLabUIOgm.getText(enterValidExpDateMsgInMonthFiled);
    }

    public String getEnterValidExpDateTextInYearField() {
        return syscoLabUIOgm.getText(enterValidExpDateMsgInYearFiled);
    }

    public void clickOnPlaceOrder() {
        syscoLabUIOgm.click(btnPlaceOrder);
    }

    public void selectPaymentOption(String option) {
        syscoLabUIOgm.clickWithJavascript(this.rdBtnPaymentOption(option));
    }
}
