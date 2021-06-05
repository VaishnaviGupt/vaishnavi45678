package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AssetMessageActivityReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.HourMeterReportPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class HourMeterReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    HourMeterReportPage hourMeterReportPage;
    private HourMeterReportTest (){
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
       hourMeterReportPage = new HourMeterReportPage();
    }

    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue( hourMeterReportPage.clickOnSideMenu().clickOnReportOptions().scroll().clickOnHourMeterReportButton().isDisplayedHourMeterReportPageTitle());
        Assert.assertTrue(hourMeterReportPage.isDisplayedAssetDropDownButton());
        Assert.assertTrue(hourMeterReportPage.isDisplayedExcelButton());
        Assert.assertTrue(hourMeterReportPage.isDisplayedEmailButton());
    }

    @Test(priority = 2)
    public void SelectAssetDropDownTest(){
        Assert.assertTrue(hourMeterReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
        Assert.assertTrue(hourMeterReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
        hourMeterReportPage.clickOnSelectAllButton();
        Assert.assertTrue(hourMeterReportPage.isDisplayedMultipleAssets(0));
        Assert.assertTrue(hourMeterReportPage.isDisplayedMultipleAssets());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void  RunReportButtonTest(){
        Assert.assertTrue(hourMeterReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 4)
    public void  ExcelButtonTest(){
        Assert.assertTrue(hourMeterReportPage.isExcelButtonClickable());
    }
    @Test(priority = 5)
    public void  EmailButtonTest(){
        Assert.assertTrue(hourMeterReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(hourMeterReportPage.isDisplayedMessageField());
        Assert.assertTrue(hourMeterReportPage.isDisplayedSendButton());
        Assert.assertTrue(hourMeterReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 6)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(hourMeterReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(hourMeterReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(hourMeterReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(hourMeterReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(hourMeterReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 7)
    public void MessageOptionalField() {
        Assert.assertTrue(hourMeterReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        hourMeterReportPage.setEmailField("sunny@mailinator.com");
        hourMeterReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 8)
    public void SendButtonTest() {
        Assert.assertTrue(hourMeterReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedHourMeterReportPageTitle());
    }
    @Test(priority = 9)
    public void CancelButtonTest() {
        Assert.assertTrue(hourMeterReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedHourMeterReportPageTitle());
    }
    @Test(priority = 10)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(hourMeterReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedAssetNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedChannelNameColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedLastReadingColumn());
        Assert.assertTrue(hourMeterReportPage.isDisplayedLastReadingTimeColumn());
    }

    @Test(priority = 11)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(hourMeterReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(hourMeterReportPage.isDisplayedSearchData("zzAMCI Operations"));
        Assert.assertFalse(hourMeterReportPage.isDisplayedSearchData("vvvv"));
        hourMeterReportPage.setSearchField(AssetMessageActivityReportPage.manualDelete());
    }

    @Test(priority = 12)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(hourMeterReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(hourMeterReportPage.isDisplayedSortingClientNameColumn());
     //   Assert.assertTrue(hourMeterReportPage.isDisplayedSortingTireNamedColumn());
        //  Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingDatapointNumberColumn());
    }




}
