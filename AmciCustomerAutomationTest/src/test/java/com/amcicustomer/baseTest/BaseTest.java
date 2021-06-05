package com.amcicustomer.baseTest;

import com.amcicustomer.driver.Driver;
import com.amcicustomer.enums.ConfigProperties;
import com.amcicustomer.reporter.ExtentSetup;
import com.amcicustomer.utils.PropertyUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {
    protected BaseTest(){

    }
    @BeforeSuite
    public void onStart() {
        ExtentSetup.initExtentReport();

    }
    @AfterSuite
    public void onFinish() {
        try {
            ExtentSetup.flushExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @BeforeClass()
    protected  void setup(){
        Driver.initDriver(PropertyUtils.getValue(ConfigProperties.BROWSER));
    }
    @BeforeMethod
    protected void setUp(Method method){
        ExtentSetup.createTest(method.getName());

    }
    @AfterClass
    protected void tearDown(){
        Driver.quitDriver();
    }
}
