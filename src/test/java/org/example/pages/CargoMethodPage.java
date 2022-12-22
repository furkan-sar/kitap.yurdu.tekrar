package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CargoMethodPage {
    Logger logger= LogManager.getLogger(CargoMethodPage.class);
    Method method;
    public CargoMethodPage(){
        method=new Method();
    }
    public void clickToContinue(){
        method.clickJS(By.id("button-checkout-continue"));
        Assertions.assertTrue(method.isElementVisible(By.id("paymentMethods")),"Odeme metodu sayfasina yonlendirilemedi");
        logger.info("Odeme metodu sayfasina yonlendirildi");
    }
}
