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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AdhocRuntimeReportPage extends BasePage {


    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenu;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    WebElement reportOptions;

    @FindBy(xpath = "//a[normalize-space()='Adhoc Runtime Report']")
    WebElement adhocRuntimeReportButton;

    @FindBy(xpath = "//h4[normalize-space()='Adhoc Runtime Report']")
    WebElement adhocRuntimeReportPageTitle;

    @FindBy(xpath = "//input[@id='startDate']")
    WebElement startDate;

    @FindBy(xpath = "//span[@class='dropdown-btn']")
    WebElement selectAssetDropDown;

    @FindBy(xpath = "//input[@id='endDate']")
    WebElement endDate;

    @FindBy(xpath = "//select[@id='reportType']")
    WebElement reportType;

    @FindBy(xpath = "//input[@id='fileFormat']")
    WebElement fileFormat;

    @FindBy(xpath = "//button[normalize-space()='Preview Report']")
    WebElement previewReport;

    @FindBy(xpath = "//button[text()='Download Report ']")
    WebElement downloadReportButton;

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

    @FindBy(xpath = "//option[text()=' Runtime With Root Cause']")
    WebElement runtimeWithRootCauseOptions;

    @FindBy(xpath = "//option[text()=' Report Basic Plus']")
    WebElement reportBasicPlusOptions;

    @FindBy(xpath = "//div[normalize-space()='CDN TEST #1']")
    WebElement cdnTest1Asset;

    @FindBy(xpath = "//div[normalize-space()='CDN TEST #5']")
    WebElement cdnTest5Asset;

    @FindBy(xpath = "//div[normalize-space()='Compressor 3']")
    WebElement compression3Asset;

    @FindBy(xpath = "//div[normalize-space()='Select All']")
    WebElement selectAllAsset;

    @FindBy(xpath = "//*[@id=\"summary_table\"]/tbody/tr[1]")
    WebElement tableRowData;

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

    @FindBy(xpath = "//a[normalize-space()='Summary']")
    WebElement summaryButton;

    @FindBy(xpath = "//a[normalize-space()='Detail']")
    WebElement detailButton;

    @FindBy(xpath = "//th[@aria-label=' Tier Name: activate to sort column descending']")
    WebElement tierNameColumn;

    @FindBy(xpath = "//table[@id='summary_table']//th[contains(@aria-label,'Site Name: activate to sort column ascending')][normalize-space()='Site Name']")
    WebElement siteNameColumn;

    @FindBy(xpath = "//table[@id='summary_table']//th[contains(@aria-label,'Asset Name: activate to sort column ascending')][normalize-space()='Asset Name']")
    WebElement assetNameColumn;

    @FindBy(xpath = "//table[@id='summary_table']//th[contains(@aria-label,'Unit Number: activate to sort column ascending')][normalize-space()='Unit Number']")
    WebElement unitNumberColumn;

    @FindBy(xpath = "//*[@id=\"summary_table\"]/thead/tr/th[5]")
    WebElement customerNameColumn;

    @FindBy(xpath = "//th[normalize-space()='Runtime Hours']")
    WebElement runtimeHoursColumn;

    @FindBy(xpath = "//th[normalize-space()='Runtime (%)']")
    WebElement runtimeColumn;

    @FindBy(xpath = "//th[contains(@aria-label,'Stand By Hours: activate to sort column ascending')]")
    WebElement standByHoursColumn;

    @FindBy(xpath = "//th[contains(@aria-label,'Stand By (%): activate to sort column ascending')]")
    WebElement standByColumn;

    @FindBy(xpath = "//table[@id='summary_table']//th[contains(@aria-label,'Downtime Hours: activate to sort column ascending')][normalize-space()='Downtime Hours']")
    WebElement downtimeHoursColumn;

    @FindBy(xpath = "//th[normalize-space()='Downtime (%)']")
    WebElement downtimeColumn;

    @FindBy(xpath = "//table[@id='summary_table']//th[contains(@aria-label,'Stand By : activate to sort column ascending')][normalize-space()='Stand By']")
    WebElement standBY;

    @FindBy(xpath = "//th[contains(@aria-label,'Mechanical Runtime Hours: activate to sort column ascending')]")
    WebElement mechanicalRuntimeHoursColumn;

    @FindBy(xpath = "//th[contains(@aria-label,'Mechanical Runtime (%): activate to sort column ascending')]")
    WebElement mechanismRuntimeColumn;

    @FindBy(xpath = "//th[contains(@aria-label,'Mechanical Downtime Hours: activate to sort column ascending')]")
    WebElement mechanicalDowntimeHoursColumn;

    @FindBy(xpath = "//th[contains(@aria-label,'Mechanical Downtime (%): activate to sort column ascending')]")
    WebElement mechanicalDowntimeColumn;

    @FindBy(xpath = "//*[text()=' Production Runtime Hours']")
    WebElement productionRuntimeHoursColumn;

    @FindBy(xpath = "//*[text()=' Production Runtime (%)']")
    WebElement productionDowntimeColumn;

    @FindBy(xpath = "//*[text()=' Unallocated Runtime Hours']")
    WebElement unallocatedRuntimeHoursColumn;

    @FindBy(xpath = "//*[text()=' Unallocated Runtime (%)']")
    WebElement unallocatedRuntimeColumn;

    @FindBy(xpath = "//*[text()=' Unallocated Downtime Hours']")
    WebElement unallocatedDowntimeHoursColumn;

    @FindBy(xpath = "//*[text()=' Unallocated Downtime (%)']")
    WebElement unallocatedDowntimeColumn;

    @FindBy(xpath = "//select[@name='summary_table_length']")
    WebElement summaryLength;

    @FindBy(xpath = "//input[@aria-controls='summary_table']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"summary_table\"]/tbody")
    WebElement dataTable;

    @FindBy(xpath = "//*[@class='item2']/li")
    List<WebElement> dropDownList;

    @FindBy(xpath = "//span[@class='dropdown-btn']")
    WebElement assetDropdownButton;

    @FindBy(xpath = "//*[@class='item2']/li")
    WebElement asset;

    @FindBy(xpath = "//li[@class='multiselect-item-checkbox']")
    WebElement selectAllButton;

    @FindBy(xpath = "//*[@class='item2']/li")
    List<WebElement> assetList;

    ////*[@class='item2']/li


    public AdhocRuntimeReportPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public static String todayDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");//yyyy-MM-dd
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static String currentMonths(){
        DateFormat dateFormat = new SimpleDateFormat("MMMM");//yyyy-MM-dd
        Date date = new Date();
        return dateFormat.format(date);
    }



    public static String endDateEvent() {
        Date objDate = new Date();
        String strDateFormat = "MMMM dd, yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        objSDF.format(objDate);
        Calendar now = Calendar.getInstance();
        now.setTime(objDate);
        now.add(Calendar.DATE, -1);
        Date featured = now.getTime();
        return objSDF.format(featured);
    }





    @SneakyThrows
    public AdhocRuntimeReportPage clickOnSideMenu() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sideMenu)).click();
        return this;
    }

    @SneakyThrows
    public AdhocRuntimeReportPage clickOnReportOptions() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportOptions)).click();
        return this;
    }

    public AdhocRuntimeReportPage clickOnAdhocRunTimeButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, adhocRuntimeReportButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedAdhocRunTimePageTitle() {
        Thread.sleep(5000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, adhocRuntimeReportPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public boolean isDisplayedStartDate() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, startDate)).isDisplayed();
    }

    public boolean isDisplayedSelectAssetDropDown() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropDown)).isDisplayed();
    }

    public boolean isDisplayedEndDate() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, endDate)).isDisplayed();
    }

    public boolean isDisplayedReportType() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportType)).isDisplayed();
    }

    public boolean isDisplayedFileFormat() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, fileFormat)).isDisplayed();
    }

    public boolean isDisplayedPreviewReport() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, previewReport)).isDisplayed();
    }

    public boolean isDisplayedDownloadReportButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, downloadReportButton)).isDisplayed();
    }

    public boolean isDisplayedEmailButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).isDisplayed();
    }

    @SneakyThrows
    public Boolean byDefaultIsDisplayedCurrentDateInStartDate() {
        Thread.sleep(4000);
        String string = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, startDate)).getAttribute("value");
        return string.substring(0, string.length() - 6).equalsIgnoreCase(this.currentDate());
    }

    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");//yyyy-MM-dd
        Date date = new Date();
        String todayDateText = dateFormat.format(date);
        System.out.println();
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
        return string.substring(0, string.length() - 6).equalsIgnoreCase(this.currentDate());
    }

    public AdhocRuntimeReportPage clickOnPageTitle() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, adhocRuntimeReportPageTitle)).click();
        return this;
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

    public AdhocRuntimeReportPage clickOnPreviewReportButton() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, previewReport)).click();
        return this;
    }

    public boolean isDisplayedErrorMessage() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessage)).isDisplayed();
    }

    @SneakyThrows
    public AdhocRuntimeReportPage clickOnReportTypeDropDown() {
        Thread.sleep(4000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportType)).click();
        return this;
    }

    public boolean isDisplayedRuntimeWithRootCauseOptions() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeWithRootCauseOptions)).isDisplayed();
    }

    public boolean isDisplayedReportBasicPlusOptions() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, reportBasicPlusOptions)).isDisplayed();
    }

    public AdhocRuntimeReportPage clickOnAssets() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectAssetDropDown)).click();
        return this;
    }

    @SneakyThrows
    public AdhocRuntimeReportPage selectCdnAsset() {
        Thread.sleep(3000);
        for (WebElement element: dropDownList){
            if (element.getText().equalsIgnoreCase(PropertyUtils.getValue(ConfigProperties.ASSETNAME))){
                 element.click();
            }
        }
       // Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cdnTest1Asset)).click();
        return this;
    }

    public AdhocRuntimeReportPage selectCdn5Asset() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cdnTest5Asset)).click();
        return this;
    }




    public boolean isDisplayedSelectedAsset() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,
                DriverManager.getWebDriver().findElement(By.xpath("//span[contains(text(),'+1')]")))).isDisplayed();
    }

    public boolean isDisplayedSelectedAssets() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE,
                DriverManager.getWebDriver().findElement(By.xpath("//span[contains(text(),'+2')]")))).isDisplayed();
    }



    public String getFileFormat() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, fileFormat)).getAttribute("value");
    }

    public boolean isDisplayedDataInGrid() {
        String tableData = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, tableRowData)).getText();
        return !tableData.isEmpty();
    }

    public boolean isClickableDownloadButton() {
        try {
            new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(downloadReportButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SneakyThrows
    public AdhocRuntimeReportPage clickOnEmailButton() {
        Thread.sleep(15000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, emailButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedEmailField() {
        Thread.sleep(2000);
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

    public AdhocRuntimeReportPage setEmailField(String emailId) {
        sendKeysToWebElement(emailsField, emailId, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public AdhocRuntimeReportPage clickOnSendButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, sendButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedErrorMessageEmailPopup() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageEmailPopup)).isDisplayed();
    }

    @SneakyThrows
    public AdhocRuntimeReportPage clickOnCancelButton() {
        Thread.sleep(3000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cancelButton)).click();
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedErrorMessageBlankEmailField() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, errorMessageBlankEmailField)).isDisplayed();
    }

    @SneakyThrows
    public AdhocRuntimeReportPage setMessageField(String message) {
        Thread.sleep(3000);
        sendKeysToWebElement(messageField, message, WaitStrategy.VISIBLE);
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedSummaryTab() {
        Thread.sleep(3000);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, summaryButton)).isDisplayed();
    }

    public boolean isDisplayedDetailTab() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, detailButton)).isDisplayed();
    }

    public boolean isDisplayedTierNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, tierNameColumn)).isDisplayed();
    }

    public boolean isDisplayedSiteNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteNameColumn)).isDisplayed();
    }

    public boolean isDisplayedAssetNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameColumn)).isDisplayed();
    }

    public boolean isDisplayedUnitNumberColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unitNumberColumn)).isDisplayed();
    }

    public boolean isDisplayedCustomerNameColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, customerNameColumn)).isDisplayed();
    }

    public boolean isDisplayedRuntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedRuntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, runtimeColumn)).isDisplayed();
    }

    public boolean isDisplayedStandByHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, standByHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedStandByColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, standByColumn)).isDisplayed();
    }

    public boolean isDisplayedDowntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, downtimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedDowntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, downtimeColumn)).isDisplayed();
    }

    public boolean isDisplayedStandBY() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, standBY)).isDisplayed();
    }

    public boolean isDisplayedMechanicalRuntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mechanicalRuntimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedMechanismRuntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mechanismRuntimeColumn)).isDisplayed();
    }

    public boolean isDisplayedMechanicalDowntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mechanicalDowntimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedMechanicalDowntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mechanicalDowntimeColumn)).isDisplayed();
    }

    public boolean isDisplayedProductionRuntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, productionRuntimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedProductionDowntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, productionDowntimeColumn)).isDisplayed();
    }

    public boolean isDisplayedUnallocatedRuntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unallocatedRuntimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedUnallocatedRuntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unallocatedRuntimeColumn)).isDisplayed();
    }

    public boolean isDisplayedUnallocatedDowntimeHoursColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unallocatedDowntimeHoursColumn)).isDisplayed();
    }

    public boolean isDisplayedUnallocatedDowntimeColumn() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, unallocatedDowntimeColumn)).isDisplayed();
    }

    public boolean isDisplayedByDefaultSelected10Data() {
        Select select = new Select(summaryLength);

        return select.getFirstSelectedOption().getText().equalsIgnoreCase("10");
    }

    public boolean isDisplayedSearchData(String value) {
        sendKeysToWebElement(searchField, value, WaitStrategy.VISIBLE);
        return dataTable.getText().contains(value);
    }

    public AdhocRuntimeReportPage clickOnAssetDropDownButton() {
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

    public AdhocRuntimeReportPage clickOnSelectAllButton() {
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



}
