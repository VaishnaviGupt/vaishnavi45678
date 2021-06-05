package com.amcicustomer.reporter;


import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.utils.PropertyUtils;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {


    private ExtentLogger() {
    }

    public static void passLog(String message) {
        ExtentManager.getExtentTestThreadLocal().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));

    }
    public static void passLog(String message,boolean isScreenshotsNeeded) {
        if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotsNeeded){
            ExtentManager.getExtentTestThreadLocal().pass(String.valueOf(MarkupHelper.createLabel(message, ExtentColor.GREEN)));
        }else {
            passLog(message);
        }

    }

    public static void skipLog(String message,boolean isScreenshotsNeeded) {
        if (PropertyUtils.getValue(ConfigProperties.SKIPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotsNeeded){
            ExtentManager.getExtentTestThreadLocal().skip(MarkupHelper.createLabel(message,ExtentColor.INDIGO));
        }else {
            skipLog(message);
        }

    }
    public static void skipLog(String message){
        ExtentManager.getExtentTestThreadLocal().skip(message);
    }
    public static void failLog(String message,boolean isScreenshotsNeeded) {
        if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotsNeeded){
            ExtentManager.getExtentTestThreadLocal().fail(MarkupHelper.createLabel(message,ExtentColor.RED));
             }else {
            failLog(message);
        }

    }
    public static void failLog(String message) {
         ExtentManager.getExtentTestThreadLocal().fail(String.valueOf(MarkupHelper.createLabel(message, ExtentColor.GREEN)));
    }



}

