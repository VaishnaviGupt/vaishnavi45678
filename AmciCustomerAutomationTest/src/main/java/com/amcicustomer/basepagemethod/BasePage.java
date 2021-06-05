package com.amcicustomer.basepagemethod;

import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.DropDown;
import com.amcicustomer.enums.WaitStrategy;
import com.amcicustomer.factory.ExplicitWaitFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

public class BasePage {

    protected WebElement waitForElement(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getWebDriver());
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void clickOnButton(WebElement element) {
        // We want to make sure user can only choose from list of predefined options
        waitForElement(element).click();
    }

    //PAGE METHODS
    protected String getCurrentURL() {
        try {
            DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return DriverManager.getWebDriver().getCurrentUrl();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    protected String waiteForePageTitle() {
        try {
            return DriverManager.getWebDriver().getTitle();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //SEND KEYS METHODS
    protected void sendKeysToWebElement(WebElement element, String textToSend, WaitStrategy waitStrategy) {
        try {
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(waitStrategy, element)).clear();
            Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(waitStrategy, element)).sendKeys(textToSend);
        } catch (Exception e) {
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    protected void selectDropdownValue(WebElement element, DropDown dropDown, String value) {
        Select select = new Select(Objects.requireNonNull(ExplicitWaitFactory.performExplicitWaitWait(WaitStrategy.VISIBLE, element)));
        switch (dropDown) {
            case INDEX:
                select.selectByIndex(Integer.parseInt(value));
                break;
            case VALUE:
                select.selectByValue(value);
                break;
            case VISIBLETEXT:
                select.selectByVisibleText(value);
                break;
            default:
                System.out.println("Please select the correct selection criteria... ");
                break;
        }
    }

    protected void moveToElement(WebElement element) {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(waitForElement(element)).click().perform();
    }


    protected void jsPageScroll(int numb1, int numb2) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
        } catch (Exception e) {
            Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
        }
    }

    //Click on column
    //Capture all the elements in to list
    //Capture text of all the elements in to new list
    protected boolean getShorting(WebElement element) {
        List<WebElement> elementsList = ExplicitWaitFactory.wait_until_MobileElementsAre_Visible(element);
        List<String> originalList = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        return originalList.equals(sortedList);
    }
    @SneakyThrows
    protected boolean getShorting(List<WebElement> element) {
        Thread.sleep(3000);
        List<String> originalList = element.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(originalList);
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        return originalList.equals(sortedList);
    }

     protected void clearField(WebElement element,int index){
        for (int i=0;i==index;i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(Keys.BACK_SPACE);

    }


}



