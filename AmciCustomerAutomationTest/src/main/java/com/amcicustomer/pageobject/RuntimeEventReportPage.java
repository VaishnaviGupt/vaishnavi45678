package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.DropDown;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class RuntimeEventReportPage extends BasePage {

    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Runtime Event Report']")
    WebElement runtimeEventReportButton;

    @FindBy(xpath = "//h4[normalize-space()='Runtime Event Report']")
    WebElement runtimeEventReportPageTitle;

    @FindBy(xpath = "//select[@name='selectedAssetId']")
    WebElement assetDropDownButton;

    @FindBy(xpath = "//input[@id='startDate']")
    WebElement startDate;

    @FindBy(xpath = "//input[@id='endDate']")
    WebElement endDate;

    @FindBy(xpath = "//button[normalize-space()='Run Report']")
    WebElement runReportButton;

    @FindBy(xpath = "//button[normalize-space()='Excel']")
    WebElement excelButton;

    @FindBy(xpath = "//button[normalize-space()='Email']")
    WebElement emailButton;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//select[@class='flatpickr-monthDropdown-months']")
    WebElement month;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//input[@aria-label='Year']")
    WebElement year;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput arrowTop open']//input[@aria-label='Year']")
    WebElement selectedYear;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@class='flatpickr-prev-month']//*[local-name()='svg']")
    WebElement previousButton;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@class='flatpickr-next-month']//*[local-name()='svg']")
    WebElement nextButton;

    @FindBy(xpath = "//div[@class='flatpickr-calendar hasTime animate showTimeInput arrowTop open']//span[@class='flatpickr-next-month']//*[local-name()='svg']")
    WebElement selectedNext;

    @FindBy(xpath = "//span[normalize-space()='Start Date should not be greater than End Date']")
    WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody/tr[1]")
    WebElement reportTable;

    @FindBy(xpath = "//input[@name='emails']")
    WebElement emailsField;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement messageField;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//div[@class='text-danger']")
    WebElement errorMessageEmailPopup;

    @FindBy(xpath = "//div[text()='Email Address is required']")
    WebElement errorMessageBlankEmailField;

    @FindBy(xpath = "//select[@name='report_table_length']")
    WebElement summaryLength;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody/tr[1]")
    WebElement dataTable;

    @FindBy(xpath = "//th[@aria-label='Client Name: activate to sort column descending']")
    WebElement clientName;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[1]")
    WebElement clientNameData;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[2]")
    List<WebElement> tierNameData;

    @FindBy(xpath = "//th[text()='Client Name']")
    WebElement clientNameColumn;

    @FindBy(xpath = "//th[text()='Tier Name']")
    WebElement tierNameColumn;

    @FindBy(xpath = "//th[text()='Site Name']")
    WebElement siteNameColumn;

    @FindBy(xpath = "//th[text()='Asset Name']")
    WebElement assetNameColumn;

    @FindBy(xpath = "//th[text()='Datapoint Number']")
    WebElement datapointNumberColumn;

    @FindBy(xpath = "//th[text()='Datapoint Description']")
    WebElement datapointDescriptionColumn;

    @FindBy(xpath = "//th[text()='Component Description']")
    WebElement componentDescriptionColumn;

    @FindBy(xpath = "//th[text()='Fault Code']")
    WebElement faultCodeColumn;

    @FindBy(xpath = "//th[text()='Source']")
    WebElement sourceColumn;

    @FindBy(xpath = "//th[text()='Event Time']")
    WebElement eventTimeColumn;

    @FindBy(xpath = "//th[text()='Alarm State']")
    WebElement alarmStateColumn;

    @FindBy(xpath = "//th[text()='Status Description']")
    WebElement statusDescriptionColumn;

    @FindBy(xpath = "//th[text()='Comment']")
    WebElement commentColumn;

    @FindBy(xpath = "//th[text()='Event Downtime in Minutes']")
    WebElement eventDowntimeInMinutesColumn;

    @FindBy(xpath = "//th[text()='Event Downtime in Hours']")
    WebElement eventDowntimeInHoursColumn;

    @FindBy(xpath = "//th[text()='Interval Downtime in Minutes']")
    WebElement intervalDowntimeInMinutesColumn;

    @FindBy(xpath = "//th[text()='Interval Downtime in Hours']")
    WebElement intervalDowntimeInHoursColumn;

    @FindBy(xpath = "//th[text()='Uptime Percentage']")
    WebElement uptimePercentageColumn;














    public RuntimeEventReportPage (){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    @SneakyThrows
    public RuntimeEventReportPage scroll(){
        Thread.sleep(3000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[normalize-space()='Runtime Event Report']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
        return this;
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnRuntimeEventReportButton(){
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeEventReportButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedRuntimeEventReportPageTitle(){
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeEventReportPageTitle)).isDisplayed();
    }
    public boolean isDisplayedAssetDropDownButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDropDownButton)).isDisplayed();
    }

    public boolean isDisplayedStartDate() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, startDate)).isDisplayed();
    }

    public boolean isDisplayedEndDate() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, endDate)).isDisplayed();
    }

    public boolean isDisplayedRunReportButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).isDisplayed();
    }

    public boolean isDisplayedExcelButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, excelButton)).isDisplayed();
    }

    public boolean isDisplayedEmailButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).isDisplayed();
    }

    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInStartDate() {
        Thread.sleep(6000);
        String string = startDate.getAttribute("value");
        return string.substring(0, string.length() - 6).equalsIgnoreCase(this.currentDate());
    }

    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");//yyyy-MM-dd
        Date date = new Date();
        String todayDateText = dateFormat.format(date);
        return todayDateText.substring(0, todayDateText.length() - 6);
    }
    @SneakyThrows
    public boolean isDisplayedSelectedCurrentAndPastDate(String exDays, String exMonth, String exYear, String exDate) {
        Thread.sleep(4000);
        startDate.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        String yearText;
        try {
            yearText = (String) js.executeScript("return arguments[0].value", year);
        } catch (Exception exception) {
            yearText = (String) js.executeScript("return arguments[0].value", selectedYear);
        }
        while (!yearText.equalsIgnoreCase(exYear)) {
            if (exDate.equalsIgnoreCase("previous")) {
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, previousButton)).click();
            } else {
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).click();
            }
            yearText = (String) js.executeScript("return arguments[0].value", year);
        }
        selectDropdownValue(month, DropDown.VISIBLETEXT, exMonth);
        Thread.sleep(4000);
        //February 2, 2021
        DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@aria-label='" + exDays + "']")).click();////div[@class='flatpickr-calendar hasTime animate showTimeInput arrowTop open']//span[@aria-label='April 11, 2021']
        String string = (String) js.executeScript("return arguments[0].value", startDate);
        Date date = new Date(exDays);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = formatter.format(date);
        return string.substring(0, string.length() - 9).equalsIgnoreCase(strDate);
    }

    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInEndDate() {
        Thread.sleep(6000);
        String string = endDate.getAttribute("value");
        System.out.println(string);
        return string.substring(0, string.length() - 6).equalsIgnoreCase(this.currentDate());
    }

    @SneakyThrows
    public boolean isDisplayedSelectedCurrentAndPastEndDate(String exDays, String exMonth, String exYear, String exDate) {
        Thread.sleep(4000);
        endDate.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        String yearText;
        try {
            yearText = (String) js.executeScript("return arguments[0].value", year);
        } catch (Exception exception) {
            yearText = (String) js.executeScript("return arguments[0].value", selectedYear);
        }
        while (!yearText.equalsIgnoreCase(exYear)) {
            if (exDate.equalsIgnoreCase("previous")) {
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, previousButton)).click();
            } else {
                Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).click();
            }
            yearText = (String) js.executeScript("return arguments[0].value", year);
        }
        selectDropdownValue(month, DropDown.VISIBLETEXT, exMonth);
        Thread.sleep(4000);
        //February 2, 2021
        DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@aria-label='" + exDays + "']")).click();
        String string = (String) js.executeScript("return arguments[0].value", endDate);
        Date date = new Date(exDays);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = formatter.format(date);
        return string.substring(0, string.length() - 9).equalsIgnoreCase(strDate);
    }

    @SneakyThrows
    public void selectAsset(String value) {
        Thread.sleep(3000);
        selectDropdownValue(assetDropDownButton, DropDown.VISIBLETEXT, value);
    }
    public RuntimeEventReportPage clickOnPageTitle() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeEventReportPageTitle)).click();
        return this;
    }

    public RuntimeEventReportPage clickOnPreviewReportButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }

    public boolean isDisplayedErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessage)).isDisplayed();
    }

    public RuntimeEventReportPage clickOnRunReportButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }
    @SneakyThrows
    public boolean isDisplayedReportData() {
        Thread.sleep(20000);
        String report = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportTable)).getText();
        return !report.isEmpty();
    }

    public Boolean isExcelButtonClickable() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, excelButton)).isDisplayed();
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnEmailButton() {
        sleep(5000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedEmailField() {
        sleep(2000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailsField)).isDisplayed();
    }

    public boolean isDisplayedMessageField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, messageField)).isDisplayed();
    }

    public boolean isDisplayedSendButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sendButton)).isDisplayed();
    }

    public boolean isDisplayedCancelButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).isDisplayed();
    }

    public RuntimeEventReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnSendButton() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sendButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedErrorMessageEmailPopup() {
        sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageEmailPopup)).isDisplayed();
    }

    @SneakyThrows
    public RuntimeEventReportPage clickOnCancelButton() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedErrorMessageBlankEmailField() {
        sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageBlankEmailField)).isDisplayed();
    }

    @SneakyThrows
    public RuntimeEventReportPage setMessageField(String message) {
        sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedByDefaultSelected10Data() {
        Select select = new Select(summaryLength);
        return select.getFirstSelectedOption().getText().equalsIgnoreCase("10");
    }
    @SneakyThrows
    public boolean isDisplayedSearchData(String value) {
        Thread.sleep(4000);
        sendKeysToWebElement(searchField, value, WaitStrategy.VISIBLE);
        return dataTable.getText().contains(value);
    }

    public void setSearchField(String value){
        sendKeysToWebElement(searchField,value,WaitStrategy.VISIBLE);
    }
    public boolean isDisplayedByDefaultAscendingOrder(){
        return   Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, clientName)).isDisplayed();
    }

    public boolean isDisplayedSortingClientNameColumn(){
        return getShorting(clientNameData);
    }
    public boolean isDisplayedSortingTireNamedColumn(){
        return getShorting(tierNameData);
    }

    public boolean isDisplayedClientNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, clientNameColumn)).isDisplayed();
    }

    public boolean isDisplayedTierNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, tierNameColumn)).isDisplayed();
    }

    public boolean isDisplayedSiteNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteNameColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameColumn)).isDisplayed();
    }

    public boolean isDisplayedDatapointNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, datapointNumberColumn)).isDisplayed();
    }

    public boolean isDisplayedDatapointDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, datapointDescriptionColumn)).isDisplayed();
    }

    public boolean isDisplayedComponentDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, componentDescriptionColumn)).isDisplayed();
    }

    public boolean isDisplayedFaultCodeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, faultCodeColumn)).isDisplayed();
    }

    public boolean isDisplayedSourceColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sourceColumn)).isDisplayed();
    }

    public boolean isDisplayedEventTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventTimeColumn)).isDisplayed();
    }

    public boolean isDisplayedAlarmStateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alarmStateColumn)).isDisplayed();
    }

    public boolean isDisplayedStatusDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, statusDescriptionColumn)).isDisplayed();
    }

    public boolean isDisplayedSCommentColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, commentColumn)).isDisplayed();
    }

    public boolean isDisplayedEventDowntimeInMinutesColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventDowntimeInMinutesColumn)).isDisplayed();
    }

    public boolean isDisplayedEventDowntimeInHoursColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventDowntimeInHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedIntervalDowntimeInMinutesColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, intervalDowntimeInMinutesColumn)).isDisplayed();
    }

    public boolean isDisplayedIntervalDowntimeInHoursColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, intervalDowntimeInHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedUptimePercentageColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, uptimePercentageColumn)).isDisplayed();
    }
}
