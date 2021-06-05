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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AssetEventNotificationReportPage extends BasePage {


    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Asset Event Notification Report']")
    WebElement assetEventNotificationReportButton;

    @FindBy(xpath = "//h4[normalize-space()='Asset Event Notification Report']")
    WebElement assetEventNotificationReportPageTitle;

    @FindBy(xpath = "//span[@class='dropdown-btn']")
    WebElement selectAssetDropdownButton;

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

    @FindBy(xpath = "//*[@class='item2']/li")
    WebElement asset;

    @FindBy(xpath = "//li[@class='multiselect-item-checkbox']")
    WebElement selectAllButton;

    @FindBy(xpath = "//*[@class='item2']/li")
    List<WebElement> assetList;

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

    @FindBy(xpath = "//th[text()='Client Name']")
    WebElement clientNameColumn;

    @FindBy(xpath = "//th[text()='Tier Name']")
    WebElement tierNameColumn;

    @FindBy(xpath = "//th[text()='Site Name']")
    WebElement siteNameColumn;

    @FindBy(xpath = "//th[text()='Customer Name']")
    WebElement customerNameColumn;

    @FindBy(xpath = "//th[text()='Site Description']")
    WebElement siteDescriptionColumn;

    @FindBy(xpath = "//th[text()='Terminal Serial Number']")
    WebElement terminalSerialNumberColumn;

    @FindBy(xpath = "//th[text()='Amci Serial Number']")
    WebElement amciSerialNumberColumn;

    @FindBy(xpath = "//th[text()='Notification Type']")
    WebElement notificationTypeColumn;

    @FindBy(xpath = "//th[text()='Notification Plan Name']")
    WebElement notificationPlanNameColumn;

    @FindBy(xpath = "//th[text()='Event Timestamp']")
    WebElement eventTimestampColumn;

    @FindBy(xpath = "//th[text()='Event State']")
    WebElement eventStateColumn;

    @FindBy(xpath = "//th[text()='Event Summary']")
    WebElement eventSummaryColumn;

    @FindBy(xpath = "//th[text()='Email Addresses']")
    WebElement emailAddressesColumn;

    @FindBy(xpath = "//th[text()='Phone Number']")
    WebElement phoneNumberColumn;

    @FindBy(xpath = "//select[@name='report_table_length']")
    WebElement summaryLength;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody/tr[1]")
    WebElement dataTable;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[3]")
    List <WebElement> siteNameList;

    @FindBy(xpath = "//th[@aria-label='Client Name: activate to sort column descending']")
    WebElement clientName;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[1]")
    WebElement clientNameData;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[2]")
    List<WebElement> tierNameData;


















    public AssetEventNotificationReportPage (){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @SneakyThrows
    public AssetEventNotificationReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public AssetEventNotificationReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    public AssetEventNotificationReportPage clickOnAssetEventNotificationReportButton(){
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetEventNotificationReportButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetEventNotificationReportPageTitle(){
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetEventNotificationReportPageTitle)).isDisplayed();
    }

    public boolean isDisplayedSelectAssetDropdownButton(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropdownButton)).isDisplayed();
    }

    public boolean isDisplayedStartDate(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, startDate)).isDisplayed();
    }

    public boolean isDisplayedEndDate(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, endDate)).isDisplayed();
    }
    public boolean isDisplayedExcelButton(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, excelButton)).isDisplayed();
    }
    public boolean isDisplayedEmailButton(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).isDisplayed();
    }
    public AssetEventNotificationReportPage clickOnAssetDropDownButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropdownButton)).click();
        return this;
    }
    @SneakyThrows
    public boolean isDisplayedAllAssets() {
        sleep(2000);
        for (WebElement element : ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(asset)) {
            return element.isDisplayed();
        }
        return false;
    }
    public AssetEventNotificationReportPage clickOnSelectAllButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAllButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAllAssetSelected() {
        sleep(2000);
        int assetCount = assetList.size();
        sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//span[text()='+" + assetCount + "']")))).isDisplayed();
    }
    @SneakyThrows
    public boolean isDisplayedMultipleAssets(int index){
        sleep(2000);
        int assetCount = 1;
        assetList.get(index).click();
        if (index==0){
            index=assetCount;
        }
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//span[text()='+"+index+"']")))).isDisplayed();
    }
    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInStartDate() {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        String string = (String) js.executeScript("return arguments[0].value", startDate);
        //  System.out.println(string.substring(0, string.length() - 3)+"    "+this.currentDate());
        return string.substring(0, string.length() - 3).equalsIgnoreCase(this.currentDate());
    }
    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");//yyyy-MM-dd
        Date date = new Date();
        String todayDateText = dateFormat.format(date);
        return todayDateText.substring(0, todayDateText.length() - 3);
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
        DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@aria-label='" + exDays + "']")).click();
        String string = (String) js.executeScript("return arguments[0].value", startDate);
        Date date = new Date(exDays);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = formatter.format(date);
        return string.substring(0, string.length() - 9).equalsIgnoreCase(strDate);
    }
    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInEndDate() {
        Thread.sleep(4000);
        String string = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, endDate)).getAttribute("value");
        return string.substring(0, string.length() - 3).equalsIgnoreCase(this.currentDate());
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
    public AssetEventNotificationReportPage clickOnPageTitle() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetEventNotificationReportPageTitle)).click();
        return this;
    }
    public AssetEventNotificationReportPage clickOnPreviewReportButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }
    public boolean isDisplayedErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessage)).isDisplayed();
    }

    @SneakyThrows
    public AssetEventNotificationReportPage clickOnRunReportButton(){
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }
    @SneakyThrows
    public boolean isDisplayedReportData(){
        Thread.sleep(80000);
        String report = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportTable)).getText();
        return !report.isEmpty();
    }
    public Boolean isExcelButtonClickable(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, excelButton)).isDisplayed();
    }
    @SneakyThrows
    public AssetEventNotificationReportPage clickOnEmailButton() {
        sleep(20000);
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
    public AssetEventNotificationReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }
    @SneakyThrows
    public AssetEventNotificationReportPage clickOnSendButton() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sendButton)).click();
        return this;
    }
    @SneakyThrows
    public boolean isDisplayedErrorMessageBlankEmailField() {
        sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageBlankEmailField)).isDisplayed();
    }

    @SneakyThrows
    public boolean isDisplayedErrorMessageEmailPopup() {
        sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageEmailPopup)).isDisplayed();
    }
    @SneakyThrows
    public AssetEventNotificationReportPage clickOnCancelButton() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).click();
        return this;
    }
    @SneakyThrows
    public AssetEventNotificationReportPage setMessageField(String message) {
        sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
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
    public boolean isDisplayedCustomerNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameColumn)).isDisplayed();
    }
    public boolean isDisplayedSiteDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteDescriptionColumn)).isDisplayed();
    }
    public boolean isDisplayedTerminalSerialNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,terminalSerialNumberColumn)).isDisplayed();
    }
    public boolean isDisplayedAmciSerialNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,amciSerialNumberColumn)).isDisplayed();
    }
    public boolean isDisplayedNotificationTypeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,notificationTypeColumn)).isDisplayed();
    }
    public boolean isDisplayedNotificationPlanNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,notificationPlanNameColumn)).isDisplayed();
    }
    public boolean isDisplayedEventTimestampColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,eventTimestampColumn)).isDisplayed();
    }
    public boolean isDisplayedEventStateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,eventStateColumn)).isDisplayed();
    }
    public boolean isDisplayedEventSummaryColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,eventSummaryColumn)).isDisplayed();
    }
    public boolean isDisplayedEmailAddressesColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,emailAddressesColumn)).isDisplayed();
    }
    public boolean isDisplayedPhoneNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,phoneNumberColumn)).isDisplayed();
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
    @SneakyThrows
    public void clearSearchField(){
        Thread.sleep(3000);
        searchField.click();
        Thread.sleep(3000);
        searchField.clear();
    }
    @SneakyThrows
    public boolean isDisplayed() {
        sleep(3000);
        List<WebElement> webElements = siteNameList;
        List<String> siteNames = new ArrayList<>();
        for (WebElement element : webElements) {
            siteNames.add(element.getText());
        }
        int count = webElements.size();
        String nextButtonClass = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).getAttribute("class");
        while (!nextButtonClass.contains("disabled")) {
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).click();
            Thread.sleep(3000);
            webElements = siteNameList;
            for (WebElement element : webElements) {
                siteNames.add(element.getText());
            }
            count = count+webElements.size();
            nextButtonClass = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).getAttribute("class");
        }
        String displayedCount = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//div[@id='report_table_info']")))).getText().split(" ")[5];
        return count == Integer.parseInt(displayedCount);
    }
    public boolean isDisplayedByDefaultAscendingOrder(){
        return   Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, clientName)).isDisplayed();
    }
    public boolean isDisplayedSortingClientNameColumn(){
        return getShorting(clientNameData);
    }
    public boolean isDisplayedSortingTireNamedColumn(){
        tierNameColumn.click();
        return getShorting(tierNameData);
    }
//    @SneakyThrows
//    public boolean isDisplayedSortingDatapointNumberColumn(){
//        Thread.sleep(2000);
//        return getShorting(datapointNumberData);
//    }

    @SneakyThrows
    public boolean isDisplayedMultipleAssets(){
        sleep(2000);
        assetList.get(1).click();
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//span[text()='+2']")))).isDisplayed();
    }






}
