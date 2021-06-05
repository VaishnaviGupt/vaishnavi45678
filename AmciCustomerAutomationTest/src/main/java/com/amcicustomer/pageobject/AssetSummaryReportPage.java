package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AssetSummaryReportPage extends BasePage {


    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(css = "li:nth-child(7) > a")
    WebElement assetSummaryButton;

    @FindBy(xpath = "//h3[normalize-space()='Asset Summary Report']")
    WebElement assetSummaryReportPageTitle;

    @FindBy(xpath = "//button[normalize-space()='Excel']")
    WebElement excelButton;

    @FindBy(xpath = "//button[normalize-space()='Email']")
    WebElement emailButton;

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

    @FindBy(xpath = "//th[text()='Asset Name']")
    WebElement AssetNameColumn;

    @FindBy(xpath = "//th[text()='Asset Description']")
    WebElement assetDescriptionColumn;

    @FindBy(xpath = "//th[text()='Customer Name']")
    WebElement customerNameColumn;

    @FindBy(xpath = "//th[text()='Notification Plan']")
    WebElement notificationPlanColumn;

    @FindBy(xpath = "//th[text()='Call Schedule']")
    WebElement callScheduleColumn;

    @FindBy(xpath = "//th[text()='Call Type']")
    WebElement callTypeColumn;

    @FindBy(xpath = "//th[text()='Current Status']")
    WebElement currentStatusColumn;

    @FindBy(xpath = "//th[text()='AMCi Serial Number']")
    WebElement amciSerialNumberColumn;

    @FindBy(xpath = "//th[text()='Manufacturer Serial Number']")
    WebElement manufacturerSerialNumberColumn;

    @FindBy(xpath = "//th[text()='Latitude']")
    WebElement latitudeColumn;

    @FindBy(xpath = "//th[text()='Longitude']")
    WebElement longitudeColumn;

    @FindBy(xpath = "//th[text()='Position Time']")
    WebElement positionTimeColumn;

    @FindBy(xpath = "//th[text()='State']")
    WebElement stateColumn;

    @FindBy(xpath = "//th[text()='Proximity']")
    WebElement proximityColumn;

    @FindBy(xpath = "//th[text()='Last Event Time']")
    WebElement lastEventTimeColumn;

    @FindBy(xpath = "//th[text()='Last Message Time']")
    WebElement lastMessageTimeColumn;

    @FindBy(xpath = "//th[text()='AMCi Product Status']")
    WebElement amciiProductStatusColumn;

    @FindBy(xpath = "//th[text()='Activation Date']")
    WebElement activationDateColumn;

    @FindBy(xpath = "//th[text()='Deactivation Date']")
    WebElement deactivationDateColumn;

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











    public AssetSummaryReportPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }


    @SneakyThrows
    public AssetSummaryReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public AssetSummaryReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    @SneakyThrows
    public AssetSummaryReportPage clickOnAssetSummaryButton(){
        Thread.sleep(6000);
        //Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetSummaryButton)).click();
        DriverManager.getWebDriver().findElement(By.cssSelector("li:nth-child(7) > a")).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetSummaryReportPageTitle()  {
        Thread.sleep(5000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetSummaryReportPageTitle)).isDisplayed();
    }

    public boolean isDisplayedExcelButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, excelButton)).isDisplayed();
    }

    public boolean isDisplayedEmailButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).isDisplayed();
    }

    @SneakyThrows
    public AssetSummaryReportPage scroll(){
        Thread.sleep(3000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[normalize-space()='Asset Summary']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
        return this;
    }
    public Boolean isExcelButtonClickable() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, excelButton)).isDisplayed();
    }

    @SneakyThrows
    public AssetSummaryReportPage clickOnEmailButton() {
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

    public AssetSummaryReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public AssetSummaryReportPage clickOnSendButton() {
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
    public AssetSummaryReportPage clickOnCancelButton() {
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
    public AssetSummaryReportPage setMessageField(String message) {
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

    public boolean isDisplayedAssetNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, AssetNameColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDescriptionColumn)).isDisplayed();
    }

    public boolean isDisplayedCustomerNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameColumn)).isDisplayed();
    }

    public boolean isDisplayedNotificationPlanColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, notificationPlanColumn)).isDisplayed();
    }

    public boolean isDisplayedCallScheduleColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, callScheduleColumn)).isDisplayed();
    }

    public boolean isDisplayedCallTypeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, callTypeColumn)).isDisplayed();
    }

    public boolean isDisplayedCurrentStatusColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, currentStatusColumn)).isDisplayed();
    }

    public boolean isDisplayedAmciSerialNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, amciSerialNumberColumn)).isDisplayed();
    }

    public boolean isDisplayedManufacturerSerialNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, manufacturerSerialNumberColumn)).isDisplayed();
    }

    public boolean isDisplayedLatitudeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, latitudeColumn)).isDisplayed();
    }

    public boolean isDisplayedLongitudeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, longitudeColumn)).isDisplayed();
    }

    public boolean isDisplayedPositionTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, positionTimeColumn)).isDisplayed();
    }

    public boolean isDisplayedStateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, stateColumn)).isDisplayed();
    }

    public boolean isDisplayedProximityColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, proximityColumn)).isDisplayed();
    }

    public boolean isDisplayedLastEventTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastEventTimeColumn)).isDisplayed();
    }

    public boolean isDisplayedLastMessageTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastMessageTimeColumn)).isDisplayed();
    }

    public boolean isDisplayedAmciiProductStatusColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, amciiProductStatusColumn)).isDisplayed();
    }

    public boolean isDisplayedActivationDateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, activationDateColumn)).isDisplayed();
    }

    public boolean isDisplayedDeactivationDateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, deactivationDateColumn)).isDisplayed();
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


}
