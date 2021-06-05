package com.amcicustomer.drivertool;

import org.openqa.selenium.WebDriver;



public final class DriverManager {

    public static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }
    public static void setWebDriver(WebDriver driver){
        webDriverThreadLocal.set(driver);
    }
    public static void unLoad(){
        webDriverThreadLocal.remove();
    }
}
