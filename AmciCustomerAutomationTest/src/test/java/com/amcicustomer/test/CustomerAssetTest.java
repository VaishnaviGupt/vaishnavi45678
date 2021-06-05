package com.amcicustomer.test;

import com.amcicustomer.baseTest.BaseTest;
import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.listeners.TestListeners;
import com.amcicustomer.pageobject.CustomerAssetPage;
import com.amcicustomer.pageobject.DashboardPage;
import com.amcicustomer.pageobject.LoginPage;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class CustomerAssetTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerAssetPage customerAssetPage;

    private CustomerAssetTest() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        customerAssetPage = new CustomerAssetPage();
    }

    @Test(priority = 1)
    public void RedirectionOfTheUserOnTheAssetsPageTest() {
        loginPage.redirectDashboardPage(PropertyUtils.getValue(ConfigProperties.VALIDEMAILID), PropertyUtils.getValue(ConfigProperties.VALIDPASSWORD));
        Assert.assertTrue(dashboardPage.isDisplayedDashboardPageTitle());
        Assert.assertTrue(dashboardPage.clickOnSideMenuButton().clickOnAssetOption().isDisplayedAssetPageTitle());
        Assert.assertEquals(customerAssetPage.getCurrentURL(), FrameWorkConstants.getASSETPAGEURL());
    }

    @Test(priority = 2)
    public void SearchFunctionalityOnTheAssetListPageTest() {
        Assert.assertTrue(customerAssetPage.setSearchField("abc").isDisplayedNoMatchingRecordsFound());
        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("CDN TEST #5")){
            Assert.assertTrue(customerAssetPage.setSearchField("CDN TEST #5").isDisplayedAssetName());
        }else {
        Assert.assertTrue(customerAssetPage.setSearchField(" CDN TEST #1 ").isDisplayedAssetName());
        }
        customerAssetPage.clearSearch();
        DriverManager.getWebDriver().navigate().refresh();
    }

    @Test(priority = 3)
    public void FunctionalityOfActionButtonOnTheAssetGridTest() {
        Assert.assertTrue(customerAssetPage.isDisplayedAssetDetail());
    }

    @Test(priority = 4)
    public void ToolTipOnTheStatusIconOfTheAssetTest() {
        Assert.assertEquals(customerAssetPage.getStatus(), "Suspended");
    }

    @Test(priority = 5)
    public void ClickEventOnTheIIconOnTheActionButton() {
        Assert.assertTrue(customerAssetPage.clickOnAssetDetailButton().isDisplayedAssetDetailPageTitle());
    }

    @Test(priority = 6)
    public void clickEventOnTheLastEventTimeInTheAssetSummaryTabTest() {
        Assert.assertTrue(customerAssetPage.clickOnLastEventTime().isDisplayedEventTimePageTitle());
        DriverManager.getWebDriver().navigate().back();
    }

    @Test(priority = 7)
    public void ClickEventOnTheLastPositionDateInTheAssetSummaryTab() {
        Assert.assertTrue(customerAssetPage.clickOnLastPositionDateButton().isDisplayedAssetPositionPopup());
        Assert.assertTrue(customerAssetPage.isDisplayedAssetPosition());
        customerAssetPage.clickOnCloseButtonMap();
    }

    @Test(priority = 8)
    public void ClickEventOnTheShowAllLinkInTheLastMessageEventsTabTest() {
        Assert.assertTrue(customerAssetPage.clickOnShowAllButton().isDisplayedEventTimePageTitle());
        DriverManager.getWebDriver().navigate().back();
    }

    @Test(priority = 9)
    public void FunctionalityOfByUserRoleTabInTheAssignedContactsSectionTest() {
        Assert.assertTrue(customerAssetPage.isByDefaultSelectedUserRole());
        Assert.assertTrue(customerAssetPage.isDisplayedPrimaryContactTab());
        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("")){
            Assert.assertTrue(customerAssetPage.isDisplayedSecondaryContactTab());
        }
        Assert.assertTrue(customerAssetPage.isDisplayedTheseUsersWillReceiveText());
        Assert.assertEquals(customerAssetPage.getEmailWithAcknowledgementToolTip(), "Email with Acknowledgement");
        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("")){
            Assert.assertEquals(customerAssetPage.getSmsWithAcknowledgementToolTip(), "SMS with Acknowledgement");
            Assert.assertEquals(customerAssetPage.getEscalationIfNoAckToolTip(), "Escalation if no Ack after 5 minutes");
            Assert.assertEquals(customerAssetPage.getLiveCallToolTip(), "Live Call (if On-Call)");
        }

    }


    @Test(priority = 10)
    public void FunctionalityOfByCalendarTabInTheAssignedContactSectionTest() {
        Assert.assertTrue(customerAssetPage.clickOnByCalendarTab().isDisplayedCalendarTab());
        Assert.assertTrue(customerAssetPage.isDisplayedProvisionsDateButton());
        Assert.assertEquals(customerAssetPage.todayDate(), customerAssetPage.todayDateText());
        Assert.assertTrue(customerAssetPage.isDisplayedNextDayButton());
        Assert.assertTrue(customerAssetPage.isDisplayedDayShift());
        Assert.assertEquals(customerAssetPage.clickOnByUserRoleButton().getUserName(), "Jayesh Gupta");
    }


    @Test(priority = 11)
    public void FunctionalityOfByTimeTabInTheAssignedContactSectionTest() {
        Assert.assertTrue(customerAssetPage.clickOnByTimeTab().isDisplayedContactsByTimeTab());
        customerAssetPage.selectNextDay();
        customerAssetPage.clickOnNotificationType();
    }

    @Test(priority = 12)
    public void ViewTheAssetGraphTest() {
        Assert.assertTrue(customerAssetPage.clickOnAssertGraph().isDisplayedAssetGraphPageTitle());
        Assert.assertTrue(customerAssetPage.clickOnActionButton().isDisplayedAssetGraph());
        customerAssetPage.clickOnAssetGraphCloseButton();
    }

    @Test(priority = 13)
    public void ViewAllTheCommentsAssociatedWithTheAssetTest() {
        Assert.assertTrue(customerAssetPage.clickOnCommentsButton().isDisplayedCommentsPageTitle());
        Assert.assertTrue(customerAssetPage.isDisplayedCommentText());
    }

    @Test(priority = 14)
    public void FunctionalityOfCommentTypeFilter() {
        Assert.assertTrue(customerAssetPage.selectCommentTypeFilter("Site").isDisplayedSiteType());
        Assert.assertTrue(customerAssetPage.selectCommentTypeFilter("Product").isDisplayedProductType());
        Assert.assertTrue(customerAssetPage.selectCommentTypeFilter("Terminal").isDisplayedTerminalType());
        Assert.assertTrue(customerAssetPage.selectCommentTypeFilter("Notification").isDisplayedNotificationType());
        Assert.assertTrue(customerAssetPage.selectCommentTypeFilter("Customer").isDisplayedCustomerType());
    }


    @SneakyThrows
    @Test(priority = 15)
    public void FunctionalityOfTheEventsTabTest() {
        Assert.assertTrue(customerAssetPage.clickOnEventsButton().isDisplayedEventTimePageTitle());
        Assert.assertEquals(customerAssetPage.isDisplayedByDefaultStartDate(),customerAssetPage.endDateEvent());
        Assert.assertEquals(customerAssetPage.isDisplayedEndDate(),customerAssetPage.startDate());

    }
    @Test(priority = 16)
    public void InformationDisplayedOnThEventsPageTest(){
         Assert.assertTrue(customerAssetPage.isDisplayedStatus());
         Assert.assertTrue(customerAssetPage.isDisplayedAssetNameEvent());
         Assert.assertTrue(customerAssetPage.isDisplayedSiteNameEvent());
         Assert.assertTrue(customerAssetPage.isDisplayedLastEventTime());
         Assert.assertTrue(customerAssetPage.isDisplayedLastPositionDate());
    }

    @Test(priority = 17)
    public void ClickEventOfTheIIconOnTheActionButtonTest(){
//Data is not available
    }
    @Test(priority = 18)
    public void FunctionalityOfMaxRecordsTextFieldTest(){
//Data is not available
    }
    @Test(priority = 19)
    public void FunctionalityOfBeginDateTimeSelectBoxTest(){
//Data is not available
    }
    @Test(priority = 20)
    public void FunctionalityOfTheTerminalTrafficTabTest(){
       Assert.assertTrue(customerAssetPage.clickOnTerminalTraffic().isDisplayedTerminalTrafficPageTitle());
    }
    @Test(priority = 21)
    public void FunctionalityOfMaxRecordsTextField(){
//Data is not available
    }
    @Test(priority = 22)
    public void FunctionalityOfBeginDateTimeSelectBox(){
//Data is not available
    }






}
