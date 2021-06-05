package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import com.amcicustomer.reporter.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ForgetPasswordPage extends BasePage {
    public ForgetPasswordPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    @FindBy(xpath = "//*[text()='Forgot Password ']")
    WebElement forgetPasswordPageTitle;
   // private final static By forgetPasswordPageTitle = By.xpath("//*[text()='Forgot Password ']");
    @FindBy(xpath = "//input[@placeholder='Email']")
   WebElement emailAddressField;
  //  private final static By emailAddressField = By.xpath("//input[@placeholder='Email']");
    @FindBy(xpath = "//*[text()='Reset Password link has been sent to your email, Please check.']")
    WebElement resetPasswordMessage;
  //  private final By resetPasswordMessage = By.xpath("//*[text()='Reset Password link has been sent to your email, Please check.']");
    @FindBy(xpath = "//i[@class='fa fa-play']")
  WebElement forgotPasswordButton;
  //  private final By forgotPasswordButton = By.xpath("//i[@class='fa fa-play']");
    @FindBy(xpath = "//h2[@id='swal2-title']")
  WebElement forgetPasswordInvalidEmailIdMessage;
 //   private final By forgetPasswordInvalidEmailIdMessage = By.xpath("//h2[@id='swal2-title']");





    public boolean isDisplayedForgetPasswordPageTitle(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, forgetPasswordPageTitle)).isDisplayed();
    }
    public ForgetPasswordPage setEmailAddressFieldForgetPage(String emailId){
        sendKeysToWebElement(emailAddressField,emailId,WaitStrategy.PRESENCE);
        return this;
    }
    public boolean isDisplayedResetPasswordMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, resetPasswordMessage)).isDisplayed();
    }
    public ForgetPasswordPage clickForgetPasswordButton(){
        clickOnButton(forgotPasswordButton);

        return this;
    }
    public boolean isDisplayedInvalidEmailIdMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, forgetPasswordInvalidEmailIdMessage)).isDisplayed();
    }


}
