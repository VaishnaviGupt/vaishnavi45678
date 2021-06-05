package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement emailAddressField;
    
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;
    
    @FindBy(xpath = "//i[@class='fa fa-play']")
    WebElement loginButton;
    
    @FindBy(xpath = "//*[text()='Bad credentials']")
    WebElement badCredentialsMessage;
    
    @FindBy(xpath = "//a[normalize-space()='Forgot Password']")
    WebElement forgetPasswordLink;
    
    @FindBy(xpath = "//span[normalize-space()='Remember me']")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[contains(@class,'dropdown-toggle')]")
    WebElement logoutDropDown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    //   private final By rememberMeCheckBox = By.xpath("//span[normalize-space()='Remember me']");

    @Override
    public String getCurrentURL() {
        return super.getCurrentURL();
    }

    @Override
    public String waiteForePageTitle() {
        return super.waiteForePageTitle();
    }

    @SneakyThrows
    public LoginPage setPasswordField(String password) {
        sendKeysToWebElement(passwordField, password, WaitStrategy.PRESENCE);

        return this;
    }

    @SneakyThrows
    public LoginPage setEmailAddressField(String emailId) {
        sendKeysToWebElement(emailAddressField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    public DashboardPage clickLoginButton() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnButton(loginButton);
        return new DashboardPage();
    }

    public boolean isDisplayedBadCredentialsMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, badCredentialsMessage)).isDisplayed();
    }

    public ForgetPasswordPage clickForgotPasswordPage() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnButton(forgetPasswordLink);
        return new ForgetPasswordPage();
    }

    public void clickOnRememberMeButton() {
        clickOnButton(rememberMeCheckBox);
    }

    public void redirectDashboardPage(String emailId, String password) {
        sendKeysToWebElement(emailAddressField, emailId, WaitStrategy.VISIBLE);
        sendKeysToWebElement(passwordField, password, WaitStrategy.PRESENCE);
        clickOnButton(loginButton);
    }

    public LoginPage clickOnLogoutDropDownButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, logoutDropDown)).click();
        return this;
    }

    public void clickOnLogoutButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, logoutButton)).click();
    }


    public void lunchURL() {
        DriverManager.getWebDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
    }


}
