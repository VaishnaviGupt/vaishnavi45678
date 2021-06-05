package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.enums.DropDown;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CustomerAssetPage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement noMatchingRecordsFoundText;

    @FindBy(xpath = "//td[@class='routerLink'][normalize-space()='CDN TEST #1']")
    WebElement assetName;

    @FindBy(xpath = "//button[@title='Asset Details']")
    WebElement assetDetails;

    @FindBy(xpath = "//*[@id='asset_data_table']/tbody/tr[1]/td[1]/span")
    WebElement statusBar;

    @FindBy(xpath = "//h3[text()='Asset Detail']")
    WebElement assetDetailPageTitle;

    @FindBy(xpath = "//td[@class='date-format routerLink']")
    WebElement lastEventTimeButton;

    @FindBy(xpath = "//h3[normalize-space()='Events']")
    WebElement eventPageTitle;

    @FindBy(xpath = "//span[@class='asset-position routerLink']")
    WebElement lastPositionDateButton;

    @FindBy(xpath = "//*[@id=\"addsitemap\"]/div/div/div[2]/agm-map/div[1]/div/div/div[1]/div[3]/div/div[3]/div/img")
    WebElement assetPositionsOnMap;

    @FindBy(xpath = "//h4[normalize-space()='Asset Position']")
    WebElement assetPositionsMap;

    @FindBy(xpath = "//div[@id='addsitemap']//button[@type='button'][normalize-space()='×']")
    WebElement closeButtonMap;

    @FindBy(xpath = "//a[normalize-space()='Show all']")
    WebElement showAllButton;

    @FindBy(xpath = "//a[normalize-space()='By User Role']")
    WebElement userRoleTab;

    @FindBy(xpath = "//h4[normalize-space()='Primary Contact']")
    WebElement primaryContactTab;

    @FindBy(xpath = "//h4[normalize-space()='Secondary Contact']")
    WebElement secondaryContactTab;

    @FindBy(xpath = "//a[normalize-space()='By Time']")
    WebElement byTimeTab;

    @FindBy(xpath = "//h4[normalize-space()='Contacts by Time']")
    WebElement contactsByTimeTab;

    @FindBy(xpath = "//div[@id='datetimepicker']//span[@class='add-on']")
    WebElement whenDateDropDown;

    @FindBy(xpath = "//span[text()='These User(s) will receive : ']")
    WebElement theseUsersWillReceiveText;

    @FindBy(xpath = "//*[@id=\"userRoleTab\"]/div[1]/div[2]/div[1]/div[1]/span/span[1]/span/img")
    WebElement emailWithAcknowledgementToolTip;

    @FindBy(xpath = "//img[@title='SMS with Acknowledgement']")
    WebElement smsWithAcknowledgementToolTip;

    @FindBy(xpath = "//img[@title='Escalation if no Ack after 5 minutes']")
    WebElement escalationIfNoAckToolTip;

    @FindBy(xpath = "//img[@title='Live Call (if On-Call)']")
    WebElement liveCallToolTip;

    @FindBy(xpath = "//a[normalize-space()='By Calendar']")
    WebElement byCalendarTab;

    @FindBy(xpath = "//h4[normalize-space()='TestCalendar']")
    WebElement testCalendarTab;

    @FindBy(xpath = "//i[@class='fas colorfff fa-chevron-left']")
    WebElement provisionsDateButton;

    @FindBy(xpath = "//*[@id=\"shiftTab\"]/div[2]/h4")
    WebElement todayDateText;

    @FindBy(xpath = "//i[@class='fas colorfff fa-chevron-right']")
    WebElement nextDateButton;

    @FindBy(xpath = "//h6[@class='text-left day_heading_6']")
    WebElement dayShift;

    @FindBy(xpath = "//td[normalize-space()='Jayesh Gupta']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='notifyDate']")
    WebElement whenDateField;

    @FindBy(xpath = "//select[@id='notificationType']")
    WebElement notificationTypeDropDown;

    @FindBy(xpath = "//a[normalize-space()='Asset Graph']")
    WebElement assetGraphButton;

    @FindBy(xpath = "//h3[normalize-space()='Asset Graph']")
    WebElement assetGraphPageTitle;

    @FindBy(xpath = "//i[@class='fas fa-chart-bar']")
    WebElement actionButton;

    @FindBy(xpath = "//h4[@class='modal-title'][normalize-space()='Asset Graph']")
    WebElement assetGraph;

    @FindBy(xpath = "//div[@class='modal-dialog modal-big']//button[@type='button'][normalize-space()='×']")
    WebElement assetGraphCloseButton;

    @FindBy(xpath = "//a[normalize-space()='Comments']")
    WebElement commentsButton;

    @FindBy(xpath = "//h3[normalize-space()='Comments']")
    WebElement commentsPageTitle;

    @FindBy(xpath = "//select[@class='form-control']")
    WebElement commentTypeFilterDroDown;

    @FindBy(xpath = "//td[text()='Site']")
    WebElement siteType;

    @FindBy(xpath = "//td[@class='text-center']")
    WebElement noRecordFoundText;

    @FindBy(xpath = "//td[text()='Product']")
    WebElement productType;

    @FindBy(xpath = "//td[text()='Terminal']")
    WebElement terminalType;

    @FindBy(xpath = "//td[text()='Notification']")
    WebElement notificationType;

    @FindBy(xpath = "//td[text()='Customer']")
    WebElement customerType;

    @FindBy(xpath = "//a[normalize-space()='Events']")
    WebElement eventsButton;

    @FindBy(xpath = "//*[@id=\"less-text4\"]")
    WebElement commentText;

    @FindBy(xpath = "//a[@id='Show4']")
    WebElement showMoreButton;

    @FindBy(xpath = "//*[@id=\"startDate\"]")
    WebElement startDate;

    @FindBy(xpath = "//*[@id=\"endDate\"]")
    WebElement endDate;

    @FindBy(xpath = "//span[@class='btn cursor-pointer-default']")
    WebElement status;

    @FindBy(xpath = "//*[@class='table table-striped no-bordered']/tbody/tr[1]/td[2]")
    WebElement assetNameEvent;

    @FindBy(xpath = "//*[@class='table table-striped no-bordered']/tbody/tr[1]/td[3]")
    WebElement siteName;

    @FindBy(xpath = "//*[@class='table table-striped no-bordered']/tbody/tr[1]/td[4]")
    WebElement lastEventTime;

    @FindBy(xpath = "//*[@class='table table-striped no-bordered']/tbody/tr[1]/td[5]")
    WebElement lastPositionDate;

    @FindBy(xpath = "//a[normalize-space()='Terminal Traffic']")
    WebElement terminalTrafficButton;

    @FindBy(xpath = "//h3[normalize-space()='Terminal Traffic']")
    WebElement terminalTrafficPageTitle;

    @FindBy(xpath = "//div[@class='form-inline']//div[1]//span[1]")
    WebElement dateField;

    @FindBy(xpath = "/html/body/div[10]/ul/li[1]/div")
    WebElement datePicker;

    @FindBy(xpath = "//th[@class='prev']/following-sibling::th[@class='switch']")
    WebElement dayAndMonthYear;

    @FindBy(xpath = "//th[@class='prev']")
    WebElement previousMonthYear;

    @FindBy(xpath = "//*[@id=\"data_table\"]/tbody/tr/td[4]")
    WebElement lastEventTimeText;

    @FindBy(xpath = "//a[normalize-space()='By User Role']")
    WebElement byUserRoleButton;


    public CustomerAssetPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Override
    public String getCurrentURL() {
        return super.getCurrentURL();
    }

    public CustomerAssetPage setSearchField(String value) {
        sendKeysToWebElement(searchField, value, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedNoMatchingRecordsFound() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noMatchingRecordsFoundText)).isDisplayed();
    }

    public boolean isDisplayedAssetName() {
        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("CDN TEST #5")){
          return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//td[@class='routerLink'][normalize-space()='CDN TEST #5']")))).isDisplayed();
        }else {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetName)).isDisplayed();
        }
        }

    public void clearSearch() {
        searchField.clear();
    }

    public boolean isDisplayedAssetDetail() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDetails)).isDisplayed();
    }

    public String getStatus() {
        return statusBar.getAttribute("title");
    }

    @SneakyThrows
    public CustomerAssetPage clickOnAssetDetailButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDetails)).click();
        return this;
    }

    public boolean isDisplayedAssetDetailPageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDetailPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public CustomerAssetPage clickOnLastEventTime() {
        Thread.sleep(5000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastEventTimeButton)).click();
        return this;
    }

    public boolean isDisplayedEventTimePageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public CustomerAssetPage clickOnLastPositionDateButton() {
        Thread.sleep(10000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastPositionDateButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetPositionPopup() {
        Thread.sleep(5000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetPositionsMap)).isDisplayed();
    }


    public boolean isDisplayedAssetPosition() {
        return assetPositionsOnMap.isDisplayed();
    }

    public void clickOnCloseButtonMap() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, closeButtonMap)).click();
    }

    public CustomerAssetPage clickOnShowAllButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, showAllButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isByDefaultSelectedUserRole() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, userRoleTab)).isDisplayed();
    }

    public boolean isDisplayedPrimaryContactTab() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, primaryContactTab)).isDisplayed();
    }

    public boolean isDisplayedSecondaryContactTab() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, secondaryContactTab)).isDisplayed();
    }


    @SneakyThrows
    public CustomerAssetPage clickOnByTimeTab() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, byTimeTab)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedContactsByTimeTab() {
        Thread.sleep(2000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, contactsByTimeTab)).isDisplayed();
    }

    public CustomerAssetPage clickOnWhenDateDropDown() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, whenDateDropDown)).click();
        return this;
    }

    public boolean isDisplayedTheseUsersWillReceiveText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, theseUsersWillReceiveText)).isDisplayed();
    }

    public String getEmailWithAcknowledgementToolTip() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailWithAcknowledgementToolTip)).getAttribute("title");
    }

    public String getSmsWithAcknowledgementToolTip() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, smsWithAcknowledgementToolTip)).getAttribute("title");
    }

    public String getEscalationIfNoAckToolTip() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, escalationIfNoAckToolTip)).getAttribute("title");
    }

    public String getLiveCallToolTip() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, liveCallToolTip)).getAttribute("title");
    }

    @SneakyThrows
    public CustomerAssetPage clickOnByCalendarTab() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, byCalendarTab)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedCalendarTab() {
        Thread.sleep(4000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, testCalendarTab)).isDisplayed();
    }

    public boolean isDisplayedProvisionsDateButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, provisionsDateButton)).isDisplayed();
    }

    public String todayDate() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM ");
        Date date = new Date();
        String todayDateText = dateFormat.format(date);
        return todayDateText.trim();
    }


    public String todayDateText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, todayDateText)).getText().trim();
    }

    public boolean isDisplayedNextDayButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, nextDateButton)).isDisplayed();
    }

    public boolean isDisplayedDayShift() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dayShift)).isDisplayed();
    }

    @SneakyThrows
    public String getUserName() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, userName)).getText();
    }

    @SneakyThrows
    public void selectNextDay() {
        Thread.sleep(3000);
        whenDateField.sendKeys(endDate(), Keys.ENTER);
        // sendKeysToWebElement(whenDateField,date,WaitStrategy.VISIBLE);
    }

    public void clickOnNotificationType() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, notificationTypeDropDown)).click();
    }

    public String endDate() {
        Date objDate = new Date();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        objSDF.format(objDate);
        Calendar now = Calendar.getInstance();
        now.setTime(objDate);
        now.add(Calendar.DATE, 1);
        Date featured = now.getTime();
        return objSDF.format(featured);
    }

    public CustomerAssetPage clickOnAssertGraph() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetGraphButton)).click();
        return this;
    }

    public boolean isDisplayedAssetGraphPageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetGraphPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public CustomerAssetPage clickOnActionButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, actionButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetGraph() {
        Thread.sleep(2000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetGraph)).isDisplayed();
    }

    public void clickOnAssetGraphCloseButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetGraphCloseButton)).click();
    }

    @SneakyThrows
    public CustomerAssetPage clickOnCommentsButton() {
        Thread.sleep(2000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, commentsButton)).click();
        return this;
    }

    public boolean isDisplayedCommentsPageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, commentsPageTitle)).isDisplayed();
    }

    public CustomerAssetPage selectCommentTypeFilter(String value) {
        selectDropdownValue(commentTypeFilterDroDown, DropDown.VISIBLETEXT, value);
        return this;
    }

    public boolean isDisplayedSiteType() {
        try {
            Thread.sleep(3000);
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteType)).isDisplayed()) {
                return true;
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
        }
    }

    public boolean isDisplayedProductType() {
        try {
            Thread.sleep(3000);
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, productType)).isDisplayed()) {
                return true;
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
        }
    }

    public boolean isDisplayedTerminalType() {
        try {
            Thread.sleep(3000);
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, terminalType)).isDisplayed()) {
                return true;
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
        }
    }

    public boolean isDisplayedNotificationType() {
        try {
            Thread.sleep(3000);
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, notificationType)).isDisplayed()) {
                return true;
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
        }
    }

    public boolean isDisplayedCustomerType() {
        try {
            Thread.sleep(3000);
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerType)).isDisplayed()) {
                return true;
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordFoundText)).isDisplayed();
        }
    }

    public CustomerAssetPage clickOnEventsButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventsButton)).click();
        return this;
    }

    public boolean isDisplayedCommentText() {
        String comments = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, commentText)).getText();
        return !comments.isEmpty();
    }

    @SneakyThrows
    public String isDisplayedByDefaultStartDate() {
        Thread.sleep(4000);
        DriverManager.getWebDriver().navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        String string = (String) js.executeScript("return arguments[0].value", startDate);
        return string.substring(0, string.length() - 3);
    }

    public String startDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String todayDateText = dateFormat.format(date);
        return todayDateText.substring(0,todayDateText.length()-3);
    }

    public String endDateEvent() {
        Date objDate = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        objSDF.format(objDate);
        Calendar now = Calendar.getInstance();
        now.setTime(objDate);
        now.add(Calendar.DATE, -3);
        Date featured = now.getTime();
        String newDate = objSDF.format(featured);
        return newDate.substring(0, newDate.length() - 3);
    }


    @SneakyThrows
    public String isDisplayedEndDate() {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        String string = (String) js.executeScript("return arguments[0].value", endDate);
        return string.substring(0,string.length()-3);
    }

    public boolean isDisplayedStatus() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, status)).isDisplayed();
    }

    @SneakyThrows
    public boolean isDisplayedAssetNameEvent() {
        Thread.sleep(3000);
        String assetNameText = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameEvent)).getText();
        return !assetNameText.isEmpty();
    }

    public boolean isDisplayedSiteNameEvent() {
        String siteNameText = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteName)).getText();
        return !siteNameText.isEmpty();
    }

    public boolean isDisplayedLastEventTime() {
        String lastEventTimeText = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastEventTime)).getText();
        return !lastEventTimeText.isEmpty();
    }

    public boolean isDisplayedLastPositionDate() {
        String lastPositionDateText = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastPositionDate)).getText();
        return !lastPositionDateText.isEmpty();
    }

    public CustomerAssetPage clickOnTerminalTraffic() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, terminalTrafficButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedTerminalTrafficPageTitle() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, terminalTrafficPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public void clickOnDateTimeField(){
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dateField)).click();
    }

    @SneakyThrows
    public void getDayAndMonth(String exDays,String exMonth,String exYear){
        Thread.sleep(5000);
        String monthYear = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dayAndMonthYear)).getText();
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();
        while (!(month.equalsIgnoreCase(exMonth)&&year.equalsIgnoreCase(exYear))){
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, previousMonthYear)).click();
             monthYear = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dayAndMonthYear)).getText();
             month = monthYear.split(" ")[0].trim();
             year = monthYear.split(" ")[1].trim();
        }
        Thread.sleep(3000);
        DriverManager.getWebDriver().findElement(By.xpath("//td[text()='"+exDays+"']")).click();
    }

    @SneakyThrows
    public String getLastEventTime(){
        Thread.sleep(3000);
        String lastTime= Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastEventTimeText)).getText();
        return lastTime.substring(0,lastTime.length()-12);
    }
    public static String getTodayDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public CustomerAssetPage clickOnByUserRoleButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, byUserRoleButton)).click();
        return this;
    }





}
