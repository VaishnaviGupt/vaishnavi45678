package com.amcicustomer.factory;

import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
      private DriverFactory(){

      }



      public static WebDriver getDriver(String browser) throws MalformedURLException {
          WebDriver webDriver = null;
          if (browser.equalsIgnoreCase("chrome")){
              if (PropertyUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")){
                  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                  desiredCapabilities.setBrowserName(BrowserType.CHROME);
                  webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
              }else {
                  WebDriverManager.chromedriver().setup();
                  webDriver = new ChromeDriver();
              }
          }else if (browser.equalsIgnoreCase("firefox")){
              if (PropertyUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")){
                  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                  desiredCapabilities.setBrowserName(BrowserType.CHROME);
                  webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);

              }else {
                  WebDriverManager.firefoxdriver().setup();
                  webDriver = new FirefoxDriver() ;
              }
          }
          return webDriver;

      }

}
