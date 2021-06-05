package com.amcicustomer.factory;

import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory() {

    }

    public static WebElement performExplicitWaitWait(WaitStrategy waitStrategy, WebElement element) {

        switch (waitStrategy) {
            case CLICKABLE:
                return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(FrameWorkConstants.getEXPLICITLYWAIT()))
                        .until(ExpectedConditions.elementToBeClickable(element));
            case PRESENCE:
            case VISIBLE:
                new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(FrameWorkConstants.getEXPLICITLYWAIT()));
                 return element;

            case NONE:
                return element;
        }
        return null;
    }
    public static boolean isElementInVisible(WebElement element){
        return  new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(FrameWorkConstants.getEXPLICITLYWAIT()))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // WAIT FOR MAX TIME 5 SECS TILL THE ELEMENT IS PRESENT
    public static List<WebElement> wait_until_MobileElementsAre_Present( WebElement element) {
      return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(FrameWorkConstants.getEXPLICITLYWAIT()))
        .until(ExpectedConditions.visibilityOfAllElements(element));
    }



    // WAIT FOR MAX TIME 5 SECS TILL THE ELEMENT IS VISIBLE
    public static List<WebElement> wait_until_MobileElementsAre_Visible(WebElement element) {
       return   new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(FrameWorkConstants.getEXPLICITLYWAIT()))
        .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static List<WebElement> wait_until_MobileElementsAre_Visible( By locator, int timeInSeconds) {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(timeInSeconds))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
