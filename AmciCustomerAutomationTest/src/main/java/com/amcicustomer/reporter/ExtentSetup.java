package com.amcicustomer.reporter;

import com.amcicustomer.constants.FrameWorkConstants;
import com.amcicustomer.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public final class ExtentSetup {
    private static ExtentReports extent;

    private ExtentSetup() {
    }
    static {
      extent = ExtentSetup.initExtentReport();
    }

    public static ExtentReports initExtentReport() {
        if (Objects.isNull(extent)) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath()).
                    viewConfigurer().viewOrder().
                    as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,}).apply();
            extentSparkReporter.config().setDocumentTitle("AMCI_AUTOMATION");
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setReportName("AMCI_Customer_Application");
            extentSparkReporter.config().setEncoding("utf-8");
            extent = new ExtentReports();
            extent.attachReporter(extentSparkReporter);
            extent.setSystemInfo("AMCI_Project_Manager", "Rahul_Gupta");
            extent.setSystemInfo("Amci_Automation_Lead", "Sunny_Kumrawat");
            extent.setSystemInfo("Automation_Tester", "Samkit Jain");
            extent.setSystemInfo("Organization", "CDN Solution");
        }
        return extent;

    }

    public static void flushExtentReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unLoadExtent();
        Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testName) {
        ExtentManager.setExtentTestThreadLocal(extent.createTest(testName));
    }

    public static void addAuthors(String [] authors){
        Arrays.stream(authors).forEachOrdered(string -> ExtentManager.getExtentTestThreadLocal().assignAuthor(string));

        }
    public static void addCategories(CategoryType[] categories) {
        Arrays.stream(categories).forEachOrdered(categoryType -> ExtentManager.getExtentTestThreadLocal().assignAuthor(categoryType.toString()));
    }
}
