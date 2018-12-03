package com.sysco.web_automation.tests;

import com.sysco.web_automation.data.*;
import com.sysco.web_automation.functions.*;
import com.sysco.web_automation.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
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
        iTestContext.setAttribute("feature", "Online Shopping - Checkout");
        MyAccount.loadMyAccountPage();
        Header.isDisplayedLoginButton();
        Header.navigateToLoginPage();
    }

    @Test(description = "", alwaysRun = true)
    public void testLoginValidation() {
        Login.clickOnLoginButton();
        Assert.assertEquals(Login.getEmailIsRequiredText(), requiredFieldMsg);
        Assert.assertEquals(Login.getPasswordIsRequiredText(), requiredFieldMsg);

        //enter invalid email format
        Login.loginToAthletesFoot(LoginData.invalidEmail, LoginData.invalidPassword);
        Assert.assertEquals(Login.getEmailIsRequiredText(), invalidEmailMsg);

        //enter valid email with wrong password
        Login.loginToAthletesFoot(LoginData.email, LoginData.invalidPassword);
        Assert.assertEquals(Login.getUnsuccessfulLoginText(), unsuccessfulLoginMsg);

        //successful login
        Login.loginToAthletesFoot(LoginData.email, LoginData.password);
        Assert.assertEquals(Header.getUsername(), LoginData.username);

    }

    @Test(description = "", alwaysRun = true, dependsOnMethods = "testLoginValidation")
    public void testRemoveCartItemsIfExists() throws Exception {
        Header.openSlideBarCart();
        MiniShoppingCart.removeAllCartItems();

    }

    @Test(description = "", alwaysRun = true, dependsOnMethods = "testRemoveCartItemsIfExists")
    public void testAddItemAndVerifyCart() throws Exception {
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

    }

    @Test(description = "", alwaysRun = true, dependsOnMethods = "testAddItemAndVerifyCart")
    public void testVerifyAndAddPaymentDetails() throws Exception {
        Assert.assertEquals(Checkout.getFirstName().toUpperCase().trim(), Header.getFirstName());
        Assert.assertEquals(Checkout.getLastName().toUpperCase().trim(), Header.getLastName());

        Checkout.clickOnContinueButton();
        Assert.assertEquals(Checkout.getCityIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPhoneNumberIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getPostCodeIsRequiredText().toUpperCase(), requiredFieldMsg);
        Assert.assertEquals(Checkout.getStateIsRequiredText().toUpperCase(), requiredFieldMsg);
        Checkout.fillMandatoryDeliveryInformation(new CheckoutData());

    }

    @Test(description = "", alwaysRun = true, dependsOnMethods = "testVerifyAndAddPaymentDetails")
    public void testVerifyDeliveryOptions() {
        Assert.assertEquals(Checkout.getDeliveryOptions(), CheckoutData.deliveryOptions);
    }

    @Test(description = "", alwaysRun = true, dependsOnMethods = "testVerifyDeliveryOptions")
    public void verifyCreditCardDetails() {
        Checkout.clickOnContinueButton();
        Checkout.selectPaymentOption(CheckoutData.paymentOption);
        Checkout.fillMandatoryPaymentInformation(new CheckoutData()); //filling invalid details to CC fields
        Checkout.clickOnPlaceOrder();
        Assert.assertEquals(Checkout.getEnterValidCreditCardText().toUpperCase(), invalidCreditCardNumberMsg);
        Assert.assertEquals(Checkout.getEnterValidExpDateTextInYearField().toUpperCase(), invalidExpDateMsg);
        Assert.assertEquals(Checkout.getEnterValidExpDateTextInMonthField().toUpperCase(), invalidExpDateMsg);

    }

    @AfterClass
    public void afterExecution() {
        Checkout.quiteDriver();
    }
}
