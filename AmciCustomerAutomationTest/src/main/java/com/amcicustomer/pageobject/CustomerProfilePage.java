package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomerProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Settings']")
    WebElement settingsButton;

    @FindBy(xpath = "//a[normalize-space()='Customer Profile']")
    WebElement customerProfileButton;

    @FindBy(xpath = "//h3[normalize-space()='Customer Profile']")
    WebElement customerProfilePageTitle;

    @FindBy(xpath = "//*[text()=' Customer Name']")
    WebElement customerNameText;

    @FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
    WebElement customerNameField;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    WebElement emailText;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//label[normalize-space()='Country']")
    WebElement countryText;

    @FindBy(xpath = "//select[@name='Country']")
    WebElement countryDropDown;

    @FindBy(xpath = "//label[normalize-space()='State']")
    WebElement stateText;

    @FindBy(xpath = "//select[@name='State']")
    WebElement stateDropDown;

    @FindBy(xpath = "//label[normalize-space()='City']")
    WebElement cityText;

    @FindBy(xpath = "//input[@placeholder='Enter City']")
    WebElement cityNameField;

    @FindBy(xpath = "//label[text()='Phone Number']")
    WebElement phoneNumberText;

    @FindBy(xpath = "//input[@name='contactNumber']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class='form-group col-md-4 col-12']//label[contains(text(),'Alternate Number')]")
    WebElement alternateNumberText;

    @FindBy(xpath = "//input[@name='alternateNumber']")
    WebElement alternateNumberField;

    @FindBy(xpath = "//label[text()='Customer Code']")
    WebElement customerCodeText;

    @FindBy(xpath = "//input[@placeholder='Enter Customer Code']")
    WebElement customerCodeField;

    @FindBy(xpath = "//label[normalize-space()='Billing Address']")
    WebElement billingAddressText;

    @FindBy(xpath = "//textarea[@placeholder='Enter Billing Address']")
    WebElement billingAddressField;

    @FindBy(xpath = "//span[normalize-space()='IsActive']")
    WebElement isActiveCheckBox;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Update Customer']")
    WebElement updateCustomerButton;

    @FindBy(xpath = "//h4[normalize-space()='Customer Contact']")
    WebElement customerContactText;

    @FindBy(xpath = "//label[text()='First Name']")
    WebElement firstNameText;

    @FindBy(xpath = "//input[@placeholder='Enter First Name']")
    WebElement firstNameField;

    @FindBy(xpath = "//label[text()='Last Name']")
    WebElement lastNameText;

    @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
    WebElement lastNameField;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    WebElement emailTextCustomerContact;

    @FindBy(xpath = "//input[@name='Email']")
    WebElement emailFieldCustomerContact;

    @FindBy(xpath = "//input[@name='Phone']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@name='Mobile']")
    WebElement mobileField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//span[@class='required']")
    WebElement errorMessage;

    @FindBy(xpath = "//span[text()=' Phone Number is required ']")
    WebElement phoneNumberRequiredErrorMessage;

    @FindBy(xpath = "//span[text()=' Please enter valid Phone Number ']")
    WebElement pleaseEnterValidPhoneNumberErrorMessage;

    @FindBy(xpath = "//span[text()=' Please enter valid Alternate Number ']")
    WebElement pleaseEnterValidAlternateNumberErrorMessage;

    @FindBy(xpath = "//div[text()=' Customer Code is required ']")
    WebElement customerCodeRequiredErrorMessage;

    @FindBy(xpath = "//h3[normalize-space()='Dashboard']")
    WebElement dashboardPageTitle;

    @FindBy(xpath = "//a[text()='Settings']")
    WebElement settingOption;

    @FindBy(xpath = "//span[text()=' First Name is required ']")
    WebElement firstNameIsRequiredErrorMessage;

    @FindBy(xpath = "//span[text()=' Last Name is required ']")
    WebElement lastNameIsRequiredErrorMessage;

    @FindBy(xpath = "//span[text()=' Email is required ']")
    WebElement emailIsRequiredErrorMessage;

    @FindBy(xpath = "//span[text()=' Phone Number is required ']")
    WebElement phoneNumberIsRequiredErrorMessage;

    @FindBy(xpath = "//input[@type='file']")
    WebElement profileImg;

    @FindBy(xpath = "//span[text()=' Please enter valid Email ']")
    WebElement pleaseEnterValidEmailErrorMessage;

    @FindBy(xpath = "//span[text()=' Please enter valid Phone Number ']")
    WebElement pleaseEnterValidPhoneErrorMessage;

    @FindBy(xpath = "//span[text()=' Please enter valid Alternate Number ']")
    WebElement pleaseEnterValidAlternateNumberMessage;

    @FindBy(xpath = "//h2[text()='Image should not be greater than 300 X 300']")
    WebElement imageShouldNotBeGreatMessage;

    @FindBy(xpath = "//h2[text()='Only PNG/JPG/JPEG images are allowed']")
    WebElement onlyPngAndJpgAndJpegImagesAreAllowedMessage;

    @FindBy(xpath = "//*[@id='myimage']")
    WebElement imgFilename;

    @FindBy(xpath = "//div[contains(@class,'cutomer-image-upload overflow-hidden position-relative')]//i[@class='fa fa-times text-danger']")
    WebElement profileImageCrossButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, remove it!']")
    WebElement yesRemoveItButton;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Cancel']")
    WebElement cancelUploadImgButton;

    @FindBy(xpath = "//h2[text()='Profile Image removed successfully']")
    WebElement profileImageRemovedSuccessMessage;

    @FindBy(xpath = "//label[text()='Inner Page Logo']//following-sibling::div//input[@type='file']")
    WebElement innerPageLogo;

    @FindBy(xpath = "//i[@class='fa fa-times text-danger']")
    WebElement innerPageLogoCrossButton;

    @FindBy(xpath = "//h2[text()='Inner Page Logo removed successfully']")
    WebElement innerPageLogoRemovedSuccessMessage;

    @FindBy(xpath = "//*[@id=\"customer_contact_table\"]/tbody/tr")
    WebElement tableData;

    @FindBy(xpath = "//h2[text()='EmailId already exists.']")
    WebElement emailIdAlreadyExistsMessage;

    @FindBy(xpath = "//span[text()=' Phone Number & Alternate Number should not be same ']")
    WebElement phoneNumberAndAlternateNumberShouldNotBeSameMessage;

    @FindBy(xpath = "//button[@class='btn btn-danger dropdown-toggle']")
    WebElement actionButton;

    @FindBy(xpath = "//i[@class='fas fa-edit']")
    WebElement actionsEditButton;

    @FindBy(xpath = "//i[@class='fas fa-trash']")
    WebElement actionsDeleteButton;

    @FindBy(xpath = "//h2[text()='Contact details updated successfully']")
    WebElement contactDetailsUpdatedSuccessMessage;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Cancel']")
    WebElement actionDeleteCancelButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, delete it!']")
    WebElement actionDeleteYesDeletedButton;

    @FindBy(xpath = "//h2[text()='Contact deleted successfully']")
    WebElement contactDeletedSuccessMessage;


    public CustomerProfilePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @SneakyThrows
    public CustomerProfilePage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnSettingsButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, settingsButton)).click();
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnCustomerProfileButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerProfileButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedCustomerProfilePageTitle() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerProfilePageTitle)).isDisplayed();
    }

    public boolean isDisplayedCustomerNameText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameText)).isDisplayed();
    }

    public boolean isDisplayedCustomerNameField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameField)).isDisplayed();
    }

    public boolean isDisplayedEmailText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailText)).isDisplayed();
    }

    public boolean isDisplayedEmailField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailField)).isDisplayed();
    }

    public boolean isDisplayedCountryText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, countryText)).isDisplayed();
    }

    public boolean isDisplayedCountryDropDown() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, countryDropDown)).isDisplayed();
    }

    public boolean isDisplayedStateText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, stateText)).isDisplayed();
    }

    public boolean isDisplayedStateDropDown() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, stateDropDown)).isDisplayed();
    }

    public boolean isDisplayedCityText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cityText)).isDisplayed();
    }

    public boolean isDisplayedCityNameField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cityNameField)).isDisplayed();
    }

    public boolean isDisplayedPhoneNumberText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberText)).isDisplayed();
    }

    public boolean isDisplayedPhoneNumberField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberField)).isDisplayed();
    }

    public boolean isDisplayedAlternateNumberText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alternateNumberText)).isDisplayed();
    }

    public boolean isDisplayedAlternateNumberField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alternateNumberField)).isDisplayed();
    }

    public boolean isDisplayedCustomerCodeText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerCodeText)).isDisplayed();
    }

    public boolean isDisplayedCustomerCodeField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerCodeField)).isDisplayed();
    }

    public boolean isDisplayedBillingAddressText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, billingAddressText)).isDisplayed();
    }

    public boolean isDisplayedBillingAddressField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, billingAddressField)).isDisplayed();
    }

    public boolean isDisplayedIsActiveCheckBox() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, isActiveCheckBox)).isDisplayed();
    }

    public boolean isDisplayedCancelButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).isDisplayed();
    }

    public boolean isDisplayedUpdateCustomerButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, updateCustomerButton)).isDisplayed();
    }

    public boolean isDisplayedCustomerContactText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerContactText)).isDisplayed();
    }

    public boolean isDisplayedFirstNameText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, firstNameText)).isDisplayed();
    }

    public boolean isDisplayedFirstNameField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, firstNameField)).isDisplayed();
    }

    public boolean isDisplayedLastNameText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastNameText)).isDisplayed();
    }

    public boolean isDisplayedLastNameField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastNameField)).isDisplayed();
    }

    public boolean isDisplayedEmailTextCustomerContact() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailTextCustomerContact)).isDisplayed();
    }

    public boolean isDisplayedEmailFieldCustomerContact() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailFieldCustomerContact)).isDisplayed();
    }

    public boolean isDisplayedPhoneField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneField)).isDisplayed();
    }

    public boolean isDisplayedMobileField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mobileField)).isDisplayed();
    }

    public boolean isDisplayedSaveButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, saveButton)).isDisplayed();
    }

    public String getCustomerName() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameField)).getAttribute("value").trim();
    }

    @SneakyThrows
    public CustomerProfilePage clearCustomerNameField() {
        String b = Keys.BACK_SPACE.toString();
        customerNameField.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
        return this;
    }

    public CustomerProfilePage clearPhoneNumberField() {
        String b = Keys.BACK_SPACE.toString();
        phoneNumberField.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
        return this;
    }

    public CustomerProfilePage clearCustomerCoderField() {
        String b = Keys.BACK_SPACE.toString();
        customerCodeField.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
        return this;
    }


    public CustomerProfilePage setCustomerNameField(String name) {
        sendKeysToWebElement(customerNameField, name, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnUpdateCustomerButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, updateCustomerButton)).click();
        return this;
    }

    public boolean isDisplayedCustomerNameIsRequiredMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessage)).isDisplayed();
    }

    public CustomerProfilePage setPhoneNumberField(String name) {
        sendKeysToWebElement(phoneNumberField, name, WaitStrategy.VISIBLE);
        return this;
    }

    public CustomerProfilePage setCustomerCodeField(String name) {
        sendKeysToWebElement(customerCodeField, name, WaitStrategy.VISIBLE);
        return this;
    }

    public CustomerProfilePage setEmailField(String emailId) {
        sendKeysToWebElement(emailField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    public String getEmail() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailField)).getAttribute("value").trim();
    }

    public boolean isDisplayedPhoneNumberRequiredErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberRequiredErrorMessage)).isDisplayed();
    }

    public boolean isDisplayedPleaseEnterValidPhoneNumberErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pleaseEnterValidPhoneNumberErrorMessage)).isDisplayed();
    }

    public String getPhoneNumber() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberField)).getAttribute("value");
    }

    public CustomerProfilePage setAlternateNumberField(String number) {
        sendKeysToWebElement(alternateNumberField, number, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedPleaseEnterValidAlternateNumberErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pleaseEnterValidAlternateNumberErrorMessage)).isDisplayed();
    }

    public String getAlternateNumber() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alternateNumberField)).getAttribute("value").trim();
    }

    public boolean isDisplayedCustomerCodeRequiredErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerCodeRequiredErrorMessage)).isDisplayed();
    }

    public String getCustomerCode() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerCodeField)).getAttribute("value").trim();
    }

    public CustomerProfilePage clickOnCancelButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedDashboardPageTitle() {
        Thread.sleep(5000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dashboardPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public boolean isDisplayedSelectedCountry(String selectedCountry) {
        Select select = new Select(countryDropDown);
        select.selectByVisibleText(selectedCountry);
        Thread.sleep(5000);
        return select.getFirstSelectedOption().getText().trim().equalsIgnoreCase(selectedCountry.trim());
    }

    @SneakyThrows
    public boolean isDisplayedSelectedState(String selectedState) {
        Select select = new Select(stateDropDown);
        select.selectByVisibleText(selectedState);
        Thread.sleep(5000);
        return select.getFirstSelectedOption().getText().trim().equalsIgnoreCase(selectedState.trim());
    }

    public CustomerProfilePage clickOnSaveButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, saveButton)).click();
        return this;
    }

    public List<Boolean> getCustomerContactMandatoryMessage() {
        return Arrays.asList(
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, firstNameIsRequiredErrorMessage)).isDisplayed()
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastNameIsRequiredErrorMessage)).isDisplayed()
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailIsRequiredErrorMessage)).isDisplayed()
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberIsRequiredErrorMessage)).isDisplayed());
    }

    public CustomerProfilePage setCustomerContactFirstNameFiled(String firstName) {
        sendKeysToWebElement(firstNameField, firstName, WaitStrategy.VISIBLE);
        return this;
    }

    public String getFirstName() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, firstNameField)).getAttribute("value");
    }

    public CustomerProfilePage setCustomerContactLastNameField(String lastName) {
        sendKeysToWebElement(lastNameField, lastName, WaitStrategy.VISIBLE);
        return this;
    }

    public String getLastName() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastNameField)).getAttribute("value");
    }

    public CustomerProfilePage setCustomerContactEmailField(String emailId) {
        sendKeysToWebElement(emailFieldCustomerContact, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedPleaseEnterValidEmailErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pleaseEnterValidEmailErrorMessage)).isDisplayed();
    }

    public CustomerProfilePage setCustomerContactPhoneNumberField(String phoneNumber) {
        sendKeysToWebElement(phoneField, phoneNumber, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedPleaseEnterValidPhoneErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pleaseEnterValidPhoneErrorMessage)).isDisplayed();
    }

    public String getCustomerContactPhoneNumber() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneField)).getAttribute("value");

    }

    public CustomerProfilePage setCustomerContactAlternateNumberField(String alternateNumber) {
        sendKeysToWebElement(mobileField, alternateNumber, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedPleaseEnterValidAlternateNumberMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pleaseEnterValidAlternateNumberMessage)).isDisplayed();
    }

    public String getCustomerContactAlternateNumber() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mobileField)).getAttribute("value");
    }

    public CustomerProfilePage setProfileImg(String path) {
        sendKeysToWebElement(profileImg, path, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedImageShouldNotBeGreatMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, imageShouldNotBeGreatMessage)).isDisplayed();
    }

    public boolean isDisplayedOnlyPngAndJpgAndJpegImagesAreAllowedMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, onlyPngAndJpgAndJpegImagesAreAllowedMessage)).isDisplayed();
    }

    @SneakyThrows
    public boolean isDisplayedImgFilename() {
        Thread.sleep(8000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, imgFilename)).isDisplayed();
    }

    public CustomerProfilePage clickOnProfileImageCrossButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, profileImageCrossButton)).click();
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnYesRemoveItButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, yesRemoveItButton)).click();
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnCancelUploadImgButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelUploadImgButton)).click();
        return this;
    }

    public boolean isDisplayedProfileImageRemovedSuccessMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, profileImageRemovedSuccessMessage)).isDisplayed();
    }

    public CustomerProfilePage setInnerPageLogo(String image) {
        sendKeysToWebElement(innerPageLogo, image, WaitStrategy.VISIBLE);
        return this;
    }

    public CustomerProfilePage clickOnInnerPageLogoCrossButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, innerPageLogoCrossButton)).click();
        return this;
    }

    public boolean isDisplayedInnerPageLogoRemovedSuccessMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, innerPageLogoRemovedSuccessMessage)).isDisplayed();
    }

    @SneakyThrows
    public List<String> getAllCustomerProfileField() {
        Thread.sleep(4000);
        return Arrays.asList(
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, countryDropDown)).getText()
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, stateDropDown)).getText()
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cityNameField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alternateNumberField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerCodeField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, billingAddressField)).getAttribute("value"));
    }

    public void setBillingAddressField(String address) {
        sendKeysToWebElement(billingAddressField, address, WaitStrategy.VISIBLE);
    }

    public CustomerProfilePage clickOnUpdateButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, updateCustomerButton)).click();
        return this;
    }

    public List<String> getCustomerContactFieldText() {
        return Arrays.asList(
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, firstNameField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastNameField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailFieldCustomerContact)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneField)).getAttribute("value")
                , Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mobileField)).getAttribute("value"));
    }

    @SneakyThrows
    public List<String> getTableData(){
        Thread.sleep(5000);
        return Collections.singletonList(Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, tableData)).getText());
    }

    public boolean isDisplayedEmailIdAlreadyExistsMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailIdAlreadyExistsMessage)).isDisplayed();
    }

    public boolean isDisplayedPhoneNumberAndAlternateNumberShouldNotBeSameMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, phoneNumberAndAlternateNumberShouldNotBeSameMessage)).isDisplayed();
    }

    public CustomerProfilePage clickOnActionButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionButton)).click();
        return this;
    }

    @SneakyThrows
    public CustomerProfilePage clickOnActionEditButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionsEditButton)).click();
        Thread.sleep(3000);
        return this;
    }

    public boolean isDisplayedContactDetailsUpdatedSuccessMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, contactDetailsUpdatedSuccessMessage)).isDisplayed();
    }

    public CustomerProfilePage clickOnActionDeleteButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionsDeleteButton)).click();
        return this;
    }

    public CustomerProfilePage clickOnActionDeleteCancelButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionDeleteCancelButton)).click();
        return this;
    }

    public CustomerProfilePage clickOnActionDeleteYesDeletedButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionDeleteYesDeletedButton)).click();
        return this;
    }

    public boolean isDisplayedContactDeletedSuccessMessage(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, contactDeletedSuccessMessage)).isDisplayed();
    }




}
