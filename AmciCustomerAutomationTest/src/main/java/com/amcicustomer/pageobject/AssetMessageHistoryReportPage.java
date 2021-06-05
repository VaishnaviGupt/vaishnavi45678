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

public class AssetMessageHistoryReportPage extends BasePage {

    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Asset Message History Report']")
    WebElement assetMessageHistoryButton;

    @FindBy(xpath = "//h4[normalize-space()='Asset Message History Report']")
    WebElement assetMessageHistoryReportPageTitle;

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

    @FindBy(xpath = "//th[text()='annunciator hour meter']")
    WebElement annunciatorHourMeterColumn;

    @FindBy(xpath = "//th[text()='annunciator status']")
    WebElement annunciatorStatusColumn;

    @FindBy(xpath = "//th[text()='annunciator status code']")
    WebElement annunciatorStatusCodeColumn;

    @FindBy(xpath = "//th[text()='annunciator tachometer']")
    WebElement annunciatorTachometerColumn;

    @FindBy(xpath = "//th[text()='asset description']")
    WebElement assetDescriptionColumn;

    @FindBy(xpath = "//th[text()='asset name']")
    WebElement assetNameColumn;

    @FindBy(xpath = "//th[text()='customer name']")
    WebElement customerNameColumn;

    @FindBy(xpath = "//th[text()='event timestamp']")
    WebElement eventTimestampColumn;

    @FindBy(xpath = "//th[text()='latitude']")
    WebElement latitudeColumn;

    @FindBy(xpath = "//th[text()='longitude']")
    WebElement longitudeColumn;

    @FindBy(xpath = "//th[text()='message type']")
    WebElement messageTypeColumn;

    @FindBy(xpath = "//th[text()='power']")
    WebElement powerColumn;

    @FindBy(xpath = "//th[text()='proximity']")
    WebElement proximityColumn;

    @FindBy(xpath = "//th[text()='receipt timestamp']")
    WebElement receiptTimestampColumn;

    @FindBy(xpath = "//th[text()='signal strength value']")
    WebElement signalStrengthValueColumn;

    @FindBy(xpath = "//th[text()='tier name']")
    WebElement tierNamesColumn;

    @FindBy(xpath = "//select[@name='report_table_length']")
    WebElement summaryLength;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody/tr[1]")
    WebElement dataTable;

    @FindBy(xpath = "//th[@aria-label='annunciator hour meter: activate to sort column descending']")
    WebElement clientName;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[1]")
    WebElement clientNameData;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[2]")
    List<WebElement> tierNameData;


    public AssetMessageHistoryReportPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @SneakyThrows
    public AssetMessageHistoryReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public AssetMessageHistoryReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    @SneakyThrows
    public AssetMessageHistoryReportPage clickOnAssetMessageHistoryButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetMessageHistoryButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetMessageHistoryReportPageTitle() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetMessageHistoryReportPageTitle)).isDisplayed();
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
        Thread.sleep(4000);
        String string = startDate.getAttribute("value");
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
        DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate showTimeInput open arrowTop']//span[@aria-label='" + exDays + "']")).click();////div[@class='flatpickr-calendar hasTime animate showTimeInput arrowTop open']//span[@aria-label='April 11, 2021']
        String string = (String) js.executeScript("return arguments[0].value", startDate);
        Date date = new Date(exDays);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = formatter.format(date);
        return string.substring(0, string.length() - 9).equalsIgnoreCase(strDate);
    }

    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInEndDate() {
        Thread.sleep(4000);
        String string = endDate.getAttribute("value");
        System.out.println(string);
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

    @SneakyThrows
    public void selectAsset(String value) {
        Thread.sleep(3000);
        selectDropdownValue(assetDropDownButton, DropDown.VISIBLETEXT, value);
    }

    public AssetMessageHistoryReportPage clickOnPageTitle() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetMessageHistoryReportPageTitle)).click();
        return this;
    }

    public AssetMessageHistoryReportPage clickOnPreviewReportButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }

    public boolean isDisplayedErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessage)).isDisplayed();
    }

    public AssetMessageHistoryReportPage clickOnRunReportButton() {
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
    public AssetMessageHistoryReportPage clickOnEmailButton() {
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

    public AssetMessageHistoryReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public AssetMessageHistoryReportPage clickOnSendButton() {
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
    public AssetMessageHistoryReportPage clickOnCancelButton() {
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
    public AssetMessageHistoryReportPage setMessageField(String message) {
        sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedAnnunciatorHourMeterColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, annunciatorHourMeterColumn)).isDisplayed();
    }

    public boolean isDisplayedAnnunciatorStatusColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, annunciatorStatusColumn)).isDisplayed();
    }

    public boolean isDisplayedAnnunciatorStatusCodeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, annunciatorStatusCodeColumn)).isDisplayed();
    }

    public boolean isDisplayedAnnunciatorTachometerColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, annunciatorTachometerColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetDescriptionColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDescriptionColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameColumn)).isDisplayed();
    }

    public boolean isDisplayedCustomerNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameColumn)).isDisplayed();
    }

    public boolean isDisplayedEventTimestampColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventTimestampColumn)).isDisplayed();
    }

    public boolean isDisplayedLatitudeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, latitudeColumn)).isDisplayed();
    }

    public boolean isDisplayedLongitudeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, longitudeColumn)).isDisplayed();
    }

    public boolean isDisplayedMessageTypeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, messageTypeColumn)).isDisplayed();
    }

    public boolean isDisplayedPowerColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, powerColumn)).isDisplayed();
    }

    public boolean isDisplayedProximityColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, proximityColumn)).isDisplayed();
    }

    public boolean isDisplayedReceiptTimestampColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, receiptTimestampColumn)).isDisplayed();
    }

    public boolean isDisplayedSignalStrengthValueColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, signalStrengthValueColumn)).isDisplayed();
    }

    public boolean isDisplayedTierNamesColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, tierNamesColumn)).isDisplayed();
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
    public boolean isDisplayedByDefaultAscendingOrder(){
        return   Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, clientName)).isDisplayed();
    }

    public void setSearchField(String value){
        sendKeysToWebElement(searchField,value,WaitStrategy.VISIBLE);
    }

    public boolean isDisplayedSortingClientNameColumn(){
        return getShorting(clientNameData);
    }
    public boolean isDisplayedSortingTireNamedColumn(){
        return getShorting(tierNameData);
    }
}
