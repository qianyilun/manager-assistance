package com.allen.controller;


import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.swing.*;
import java.sql.Driver;

/**
 * Created by yilunq on 12/08/17.
 *
 * This class operates the connection to SAP BCP via Selenium
 *
 * @author Allen Qian
 */
public class ConnectionConfiguration {
    private final String firstHalf = "https://support.wdf.sap.corp/sap/bc/devdb/saved_search?sap-client=001&search_id=";
    private final String secondHalf = "&format=json";
    private String queueID;
    private String jsonSourceCode;

    public ConnectionConfiguration(String queueID) {
        this.queueID = queueID;
    }

    public String getJsonSourceCode() {
        return jsonSourceCode;
    }

    public void connect() {
        String url = firstHalf + queueID + secondHalf;
        WebDriver driver = null;
        try {
            driver = openDriver(url);
            jsonSourceCode = pureJsonString(driver);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }

    private WebDriver openDriver(String url) {

//  ------------ Use Chrome Driver -------------------
        String key = "webdriver.chrome.driver";
        String value = getOSValue();
        System.setProperty(key, value);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // use HtmlUnit driver
//        WebDriver driver = new HtmlUnitDriver();


        driver.get(url);
        return driver;
    }

    private String pureJsonString(WebDriver driver) {
        String pageSource = driver.getPageSource();
        int beginIndex = pageSource.indexOf('{');
        int endIndex = pageSource.lastIndexOf('}') + 1;

        return pageSource.substring(beginIndex, endIndex);
    }

/*
 * Prevent the Selenium java.lang.IllegalStateException exception occurs
 */
    private static String getOSValue() {
        if (PlatformUtil.isMac()) {
//            return ".src/chromedriver/Mac/chromedriver";
            return "/chromedriver/Mac/chromedriver";
        }
        if (PlatformUtil.isWin7OrLater()) {
            return "src/chromedriver/Windows/chromedriver.exe";
//            return System.getProperty("user.dir")+"/src/chromedriver/Windows/chromedriver.exe";
        }
        if (PlatformUtil.isLinux()) {
//            return "./src/chromedriver/Linux64/chromedriver";
            return "/chromedriver/Linux64/chromedriver";
        }
        return null;
    }
}
