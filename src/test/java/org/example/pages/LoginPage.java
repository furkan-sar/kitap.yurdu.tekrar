package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage {

    private final String EMAIL="furkan.sar@testinium.com";
    private final String SIFRE="1q2w3e4r5t";
    Logger logger= LogManager.getLogger(LoginPage.class);
    Method method;
    public LoginPage(){
        method=new Method();
    }
    public void login(){
        method.clickJS(method.findElement(By.cssSelector(".menu-top-button.login>a")));
        logger.info("Giris yap butonuna tiklandi");
        method.sendKeys(By.id("login-email"),EMAIL);
        logger.info("E mail girildi");
        method.sendKeys(By.id("login-password"),SIFRE);
        logger.info("Sifre girildi");
        method.clickJS(method.findElement(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn")));
        logger.info("Giris yap butonuna tiklandi");
        Assertions.assertTrue(method.isElementVisible(By.cssSelector("h1[class='section']")),"Giris yapilamadi");
        logger.info("Giris yapildi");
    }
}
