package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;

import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AdhocRuntimeReportPage;
import com.amcicustomer.pageobject.AssetEventNotificationReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class AssetEventNotificationReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetEventNotificationReportPage assetEventNotificationReportPage ;
    private AssetEventNotificationReportTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
       assetEventNotificationReportPage = new AssetEventNotificationReportPage();
    }
    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(assetEventNotificationReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnAssetEventNotificationReportButton().isDisplayedAssetEventNotificationReportPageTitle());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectAssetDropdownButton());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedStartDate());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEndDate());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEmailButton());
    }
    @Test(priority = 2)
    public void SelectAssetDropDownTest(){
        Assert.assertTrue(assetEventNotificationReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
        Assert.assertTrue(assetEventNotificationReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
        assetEventNotificationReportPage.clickOnSelectAllButton();
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedMultipleAssets(0));
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedMultipleAssets());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void StartDateCalendarFieldTest() {
        Assert.assertTrue(assetEventNotificationReportPage.byDefaultIsDisplayedCurrentDateInStartDate());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.todayDate(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 4)
    public void EndDateCalendarField() {
        Assert.assertTrue(assetEventNotificationReportPage.byDefaultIsDisplayedCurrentDateInEndDate());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectedCurrentAndPastEndDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetEventNotificationReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedErrorMessage());
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 5)
    public void  RunReportButtonTest(){
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSelectedCurrentAndPastDate("March 15, 2021", "March", "2021", "previous"));
        assetEventNotificationReportPage.clickOnPageTitle();
        Assert.assertTrue(assetEventNotificationReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 6)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetEventNotificationReportPage.isExcelButtonClickable());
    }
    @Test(priority = 7)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetEventNotificationReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 8)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetEventNotificationReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetEventNotificationReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetEventNotificationReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetEventNotificationReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetEventNotificationReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 9)
    public void MessageOptionalField() {
        Assert.assertTrue(assetEventNotificationReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetEventNotificationReportPage.setEmailField("sunny@mailinator.com");
        assetEventNotificationReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 10)
    public void SendButtonTest() {
        Assert.assertTrue(assetEventNotificationReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetEventNotificationReportPageTitle());
    }
    @Test(priority = 11)
    public void CancelButtonTest() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(assetEventNotificationReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetEventNotificationReportPageTitle());
    }

    @Test(priority = 12)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSiteDescriptionColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedTerminalSerialNumberColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedAmciSerialNumberColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedNotificationTypeColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedNotificationPlanNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEventTimestampColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEventStateColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEventSummaryColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedEmailAddressesColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedPhoneNumberColumn());
    }
    @Test(priority = 13)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSearchData("CDN TEST #5"));
        Assert.assertFalse(assetEventNotificationReportPage.isDisplayedSearchData("vvvv"));
        Assert.assertFalse(assetEventNotificationReportPage.isDisplayedSearchData(""));
    }

    @Test(priority = 14)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingClientNameColumn());
        Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingTireNamedColumn());
      //  Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingDatapointNumberColumn());
    }





}
