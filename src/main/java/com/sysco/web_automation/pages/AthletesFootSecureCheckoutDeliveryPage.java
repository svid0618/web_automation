package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootSecureCheckoutDeliveryPage {

    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By txtFirstName = By.xpath("//input[@name='firstname']");
    private By txtLastName = By.xpath("//input[@name='lastname']");
    private By txtCity = By.xpath("//input[@name='city']");
    private By drpDwnState = By.xpath("//select[@name='region_id']");
    private By txtStreetAddressOne = By.xpath("//input[@name='street[0]']");
    private By txtPostCode = By.xpath("//input[@name='postcode']");
    private By txtPhoneNumber = By.xpath("//input[@name='telephone']");
    private By cityFieldRequiredMsg = By.xpath("//input[@name='city']/following-sibling::div");
    private By stateFieldRequiredMsg = By.xpath("//select[@name='region_id']/following-sibling::div");
    private By postCodeFieldRequiredMsg = By.xpath("//input[@name='postcode']/following-sibling::div");
    private By phoneNumberFieldRequiredMsg = By.xpath("//input[@name='telephone']/../div[2]/span");

    private By drpDwnPostCode(String descriptivePostCode) {
        return By.xpath(String.format("//a[contains(text(),'%s')]/parent::li", descriptivePostCode));
    }

    public void clickOnContinueButton() {
        syscoLabUIOgm.waitTillElementLoaded(btnContinue);
        syscoLabUIOgm.clickWithJavascript(btnContinue);
    }

    public String getFirstNameText() {
        return syscoLabUIOgm.getAttribute(txtFirstName, "value");
    }

    public String getLastNameText() {
        return syscoLabUIOgm.getAttribute(txtLastName, "value");
    }

    public void setCity(String city) {
        syscoLabUIOgm.sendKeys(txtCity, city);
    }

    public void setState(String state) {
        syscoLabUIOgm.selectFromDropDown(drpDwnState, state);
    }

    public void setPhoneNumber(String phoneNumber) {
        syscoLabUIOgm.sendKeys(txtPhoneNumber, phoneNumber);
    }

    public void setStreetAddressOne(String streetAddressOne) {
        syscoLabUIOgm.sendKeys(txtStreetAddressOne, streetAddressOne);
    }

    public void selectPostCode(String descriptivePostCode) {
        syscoLabUIOgm.waitTillElementLoaded(this.drpDwnPostCode(descriptivePostCode));
        syscoLabUIOgm.click(this.drpDwnPostCode(descriptivePostCode));
    }
    public void setPostCode(String postCode) {
        syscoLabUIOgm.sendKeys(txtPostCode, postCode);
    }

    public String getCityIsRequiredText() {
        return syscoLabUIOgm.getText(cityFieldRequiredMsg);
    }

    public String getStateIsRequiredText() {
        return syscoLabUIOgm.getText(stateFieldRequiredMsg);
    }

    public String getPostCodeIsRequiredText() {
        return syscoLabUIOgm.getText(postCodeFieldRequiredMsg);
    }

    public String getPhoneNumberIsRequiredText() {
        return syscoLabUIOgm.getText(phoneNumberFieldRequiredMsg);
    }
}
