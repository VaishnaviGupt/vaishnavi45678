package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AssetDataPointSummaryReportPage extends BasePage {

    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Asset Data Point Summary Report']")
    WebElement assetDataPointSummaryReportButton;

    @FindBy(xpath = "//h4[normalize-space()='Asset Data Point Summary Report']")
    WebElement assetDataPointSummaryReportPageTitle;

    @FindBy(xpath = "//span[@class='dropdown-btn']")
    WebElement selectAssetDropDownButton;

    @FindBy(xpath = "//button[normalize-space()='Run Report']")
    WebElement runReportButton;

    @FindBy(xpath = "//button[normalize-space()='Excel']")
    WebElement excelButton;

    @FindBy(xpath = "//button[normalize-space()='Email']")
    WebElement emailButton;

    @FindBy(xpath = "//*[@class='item2']/li")
    WebElement asset;

    @FindBy(xpath = "//*[@class='item2']/li")
    List<WebElement> assetList;

    @FindBy(xpath = "//li[@class='multiselect-item-checkbox']")
    WebElement selectAllButton;

    @FindBy(xpath = "//*[@class='item2']")
    WebElement allAsset;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody")
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

    @FindBy(xpath = "//th[text()='Datapoint Number']")
    WebElement datapointNumberColumn;

    @FindBy(xpath = "//th[text()='Channel Name']")
    WebElement channelNameColumn;

    @FindBy(xpath = "//th[text()='Alarm State']")
    WebElement alarmStateColumn;

    @FindBy(xpath = "//th[text()='Datapoint Status']")
    WebElement datapointStatusColumn;

    @FindBy(xpath = "//th[text()='Datapoint Value']")
    WebElement datapointValueColumn;

    @FindBy(xpath = "//th[text()='Units']")
    WebElement unitsColumn;

    @FindBy(xpath = "//th[text()='Encode Description']")
    WebElement encodeDescriptionColumn;

    @FindBy(xpath = "//th[text()='Last Update Time']")
    WebElement lastUpdateTimeColumn;

    @FindBy(xpath = "//th[text()='Asset Id']")
    WebElement assetId;

    @FindBy(xpath = "//select[@name='report_table_length']")
    WebElement summaryLength;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"report_table\"]/tbody")
    WebElement dataTable;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[3]")
   List <WebElement> siteNameList;

    @FindBy(xpath = "//a[@id='report_table_next']")
    WebElement nextButton;

    @FindBy(xpath = "//th[@aria-label='Client Name: activate to sort column descending']")
    WebElement clientName;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[1]")
    WebElement clientNameData;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[2]")
    List<WebElement> tierNameData;

    @FindBy(xpath = "//*[@id='report_table']/tbody//td[5]")
    List<WebElement> datapointNumberData;








    public AssetDataPointSummaryReportPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @SneakyThrows
    public AssetDataPointSummaryReportPage clickOnSideMenu() {
        sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public AssetDataPointSummaryReportPage clickOnReportOptions() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    @SneakyThrows
    public AssetDataPointSummaryReportPage clickOnAssetDataPointSummaryReportButton() {
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDataPointSummaryReportButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAssetDataPointSummaryReportPageTitle() {
        sleep(4000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDataPointSummaryReportPageTitle)).isDisplayed();
    }

    public boolean isDisplayedSelectAssetDropDownButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropDownButton)).isDisplayed();
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

    public AssetDataPointSummaryReportPage clickOnAssetDropDownButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropDownButton)).click();
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

    public AssetDataPointSummaryReportPage clickOnSelectAllButton() {
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
    public AssetDataPointSummaryReportPage clickOnRunReportButton(){
        sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runReportButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedReportData(){
        sleep(2000);
        String report = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportTable)).getText();
        return !report.isEmpty();
    }
    public Boolean isExcelButtonClickable(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, excelButton)).isDisplayed();
    }
    @SneakyThrows
    public AssetDataPointSummaryReportPage clickOnEmailButton() {
        sleep(4000);
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
    public AssetDataPointSummaryReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }
    @SneakyThrows
    public AssetDataPointSummaryReportPage clickOnSendButton() {
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
    public AssetDataPointSummaryReportPage clickOnCancelButton() {
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
    public AssetDataPointSummaryReportPage setMessageField(String message) {
        sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedClientNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, clientNameColumn)).isDisplayed();
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
    public boolean isDisplayedDatapointNumberColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, datapointNumberColumn)).isDisplayed();
    }
    public boolean isDisplayedChannelNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, channelNameColumn)).isDisplayed();
    }
    public boolean isDisplayedAlarmStateColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alarmStateColumn)).isDisplayed();
    }
    public boolean isDisplayedDatapointStatusColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, datapointStatusColumn)).isDisplayed();
    }
    public boolean isDisplayedDatapointValueColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, datapointValueColumn)).isDisplayed();
    }
    public boolean isDisplayedUnitsColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unitsColumn)).isDisplayed();
    }
    public boolean isDisplayedEncodeDescriptionColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, encodeDescriptionColumn)).isDisplayed();
    }
    public boolean isDisplayedLastUpdateTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastUpdateTimeColumn)).isDisplayed();
    }
    public boolean isDisplayedAssetId(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetId)).isDisplayed();
    }
    public boolean isDisplayedByDefaultSelected10Data() {
        Select select = new Select(summaryLength);
        return select.getFirstSelectedOption().getText().equalsIgnoreCase("10");
    }

    public boolean isDisplayedSearchData(String value) {
        sendKeysToWebElement(searchField, value, WaitStrategy.VISIBLE);
        return dataTable.getText().contains(value);
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
    @SneakyThrows
    public boolean isDisplayedSortingDatapointNumberColumn(){
        datapointNumberColumn.click();
        Thread.sleep(2000);
        return getShorting(datapointNumberData);
    }

    @SneakyThrows
    public boolean isDisplayedMultipleAssets(){
        sleep(2000);
        assetList.get(1).click();
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//span[text()='+2']")))).isDisplayed();
    }





}
