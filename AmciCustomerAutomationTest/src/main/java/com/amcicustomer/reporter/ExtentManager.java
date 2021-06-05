package com.amcicustomer.reporter;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    private ExtentManager() {

    }

    static ExtentTest getExtentTestThreadLocal() {
        return extentTestThreadLocal.get();
    }

    static void setExtentTestThreadLocal(ExtentTest test) {
        extentTestThreadLocal.set(test);
    }

    static void unLoadExtent() {
        extentTestThreadLocal.remove();
    }


}
