package com.sysco.web_automation.tests;

import com.sysco.web_automation.data.*;
import com.sysco.web_automation.functions.*;
import com.sysco.web_automation.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {

    private String requiredFieldMsg = "THIS IS A REQUIRED FIELD.";
    private String invalidEmailMsg = "PLEASE ENTER A VALID EMAIL ADDRESS (EX: JOHNDOE@DOMAIN.COM).";
    private String unsuccessfulLoginMsg = "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.";
    private String invalidCreditCardNumberMsg = "PLEASE, ENTER VALID CREDIT CARD NUMBER";
    private String invalidExpDateMsg = "PLEASE, ENTER VALID EXPIRATION DATE";

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - Checkout_SS");
        MyAccount.loadMyAccountPage();
        Header.isDisplayedLoginButton();
        Header.navigateToLoginPage();
    }

    @Test(description = "", alwaysRun = true)
    public void testLoginValidation() {

        Login.clickOnLoginButton();
        Assert.assertEquals(Login.getEmailIsRequiredText(), requiredFieldMsg, "");
        Assert.assertEquals(Login.getPasswordIsRequiredText(), requiredFieldMsg, "");
        //enter invalid email format
        Login.loginToAthletesFoot(LoginData.invalidEmail, LoginData.invalidPassword);
        Assert.assertEquals(Login.getEmailIsRequiredText(), invalidEmailMsg, "");

        //enter valid email with wrong password
        Login.loginToAthletesFoot(LoginData.email, LoginData.invalidPassword);
        Assert.assertEquals(Login.getUnsuccessfulLoginText(), unsuccessfulLoginMsg, "");

    }

    @Test(description = "", alwaysRun = true)
    public void testPlaceOrder() throws Exception {
        Login.loginToAthletesFoot(LoginData.email, LoginData.password);
        Assert.assertEquals(Header.getUsername(), LoginData.username);
        Header.openSlideBarCart();
        MiniShoppingCart.removeAllCartItems();

        Header.navigateToGivenCategory(HeaderData.category, HeaderData.subcategory);
        Category.clickOnProduct(CategoryData.productName);
        ShoeProduct.addProductToCart(ShoeProductData.size);

        Header.openSlideBarCart();
        MiniShoppingCart.clickOnViewCart();
        Assert.assertEquals(ShoppingCart.getProductNameByRow(1), ShoeProduct.getProductName());
        Assert.assertEquals(ShoppingCart.getProductPriceByRow(1), ShoeProduct.getProductPrice());
        ShoppingCart.clickOnSecureCheckout();

        Assert.assertEquals(Checkout.getFirstName().toUpperCase().trim(), Header.getFirstName());
        Assert.assertEquals(Checkout.getLastName().toUpperCase().trim(), Header.getLastName());

        Checkout.clickOnContinueButton();
        Assert.assertEquals(Checkout.getCityIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPhoneNumberIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPostCodeIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getStateIsRequiredText().toUpperCase(), requiredFieldMsg);
        Checkout.fillMandatoryDeliveryInformation(new CheckoutData());

        Checkout.clickOnContinueButton();
        Checkout.selectPaymentOption(CheckoutData.paymentOption);
        Checkout.fillMandatoryPaymentInformation(new CheckoutData());
        Checkout.clickOnPlaceOrder();
        Assert.assertEquals(Checkout.getEnterValidCreditCardText().toUpperCase(), invalidCreditCardNumberMsg);
        Assert.assertEquals(Checkout.getEnterValidExpDateTextInYearField().toUpperCase(), invalidExpDateMsg);
        Assert.assertEquals(Checkout.getEnterValidExpDateTextInMonthField().toUpperCase(), invalidExpDateMsg);
    }
}
