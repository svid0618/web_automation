package com.sysco.web_automation.functions;

import com.sysco.web_automation.common.Constants;
import com.sysco.web_automation.pages.AthletesFootMyAccountPage;
import com.sysco.web_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Subodhi on 17/11/18.
 */
public class MyAccount {

    public static AthletesFootMyAccountPage athletesFootMyAccountPage = new AthletesFootMyAccountPage();

    public static void loadMyAccountPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            athletesFootMyAccountPage.loadMyAccountPage(capabilities, Constants.APP_URL);
        } else {
            athletesFootMyAccountPage.loadMyAccountPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static void quiteDriver() {
        athletesFootMyAccountPage.quitDriver();
    }
}
