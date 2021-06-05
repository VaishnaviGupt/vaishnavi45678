package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.reporter.ExtentLogger;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Set;

@Listeners(TestListeners.class)
public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    private DashboardTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Test(priority = 1)
    public void DropDownOptionsOfSiteTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        ExtentLogger.passLog("User is on dashboard page");
        Set<String> siteData = dashboardPage.clickOnSiteDropDown().getSiteDropDownText();
        Set<String> assetData = dashboardPage.doLoginClientApplication(FrameWorkConstants.getEMAILIDCLIENTAPPLICATION(), FrameWorkConstants.getPASSWORDCLIENTAPPLICATION()).
                clickOnSideMenuButton().
                clickOnCustomerOptionButton().clickOnCustomerName().clickOnAssertOption().
                getAssetsTableData();
        for (String string : assetData) {
            Assert.assertTrue(siteData.toString().contains(string));
        }
    }

    @Test(priority = 2)
    public void DropDownOptionsOfAssetTest() throws InterruptedException {
        loginPage.lunchURL();
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Set<String> assetData = dashboardPage.clickOnAssetDropDownButton().getAssetDropDownText();
        Set<String> assetsData = dashboardPage.lunchURL().clickOnSideMenuButton().
                clickOnCustomerOptionButton().clickOnCustomerName().clickOnAssertOption().
                getAssetTableData();
        for (String string : assetsData) {
            Assert.assertTrue(assetData.toString().contains(string));
        }

    }

    @Test(priority = 3)
    public void DefaultStatusOfTheSiteAndAssetDropDownTest() {
        loginPage.lunchURL();
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.isDisplayedSiteDropDown());
        Assert.assertTrue(dashboardPage.isDisplayedAssetDropDown());
    }

    @Test(priority = 4)
    public void FilteringThroughSiteFilterTest() {
        String selectedSiteName = dashboardPage.clickOnSiteDropDown().selectedSiteDropDownValue(0);
        String liveFeedEventSiteValue = dashboardPage
                .selectedSiteDropDown(0)
                .clickOnSiteDrop()
                .clickOnSubmitButton()
                .getLiveFeedEventSiteTableData();
        if (liveFeedEventSiteValue.equalsIgnoreCase("No data available in table")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals(selectedSiteName, liveFeedEventSiteValue);
        }

    }

    @Test(priority = 5)
    public void FilteringThroughAssetFilterTest() {
        String selectedAssetName = dashboardPage.clickOnAssetDropDownButton().selectAssetDropDownValue(0);
        String liveFeedEventAssetValue = dashboardPage.selectedAssetDropDown(0).clickOnSiteDrop().clickOnSubmitButton().getLiveFeedEventAssetTableData();
        if (liveFeedEventAssetValue.equalsIgnoreCase("No data available in table")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals(selectedAssetName, liveFeedEventAssetValue);
        }
    }

    @Test(priority = 6)
    public void FilteringThroughSiteAndAssetFiltersTest() {
        String selectedSiteName = dashboardPage.clickOnAfterSiteDropDownButton().getOnCDNSite();
        dashboardPage.clickOnSiteDrop();
        String selectedAssetName = dashboardPage.clickOnAfterSelectAsset().getCdnAsset();
        String liveFeedEventAssetValue = dashboardPage.getLiveFeedEventAssetTableData();
        String liveFeedEventSiteValue = dashboardPage.getLiveFeedEventSiteTableData();
        if (liveFeedEventSiteValue.equalsIgnoreCase("No data available in table")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals(selectedSiteName, liveFeedEventSiteValue);
        }
        if (liveFeedEventAssetValue.equalsIgnoreCase("No data available in table")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals(selectedAssetName, liveFeedEventAssetValue);
        }
    }

    @Test(priority = 7)
    public void UnCheckedSiteFunctionalityTest() {
        dashboardPage.clickOnAfterSiteDropDownButton().clickOnCDNSite();
        Assert.assertTrue(dashboardPage.isDisplayedAssetDropDown());
    }

    @SneakyThrows
    @Test(priority = 8)
    public void ResetButtonOfTheSiteAndAssetFiltersTest() {
        dashboardPage.clickOnAssetDropDownButton().clickOnCdnAsset().clickOnResetButton();
        Assert.assertTrue(dashboardPage.isDisplayedSiteDropDown());
        Assert.assertTrue(dashboardPage.isDisplayedAssetDropDown());
    }

    @Test(priority = 9)
    public void AlarmSitesInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.isDisplayedAlarmSitesInTheMap());
    }

    @Test(priority = 10)
    public void TheNormalSitesInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.clickOnNormalSiteRadioButton().isDisplayedNormalSitesInTheMap());
    }

    @Test(priority = 11)
    public void TheWarningSitesInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.clickOnWarningSiteRadioButton().isDisplayedWarningSitesInTheMap());
    }

    @Test(priority = 12)
    public void TheSuspendedSitesInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.clickOnSuspendedSiteRadioButton().isDisplayedSuspendedSitesInTheMap());
    }

    @Test(priority = 13)
    public void NoCommSitesInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.clickOnNoCommSiteRadioButton().isDisplayedNoCommSitesInTheMap());
    }

    @Test(priority = 14)
    public void MapWidgetsDefaultViewInTheTest() {
        Assert.assertTrue(dashboardPage.isDisplayedMapButton());
        Assert.assertTrue(dashboardPage.isDisplayedSatelliteButton());
        Assert.assertTrue(dashboardPage.clickOnMapButton().isDisplayedMapDataText());
    }

    @Test(priority = 15)
    public void MapWidgetSatelliteViewInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedSatelliteButton());
        Assert.assertTrue(dashboardPage.clickOnSatelliteButton().isDisplayedRotateButton());
    }

    @Test(priority = 16)
    public void ControlsOfTheMapWidgetInTheMapTest() {
        Assert.assertTrue(dashboardPage.isDisplayedToggleFullscreenViewButton());
        Assert.assertTrue(dashboardPage.isDisplayedPegManButton());
        Assert.assertTrue(dashboardPage.isDisplayedZoomInButton());
        Assert.assertTrue(dashboardPage.isDisplayedZoomOutButton());
    }

    // donut chart test case start here
    @Test(priority = 17)
    public void DefaultViewOfAssetStatusWidgetTest() {
        //dashboardPage.clickOnNormalAlarmChartButton("2");
        //System.out.println(dashboardPage.clickOnSideMenuButtonCustomer().clickOnAssetOptions().getNormalAlarmCount());
    }

    @Test(priority = 18)
    public void verifyTheControlsOfTheLiveFeedEventsWidget() {
        Assert.assertTrue(dashboardPage.isDisplayedByDefaultEntriesCount());
        Assert.assertTrue(dashboardPage.selectEntriesPerPage("25"));
        Assert.assertTrue(dashboardPage.selectEntriesPerPage("50"));
        Assert.assertTrue(dashboardPage.selectEntriesPerPage("100"));
        Assert.assertTrue(dashboardPage.isDisplayedSearchField());
    }

    @Test(priority = 19)
    public void verifyTheSearchFunctionality() {
        Assert.assertEquals(dashboardPage.setSearchField("abc").getNoRecordsFoundText(), "No matching records found");
        Assert.assertTrue(dashboardPage.setSearchField("cdn").getLiveFeedTableData().contains("CDN"));
        Assert.assertTrue(dashboardPage.setSearchField("CDN TEST #1").getLiveFeedTableData().contains("CDN TEST #1"));
    }

    @Test(priority = 20)
    public void verifyTheSortingOfTheLiveFeedEventsGrid() {
        Assert.assertTrue(dashboardPage.IsDisplayedDefaultSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedStatusSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedEventAndRunTimeStatusSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedSiteNameSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedAssetNameSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedChannelDescriptionSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedEventTypeSorting());
        Assert.assertTrue(dashboardPage.IsDisplayedEventTimeSorting());
    }


}

