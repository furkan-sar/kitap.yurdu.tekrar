package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BasketPage {
    Method method;
    Logger logger= LogManager.getLogger(BasketPage.class);
    public BasketPage(){
        method=new Method();
    }
    public void changeProductQuantity(String quantity){
        method.clearInput(By.xpath("//input[@name='quantity']"));
        method.sendKeys(By.xpath("//input[@name='quantity']"),quantity);
        Assertions.assertEquals(quantity,method.getValue(By.xpath("//input[@name='quantity']"))," urun adeti degistirilemedi");
        logger.info(new StringBuilder().append("urun adeti ").append(quantity).append(" olarak guncellendi"));
        method.clickJS(By.cssSelector(".fa.fa-refresh.green-icon"));
    }
    public void clickToBuy(){
        method.clickJS(By.cssSelector(".button.red"));
        Assertions.assertTrue(method.isElementVisible(By.id("shipping-tabs"))," kargo adres sayfasina yonlendirilemedi");
        logger.info("Kargo adresi sayfasina yonlendirildi");

    }
}
