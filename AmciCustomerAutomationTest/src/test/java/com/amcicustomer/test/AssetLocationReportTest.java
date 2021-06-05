package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.AssetLocationReportPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class AssetLocationReportTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetLocationReportPage assetLocationReportPage;

    private AssetLocationReportTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        assetLocationReportPage = new AssetLocationReportPage();

    }

    @Test(priority = 1)
    public void DefaultViewOfThePageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(assetLocationReportPage.clickOnSideMenu().clickOnReportOptions().
                clickOnAssetLocationReportButton().isDisplayedAssetLocationReportPageTitle());
        Assert.assertTrue(assetLocationReportPage.isDisplayedAssetDropDownButton());
        Assert.assertTrue(assetLocationReportPage.isDisplayedRunReportButton());
        Assert.assertTrue(assetLocationReportPage.isDisplayedExcelButton());
        Assert.assertTrue(assetLocationReportPage.isDisplayedEmailButton());
    }
    @Test(priority = 2)
    public void SelectAssetDropDownTest(){
        Assert.assertTrue(assetLocationReportPage.clickOnAssetDropDownButton().isDisplayedAllAssets());
        Assert.assertTrue(assetLocationReportPage.clickOnSelectAllButton().isDisplayedAllAssetSelected());
        assetLocationReportPage.clickOnSelectAllButton();
        Assert.assertTrue(assetLocationReportPage.isDisplayedMultipleAssets(0));
        Assert.assertTrue(assetLocationReportPage.isDisplayedMultipleAssets());
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void  RunReportButtonTest(){
        Assert.assertTrue(assetLocationReportPage.clickOnRunReportButton().isDisplayedReportData());
    }
    @Test(priority = 4)
    public void  ExcelButtonTest(){
        Assert.assertTrue(assetLocationReportPage.isExcelButtonClickable());
    }
    @Test(priority = 5)
    public void  EmailButtonTest(){
        Assert.assertTrue(assetLocationReportPage.clickOnEmailButton().isDisplayedEmailField());
        Assert.assertTrue(assetLocationReportPage.isDisplayedMessageField());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSendButton());
        Assert.assertTrue(assetLocationReportPage.isDisplayedCancelButton());
    }
    @Test(priority = 6)
    public void EmailAddressFieldTest() {
        Assert.assertTrue(assetLocationReportPage.setEmailField("   ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetLocationReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        Assert.assertTrue(assetLocationReportPage.setEmailField("sunnymailinator.com ").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetLocationReportPage.setEmailField("sunny@mailinator-com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
        Assert.assertTrue(assetLocationReportPage.setEmailField("sunny@@@mailinator.com").clickOnSendButton().isDisplayedErrorMessageEmailPopup());
    }
    @Test(priority = 7)
    public void MessageOptionalField() {
        Assert.assertTrue(assetLocationReportPage.clickOnCancelButton().clickOnEmailButton().clickOnSendButton().isDisplayedErrorMessageBlankEmailField());
        assetLocationReportPage.setEmailField("sunny@mailinator.com");
        assetLocationReportPage.setMessageField("Verify the Message (Optional) field test case id_013");
    }
    @Test(priority = 8)
    public void SendButtonTest() {
        Assert.assertTrue(assetLocationReportPage.setMessageField("Verify the Message (Optional) field test case id_013").clickOnSendButton().isDisplayedAssetLocationReportPageTitle());
    }
    @Test(priority = 9)
    public void CancelButtonTest() {
        Assert.assertTrue(assetLocationReportPage.clickOnEmailButton().clickOnCancelButton().isDisplayedAssetLocationReportPageTitle());
    }

    @Test(priority = 10)
    public void  ReportColumnsNameTest(){
        Assert.assertTrue(assetLocationReportPage.isDisplayedClientNameColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedTierNameColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSiteNameColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedCustomerNameColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedTerminalSerialNumberColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSiteStatusColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedLatitudeColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedLongitudeColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedCityColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedCountyColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedStateColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedProximityColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedPositionAcquiredColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedLastMessageReceivedColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedOfflineColumn());
    }
    @Test(priority = 11)
    public void  ReportGridControlsTest(){
        Assert.assertTrue(assetLocationReportPage.isDisplayedByDefaultSelected10Data());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSearchData("CDN Test"));
        Assert.assertFalse(assetLocationReportPage.isDisplayedSearchData("vvvv"));
        DriverManager.getWebDriver().navigate().refresh();
        Assert.assertTrue(assetLocationReportPage.clickOnRunReportButton().isDisplayedReportData());
        Assert.assertTrue(assetLocationReportPage.isDisplayed());
    }

    @Test(priority = 12)
    public void VerifyTheReportColumnsSortingTest(){
        Assert.assertTrue(assetLocationReportPage.isDisplayedByDefaultAscendingOrder());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSortingClientNameColumn());
        Assert.assertTrue(assetLocationReportPage.isDisplayedSortingTireNamedColumn());
       // Assert.assertTrue(assetLocationReportPage.isDisplayedSortingDatapointNumberColumn());
    }
}
