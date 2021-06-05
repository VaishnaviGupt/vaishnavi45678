package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.*;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class RuntimeEventReportTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    RuntimeEventReportPage runtimeEventReportPage;
    private RuntimeEventReportTest(){

    }
    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        runtimeEventReportPage = new RuntimeEventReportPage();
    }

    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(runtimeEventReportPage.clickOnSideMenu().clickOnReportOptions().scroll().
                clickOnRuntimeEventReportButton().isDisplayedRuntimeEventReportPageTitle());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedAssetDropDownButton());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedStartDate());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedEndDate());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedRunReportButton());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedExcelButton());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedEmailButton());
    }

    @Test(priority = 2)
    public void SelectAssetDropDownTest(){
//        Assert.assertTrue(assetMessageActivityReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
//        Assert.assertTrue(assetMessageActivityReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
//        assetMessageActivityReportPage.clickOnSelectAllButton();
//        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedMultipleAssets(1));
//        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedMultipleAssets(2));
//        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void StartDateCalendarFieldTest() {
        Assert.assertTrue(runtimeEventReportPage.byDefaultIsDisplayedCurrentDateInStartDate());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.endDateEvent(),AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.todayDate(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 4)
    public void EndDateCalendarField() {
        Assert.assertTrue(runtimeEventReportPage.byDefaultIsDisplayedCurrentDateInEndDate());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSelectedCurrentAndPastEndDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        runtimeEventReportPage.selectAsset("CDN TEST #5");
        Assert.assertTrue(runtimeEventReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedErrorMessage());
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 5)
    public void  RunReportButtonTest(){
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSelectedCurrentAndPastDate("March 15, 2021", "March", "2021", "previous"));
        runtimeEventReportPage.selectAsset("CDN TEST #5");
        runtimeEventReportPage.clickOnPageTitle();
        Assert.assertTrue(runtimeEventReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 6)
    public void  ExcelButtonTest(){
        Assert.assertTrue(runtimeEventReportPage.isExcelButtonClickable());
    }
    @Test(priority = 7)
    public void  EmailButtonTest(){
        Assert.assertTrue(runtimeEventReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedMessageField());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSendButton());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 8)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(runtimeEventReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(runtimeEventReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(runtimeEventReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(runtimeEventReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(runtimeEventReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 9)
    public void MessageOptionalField() {
        Assert.assertTrue(runtimeEventReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        runtimeEventReportPage.setEmailField("sunny@mailinator.com");
        runtimeEventReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 10)
    public void SendButtonTest() {
        Assert.assertTrue(runtimeEventReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedRuntimeEventReportPageTitle());
    }
    @Test(priority = 11)
    public void CancelButtonTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(runtimeEventReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedRuntimeEventReportPageTitle());
    }

    @Test(priority = 12)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(runtimeEventReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedAssetNameColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedDatapointNumberColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedDatapointDescriptionColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedComponentDescriptionColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedFaultCodeColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSourceColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedEventTimeColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedAlarmStateColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedStatusDescriptionColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSCommentColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedEventDowntimeInMinutesColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedEventDowntimeInHoursColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedIntervalDowntimeInMinutesColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedIntervalDowntimeInHoursColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedUptimePercentageColumn());
    }
    @Test(priority = 13)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(runtimeEventReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSearchData("zzAMCI Operations"));
        Assert.assertFalse(runtimeEventReportPage.isDisplayedSearchData("vvvv"));
        runtimeEventReportPage.setSearchField(AssetMessageActivityReportPage.manualDelete());
    }

    @Test(priority = 14)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(runtimeEventReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSortingClientNameColumn());
        Assert.assertTrue(runtimeEventReportPage.isDisplayedSortingTireNamedColumn());
        //  Assert.assertTrue(runtimeEventReportPage.isDisplayedSortingDatapointNumberColumn());
    }

}
