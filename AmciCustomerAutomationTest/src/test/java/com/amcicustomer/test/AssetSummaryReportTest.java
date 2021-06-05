package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AssetMessageActivityReportPage;
import com.amcicustomer.pageobject.AssetSummaryReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class AssetSummaryReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetSummaryReportPage assetSummaryReportPage;
    private AssetSummaryReportTest (){
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        assetSummaryReportPage = new AssetSummaryReportPage();
    }


    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue( assetSummaryReportPage.clickOnSideMenu().clickOnReportOptions().scroll().clickOnAssetSummaryButton().isDisplayedAssetSummaryReportPageTitle());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedEmailButton());
    }

    @Test(priority = 2)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetSummaryReportPage.isExcelButtonClickable());
    }
    @Test(priority = 3)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetSummaryReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 4)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetSummaryReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetSummaryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetSummaryReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetSummaryReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetSummaryReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 5)
    public void MessageOptionalField() {
        Assert.assertTrue(assetSummaryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetSummaryReportPage.setEmailField("sunny@mailinator.com");
        assetSummaryReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 6)
    public void SendButtonTest() {
        Assert.assertTrue(assetSummaryReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetSummaryReportPageTitle());
    }
    @Test(priority = 7)
    public void CancelButtonTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(assetSummaryReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetSummaryReportPageTitle());
    }

    @Test(priority = 8)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(assetSummaryReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedAssetNameColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedAssetDescriptionColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedNotificationPlanColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedCallScheduleColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedCallTypeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedCurrentStatusColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedAmciSerialNumberColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedManufacturerSerialNumberColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedLatitudeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedLongitudeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedPositionTimeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedStateColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedProximityColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedLastEventTimeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedLastMessageTimeColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedAmciiProductStatusColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedActivationDateColumn());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedDeactivationDateColumn());
    }
    @Test(priority = 9)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetSummaryReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedSearchData("zzAMCI Operations"));
        Assert.assertFalse(assetSummaryReportPage.isDisplayedSearchData("vvvv"));
        assetSummaryReportPage.setSearchField(AssetMessageActivityReportPage.manualDelete());
    }

    @Test(priority = 10)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(assetSummaryReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(assetSummaryReportPage.isDisplayedSortingClientNameColumn());
      //  Assert.assertTrue(assetSummaryReportPage.isDisplayedSortingTireNamedColumn());
        //  Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingDatapointNumberColumn());
    }
}
