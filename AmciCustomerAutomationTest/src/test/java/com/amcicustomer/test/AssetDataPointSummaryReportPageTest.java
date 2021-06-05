package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AssetDataPointSummaryReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class AssetDataPointSummaryReportPageTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetDataPointSummaryReportPage assetDataPointSummaryReportPage ;

    private AssetDataPointSummaryReportPageTest (){

    }
    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        assetDataPointSummaryReportPage = new AssetDataPointSummaryReportPage();
    }


    @Test(priority = 1)
    public void DefaultViewOfThePageTest(){
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnAssetDataPointSummaryReportButton().isDisplayedAssetDataPointSummaryReportPageTitle());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSelectAssetDropDownButton());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedRunReportButton());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedEmailButton());
    }

    @Test(priority = 2)
    public void SelectAssetDropDownTest(){
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
        assetDataPointSummaryReportPage.clickOnSelectAllButton();
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedMultipleAssets(0));
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedMultipleAssets());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void  RunReportButtonTest(){
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 4)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetDataPointSummaryReportPage.isExcelButtonClickable());
    }
    @Test(priority = 5)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 6)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetDataPointSummaryReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetDataPointSummaryReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetDataPointSummaryReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetDataPointSummaryReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 7)
    public void MessageOptionalField() {
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetDataPointSummaryReportPage.setEmailField("sunny@mailinator.com");
        assetDataPointSummaryReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 8)
    public void SendButtonTest() {
        Assert.assertTrue(assetDataPointSummaryReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetDataPointSummaryReportPageTitle());
    }
    @Test(priority = 9)
    public void CancelButtonTest() {
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetDataPointSummaryReportPageTitle());
    }

    @Test(priority = 10)
    public void  ReportColumnsNameTest(){
      Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedDatapointNumberColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedChannelNameColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedAlarmStateColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedDatapointStatusColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedDatapointValueColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedUnitsColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedEncodeDescriptionColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedLastUpdateTimeColumn());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedAssetId());
    }
    @Test(priority = 11)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSearchData("CDN TEST #1"));
        Assert.assertFalse(assetDataPointSummaryReportPage.isDisplayedSearchData("vvvv"));
        DriverManager.getWebDriver().navigate().refresh();
        Assert.assertTrue(assetDataPointSummaryReportPage.clickOnRunReportButton().isDisplayedReportData());
        Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayed());
    }

    @Test(priority = 12)
    public void VerifyTheReportColumnsSortingTest(){
      Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedByDefaultAscendingOrder());
      Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSortingClientNameColumn());
      Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSortingTireNamedColumn());
     // Assert.assertTrue(assetDataPointSummaryReportPage.isDisplayedSortingDatapointNumberColumn());
    }



}
