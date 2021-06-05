package com.amcicustomer.constants;


import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.utils.PropertyUtils;
import lombok.Getter;


public final class FrameWorkConstants {
    private FrameWorkConstants() {
    }


    @Getter
    private static final String RESOURCEPATH=System.getProperty("user.dir") + "/src/test/resources";
    @Getter
    private static final String CHROMEDRIVERPATH = RESOURCEPATH+"/executables/chromedriver 2";
    @Getter
    private static final String CONFIGSPATH = RESOURCEPATH+"/config/Config.properties";
    @Getter
    private static final int EXPLICITLYWAIT = 10;
    @Getter
    private static final String dashboardUrl= "https://trial1-customer.amci1440.com/dashboard";
    @Getter
    private static final String GECKODRIVERPATH = RESOURCEPATH+"/executables/chromedriver";
    @Getter
    private static final String EXCELPATH = RESOURCEPATH+"/excel/testData.xlsx";
    @Getter
    private static final String INVLIDEMAILID = "skumrawat.com";
    @Getter
    private static final String INVALIDPASSWORD = "1234321";
    @Getter
    private static final String FORGETPASSWORDURL = "https://trial1-customer.amci1440.com/forgot-password";
    @Getter
    private static final String CLIENTAPPLICATIONURL = "https://trial1.amci1440.com/addcustomer/1";
    @Getter
    private static final String EMAILIDCLIENTAPPLICATION = "skumrawat@amci-wireless.com";
    @Getter
    private static final String PASSWORDCLIENTAPPLICATION = "Amci@123";
    @Getter
    private static final String ASSETPAGEURL = "https://trial1-customer.amci1440.com/asset-management";
    @Getter
    private static final String IMGFILE1000KB = RESOURCEPATH+"/imgFile/0_xMaFF2hSXpf_kIfG.jpg";
    @Getter
    private static final String IMGFILE = RESOURCEPATH+"/imgFile/300x200.jpg";
    @Getter
    private static final String GIFFILE = RESOURCEPATH+"/imgFile/ezgif.com-gif-maker.gif";
















    private static final String EXTENREPORTFOLDERPATH = RESOURCEPATH+"/extent-test-output";
    private static  String extentReportFilePath = "";
    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()){
             extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath(){
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENREPORTFOLDERPATH +System.currentTimeMillis()+"/index.html";
        }else {
            return EXTENREPORTFOLDERPATH +"/index.html";
        }
    }
}
