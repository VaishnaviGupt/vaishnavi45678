package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class HourMeterReportPage extends BasePage {



    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Hour Meter Report']")
    WebElement hourMeterReportButton;

    @FindBy(xpath = "//h3[normalize-space()='Hour Meter Report']")
    WebElement hourMeterReportPageTitle;

    @FindBy(xpath = "//span[@class='dropdown-btn']")
    WebElement assetDropdownButton;

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

    @FindBy(xpath = "//button[normalize-space()='Run Report']")
    WebElement runReportButton;

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

    @FindBy(xpath = "//th[text()='Asset Name']")
    WebElement assetNameColumn;

    @FindBy(xpath = "//th[text()='Tier Name']")
    WebElement tierNameColumn;

    @FindBy(xpath = "//th[text()='Site Name']")
    WebElement siteNameColumn;

    @FindBy(xpath = "//th[text()='Customer Name']")
    WebElement customerNameColumn;

    @FindBy(xpath = "//th[text()='Channel Name']")
    WebElement channelNameColumn;

    @FindBy(xpath = "//th[text()='Last Reading']")
    WebElement lastReadingColumn;

    @FindBy(xpath = "//th[text()='Last Reading Time']")
    WebElement lastReadingTimeColumn;

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







    public HourMeterReportPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }


    @SneakyThrows
    public HourMeterReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public HourMeterReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    @SneakyThrows
    public HourMeterReportPage clickOnHourMeterReportButton(){
        Thread.sleep(6000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, hourMeterReportButton)).click();

        return this;
    }

    @SneakyThrows
    public boolean isDisplayedHourMeterReportPageTitle()  {
        Thread.sleep(5000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, hourMeterReportPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public HourMeterReportPage scroll(){
        Thread.sleep(3000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getWebDriver();
        WebElement element = DriverManager.getWebDriver().findElement(By.xpath("//a[normalize-space()='Hour Meter Report']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
        return this;
    }

    public boolean isDisplayedExcelButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, excelButton)).isDisplayed();
    }

    public boolean isDisplayedEmailButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).isDisplayed();
    }

    public boolean isDisplayedAssetDropDownButton(){
        return  Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDropdownButton)).isDisplayed();
    }

    public HourMeterReportPage clickOnAssetDropDownButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDropdownButton)).click();
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

    public HourMeterReportPage clickOnSelectAllButton() {
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
    public boolean isDisplayedMultipleAssets(){
        sleep(2000);
        assetList.get(1).click();
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//span[text()='+2']")))).isDisplayed();
    }

    @SneakyThrows
    public HourMeterReportPage clickOnRunReportButton(){
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
    public HourMeterReportPage clickOnEmailButton() {
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

    public HourMeterReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public HourMeterReportPage clickOnSendButton() {
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
    public HourMeterReportPage clickOnCancelButton() {
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
    public HourMeterReportPage setMessageField(String message) {
        sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
    }

    public boolean isDisplayedClientNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, clientNameColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameColumn)).isDisplayed();
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

    public boolean isDisplayedChannelNameColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, channelNameColumn)).isDisplayed();
    }

    public boolean isDisplayedLastReadingColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastReadingColumn)).isDisplayed();
    }

    public boolean isDisplayedLastReadingTimeColumn(){
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, lastReadingTimeColumn)).isDisplayed();
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
