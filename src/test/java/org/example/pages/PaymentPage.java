package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class PaymentPage {
    Logger logger= LogManager.getLogger(PaymentPage.class);
    Method method;
    public PaymentPage(){
        method=new Method();
    }
    public void setCardName(String cardName){
        method.isElementClickable(By.id("credit-card-owner"));
        method.sendKeys(By.id("credit-card-owner"),cardName);
        Assertions.assertEquals(cardName,method.getValue(By.id("credit-card-owner"))," kart sahibini adi girilemedi");
        logger.info(" kart sahibinin adi: "+cardName+" olarak girildi");
    }
    public void setCardNumber(String cardNumber){
        method.isElementVisible(By.id("credit_card_number_1"));
        method.sendKeys(By.id("credit_card_number_1"),cardNumber.substring(0,4));
        Assertions.assertEquals(cardNumber.substring(0,4),method.getValue(By.id("credit_card_number_1")));

        method.isElementVisible(By.id("credit_card_number_2"));
        method.sendKeys(By.id("credit_card_number_2"),cardNumber.substring(4,8));
        Assertions.assertEquals(cardNumber.substring(4,8),method.getValue(By.id("credit_card_number_2")));

        method.isElementVisible(By.id("credit_card_number_3"));
        method.sendKeys(By.id("credit_card_number_3"),cardNumber.substring(8,12));
        Assertions.assertEquals(cardNumber.substring(8,12),method.getValue(By.id("credit_card_number_3")));

        method.isElementVisible(By.id("credit_card_number_4"));
        method.sendKeys(By.id("credit_card_number_4"),cardNumber.substring(12,16));
        Assertions.assertEquals(cardNumber.substring(12,16),method.getValue(By.id("credit_card_number_4")));
        logger.info("Kart numarası: "+cardNumber+" olarak girildi");
    }
    public void selectExpireDate(String month,String year){
        method.selectByText(By.id("credit-card-expire-date-month"),month);
        Assertions.assertEquals(month,method.getValue(By.id("credit-card-expire-date-month"))," ay bilgisi girilemedi");
        logger.info("Ay "+month+" olarak girildi");

        method.selectByText(By.id("credit-card-expire-date-year"),year);
        Assertions.assertEquals(year,method.getValue(By.id("credit-card-expire-date-year"))," ay bilgisi girilemedi");
        logger.info("Ay "+year+" olarak girildi");
    }

    public void sendCVV(String cvv){
        method.sendKeys(By.id("credit-card-security-code"),cvv);
        Assertions.assertEquals(cvv,method.getValue(By.id("credit-card-security-code")));
        logger.info("CVV "+cvv+" olarak girildi");
    }
    public void clickToContinue(){
        for(int i=0;i<100;i++){
            method.clickJS(By.cssSelector("button#button-checkout-continue"));
            if(method.isElementExist(By.cssSelector(".span.error"))){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Assertions.assertTrue(method.isElementExist(By.cssSelector(".span.error")),"Kart numarasi gecersiz mesaji gorulmedi");
        logger.info("Kart numarası geçersiz hatası alındı");
    }
    public void clickLogo(){
        method.clickJS(By.cssSelector(".checkout-logo"));
    }

}
