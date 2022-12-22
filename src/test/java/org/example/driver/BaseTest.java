package org.example.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;

    public static final String ANASAYFA_URL="https://www.kitapyurdu.com/";
    @BeforeAll
    public static void setup(){
        Logger logger= LogManager.getLogger(BaseTest.class);
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-translate");

        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get(ANASAYFA_URL);
        Assertions.assertEquals(ANASAYFA_URL,driver.getCurrentUrl());
        logger.info(ANASAYFA_URL+" acildi");
    }
    @AfterAll
    public static void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }
}
