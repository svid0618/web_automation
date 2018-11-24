package com.sysco.web_automation.tests;

import com.sysco.web_automation.data.*;
import com.sysco.web_automation.functions.*;
import com.sysco.web_automation.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class LoginTest extends TestBase {

    private String requiredFieldMsg = "THIS IS A REQUIRED FIELD.";// can be finale?
    private String invalidEmailMsg = "PLEASE ENTER A VALID EMAIL ADDRESS (EX: JOHNDOE@DOMAIN.COM).";
    private String unsuccessfulLoginMsg = "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.";
    private String invalidCreditCardNumberMsg = "PLEASE, ENTER VALID CREDIT CARD NUMBER";

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
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
        Login.loginToAthletesFoot("abcd", "password");
        Assert.assertEquals(Login.getEmailIsRequiredText(), invalidEmailMsg, "");

        //enter valid email with wrong password
        Login.loginToAthletesFoot("williamjacob802@gmail.com", "password");
        Assert.assertEquals(Login.getUnsuccessfulLoginText(), unsuccessfulLoginMsg, "");

    }
/*
    @Test(description = "", alwaysRun = true)
    public void testPlaceOrder() throws Exception {
        Login.loginToAthletesFoot(LoginData.email, LoginData.password);
        Assert.assertEquals(Header.getUsername(), LoginData.username);
        Header.openSlideBarCart();
        MiniShoppingCart.removeAllCartItems();

        Header.navigateToGivenCategory(HeaderData.category, HeaderData.subcategory);
        Category.clickOnProduct(CategoryData.productName);
        ShoeProduct.addProductToCart(ShoeProductData.size);
        String productName = ShoeProduct.getProductName();
        String productPrice = ShoeProduct.getProductPrice();

        Header.openSlideBarCart();
        MiniShoppingCart.clickOnViewCart();
        Assert.assertEquals(ShoppingCart.getProductNameByRow(1), productName);
        Assert.assertEquals(ShoppingCart.getProductPriceByRow(1), productPrice);
        ShoppingCart.clickOnSecureCheckout();

        Assert.assertEquals(Checkout.getFirstName().toUpperCase(),
                Arrays.asList(Header.getUsername().split(" ")[0]));
        Assert.assertEquals(Checkout.getLastName().toUpperCase(),
                Arrays.asList(Header.getUsername().split(" ")[1]));

        Checkout.clickOnContinueButton();
        Assert.assertEquals(Checkout.getCityIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPhoneNumberIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPostCodeIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getStateIsRequiredText().toUpperCase(), requiredFieldMsg);
        Checkout.fillMandatoryDeliveryInformation(new CheckoutData());

        Checkout.clickOnContinueButton();
        Checkout.selectPaymentOption(CheckoutData.paymentOption);
        Checkout.setCreditCardNumber(CheckoutData.creditCardNumber);
        Checkout.clickOnPlaceOrder();
        Assert.assertEquals(Checkout.getEnterValidCreditCardText().toUpperCase(), invalidCreditCardNumberMsg);
    }*/
}
