package com.amcicustomer.pageobject;

import com.amcicustomer.basepagemethod.BasePage;
import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.enums.DropDown;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import com.amcicustomer.utils.PropertyUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//th[@aria-label='Notification Text: activate to sort column ascending']")
    WebElement notificationTextAscendingOrder;
    //   private final By notificationTextAscendingOrder = By.xpath("//th[@aria-label='Notification Text: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Channel Description: activate to sort column ascending']")
    WebElement channelDescriptionAscendingOrder;
    //   private final By channelDescriptionAscendingOrder = By.xpath("//th[@aria-label='Channel Description: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Event Type: activate to sort column ascending']")
    WebElement eventTypeAscendingOrder;
    //   private final By eventTypeAscendingOrder = By.xpath("//th[@aria-label='Event Type: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Event Time: activate to sort column ascending']")
    WebElement eventTimeAscendingOrder;
    //   private final By eventTimeAscendingOrder = By.xpath("//th[@aria-label='Event Time: activate to sort column ascending']");
    @FindBy(xpath = "//tr/th[text()='Status']")
    WebElement statusButton;
    //   private final By statusButton = By.xpath("//tr/th[text()='Status']");
    @FindBy(xpath = "//tr//td[1]/span[@class='btn']")
    WebElement statusList;
    //    private final By statusList = By.xpath("//tr//td[1]/span[@class='btn']");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[2]")
    WebElement eventAndRunTimeStatusList;
    //    private final By eventAndRunTimeStatusList = By.xpath("//*[@id='live_table']/tbody//td[2]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[3]")
    WebElement siteNameList;
    //   private final By siteNameList = By.xpath("//*[@id='live_table']/tbody//td[3]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[4]")
    WebElement assetNameList;
    //   private final By assetNameList = By.xpath("//*[@id='live_table']/tbody//td[4]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[5]")
    WebElement notificationTextList;
    // private final By notificationTextList = By.xpath("//*[@id='live_table']/tbody//td[5]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[6]")
    WebElement channelDescriptionList;
    //   private final By channelDescriptionList = By.xpath("//*[@id='live_table']/tbody//td[6]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[7]")
    WebElement eventTypeList;
    //   private final By eventTypeList = By.xpath("//*[@id='live_table']/tbody//td[7]");
    @FindBy(xpath = "//*[@id='live_table']/tbody//td[8]")
    WebElement eventTimeList;
    //   private final By eventTimeList = By.xpath("//*[@id='live_table']/tbody//td[8]");
    @FindBy(xpath = "//a[@id='live_table_next']")
    WebElement nextButton;
    //   private final By nextButton = By.xpath("//a[@id='live_table_next']");
    @FindBy(xpath = "//h3[normalize-space()='Dashboard']")
    WebElement dashboardPageTitle;
    @FindBy(css = "div[class='sm-toggle'] span")
    WebElement sideMenuButton;
    @FindBy(xpath = "//a[normalize-space()='Customers']")
    WebElement customerOptionButton;
    @FindBy(xpath = "//td[normalize-space()='AMCi Advanced Demo']")
    WebElement customerName;
    //  private final By customerName = By.xpath("//td[normalize-space()='AMCi Advanced Demo']");
    @FindBy(xpath = "//a[@class='nav-link'][normalize-space()='Assets']")
    WebElement assetOption;
    // private final By assetOption = By.xpath("//a[@class='nav-link'][normalize-space()='Assets']");
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement emailFieldClientApplication;
    // private final By emailFieldClientApplication = By.xpath("//input[@placeholder='Username']");
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordFieldClientApplication;
    //private final By passwordFieldClientApplication = By.xpath("//input[@placeholder='Password']");
    @FindBy(xpath = "//i[@class='fa fa-play']")
    WebElement loginButton;
    //  private final By loginButton = By.xpath("//i[@class='fa fa-play']");
    @FindBy(xpath = "//span[contains(text(),'Select Site')]")
    WebElement siteDropDownButton;
    // private final By siteDropDownButton = By.xpath("//span[contains(text(),'Select Site')]");
    @FindBy(xpath = "//ul[@class='item2']")
    WebElement siteDropdownText;
    //  private final By siteDropdownText = By.xpath("//ul[@class='item2']");
    @FindBy(xpath = "//tr[@role='row']")
    List<WebElement> assetTable;
    //   private final By assetTable = By.xpath("//tr[@role='row']");
    @FindBy(xpath = "//span[contains(text(),'Select Asset')]")
    WebElement assetDropDownButton;
    //  private final By assetDropDownButton = By.xpath("//span[contains(text(),'Select Asset')]");
    @FindBy(className = "loading-bar-fixedr")
    WebElement loader;
    //  private final By loader = By.className("loading-bar-fixed");
    @FindBy(xpath = "//span[text()='Select Asset']/following::ul[@class='item2']")
    WebElement assetDropDownText;
    // private final By assetDropDownText = By.xpath("//span[text()='Select Asset']/following::ul[@class='item2']");
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement noDataAvailableInTable;
    //  private final By noDataAvailableInTable = By.xpath("//td[@class='dataTables_empty']");
    @FindBy(xpath = "//span[text()='Select Site']/following::ul[@class='item2'] [1]//div")
    WebElement siteDropDownValue;
    //  private final By siteDropDownValue = By.xpath("//span[text()='Select Site']/following::ul[@class='item2'] [1]//div");
    @FindBy(xpath = "//*[text()=' Submit ']")
    WebElement submitButton;
    //   private final By submitButton = By.xpath("//*[text()=' Submit ']");
    @FindBy(xpath = "//span[contains(text(),'+1')]")
    WebElement siteDropDown;
    //   private final By siteDropDown = By.xpath("//span[contains(text(),'+1')]");
    @FindBy(xpath = "//*[@id='live_table']/tbody/tr[1]/td[3]")
    WebElement liveFeedEventData;
    //  private final By liveFeedEventData = By.xpath("//*[@id='live_table']/tbody/tr[1]/td[3]");
    @FindBy(xpath = "//span[text()='Select Asset']/following::ul[@class='item2'] [1]//div")
    WebElement assetDropDownValue;
    //  private final By assetDropDownValue = By.xpath("//span[text()='Select Asset']/following::ul[@class='item2'] [1]//div");
    @FindBy(xpath = "//*[@id='live_table']/tbody/tr[1]/td[4]")
    WebElement getAssetTableData;
    //  private final By getAssetTableData = By.xpath("//*[@id='live_table']/tbody/tr[1]/td[4]");
    @FindBy(xpath = "//span[text()='+1']/following::ul[@class='item2'] [1]//div")
    WebElement unSiteDropDownValue;
    //  private final By unSiteDropDownValue = By.xpath("//span[text()='+1']/following::ul[@class='item2'] [1]//div");
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;
    //  private final By resetButton = By.xpath("//button[normalize-space()='Reset']");
    @FindBy(xpath = "//div[@class='Alarm map-status']")
    WebElement alarmSitesInTheMap;
    //   private final By alarmSitesInTheMap = By.xpath("//div[@class='Alarm map-status']");
    @FindBy(xpath = "//label[@class='form-check-label inner-label']//span[contains(text(),'Normal')]")
    WebElement normalSiteRadioButton;
    //   private final By normalSiteRadioButton = By.xpath("//label[@class='form-check-label inner-label']//span[contains(text(),'Normal')]");
    @FindBy(xpath = "//div[@class='Normal map-status']")
    WebElement normalSiteInTheMap;
    //  private final By normalSiteInTheMap = By.xpath("//div[@class='Normal map-status']");
    @FindBy(xpath = "//label[@class='form-check-label inner-label']//span[contains(text(),'Warning')]")
    WebElement warningSiteRadioButton;
    //  private final By warningSiteRadioButton = By.xpath("//label[@class='form-check-label inner-label']//span[contains(text(),'Warning')]");
    @FindBy(xpath = "//div[@role='alert']")
    WebElement siteStatusInMap;
    //  private final By siteStatusInMap = By.xpath("//div[@role='alert']");
    @FindBy(xpath = "//label[@class='form-check-label inner-label']//span[contains(text(),'Suspended')]")
    WebElement suspendedSiteRadioButton;
    //   private final By suspendedSiteRadioButton = By.xpath("//label[@class='form-check-label inner-label']//span[contains(text(),'Suspended')]");
    @FindBy(xpath = "//label[@class='form-check-label inner-label']//span[contains(text(),'No Comm')]")
    WebElement noCommSiteRadioButton;
    //   private final By noCommSiteRadioButton = By.xpath("//label[@class='form-check-label inner-label']//span[contains(text(),'No Comm')]");
    @FindBy(xpath = "//button[text()='Map']")
    WebElement mapButton;
    //   private final By mapButton = By.xpath("//button[text()='Map']");
    @FindBy(xpath = "//button[text()='Satellite']")
    WebElement satelliteButton;
    //   private final By satelliteButton = By.xpath("//button[text()='Satellite']");
    @FindBy(xpath = "//*[text()='Terrain']")
    WebElement terrainButton;
    //  private final By terrainButton = By.xpath("//*[text()='Terrain']");
    @FindBy(xpath = "//span[text()='Map data ©2021']")
    WebElement mapDataText;
    //  private final By mapDataText = By.xpath("//span[text()='Map data ©2021']");
    @FindBy(xpath = "//*[text()='Labels']")
    WebElement labelButton;
    //  private final By labelButton = By.xpath("//*[text()='Labels']");
    @FindBy(xpath = "//button[@aria-label='Rotate map 90 degrees']")
    WebElement rotateButton;
    //   private final By rotateButton = By.xpath("//button[@aria-label='Rotate map 90 degrees']");
    @FindBy(xpath = "//span[text()='Map data ©2021  Imagery ©2021 , Maxar Technologies, USDA Farm Service Agency']")
    WebElement satelliteMapDataText;
    //  private final By satelliteMapDataText = By.xpath("//span[text()='Map data ©2021  Imagery ©2021 , Maxar Technologies, USDA Farm Service Agency']");
    @FindBy(xpath = "//button[@title='Toggle fullscreen view']")
    WebElement toggleFullscreenViewButton;
    //  private final By toggleFullscreenViewButton = By.xpath("//button[@title='Toggle fullscreen view']");
    @FindBy(xpath = "//div[@title='Drag Pegman onto the map to open Street View']")
    WebElement pegManButton;
    //  private final By pegManButton = By.xpath("//div[@title='Drag Pegman onto the map to open Street View']");
    @FindBy(xpath = "//button[@title='Zoom in']")
    WebElement zoomInButton;
    //   private final By zoomInButton = By.xpath("//button[@title='Zoom in']");
    @FindBy(xpath = "//button[@title='Zoom out']")
    WebElement zoomOutButton;
    @FindBy(xpath = "//div[@class='sm-toggle']//span")
    WebElement sideMenuButtonCustomer;
    //  private final By sideMenuButtonCustomer = By.xpath("//div[@class='sm-toggle']//span");
    @FindBy(xpath = "//a[normalize-space()='Assets']")
    WebElement assetOptionSideMenu;
    //   private final By assetOptionSideMenu = By.xpath("//a[normalize-space()='Assets']");
    @FindBy(xpath = "//span[@title='Normal']")
    WebElement normalAlarmCount;
    //   private final By normalAlarmCount = By.xpath("//span[@title='Normal']");
    @FindBy(xpath = "//span[@title='Alarm']")
    WebElement alarmCount;
    //   private final By alarmCount = By.xpath("//span[@title='Alarm']");
    @FindBy(xpath = "//option[text()='10']")
    WebElement defaultPerPageOptions;
    //  private final By defaultPerPageOptions = By.xpath("//option[text()='10']");
    @FindBy(xpath = "//select[@name='live_table_length']")
    WebElement perPageOptions;
    //   private final By perPageOptions = By.xpath("//select[@name='live_table_length']");
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;
    //   private final By searchField = By.xpath("//input[@type='search']");
    @FindBy(xpath = "//td[text()='No matching records found']")
    WebElement noRecordsFoundText;
    //   private final By noRecordsFoundText = By.xpath("//td[text()='No matching records found']");
    @FindBy(xpath = "//*[@id='live_table']/tbody")
    WebElement liveFeedEventTable;
    //   private final By liveFeedEventTable = By.xpath("//*[@id='live_table']/tbody");
    @FindBy(xpath = "//th[@aria-label='Status: activate to sort column ascending']")
    WebElement statusAscendingOrder;
    //  private final By statusAscendingOrder = By.xpath("//th[@aria-label='Status: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Event / Runtime Status: activate to sort column ascending']")
    WebElement eventAbdRunTimesAscendingOrder;
    //  private final By eventAbdRunTimesAscendingOrder = By.xpath("//th[@aria-label='Event / Runtime Status: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Site Name: activate to sort column ascending']")
    WebElement siteNameAscendingOrder;
    //   private final By siteNameAscendingOrder = By.xpath("//th[@aria-label='Site Name: activate to sort column ascending']");
    @FindBy(xpath = "//th[@aria-label='Asset Name: activate to sort column ascending']")
    WebElement assetNameAscendingOrder;

    @FindBy(xpath = "//span[contains(text(),'+1')]")
    WebElement afterSelectSiteDropDown;

    @FindBy(xpath = "//div[normalize-space()='CDN']")
    WebElement selectedSite;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-view[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ng-multiselect-dropdown[1]/div[1]/div[1]/span[1]/span[2]/span[1]")
    WebElement afterSelectAssetDropDown;

    @FindBy(xpath = "//div[normalize-space()='CDN TEST #1']")
    WebElement cdnAsset;

    @FindBy(xpath = "//a[normalize-space()='Assets']")
    WebElement assetOptions;

    @FindBy(xpath = "//h3[text()='Asset List']")
    WebElement assetPageTitle;

    @FindBy(xpath = "//div[@class='Suspended map-status']")
    WebElement suspendedMapStatus;

    @FindBy(xpath = "//*[@class='item2']/li")
     List< WebElement > dropDownList;

    public DashboardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public DashboardPage doLoginClientApplication(String emailId, String password) {
        DriverManager.getWebDriver().get(FrameWorkConstants.getCLIENTAPPLICATIONURL());
        sendKeysToWebElement(emailFieldClientApplication, emailId, WaitStrategy.VISIBLE);
        sendKeysToWebElement(passwordFieldClientApplication, password, WaitStrategy.VISIBLE);
        clickOnButton(loginButton);
        return this;
    }

    public DashboardPage lunchURL() {
        DriverManager.getWebDriver().get(FrameWorkConstants.getCLIENTAPPLICATIONURL());
        return this;
    }

    public boolean isDisplayedDashboardPageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, dashboardPageTitle)).isDisplayed();
    }

    @SneakyThrows
    public DashboardPage clickOnSideMenuButton() {
        Thread.sleep(30000);
        clickOnButton(sideMenuButton);
        return this;
    }

    public DashboardPage clickOnCustomerOptionButton() {
        clickOnButton(customerOptionButton);
        return this;
    }

    @SneakyThrows
    public DashboardPage clickOnCustomerName() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(customerName);
        }
        return this;

    }

    @SneakyThrows
    public DashboardPage clickOnAssertOption() {
        Thread.sleep(15000);
        clickOnButton(assetOption);
        return this;
    }

    public Set<String> getAssetsTableData() {
        String beForeXpath = "//*[@id='userAsset']/tbody/tr[";
        String afterXpath = "]/td[3]";
        List<WebElement> elements = assetTable;
        Set<String> strings = new LinkedHashSet<>();
        for (int i = 1; i < elements.size(); i++) {
            String actualXpath = beForeXpath + i + afterXpath;
            WebElement element = DriverManager.getWebDriver().findElement(By.xpath(actualXpath));
            strings.add(element.getText());
        }
        return strings;
    }

    @SneakyThrows
    public DashboardPage clickOnSiteDropDown() {
        Thread.sleep(8000);
        clickOnButton(siteDropDownButton);
        return this;
    }

    @SneakyThrows
    public Set<String> getSiteDropDownText() {
        Set<String> siteName = new LinkedHashSet<>();
        siteName.add(waitForElement(siteDropdownText).getText());
        return siteName;
    }

    @SneakyThrows
    public DashboardPage clickOnAssetDropDownButton() {
        Thread.sleep(5000);
        clickOnButton(assetDropDownButton);
        return this;
    }

    @SneakyThrows
    public Set<String> getAssetDropDownText() {
        Set<String> siteName = new LinkedHashSet<>();
        siteName.add(waitForElement(assetDropDownText).getText());
        return siteName;
    }

    public Set<String> getAssetTableData() throws InterruptedException {
        Thread.sleep(5000);
        String beForeXpath = "//*[@id='userAsset']/tbody/tr[";
        String afterXpath = "]/td[2]";
        List<WebElement> elements = assetTable;
        Set<String> strings = new LinkedHashSet<>();
        for (int i = 1; i < elements.size(); i++) {
            String actualXpath = beForeXpath + i + afterXpath;
            WebElement element = DriverManager.getWebDriver().findElement(By.xpath(actualXpath));
            strings.add(element.getText());
        }
        return strings;
    }

    public boolean isDisplayedSiteDropDown() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteDropDownButton)).isDisplayed();
    }

    public boolean isDisplayedAssetDropDown() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetDropDownButton)).isDisplayed();
    }


    @Override
    public void jsPageScroll(int numb1, int numb2) {
        ExplicitWaitFactory.isElementInVisible(loader);
        super.jsPageScroll(numb1, numb2);
    }

    public DashboardPage selectedSiteDropDown(int index) {
        ExplicitWaitFactory.wait_until_MobileElementsAre_Present(siteDropDownValue).get(index).click();
        return this;
    }

    public DashboardPage selectedAssetDropDown(int index) {
        ExplicitWaitFactory.wait_until_MobileElementsAre_Present(assetDropDownValue).get(index).click();
        return this;
    }

    public String selectedSiteDropDownValue(int index) {
        return ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(siteDropDownValue).get(index).getText();
    }

    public String selectAssetDropDownValue(int index) {
        return ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(assetDropDownValue).get(index).getText();
    }

    @SneakyThrows
    public DashboardPage clickOnSubmitButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(submitButton);
        }
        return this;
    }

    @SneakyThrows
    public DashboardPage clickOnSiteDrop() {
        Thread.sleep(6000);
        clickOnButton(siteDropDown);
        return this;
    }

    @SneakyThrows
    public String getLiveFeedEventSiteTableData() {
        Thread.sleep(5000);
        try {
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.NONE, noDataAvailableInTable)).isDisplayed()) {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.NONE, noDataAvailableInTable)).getText();
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, liveFeedEventData)).getText();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, liveFeedEventData)).getText();

        }
    }

    @SneakyThrows
    public String getLiveFeedEventAssetTableData() {
        Thread.sleep(5000);
        try {
            if (Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.NONE, noDataAvailableInTable)).isDisplayed()) {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.NONE, noDataAvailableInTable)).getText();
            } else {
                return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, getAssetTableData)).getText();
            }
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, getAssetTableData)).getText();

        }
    }

    public void clickOnResetButton() {
        clickOnButton(resetButton);
    }

    public boolean isDisplayedAlarmSitesInTheMap() {
        ExplicitWaitFactory.isElementInVisible(loader);
        try {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() ? Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() : Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alarmSitesInTheMap)).isDisplayed();
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, alarmSitesInTheMap)).isDisplayed();
        }

    }

    public DashboardPage clickOnNormalSiteRadioButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(normalSiteRadioButton);
        }
        return this;
    }

    public boolean isDisplayedNormalSitesInTheMap() {
        ExplicitWaitFactory.isElementInVisible(loader);
        try {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() ? Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() : Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, normalSiteInTheMap)).isDisplayed();
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, normalSiteInTheMap)).isDisplayed();
        }

    }

    public DashboardPage clickOnWarningSiteRadioButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(warningSiteRadioButton);
        }
        return this;
    }

    public boolean isDisplayedWarningSitesInTheMap() {
        ExplicitWaitFactory.isElementInVisible(loader);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed();
    }

    public DashboardPage clickOnSuspendedSiteRadioButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(suspendedSiteRadioButton);
        }
        return this;
    }

    public boolean isDisplayedSuspendedSitesInTheMap() {
        ExplicitWaitFactory.isElementInVisible(loader);
        try {
            Thread.sleep(3000);
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() ? Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed() : Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, suspendedMapStatus)).isDisplayed();
        } catch (Exception exception) {
            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, suspendedMapStatus)).isDisplayed();
        }
    }

    public DashboardPage clickOnNoCommSiteRadioButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(noCommSiteRadioButton);
        }
        return this;
    }

    public boolean isDisplayedNoCommSitesInTheMap() {
        ExplicitWaitFactory.isElementInVisible(loader);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteStatusInMap)).isDisplayed();
    }

    @SneakyThrows
    public DashboardPage clickOnMapButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(mapButton);
        }
        moveToElement(terrainButton);
        return this;
    }

    public boolean isDisplayedMapButton() {
        ExplicitWaitFactory.isElementInVisible(loader);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mapButton)).isDisplayed();
    }

    public boolean isDisplayedSatelliteButton() {
        ExplicitWaitFactory.isElementInVisible(loader);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, satelliteButton)).isDisplayed();
    }

    public boolean isDisplayedMapDataText() {
        ExplicitWaitFactory.isElementInVisible(loader);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, mapDataText)).isDisplayed();
    }

    public DashboardPage clickOnSatelliteButton() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            clickOnButton(satelliteButton);
        }
        return this;
    }

    @SneakyThrows
    public boolean isDisplayedRotateButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, rotateButton)).isDisplayed();
    }

    public boolean isDisplayedToggleFullscreenViewButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, toggleFullscreenViewButton)).isDisplayed();
    }

    public boolean isDisplayedPegManButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, pegManButton)).isDisplayed();
    }

    public boolean isDisplayedZoomInButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, zoomInButton)).isDisplayed();
    }

    public boolean isDisplayedZoomOutButton() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, zoomOutButton)).isDisplayed();
    }

    public boolean isDisplayedByDefaultEntriesCount() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, defaultPerPageOptions)).isDisplayed();
    }

    public boolean selectEntriesPerPage(String index) {
        selectDropdownValue(perPageOptions, DropDown.VALUE, index);
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//option[text()='" + index + "']")))).isDisplayed();
    }

    public boolean isDisplayedSearchField() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, searchField)).isDisplayed();
    }

    public DashboardPage setSearchField(String searchText) {
        ExplicitWaitFactory.isElementInVisible(loader);
        sendKeysToWebElement(searchField, searchText, WaitStrategy.VISIBLE);
        return this;
    }

    public String getNoRecordsFoundText() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, noRecordsFoundText)).getText();
    }

    public String getLiveFeedTableData() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, liveFeedEventTable)).getText();
    }

    public boolean IsDisplayedDefaultSorting() {
        List<WebElement> webElements = new LinkedList<>();
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, statusAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventAbdRunTimesAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, siteNameAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetNameAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, notificationTextAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, channelDescriptionAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventTypeAscendingOrder));
        webElements.add(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, eventTimeAscendingOrder));
        return webElements.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean IsDisplayedStatusSorting() {
        if (ExplicitWaitFactory.isElementInVisible(loader)) {
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, statusButton)).click();
        }
        return getShorting(statusList);
    }

    public boolean IsDisplayedEventAndRunTimeStatusSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, eventAbdRunTimesAscendingOrder)).click();
        return getShorting(eventAndRunTimeStatusList);
    }

    public boolean IsDisplayedSiteNameSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, siteNameAscendingOrder)).click();
        return getShorting(siteNameList);
    }

    public boolean IsDisplayedAssetNameSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, assetNameAscendingOrder)).click();
        return getShorting(assetNameList);
    }

    public boolean IsDisplayedChannelDescriptionSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, channelDescriptionAscendingOrder)).click();
        return getShorting(channelDescriptionList);
    }

    public boolean IsDisplayedEventTypeSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, eventTypeAscendingOrder)).click();
        return getShorting(eventTypeList);
    }

    public boolean IsDisplayedEventTimeSorting() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.CLICKABLE, eventTimeAscendingOrder)).click();
        return getShorting(eventTimeList);
    }

    public DashboardPage clickOnAfterSiteDropDownButton() {
        clickOnButton(afterSelectSiteDropDown);
        return this;
    }

    public String getOnCDNSite() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectedSite)).getText();
    }

    @SneakyThrows
    public void clickOnCDNSite() {
        Thread.sleep(2000);
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, selectedSite)).click();
    }

    public DashboardPage clickOnAfterSelectAsset() {
        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, afterSelectAssetDropDown)).click();
        return this;
    }

    @SneakyThrows
    public String getCdnAsset() {
        Thread.sleep(3000);
        for (WebElement element: dropDownList){
            if (element.getText().equalsIgnoreCase(PropertyUtils.getValue(ConfigProperties.ASSETNAME))){
                return element.getText();
            }
        }
//        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("CDN TEST #5")){
//            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flex-center float-right']//div[2]//ng-multiselect-dropdown[1]//div[1]//div[2]//ul[2]//li[1]//div[1]")))).getText();
//        }else {
//            return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cdnAsset)).getText();
//        }
        return "";
        }

    public DashboardPage clickOnCdnAsset() {

        if (PropertyUtils.getValue(ConfigProperties.ASSETNAME).equalsIgnoreCase("CDN TEST #5")){
             Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//div[@class='flex-center float-right']//div[2]//ng-multiselect-dropdown[1]//div[1]//div[2]//ul[2]//li[1]//div[1]")))).click();
        }else {
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, cdnAsset)).click();;
        }
        return this;
    }

    public DashboardPage clickOnAssetOption() {

        Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetOptions)).click();
        return this;
    }

    public boolean isDisplayedAssetPageTitle() {
        return Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, assetPageTitle)).isDisplayed();
    }

    public void get() {
        List<WebElement> webElements = ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(siteNameList);
        List<String> siteNames = new ArrayList<>();
        for (WebElement element : webElements) {
            siteNames.add(element.getText());
        }
        String nextButtonClass = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).getAttribute("class");
        while (!nextButtonClass.contains("disabled")) {
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).click();
            webElements = ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(siteNameList);
            for (WebElement element : webElements) {
                siteNames.add(element.getText());
            }
            nextButtonClass = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, nextButton)).getAttribute("class");
        }
        int totalSiteName = siteNames.size();
        System.out.println(totalSiteName);
        String displayedCount = Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, DriverManager.getWebDriver().findElement(By.xpath("//div[@id='live_table_info']")))).getText().split(" ")[5];
        System.out.println(displayedCount);
    }


}
