package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.CustomerProfilePage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;


@Listeners(TestListeners.class)
public class CustomerProfileTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerProfilePage customerProfilePage;
    List<String> customerProfileField;
    List<String> customerContactFieldText;


    private CustomerProfileTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        customerProfilePage = new CustomerProfilePage();
    }

    @Test(priority = 1)
    public void DefaultViewOfTheCustomerProfilePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(customerProfilePage.clickOnSideMenu().clickOnSettingsButton().
                clickOnCustomerProfileButton().isDisplayedCustomerProfilePageTitle());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(customerProfilePage.isDisplayedCustomerNameText());
        softAssert.assertTrue(customerProfilePage.isDisplayedCustomerNameField());
        softAssert.assertTrue(customerProfilePage.isDisplayedEmailText());
        softAssert.assertTrue(customerProfilePage.isDisplayedEmailField());
        softAssert.assertTrue(customerProfilePage.isDisplayedCountryText());
        softAssert.assertTrue(customerProfilePage.isDisplayedCountryDropDown());
        softAssert.assertTrue(customerProfilePage.isDisplayedStateText());
        softAssert.assertTrue(customerProfilePage.isDisplayedStateDropDown());
        softAssert.assertTrue(customerProfilePage.isDisplayedCityText());
        softAssert.assertTrue(customerProfilePage.isDisplayedCityNameField());
        softAssert.assertTrue(customerProfilePage.isDisplayedPhoneNumberText());
        softAssert.assertTrue(customerProfilePage.isDisplayedPhoneNumberField());
        softAssert.assertTrue(customerProfilePage.isDisplayedAlternateNumberText());
        softAssert.assertTrue(customerProfilePage.isDisplayedAlternateNumberField());
        softAssert.assertTrue(customerProfilePage.isDisplayedCustomerCodeText());
        softAssert.assertTrue(customerProfilePage.isDisplayedCustomerCodeField());
        softAssert.assertTrue(customerProfilePage.isDisplayedBillingAddressText());
        softAssert.assertTrue(customerProfilePage.isDisplayedBillingAddressField());
        softAssert.assertTrue(customerProfilePage.isDisplayedIsActiveCheckBox());
        softAssert.assertTrue(customerProfilePage.isDisplayedCancelButton());
        softAssert.assertTrue(customerProfilePage.isDisplayedUpdateCustomerButton());
        softAssert.assertTrue(customerProfilePage.isDisplayedCustomerContactText());
        softAssert.assertTrue(customerProfilePage.isDisplayedFirstNameText());
        softAssert.assertTrue(customerProfilePage.isDisplayedFirstNameField());
        softAssert.assertTrue(customerProfilePage.isDisplayedLastNameText());
        softAssert.assertTrue(customerProfilePage.isDisplayedLastNameField());
        softAssert.assertTrue(customerProfilePage.isDisplayedEmailTextCustomerContact());
        softAssert.assertTrue(customerProfilePage.isDisplayedEmailFieldCustomerContact());
        softAssert.assertTrue(customerProfilePage.isDisplayedPhoneField());
        softAssert.assertTrue(customerProfilePage.isDisplayedMobileField());
        softAssert.assertTrue(customerProfilePage.isDisplayedSaveButton());
        softAssert.assertAll();
        customerProfileField = customerProfilePage.getAllCustomerProfileField();

    }

    @Test(priority = 2)
    public void ProfileImageTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(customerProfilePage
                .setProfileImg(FrameWorkConstants.getIMGFILE1000KB())
                .isDisplayedImageShouldNotBeGreatMessage());
        softAssert.assertTrue(customerProfilePage
                .setProfileImg(FrameWorkConstants.getGIFFILE())
                .isDisplayedOnlyPngAndJpgAndJpegImagesAreAllowedMessage());
        softAssert.assertTrue(customerProfilePage
                .setProfileImg(FrameWorkConstants.getIMGFILE())
                .isDisplayedImgFilename());
        softAssert.assertTrue(customerProfilePage
                .clickOnProfileImageCrossButton()
                .clickOnCancelUploadImgButton()
                .isDisplayedImgFilename());
        softAssert.assertTrue(customerProfilePage
                .clickOnProfileImageCrossButton()
                .clickOnYesRemoveItButton()
                .isDisplayedProfileImageRemovedSuccessMessage());
        softAssert.assertAll();
    }

    @SneakyThrows
    @Test(priority = 3)
    public void InnerPageLogoTest() {
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(customerProfilePage
                .setInnerPageLogo(FrameWorkConstants.getIMGFILE1000KB())
                .isDisplayedImageShouldNotBeGreatMessage());
        softAssert.assertTrue(customerProfilePage
                .setInnerPageLogo(FrameWorkConstants.getGIFFILE())
                .isDisplayedOnlyPngAndJpgAndJpegImagesAreAllowedMessage());
        softAssert.assertTrue(customerProfilePage
                .setInnerPageLogo(FrameWorkConstants.getIMGFILE())
                .isDisplayedImgFilename());
        softAssert.assertTrue(customerProfilePage
                .clickOnInnerPageLogoCrossButton()
                .clickOnCancelUploadImgButton()
                .isDisplayedImgFilename());
        softAssert.assertTrue(customerProfilePage
                .clickOnInnerPageLogoCrossButton()
                .clickOnYesRemoveItButton()
                .isDisplayedInnerPageLogoRemovedSuccessMessage());
        softAssert.assertAll();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void ByDefaultCustomerNameTest() {
        Assert.assertEquals(customerProfilePage.getCustomerName(), "AMCi Advanced Demo");
    }

    @Test(priority = 5)
    public void CustomerNameFieldTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(customerProfilePage
                .clearCustomerNameField()
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerNameIsRequiredMessage());
        softAssert.assertEquals(customerProfilePage
                .setCustomerNameField("AMCi Advanced Demo")
                .getCustomerName(), "AMCi Advanced Demo");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void EmailFieldTest() {
        Assert.assertEquals(customerProfilePage
                .getEmail(), "amciadvanceddemo@mailinator.com");
        Assert.assertTrue(customerProfilePage
                .setEmailField("mm")
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerNameIsRequiredMessage());
        Assert.assertTrue(customerProfilePage
                .setEmailField("sunnymailinator.com ")
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerNameIsRequiredMessage());
        Assert.assertTrue(customerProfilePage
                .setEmailField("sunny@mailinator-com")
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerNameIsRequiredMessage());
        Assert.assertTrue(customerProfilePage
                .setEmailField("sunny@@@mailinator.com")
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerNameIsRequiredMessage());
        Assert.assertEquals(customerProfilePage
                .setEmailField("amciadvanceddemo@mailinator.com")
                .getEmail(), "amciadvanceddemo@mailinator.com");
    }

    @Test(priority = 7)
    public void CountryDropDownTest() {
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedCountry("Australia "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedCountry("United States "));
    }

    @SneakyThrows
    @Test(priority = 8)
    public void StateDropDownTest() {
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedCountry("Australia "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("New South Wales "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("Queensland "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("Sydney "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedCountry("United States "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("Arizona "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("California "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("Florida "));
    }

    @Test(priority = 9)
    public void CityFieldTest() {

    }

    @Test(priority = 10)
    public void PhoneNumberFieldTest() {
        Assert.assertTrue(customerProfilePage
                .clearPhoneNumberField()
                .clickOnUpdateCustomerButton()
                .isDisplayedPhoneNumberRequiredErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setPhoneNumberField("Abcd")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setPhoneNumberField("1234")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setPhoneNumberField("   ")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertTrue(customerProfilePage.setPhoneNumberField("Abcd@123")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setPhoneNumberField("12345678910101012")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setPhoneNumberField("1234567890@")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidPhoneNumberErrorMessage());
        Assert.assertEquals(customerProfilePage
                .setPhoneNumberField("3467015711")
                .getPhoneNumber(), "3467015711");
    }

    @Test(priority = 11)
    public void AlternateNumberFieldTest() {
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("Abcd")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("123456789011")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("123456789011")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("1234567890@")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("12345@67890")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setAlternateNumberField("16")
                .clickOnUpdateCustomerButton()
                .isDisplayedPleaseEnterValidAlternateNumberErrorMessage());
        Assert.assertEquals(customerProfilePage
                .setAlternateNumberField("3032792002")
                .getAlternateNumber(), "3032792002");
    }

    @Test(priority = 12)
    public void CustomerCodeFieldTest() {
        Assert.assertTrue(customerProfilePage
                .clearCustomerCoderField()
                .clickOnUpdateCustomerButton()
                .isDisplayedCustomerCodeRequiredErrorMessage());
        Assert.assertEquals(customerProfilePage
                .setCustomerCodeField("zzAMCiOps")
                .getCustomerCode(), "zzAMCiOps");
    }

    @Test(priority = 13)
    public void BillingAddressFieldTest() {

    }

    @Test(priority = 14)
    public void CancelButtonTest() {
        Assert.assertTrue(customerProfilePage
                .clickOnCancelButton()
                .isDisplayedDashboardPageTitle());
        Assert.assertEquals(customerProfilePage
                        .clickOnSideMenu()
                        .clickOnCustomerProfileButton()
                        .getAllCustomerProfileField(),
                customerProfileField);
    }

    @Test(priority = 15)
    public void UpdateCustomerProfileTest() {
        customerProfilePage
                .clearCustomerNameField()
                .setCustomerNameField("AMCi Advanced Demo")
                .setEmailField("amciadvanceddemo@mailinator.com");
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedCountry("Australia "));
        Assert.assertTrue(customerProfilePage.isDisplayedSelectedState("New South Wales "));
        customerProfilePage
                .clearPhoneNumberField()
                .setPhoneNumberField("3467015711")
                .setAlternateNumberField("3032792002")
                .clearCustomerCoderField()
                .setCustomerCodeField("zzAMCiOps")
                .setBillingAddressField("Testing Billing Address");
        List<String> field_Text = customerProfilePage.getAllCustomerProfileField();
        Assert.assertTrue(customerProfilePage
                .clickOnUpdateButton()
                .isDisplayedDashboardPageTitle());
        Assert.assertEquals(customerProfilePage
                        .clickOnSideMenu()
                        .clickOnCustomerProfileButton()
                        .getAllCustomerProfileField(),
                field_Text);
    }

    @SneakyThrows
    @Test(priority = 16)
    public void CustomerContactMandatoryFieldTest() {
        Thread.sleep(3000);
        Assert.assertTrue(customerProfilePage
                .clickOnSaveButton()
                .getCustomerContactMandatoryMessage().stream().allMatch(bool -> bool));
    }

    @Test(priority = 17)
    public void CustomerContactFirstNameFiledTest() {
        Assert.assertEquals(customerProfilePage
                .setCustomerContactFirstNameFiled("Test001")
                .getFirstName(), "Test001");
    }

    @Test(priority = 18)
    public void CustomerContactLastNameFiledTest() {
        Assert.assertEquals(customerProfilePage
                .setCustomerContactLastNameField("Test001")
                .getLastName(), "Test001");
    }

    @Test(priority = 19)
    public void CustomerContactEmailFiledTest() {
        Assert.assertTrue(customerProfilePage
                .setCustomerContactEmailField("mm")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidEmailErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactEmailField("sunnymailinator.com ")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidEmailErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactEmailField("sunny@mailinator-com")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidEmailErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactEmailField("sunny@@@mailinator.com")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidEmailErrorMessage());
    }

    @Test(priority = 20)
    public void CustomerContactPhoneNumberFieldTest() {
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("Abcd")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("1234")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("   ")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("Abcd@123")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("12345678910101012")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("1234567890@")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidPhoneErrorMessage());
        Assert.assertEquals(customerProfilePage
                .setCustomerContactPhoneNumberField("3467015711")
                .getCustomerContactPhoneNumber(), "3467015711");
    }

    @Test(priority = 21)
    public void CustomerContactAlternateNumberFieldTest() {
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("Abcd")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("123456789011")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("123456789011")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("1234567890@")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("12345@67890")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactAlternateNumberField("16")
                .clickOnSaveButton()
                .isDisplayedPleaseEnterValidAlternateNumberMessage());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactPhoneNumberField("3032792002")
                .setCustomerContactAlternateNumberField("3032792002")
                .clickOnSaveButton()
                .isDisplayedPhoneNumberAndAlternateNumberShouldNotBeSameMessage());
        Assert.assertEquals(customerProfilePage
                .setCustomerContactAlternateNumberField("3032792003")
                .getCustomerContactAlternateNumber(), "3032792003");
    }

    @Test(priority = 22)
    public void SaveButtonTest() {
        customerProfilePage
                .setCustomerContactFirstNameFiled("Test001")
                .setCustomerContactLastNameField("Test001")
                .setCustomerContactEmailField("Samkitjain@cdnsol.com")
                .setCustomerContactPhoneNumberField("1234567890")
                .setCustomerContactAlternateNumberField("3032792002");
        customerContactFieldText = customerProfilePage.getCustomerContactFieldText();
        StringBuilder field = new StringBuilder();
        for (String s : customerContactFieldText) {
            field.append(s).append(" ");
        }
        List<String> stringList2 = Collections.singletonList(String.valueOf(field).trim());
        Assert.assertEquals(stringList2, customerProfilePage
                .clickOnSaveButton()
                .getTableData());
        Assert.assertTrue(customerProfilePage
                .setCustomerContactFirstNameFiled("John")
                .setCustomerContactLastNameField("Test001")
                .setCustomerContactEmailField("Samkitjain@cdnsol.com")
                .setCustomerContactPhoneNumberField("1234567890")
                .setCustomerContactAlternateNumberField("3032792002")
                .clickOnSaveButton()
                .isDisplayedEmailIdAlreadyExistsMessage());
    }

    @SneakyThrows
    @Test(priority = 23)
    public void ActionEditTest() {
        Thread.sleep(5000);
        Assert.assertEquals(customerContactFieldText, customerProfilePage
                .clickOnActionButton()
                .clickOnActionEditButton()
                .getCustomerContactFieldText());
        customerProfilePage
                .setCustomerContactFirstNameFiled("Test001")
                .setCustomerContactLastNameField("Test001")
                .setCustomerContactEmailField("Samkitjain@gmail.com")
                .setCustomerContactPhoneNumberField("1234567890")
                .setCustomerContactAlternateNumberField("3032792002");
        customerContactFieldText = customerProfilePage.getCustomerContactFieldText();
        StringBuilder field = new StringBuilder();
        for (String s : customerContactFieldText) {
            field.append(s).append(" ");
        }
        List<String> stringList2 = Collections.singletonList(String.valueOf(field).trim());
        Assert.assertTrue(customerProfilePage
        .clickOnSaveButton()
        .isDisplayedContactDetailsUpdatedSuccessMessage());
        Assert.assertEquals(stringList2,
                customerProfilePage
                .getTableData());
    }

    @Test(priority = 24)
    public void ActionDeleteButton(){
        List<String> customerContactTable = customerProfilePage.getTableData();
        Assert.assertEquals(customerContactTable,customerProfilePage
        .clickOnActionButton()
        .clickOnActionDeleteButton()
        .clickOnActionDeleteCancelButton()
        .getTableData());
        Assert.assertTrue(customerProfilePage
        .clickOnActionButton()
        .clickOnActionDeleteButton()
        .clickOnActionDeleteYesDeletedButton()
        .isDisplayedContactDeletedSuccessMessage());
        Assert.assertNotEquals(customerContactTable
                ,customerProfilePage.getTableData());

    }


}
