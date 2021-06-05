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
public class AssetMessageHistoryReportTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetMessageHistoryReportPage assetMessageHistoryReportPage;
    private AssetMessageHistoryReportTest(){

    }
    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        assetMessageHistoryReportPage = new AssetMessageHistoryReportPage();
    }
    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnAssetMessageHistoryButton().isDisplayedAssetMessageHistoryReportPageTitle());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAssetDropDownButton());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedStartDate());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedEndDate());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedRunReportButton());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedEmailButton());
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
        Assert.assertTrue(assetMessageHistoryReportPage.byDefaultIsDisplayedCurrentDateInStartDate());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.todayDate(), "April", "2021", "previous"));
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 4)
    public void EndDateCalendarField() {
        Assert.assertTrue(assetMessageHistoryReportPage.byDefaultIsDisplayedCurrentDateInEndDate());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSelectedCurrentAndPastEndDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        assetMessageHistoryReportPage.selectAsset("CDN TEST #5");
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedErrorMessage());
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 5)
    public void  RunReportButtonTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSelectedCurrentAndPastDate("March 15, 2021", "March", "2021", "previous"));
        assetMessageHistoryReportPage.selectAsset("CDN TEST #5");
        assetMessageHistoryReportPage.clickOnPageTitle();
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 6)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.isExcelButtonClickable());
    }
    @Test(priority = 7)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 8)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetMessageHistoryReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetMessageHistoryReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageHistoryReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageHistoryReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 9)
    public void MessageOptionalField() {
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetMessageHistoryReportPage.setEmailField("sunny@mailinator.com");
        assetMessageHistoryReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 10)
    public void SendButtonTest() {
        Assert.assertTrue(assetMessageHistoryReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetMessageHistoryReportPageTitle());
    }
    @Test(priority = 11)
    public void CancelButtonTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(assetMessageHistoryReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetMessageHistoryReportPageTitle());
    }

    @Test(priority = 12)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAnnunciatorHourMeterColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAnnunciatorStatusColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAnnunciatorStatusCodeColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAnnunciatorTachometerColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAssetDescriptionColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedAssetNameColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedEventTimestampColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedLatitudeColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedLongitudeColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedMessageTypeColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedPowerColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedProximityColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedReceiptTimestampColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSignalStrengthValueColumn());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedTierNamesColumn());
    }
    @Test(priority = 13)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSearchData("AMCi Advanced Demo"));
        Assert.assertFalse(assetMessageHistoryReportPage.isDisplayedSearchData("vvvv"));
        assetMessageHistoryReportPage.setSearchField(AssetMessageActivityReportPage.manualDelete());
    }

    @Test(priority = 14)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSortingClientNameColumn());
       // Assert.assertTrue(assetMessageHistoryReportPage.isDisplayedSortingTireNamedColumn());
        //  Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingDatapointNumberColumn());
    }
}
