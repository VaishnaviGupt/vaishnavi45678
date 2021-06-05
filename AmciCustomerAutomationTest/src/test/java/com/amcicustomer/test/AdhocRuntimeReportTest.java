package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AdhocRuntimeReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class AdhocRuntimeReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdhocRuntimeReportPage adhocRuntimeReportPage;


    private AdhocRuntimeReportTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        adhocRuntimeReportPage = new AdhocRuntimeReportPage();
    }

    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(adhocRuntimeReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnAdhocRunTimeButton().isDisplayedAdhocRunTimePageTitle());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedStartDate());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectAssetDropDown());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedEndDate());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedReportType());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedFileFormat());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedPreviewReport());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedDownloadReportButton());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedEmailButton());
    }

    @Test(priority = 2)
    public void StartDateCalendarFieldTest() {
        Assert.assertTrue(adhocRuntimeReportPage.byDefaultIsDisplayedCurrentDateInStartDate());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectedCurrentAndPastDate(AdhocRuntimeReportPage.todayDate(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void EndDateCalendarField() {
        Assert.assertTrue(adhocRuntimeReportPage.byDefaultIsDisplayedCurrentDateInEndDate());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectedCurrentAndPastEndDate(AdhocRuntimeReportPage.endDateEvent(), AdhocRuntimeReportPage.currentMonths(), "2021", "previous"));
        Assert.assertTrue(adhocRuntimeReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedErrorMessage());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 4)
    public void ReportTypeDropDownTest() {
        Assert.assertTrue(adhocRuntimeReportPage.clickOnReportTypeDropDown().isDisplayedRuntimeWithRootCauseOptions());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedReportBasicPlusOptions());
    }

    @Test(priority = 5)
    public void SelectAssetDropDownTest() {
        Assert.assertTrue(adhocRuntimeReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
        Assert.assertTrue(adhocRuntimeReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
        adhocRuntimeReportPage.clickOnSelectAllButton();
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMultipleAssets(0));
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMultipleAssets());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 6)
    public void FileFormatTest() {
        Assert.assertEquals(adhocRuntimeReportPage.getFileFormat(), "xlsx");
    }

    @Test(priority = 7)
    public void ButtonPreviewReportTest() {
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSelectedCurrentAndPastDate("August 20, 2020", "August", "2020", "previous"));
        Assert.assertTrue(adhocRuntimeReportPage.clickOnPageTitle().clickOnPreviewReportButton().isDisplayedDataInGrid());
    }

    @Test(priority = 8)
    public void DownloadReportButtonTest() {
        Assert.assertTrue(adhocRuntimeReportPage.isClickableDownloadButton());
    }

    @Test(priority = 9)
    public void EmailButtonTest() {
        Assert.assertTrue(adhocRuntimeReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMessageField());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSendButton());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedCancelButton());
    }

    @Test(priority = 10)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(adhocRuntimeReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(adhocRuntimeReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(adhocRuntimeReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(adhocRuntimeReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(adhocRuntimeReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }

    @Test(priority = 11)
    public void MessageOptionalField() {
        Assert.assertTrue(adhocRuntimeReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        adhocRuntimeReportPage.setEmailField("sunny@mailinator.com");
        adhocRuntimeReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }

    @Test(priority = 12)
    public void SendButtonTest() {
        Assert.assertTrue(adhocRuntimeReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAdhocRunTimePageTitle());
    }

    @Test(priority = 13)
    public void CancelButtonTest() {
        Assert.assertTrue(adhocRuntimeReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAdhocRunTimePageTitle());
    }

    @Test(priority = 14)
    public void ReportGridTest() {
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSummaryTab());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedDetailTab());
    }

    @Test(priority = 15)
    public void SummaryReportTest() {
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedAssetNameColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedUnitNumberColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedRuntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedRuntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedStandByHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedStandByColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedDowntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedDowntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedStandBY());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanicalRuntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanismRuntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanicalDowntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanicalRuntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanismRuntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanicalDowntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedMechanicalDowntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedProductionRuntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedProductionDowntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedUnallocatedRuntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedUnallocatedRuntimeColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedUnallocatedDowntimeHoursColumn());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedUnallocatedDowntimeColumn());
    }

    @Test(priority = 16)
    public void SummaryReportGridControlsTest() {
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(adhocRuntimeReportPage.isDisplayedSearchData("CDN TEST #1"));
        Assert.assertFalse(adhocRuntimeReportPage.isDisplayedSearchData("vvvv"));
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 17)
    public void SummaryReportColumnSortingTest(){

    }

    @Test(priority = 18)
    public void  DetailReportTest(){

    }

    @Test(priority = 19)
    public void DetailReportGridControlsTest(){

    }

    @Test(priority = 20)
    public void DetailReportColumnSortingTest(){

    }



}
