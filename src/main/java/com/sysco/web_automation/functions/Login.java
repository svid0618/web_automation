package com.sysco.web_automation.functions;

import com.sysco.web_automation.common.Constants;
import com.sysco.web_automation.pages.AthletesFootLoginPage;
import com.sysco.web_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Subodhi on 17/11/18.
 */
public class Login {

    public static AthletesFootLoginPage athletesFootLoginPage = new AthletesFootLoginPage();

    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            athletesFootLoginPage.loadLoginPage(capabilities, Constants.APP_URL + "");
        } else {
            athletesFootLoginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static void quiteDriver() {
        athletesFootLoginPage.quitDriver();
    }

    public static void clickOnLoginButton() {
        athletesFootLoginPage.clickOnLoginButton();
    }

    public static void loginToAthletesFoot(String email, String password) {
        athletesFootLoginPage.setEmail(email);
        athletesFootLoginPage.setPassword(password);
        athletesFootLoginPage.clickOnLoginButton();
    }

    public static String getEmailIsRequiredText() {
        return athletesFootLoginPage.getEmailIsRequiredText();
    }

    public static String getPasswordIsRequiredText() {
        return athletesFootLoginPage.getPasswordIsRequiredText();
    }

    public static String getUnsuccessfulLoginText() {
        return athletesFootLoginPage.getUnsuccessfulLoginText();
    }
}
