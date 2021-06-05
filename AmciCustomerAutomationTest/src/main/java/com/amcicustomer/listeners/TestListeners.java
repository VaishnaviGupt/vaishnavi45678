package com.amcicustomer.listeners;


import com.amcicustomer.reporter.ExtentLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {




    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.passLog(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.failLog(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.failLog( result.getThrowable().toString());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skipLog(result.getMethod().getMethodName() + " is skipped", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }


}
