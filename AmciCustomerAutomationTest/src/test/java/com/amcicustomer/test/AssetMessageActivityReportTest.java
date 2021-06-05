package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AdhocRuntimeReportPage;
import com.amcicustomer.pageobject.AssetMessageActivityReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class AssetMessageActivityReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetMessageActivityReportPage assetMessageActivityReportPage;
    private AssetMessageActivityReportTest(){

    }
    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        assetMessageActivityReportPage = new AssetMessageActivityReportPage();
    }
    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(assetMessageActivityReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnsAssetMessageActivityReportButton().isDisplayedAssetMessageActivityReportPageTitle());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedAssetDropDownButton());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedStartDate());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedEndDate());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedRunReportButton());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedMaxRecordField());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedEmailButton());
        System.out.println(assetMessageActivityReportPage.get());
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
        Assert.assertTrue(assetMessageActivityReportPage.byDefaultIsDisplayedCurrentDateInStartDate());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.todayDate(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        DriverManager.getWebDriver().navigate().refresh();
    }
    @Test(priority = 4)
    public void EndDateCalendarField() {
        Assert.assertTrue(assetMessageActivityReportPage.byDefaultIsDisplayedCurrentDateInEndDate());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSelectedCurrentAndPastEndDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        assetMessageActivityReportPage.selectAsset("CDN TEST #5");
        Assert.assertTrue(assetMessageActivityReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedErrorMessage());
        DriverManager.getWebDriver().navigate().refresh();
    }


    @Test(priority = 5)
    public void MaxRowsFieldTest(){
        assetMessageActivityReportPage.selectAsset("CDN TEST #5");
        Assert.assertTrue(assetMessageActivityReportPage.byDefaultIsDisplayedMaxRows("50"));
        Assert.assertTrue(assetMessageActivityReportPage.setMaxRecordField("abc").clickOnRunReportButton().isDisplayedErrorMaxRows());
        Assert.assertTrue(assetMessageActivityReportPage.setMaxRecordField("@#$").clickOnRunReportButton().isDisplayedErrorMaxRows());
        Assert.assertTrue(assetMessageActivityReportPage.setMaxRecordField("60").clickOnRunReportButton().byDefaultIsDisplayedMaxRows("60"));
        Assert.assertTrue(assetMessageActivityReportPage.setMaxRecordField("70abcd").clickOnRunReportButton().byDefaultIsDisplayedMaxRows("70"));
        Assert.assertTrue(assetMessageActivityReportPage.setMaxRecordField("   80").clickOnRunReportButton().byDefaultIsDisplayedMaxRows("80"));
    }
    @Test(priority = 6)
    public void  RunReportButtonTest(){
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSelectedCurrentAndPastDate("March 15, 2021", "March", "2021", "previous"));
        assetMessageActivityReportPage.clickOnPageTitle();
        Assert.assertTrue(assetMessageActivityReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 7)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetMessageActivityReportPage.isExcelButtonClickable());
    }
    @Test(priority = 8)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetMessageActivityReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 9)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetMessageActivityReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageActivityReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetMessageActivityReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageActivityReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetMessageActivityReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 10)
    public void MessageOptionalField() {
        Assert.assertTrue(assetMessageActivityReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetMessageActivityReportPage.setEmailField("sunny@mailinator.com");
        assetMessageActivityReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 11)
    public void SendButtonTest() {
        Assert.assertTrue(assetMessageActivityReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetMessageActivityReportPageTitle());
    }
    @Test(priority = 12)
    public void CancelButtonTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(assetMessageActivityReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetMessageActivityReportPageTitle());
    }
    @Test(priority = 13)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedEventTimeColumn());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedActivityTypeColumn());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedDetailsColumn());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedCreationTimeColumn());
    }
    @Test(priority = 14)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSearchData("Message Type: Modbus Query Response"));
        Assert.assertFalse(assetMessageActivityReportPage.isDisplayedSearchData("vvvv"));
        assetMessageActivityReportPage.setSearchField(AssetMessageActivityReportPage.manualDelete());
    }

    @Test(priority = 15)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSortingClientNameColumn());
       // Assert.assertTrue(assetMessageActivityReportPage.isDisplayedSortingTireNamedColumn());
        //  Assert.assertTrue(assetEventNotificationReportPage.isDisplayedSortingDatapointNumberColumn());
    }
}
