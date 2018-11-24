package com.sysco.web_automation.pages;

import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import static com.sysco.web_automation.pages.AthletesFootMyAccountPage.syscoLabUIOgm;

/**
 * Created by Subodhi on 17/11/18.
 */
public class AthletesFootLoginPage {

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By emailFieldRequiredMsg = By.xpath("//input[@title='Email']/following-sibling::div");
    private By passwordFieldRequiredMsg = By.xpath("//input[@title='Password']/following-sibling::div");
    private By unsuccessfulLoginMsg = By.xpath("//div[@class='page messages']");

    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }

    public void setEmail(String username) {
        syscoLabUIOgm.sendKeys(txtEmail, username);
    }

    public void setPassword(String password) {
        syscoLabUIOgm.sendKeys(txtPassword, password);
    }

    public void clickOnLoginButton() {
        syscoLabUIOgm.click(btnLogin);
    }

    public String getEmailIsRequiredText() {
        return syscoLabUIOgm.getText(emailFieldRequiredMsg);
    }

    public String getPasswordIsRequiredText() {
        return syscoLabUIOgm.getText(passwordFieldRequiredMsg);
    }

    public String getUnsuccessfulLoginText() {
        return syscoLabUIOgm.getText(unsuccessfulLoginMsg);
    }
}
