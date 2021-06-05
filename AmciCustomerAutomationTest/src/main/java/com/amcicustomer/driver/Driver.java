package com.amcicustomer.driver;

import com.amcicustomer.drivertool.DriverManager;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.factory.DriverFactory;
import com.amcicustomer.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

public final class Driver {
    private Driver() {
    }


    public static void initDriver(String browser) {

        if (Objects.isNull(DriverManager.getWebDriver())) {
            try {
                DriverManager.setWebDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Browser invocation failed. Please check the capabilities");
            }
            Objects.requireNonNull(DriverManager.getWebDriver()).manage().timeouts().getPageLoadTimeout();
            DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            DriverManager.getWebDriver().manage().window().maximize();
            DriverManager.getWebDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        }

    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getWebDriver())) {
            DriverManager.getWebDriver().quit();
            DriverManager.unLoad();
        }
    }
}
