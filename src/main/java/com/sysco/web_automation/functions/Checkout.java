package com.sysco.web_automation.functions;

import com.sysco.web_automation.data.CheckoutData;
import com.sysco.web_automation.pages.AthletesFootSecureCheckoutDeliveryPage;
import com.sysco.web_automation.pages.AthletesFootSecureCheckoutPaymentPage;

/**
 * Created by Subodhi on 17/11/18.
 */
public class Checkout {

    public static AthletesFootSecureCheckoutDeliveryPage deliveryPage = new AthletesFootSecureCheckoutDeliveryPage();
    public static AthletesFootSecureCheckoutPaymentPage paymentPage = new AthletesFootSecureCheckoutPaymentPage();

    public static void clickOnContinueButton() {
        deliveryPage.clickOnContinueButton();
    }

    public static String getCityIsRequiredText() {
        return deliveryPage.getCityIsRequiredText();
    }

    public static String getStateIsRequiredText() {
        return deliveryPage.getStateIsRequiredText();
    }

    public static String getPostCodeIsRequiredText() {
        return deliveryPage.getPostCodeIsRequiredText();
    }

    public static String getPhoneNumberIsRequiredText() {
        return deliveryPage.getPhoneNumberIsRequiredText();
    }

    public static void fillMandatoryDeliveryInformation(CheckoutData checkoutData) {
        deliveryPage.setStreetAddressOne(checkoutData.streetOne);
        deliveryPage.setPostCode(checkoutData.postCode);
        deliveryPage.selectPostCode(checkoutData.descriptivePostCode);
        deliveryPage.setPhoneNumber(checkoutData.phoneNumber);
    }

    public static void selectPaymentOption(String option) {
        paymentPage.selectPaymentOption(option);
    }

    public static void setCreditCardNumber(String creditCardNumber) {
        paymentPage.setCreditCardNumberText(creditCardNumber);
    }

    public static void clickOnPlaceOrder() {
        paymentPage.clickOnPlaceOrder();
    }

    public static String getEnterValidCreditCardText() {
        return paymentPage.getEnterValidCreditCardText();
    }

    public static String getFirstName() {
        return deliveryPage.getFirstNameText();
    }

    public static String getLastName() {
        return deliveryPage.getLastNameText();
    }
}
