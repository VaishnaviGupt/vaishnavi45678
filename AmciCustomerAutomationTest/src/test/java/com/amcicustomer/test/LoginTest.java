package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.ForgetPasswordPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.reporter.ExtentLogger;
import com.amcicustomer.utils.PropertyUtils;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public final class LoginTest extends BaseTest {
    LoginPage loginPage;
    ForgetPasswordPage forgetPasswordPage;


    private LoginTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        forgetPasswordPage = new ForgetPasswordPage();

    }

    @Test
    public void TheClientURLOfDemoEnvironmentTest() {
        Assertions.assertThat(loginPage.getCurrentURL()).isEqualTo(PropertyUtils.getValue(ConfigProperties.URL));
        ExtentLogger.passLog("User is able to redirect login page and Login page is open");
        Assertions.assertThat(loginPage.waiteForePageTitle()).isEqualTo(PropertyUtils.getValue(ConfigProperties.PAGETITLE));
        ExtentLogger.passLog("Login page title is displaying");

    }

    @Test(priority = 1)
    public void LoginThroughValidUsernameAndPasswordTest() {
        DashboardPage dashboardPage = loginPage.setEmailAddressField(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID)).
                setPasswordField(PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD)).clickLoginButton();
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assertions.assertThat(loginPage.getCurrentURL()).isEqualTo(PropertyUtils.getValue(ConfigProperties.DASHBOARDURL));
        ExtentLogger.passLog("User is able to redirect on dashboard page");
        loginPage.clickOnLogoutDropDownButton().clickOnLogoutButton();
    }

    @Test(priority = 2)
    public void LoginThroughValidUsernameAndInvalidPasswordTest() {
        loginPage.setEmailAddressField(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID)).
                setPasswordField(FrameWorkConstants.getINVALIDPASSWORD()).clickLoginButton();
        Assert.assertTrue(loginPage.isDisplayedBadCredentialsMessage());
        ExtentLogger.passLog("An error message is displayed as “Bad Credentials” on the Login page");
    }

    @Test(priority = 3)
    public void LoginThroughInvalidUsernameAndValidPasswordTest() {
        loginPage.setEmailAddressField(FrameWorkConstants.getINVLIDEMAILID()).
                setPasswordField(PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD)).clickLoginButton();
        Assert.assertTrue(loginPage.isDisplayedBadCredentialsMessage());
        ExtentLogger.passLog("An error message is displayed as “Bad Credentials” on the Login page");
    }

    @Test(priority = 4)
    public void LoginThroughInvalidUserNameAndInvalidPasswordTest() {
        loginPage.setEmailAddressField(FrameWorkConstants.getINVLIDEMAILID()).
                setPasswordField(FrameWorkConstants.getINVALIDPASSWORD()).clickLoginButton();
        Assert.assertTrue(loginPage.isDisplayedBadCredentialsMessage());
        ExtentLogger.passLog("An error message is displayed as “Bad Credentials” on the Login page");
    }

    @Test(priority = 5)
    public void ForgotPasswordPageNavigationTest() {
        Assert.assertTrue(loginPage.clickForgotPasswordPage().isDisplayedForgetPasswordPageTitle());
        Assertions.assertThat(loginPage.getCurrentURL()).isEqualTo(FrameWorkConstants.getFORGETPASSWORDURL());
        ExtentLogger.passLog("User is able to redirect to “Reset Password” page.");
    }

    @Test(priority = 6)
    public void ForgotPasswordWithValidEmailTest() {
        Assert.assertTrue(forgetPasswordPage.
                setEmailAddressFieldForgetPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID)).
                clickForgetPasswordButton().isDisplayedResetPasswordMessage());
        Assertions.assertThat(loginPage.getCurrentURL()).isEqualTo(PropertyUtils.getValue(ConfigProperties.URL));
        ExtentLogger.passLog("User is able to redirect to Login page with message “Reset Password link has been sent to your email, please check.");
    }

    @Test(priority = 7)
    public void ForgotPasswordWithInvalidEmailTest(){
        Assert.assertTrue(loginPage.clickForgotPasswordPage().setEmailAddressFieldForgetPage(FrameWorkConstants.getINVLIDEMAILID()).clickForgetPasswordButton().isDisplayedInvalidEmailIdMessage());
    }




}
